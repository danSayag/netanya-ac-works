using System.Net;
using System.Text;
using System.Text.Json;

namespace Client
{
    public partial class Form1 : Form
    {
        public Label[] arrLabels;
        public Label[] arrLabels_result = null!;

        public int prevCounter = 0;// מספר הפקדים שכולל את כל הפקדים מכל הפעמים שפתחנו כמה פעמים

        public static Random myRand = new Random();
        JsonSerializerOptions options = new JsonSerializerOptions { IncludeFields = true };
        public Form1()
        {
            InitializeComponent();

            int arrSize = myRand.Next(12, 16);

            arrLabels = new Label[arrSize];

            int currPosition = 2;
            for (int i = 0; i < arrSize; i++)
            {
                arrLabels[i] = new Label();


                if (myRand.Next(2) == 0)
                    arrLabels[i].Name = "Cat";
                else
                    arrLabels[i].Name = "Dog";

                arrLabels[i].Font = new Font("Arial", 12, FontStyle.Bold);
                arrLabels[i].TextAlign = ContentAlignment.MiddleCenter;
                arrLabels[i].ForeColor = Color.White;
                arrLabels[i].Location = new Point(currPosition, 3);
                arrLabels[i].Size = new Size(myRand.Next(75, 170), myRand.Next(75, 170));

                switch (myRand.Next(4))
                {
                    case 0: arrLabels[i].BackColor = Color.FromArgb(myRand.Next(150, 256), 0, 0); break;
                    case 1: arrLabels[i].BackColor = Color.FromArgb(0, myRand.Next(150, 256), 0); break;
                    case 2:
                        arrLabels[i].BackColor = Color.White;
                        arrLabels[i].Tag = "Red"; break;
                    case 3:
                        arrLabels[i].BackColor = Color.White;
                        arrLabels[i].Tag = "Green"; break;
                }

                if (arrLabels[i].BackColor != Color.White)
                    arrLabels[i].Text = arrLabels[i].Name;
                else
                    arrLabels[i].Image = getImage(arrLabels[i].Size, "../../../" + arrLabels[i].Name + "_" + arrLabels[i].Tag + ".jpg");

                currPosition += arrLabels[i].Size.Width + 3;
                this.Controls.Add(arrLabels[i]);
            }

            if (myRand.Next(2) == 0)
                this.Text = "Cat"; // זה הכותרת של הדף 
            else this.Text = "Dog";

            if (myRand.Next(2) == 0)
                RedGreen_Label.Text = "Red";
            else RedGreen_Label.Text = "Green";

            if (myRand.Next(2) == 0)
                ImageText_Label.Text = "Text";
            else ImageText_Label.Text = "Image";

            RedGreen_Label.ForeColor = Color.FromName(RedGreen_Label.Text);
            ImageText_Label.ForeColor = Color.FromName(RedGreen_Label.Text);
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            DogCatTextImageRedGreen[] arrDogCatTIRG = new DogCatTextImageRedGreen[arrLabels.Length];
            for (int i = 0; i < arrLabels.Length; i++)
            {
                arrDogCatTIRG[i] = new DogCatTextImageRedGreen();
                arrDogCatTIRG[i].DogCat = arrLabels[i].Name; // Dog / Cat
                arrDogCatTIRG[i].width = arrLabels[i].Width;
                arrDogCatTIRG[i].height = arrLabels[i].Height;
                arrDogCatTIRG[i].R = arrLabels[i].BackColor.R;
                arrDogCatTIRG[i].G = arrLabels[i].BackColor.G;
                arrDogCatTIRG[i].B = arrLabels[i].BackColor.B;
                if (arrLabels[i].Tag != null)
                {
                    arrDogCatTIRG[i].tagRedGreen = arrLabels[i].Tag.ToString();
                }
                //arrDogCatTIRG[i].text = arrLabels[i].Text;
                //arrDogCatTIRG[i].B = arrLabels[i].Image;
            }
            string url = "http://localhost:12345/";
            WebRequest request = WebRequest.Create(url);
            request.Method = "POST";
            string jsonString = JsonSerializer.Serialize(arrDogCatTIRG, options);
            byte[] byteArray = Encoding.UTF8.GetBytes(jsonString);

            request.ContentType = "application/x-www-form-urlencoded";
            request.ContentLength = byteArray.Length;
            Stream requestStream = request.GetRequestStream();
            requestStream.Write(byteArray, 0, byteArray.Length);


            WebResponse response = request.GetResponse();
            Stream responseStream = response.GetResponseStream();
            StreamReader reader = new StreamReader(responseStream);

            string result = reader.ReadToEnd();

            if (result == "OK")
            {
                timer1.Start();
            }

            else
                MessageBox.Show("Error");

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            string url = "http://localhost:12345/";
            string dogCat = this.Text;
            url += "?RedGreen=" + RedGreen_Label.Text + "&ImageText=" + ImageText_Label.Text + "&DogCat=" + dogCat + "&prevCounter=" + prevCounter;


            WebClient client = new WebClient();
            string resultStr = client.DownloadString(new Uri(url));
            // שולח בקשת ווב לשרת ומקבל את התשובה כמחרוזת 
            if (resultStr == "Error")
            {
                MessageBox.Show("Error (Timer)");
                return;
            }
            if (resultStr == "Unchanged")
                return;
            // בדיקת התשובה 

            arrTypeSizeColor___Counter? resultObect = JsonSerializer.Deserialize<arrTypeSizeColor___Counter>(resultStr, options);
            // המרת המחרוזת לאובייקט שכולל גם את המערך וגם קאונטר 
            if (resultObect == null || prevCounter == resultObect.arrDogCatTIRG.Length)
                return;
            // אם אין תשובה תקינה או שהתוכן לא השתנה אין טעם להמשיך 
            prevCounter = resultObect.arrDogCatTIRG.Length;
            if (prevCounter == 0)
                return;
            // מעדכנים את המספר הפקדים למספר החדש שיש כרגע - אם אין כלום אז אין מה להמשיך
            if (arrLabels_result != null)
                for (int i = 0; i < arrLabels_result.Length; i++)
                    this.Controls.Remove(arrLabels_result[i]);
            // מסירים את הפקדים הקודמים שהיו בשרת שלא יווצר מלא שכבות - מנקים
            arrLabels_result = new Label[resultObect.arrDogCatTIRG.Length];
            int currPosition = 2;
            // יוצרים את הפקדים החדשים ---מגדירים מערך חדש וממקמים אותם 
            for (int i = 0; i < arrLabels_result.Length; i++)
            {
                arrLabels_result[i] = new Label();
                arrLabels_result[i].BackColor = Color.FromArgb(
                   resultObect.arrDogCatTIRG[i].R, resultObect.arrDogCatTIRG[i].G, resultObect.arrDogCatTIRG[i].B);
                arrLabels_result[i].Width = resultObect.arrDogCatTIRG[i].width;
                arrLabels_result[i].Height = resultObect.arrDogCatTIRG[i].height;
                arrLabels_result[i].Name = resultObect.arrDogCatTIRG[i].DogCat;
                arrLabels_result[i].Tag = resultObect.arrDogCatTIRG[i].tagRedGreen;
                if (ImageText_Label.Text.Equals("Image"))
                {
                    arrLabels_result[i].Image = getImage(arrLabels_result[i].Size, "../../../" + arrLabels_result[i].Name + "_" + arrLabels_result[i].Tag + ".jpg");
                }
                else
                {
                    arrLabels_result[i].Font = new Font("Arial", 12, FontStyle.Bold);
                    arrLabels_result[i].TextAlign = ContentAlignment.MiddleCenter;
                    arrLabels_result[i].ForeColor = Color.White;
                    arrLabels_result[i].Text = resultObect.arrDogCatTIRG[i].DogCat;
                }
                arrLabels_result[i].Location = new Point(currPosition, 200);
                currPosition += arrLabels_result[i].Width + 2;
                this.Controls.Add(arrLabels_result[i]);
            }
        }

        private Image getImage(Size size, string path)
        {
            Image tempImage = Image.FromFile(path);
            tempImage = (Image)new Bitmap(tempImage, size);
            return tempImage;
        }
    }
}


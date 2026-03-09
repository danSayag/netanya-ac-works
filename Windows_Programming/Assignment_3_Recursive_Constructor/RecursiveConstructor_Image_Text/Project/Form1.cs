using static System.Windows.Forms.VisualStyles.VisualStyleElement.StartPanel;

namespace RecoursiveConstructor_Image_Text
{
    public partial class Form1 : Form
    {
        private UserControl1[] arrUC;
        private int arrUser_size = 2;
        static private Form1 Cat_Form, Dog_Form;
        private static Random formRand = new Random();

        static private UserControl1 Dog_UC, Cat_UC;
        static private int counterEvent = 0;
        private List<Label> DogList = new List<Label>();
        private List<Label> CatList = new List<Label>();
        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            Application.Exit();
        }

        public Form1(int counter)
        {
            InitializeComponent();
            this.AutoScaleMode = AutoScaleMode.Dpi;
            this.WindowState = FormWindowState.Normal;

            arrUC = new UserControl1[arrUser_size];
            for (int i = 0; i < arrUser_size; i++)
            {
                arrUC[i] = new UserControl1(formRand);
                arrUC[i].Location = new Point(160, 30 + 120 * i);
                arrUC[i].event_FromUC += new delegate_MyEventHadler(Form_event_FromUC);
                this.Controls.Add(arrUC[i]);
            }

            if (counter == 2)
            {
                Cat_Form = this;

                Form1 temp = new Form1(1);
                temp.Show();
            }

            if (counter == 1)
            {
                this.Text = "Dog";
                Dog_Form = this;

                if (formRand.Next(2) == 0)
                {
                    Cat_Form.Min_Max_label.Text = "Min";
                    Dog_Form.Min_Max_label.Text = "Max";
                }
                else
                {
                    Cat_Form.Min_Max_label.Text = "Max";
                    Dog_Form.Min_Max_label.Text = "Min";
                }

                if (formRand.Next(2) == 0)
                {
                    Cat_Form.Image_Text_label.Text = "Image";
                    Cat_Form.bySize_byBrightness_label.Text = "bySize";
                    Dog_Form.Image_Text_label.Text = "Text";
                    Dog_Form.bySize_byBrightness_label.Text = "byBrightness";
                }
                else
                {
                    Dog_Form.Image_Text_label.Text = "Image";
                    Dog_Form.bySize_byBrightness_label.Text = "bySize";
                    Cat_Form.Image_Text_label.Text = "Text";
                    Cat_Form.bySize_byBrightness_label.Text = "byBrightness";
                }
            }
        }
        private void Form_event_FromUC(object sender, myEventArgs e)
        {
            if (this.Text == "Dog")
                Dog_UC = e.EventArgs_UC;
            else
                Cat_UC = e.EventArgs_UC;
            counterEvent++;

            if (counterEvent == 2)
            {
                ActionMinMax();
                ActionSort();
            }
        }

        void ActionSort()
        {
            if (Dog_Form.bySize_byBrightness_label.Text == "bySize")
            {
                DogList.Sort((x, y) => x.Width * x.Height - y.Width * y.Height);
                CatList.Sort((x, y) => x.BackColor.R + x.BackColor.G - y.BackColor.R - y.BackColor.G);
            }
            else
            {
                DogList.Sort((x, y) => x.BackColor.R + x.BackColor.G - y.BackColor.R - y.BackColor.G);
                CatList.Sort((x, y) => x.Width * x.Height - y.Width * y.Height);
            }

            Arrange(Dog_UC, DogList);
            Arrange(Cat_UC, CatList);
        }

        void Arrange(UserControl1 UC, List<Label> tempList)
        {
            UC.Controls.Clear();
            int currPosition = 2;
            for (int i = 0; i < tempList.Count; i++)
            {
                Label tempLabel = tempList[i];
                tempLabel.Location = new Point(currPosition, 2);
                UC.Controls.Add(tempLabel);
                currPosition += tempLabel.Width + 2;
            }
        }


        public void ActionMinMax()
        {
            for (int i = 0; i < Dog_UC.arrLabels.Length; i++)
            {
                if (Dog_UC.arrLabels[i].Name == "Dog")

                    DogList.Add(Dog_UC.arrLabels[i]);

                else
                    CatList.Add(Dog_UC.arrLabels[i]);
            }
            for (int i = 0; i < Cat_UC.arrLabels.Length; i++)
            {
                if (Cat_UC.arrLabels[i].Name == "Cat")
                    CatList.Add(Cat_UC.arrLabels[i]);
                else
                    DogList.Add(Cat_UC.arrLabels[i]);
            }

            string Dog_RedGreen = "Red";
            if (Dog_Form.radioButton_Green.Checked)
                Dog_RedGreen = "Green";

            string Cat_RedGreen = "Red";
            if (Cat_Form.radioButton_Green.Checked)
                Cat_RedGreen = "Green";


            DogList = filter_RedGreen(DogList, Dog_RedGreen);
            CatList = filter_RedGreen(CatList, Cat_RedGreen);

            // filter images

            string Dog_ImageLabel = Dog_Form.Image_Text_label.Text;
            string Cat_ImageLabel = Cat_Form.Image_Text_label.Text;

            DogList = filter_ImageText(DogList, Dog_ImageLabel);
            CatList = filter_ImageText(CatList, Cat_ImageLabel);

            // everything is filtered!



            MinMax_control_Copy(Dog_Form, DogList, Dog_Form.Min_Max_label.Text);
            MinMax_control_Copy(Cat_Form, CatList, Cat_Form.Min_Max_label.Text);
        }


        List<Label> filter_RedGreen(List<Label> tempList, string selectedColor)
        {
            List<Label> returnList = new List<Label>();

            foreach (Label label in tempList)
            {
                bool isImageLabel = label.BackColor == Color.White;

                bool isTextLabel = !isImageLabel;


                if (selectedColor == "Red")
                {
                    if (isTextLabel && label.BackColor.R != 0 && label.BackColor.G == 0 && label.BackColor.B == 0)
                        returnList.Add(label);

                    if (isImageLabel && label.Tag.Equals("Red"))
                        returnList.Add(label);
                }
                else if (selectedColor == "Green")
                {
                    if (isTextLabel && label.BackColor.G != 0 && label.BackColor.R == 0 && label.BackColor.B == 0)
                        returnList.Add(label);

                    // תמונה: שם מתאים (Cat_Green או Dog_Green)
                    if (isImageLabel && label.Tag.Equals("Green"))
                        returnList.Add(label);
                }
            }

            return returnList;
        }

        List<Label> filter_ImageText(List<Label> tempList, string imageOrText)
        {
            List<Label> returnList = new List<Label>();

            foreach (Label label in tempList)
            {
                if (imageOrText.Equals("Text"))
                {
                    if (!label.Text.Equals(""))
                    {
                        returnList.Add(label);
                    }
                }
                else if (imageOrText.Equals("Image"))
                {
                    if (label.Text.Equals(""))
                    {
                        returnList.Add(label);
                    }
                }

            }

            return returnList;
        }

        void MinMax_control_Copy(Form1 tempForm, List<Label> tempList, string strMinMax)
        {
            Label tempLabel = null;
            if (tempForm.bySize_byBrightness_label.Text.Equals("bySize"))
            {
                if (strMinMax == "Max")
                    tempLabel = tempList.MaxBy(x => x.Width * x.Height);
                if (strMinMax == "Min")
                    tempLabel = tempList.MinBy(x => x.Width * x.Height);
            }
            if (tempForm.bySize_byBrightness_label.Text.Equals("byBrightness"))
            {
                if (strMinMax == "Max")
                    tempLabel = tempList.MaxBy(x => x.BackColor.R + x.BackColor.G);
                if (strMinMax == "Min")
                    tempLabel = tempList.MinBy(x => x.BackColor.R + x.BackColor.G);
            }


            tempForm.MinMax_Result_label.Size = tempLabel.Size;
            tempForm.MinMax_Result_label.BackColor = tempLabel.BackColor;
            tempForm.MinMax_Result_label.Text = tempLabel.Text;
            tempForm.MinMax_Result_label.Image = tempLabel.Image;

        }

        private void Image_Text_label_Click(object sender, EventArgs e)
        {

        }
    
   

    }
}


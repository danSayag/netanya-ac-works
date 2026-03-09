// using Client;
using System.Drawing;
using System.Net;
using System.Reflection.Emit;
using System.Text;
using System.Text.Json;

namespace Server
{
    class Program
    {
        public static List<DogCatTextImageRedGreen> commonList = new List<DogCatTextImageRedGreen>();
        static void Main(string[] args)
        {
            HttpListener listener = new HttpListener();
            listener.Prefixes.Add("http://localhost:12345/");

            listener.Start();

		Console.WriteLine("Server:  Listens on port 12345...");

            while (true)
            {
                HttpListenerContext context = listener.GetContext();
                HttpListenerRequest request = context.Request;

                string jsonString = "OK";

                if (request.HttpMethod == "GET")
                    jsonString = GET_function(request);
                else
                {
                    Stream body = request.InputStream;
                    if (body != null)
                        POST_function(request, body);
                }

                HttpListenerResponse response = context.Response;

                byte[] buffer = Encoding.UTF8.GetBytes(jsonString);
                response.ContentLength64 = buffer.Length;

                Stream outputStream = response.OutputStream;

                outputStream.Write(buffer, 0, buffer.Length);
            }
        }

        static string POST_function(HttpListenerRequest request, Stream body)
        {
            Encoding encoding = request.ContentEncoding;

            StreamReader reader = new StreamReader(body, encoding);

            string jsonString = reader.ReadToEnd();

            reader.Close();
            body.Close();

            JsonSerializerOptions options = new JsonSerializerOptions { IncludeFields = true };
            DogCatTextImageRedGreen[]? arrTypeSizeColor = JsonSerializer.Deserialize<DogCatTextImageRedGreen[]>(jsonString, options);
            if (arrTypeSizeColor == null)
                return "Error";

            for (int i = 0; i < arrTypeSizeColor.Length; i++)
                Program.commonList.Add(arrTypeSizeColor[i]);
            return "OK";

         
        }

        static string GET_function(HttpListenerRequest request)
        {

            string? redGreen = request.QueryString["RedGreen"];
            string? imageText = request.QueryString["ImageText"];
            string? dogCat = request.QueryString["DogCat"];
            string? counterStr = request.QueryString["prevCounter"];

            if(redGreen == null || imageText == null || dogCat == null || counterStr == null) { return "Error"; }

            int prevCounter = int.Parse(counterStr);

            if(prevCounter == commonList.Count) { return "Unchanged"; }

            List<DogCatTextImageRedGreen> tempList = new List<DogCatTextImageRedGreen>();
            tempList = filter_ImageText(commonList, imageText);
            tempList = filter_RedGreen(tempList, redGreen);
            tempList = filter_DogCat(tempList, dogCat);

            if (imageText.Equals("Image")) // sort size
            {
                tempList.Sort((x, y) => x.height * x.width - y.height * y.width);
            }
            else // sort brightness
            {
                tempList.Sort((x, y) => x.R + x.G - y.R - y.G);
            }

            arrTypeSizeColor___Counter temp = new arrTypeSizeColor___Counter();
            temp.arrDogCatTIRG = tempList.ToArray();
            temp.Counter = commonList.Count;
            JsonSerializerOptions options = new JsonSerializerOptions { IncludeFields = true };
            return JsonSerializer.Serialize(temp, options);


        }


        static List<DogCatTextImageRedGreen> filter_RedGreen(List<DogCatTextImageRedGreen> tempList, string selectedColor)
        {
            List<DogCatTextImageRedGreen> returnList = new List<DogCatTextImageRedGreen>();

            foreach (DogCatTextImageRedGreen item in tempList)
            {
                bool isImageLabel = item.R == 255 && item.G == 255;

                bool isTextLabel = !isImageLabel;


                if (selectedColor == "Red")
                {
                    if (isTextLabel && item.R != 0 && item.G == 0)
                        returnList.Add(item);

                    if (isImageLabel && item.tagRedGreen.Equals("Red"))
                        returnList.Add(item);
                }
                else if (selectedColor == "Green")
                {
                    if (isTextLabel && item.R == 0 && item.G != 0)
                        returnList.Add(item);

                    // תמונה: שם מתאים (Cat_Green או Dog_Green)
                    if (isImageLabel && item.tagRedGreen.Equals("Green"))
                        returnList.Add(item);
                }
            }

            return returnList;
        }

        static List<DogCatTextImageRedGreen> filter_ImageText(List<DogCatTextImageRedGreen> tempList, string imageOrText)
        {
            List<DogCatTextImageRedGreen> returnList = new List<DogCatTextImageRedGreen>();

            foreach (DogCatTextImageRedGreen item in tempList)
            {
                
                if (imageOrText.Equals("Image"))
                {
                    if (item.R == 255 && item.G == 255)
                    {
                        returnList.Add(item);
                    }
                }
                else if (imageOrText.Equals("Text"))
                {
                    if (!(item.R == 255 && item.G == 255))
                    {
                        returnList.Add(item);
                    }
                }

            }

            return returnList;
        }

        static List<DogCatTextImageRedGreen> filter_DogCat(List<DogCatTextImageRedGreen> tempList, string DogOrCat)
        {
            List<DogCatTextImageRedGreen> returnList = new List<DogCatTextImageRedGreen>();

            foreach (DogCatTextImageRedGreen item in tempList)
            {
                if (item.DogCat.Equals(DogOrCat))
                {
                    returnList.Add(item);
                }
            }

            return returnList;
        }
    }
}



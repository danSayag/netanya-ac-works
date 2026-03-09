namespace CatDog_ImageText_Transport
{
    public delegate void myAddDelegate(UserControl1 UC_To, int counter_To, UserControl1 UC_From, int index_From);
    public delegate void myRemoveDelegate(UserControl1 UC, int i);
    public partial class Form1 : Form
    {
        private const int Width_From = 1700, Width_To = 1800, Width_Transport = 420;
        private const int N_From_To = 40, N_Transport = 50;

        private UserControl1[] arrUC_From = new UserControl1[4];
        private UserControl1[] arrUC_Transport = new UserControl1[4];
        private UserControl1[] arrUC_To = new UserControl1[4];



        private string[] arrRedGreen_CatDog = { "Cat_Red", "Cat_Green", "Dog_Red", "Dog_Green" };

        private Thread[] toTransport = new Thread[4], fromTransport = new Thread[4];

        private AutoResetEvent[] arrAutoResetEvent_1 = new AutoResetEvent[4], arrAutoResetEvent_2 = new AutoResetEvent[4];

        private int[] arrCounter_Transport = new int[4];
        private int[] arrCounter_To = new int[4];
        private bool[] arrIsEnd = new bool[4];
        public Form1()
        {
            InitializeComponent();

            for (int i = 0; i < 4; i++)
            {
                arrUC_From[i] = new UserControl1(Width_From, N_From_To, "Full");
                arrUC_From[i].Location = new Point(80, 20 + 95 * i);
                this.Controls.Add(arrUC_From[i]);

                arrUC_To[i] = new UserControl1(Width_To, N_From_To, "Empty");
                arrUC_To[i].Location = new Point(80, 550 + 100 * i);
                this.Controls.Add(arrUC_To[i]);

                arrUC_Transport[i] = new UserControl1(Width_Transport, N_Transport, "Empty");
                arrUC_Transport[i].Location = new Point(80 + 425 * i, 440);
                this.Controls.Add(arrUC_Transport[i]);

                arrAutoResetEvent_1[i] = new AutoResetEvent(false);
                arrAutoResetEvent_2[i] = new AutoResetEvent(false);
            }
        }

        private void startToolStripMenuItem_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < 4; i++)
            {
                toTransport[i] = new Thread(toTransport_Function);
                fromTransport[i] = new Thread(fromTransport_Function);

                toTransport[i].Start(i);
                fromTransport[i].Start(i);

            }
        }

        void toTransport_Function(object o)
        {
            int index = (int)o;

            while (true)
            {
                Label minLabel = null;
                int fromUCIndex = -1;
                int minLabelIndex = -1;
                int minArea = int.MaxValue;

                for (int k = 0; k < 4; k++)
                {
                    for (int i = 0; i < N_From_To; i++)
                    {
                        Label temp = arrUC_From[k].arrLabels[i];
                        if (temp == null) continue;

                        bool isMatch = (index == 0 && temp.Name == "Cat" && (temp.Tag == "Red" || temp.BackColor == Color.Red)) ||
                                       (index == 1 && temp.Name == "Cat" && (temp.Tag == "Green" || temp.BackColor == Color.Green)) ||
                                       (index == 2 && temp.Name == "Dog" && (temp.Tag == "Red" || temp.BackColor == Color.Red)) ||
                                       (index == 3 && temp.Name == "Dog" && (temp.Tag == "Green" || temp.BackColor == Color.Green));

                        if (isMatch)
                        {
                            int area = temp.Width * temp.Height;
                            if (area < minArea)
                            {
                                minArea = area;
                                minLabel = temp;
                                fromUCIndex = k;
                                minLabelIndex = i;
                            }
                        }
                    }
                }

                if (minLabel != null)
                {
                    this.Invoke(new myAddDelegate(add), arrUC_Transport[index], arrCounter_Transport[index], arrUC_From[fromUCIndex], minLabelIndex);
                    this.Invoke(new myRemoveDelegate(remove), arrUC_From[fromUCIndex], minLabelIndex);
                    arrCounter_Transport[index]++;
                    Thread.Sleep(100);

                    if (arrCounter_Transport[index] == 8)
                    {
                        arrAutoResetEvent_1[index].Set();
                        arrAutoResetEvent_2[index].WaitOne();
                        arrCounter_Transport[index] = 0;
                    }
                }
                else
                {
                    break;
                }
            }

            arrIsEnd[index] = true;
            arrAutoResetEvent_1[index].Set();
        }

        void fromTransport_Function(object o)
        {
            int index = (int)o;
            int to_index_image = 0;
            int to_index_color = arrUC_To[index].arrLabels.Length - 1;
            int currentX_image = 2;
            int currentX_color = Width_To - 90;

            while (true)
            {
                arrAutoResetEvent_1[index].WaitOne();
                for (int i = 0; i < arrCounter_Transport[index]; i++)
                {
                    Label temp = arrUC_Transport[index].arrLabels[i];
                    if (temp == null) continue;

                    if (temp.BackColor == Color.White) 
                    {
                        this.Invoke(new myAddDelegate(add), arrUC_To[index], to_index_image, arrUC_Transport[index], i);
                        this.Invoke(new myRemoveDelegate(remove), arrUC_Transport[index], i);
                        this.Invoke(new Action(() =>
                        {
                            arrUC_To[index].arrLabels[to_index_image].Location = new Point(currentX_image, 3);
                        }));
                        currentX_image += temp.Width + 2;
                        to_index_image++;
                    }
                    else 
                    {
                        this.Invoke(new myAddDelegate(add), arrUC_To[index], to_index_color, arrUC_Transport[index], i);
                        this.Invoke(new myRemoveDelegate(remove), arrUC_Transport[index], i);
                        this.Invoke(new Action(() =>
                        {
                            arrUC_To[index].arrLabels[to_index_color].Location = new Point(currentX_color, 3);
                        }));
                        currentX_color -= temp.Width + 2;
                        to_index_color--;
                    }
                    Thread.Sleep(100);
                }

                if (!arrIsEnd[index])
                {
                    arrCounter_Transport[index] = 0;
                    arrAutoResetEvent_2[index].Set();
                }
                else
                    break;
            }
        }


        private void add(UserControl1 UC_To, int counter_To, UserControl1 UC_From, int index_From)
        {
            UC_To.arrLabels[counter_To] = UC_From.arrLabels[index_From];
            UC_To.Controls.Add(UC_From.arrLabels[index_From]);
            UC_To.arrLabels[counter_To].Location = new Point(2 + 90 * counter_To, 3);
        }
        private void remove(UserControl1 UC, int index)
        {
            UC.Controls.Remove(UC.arrLabels[index]);
            UC.arrLabels[index] = null;
        }


    }
}

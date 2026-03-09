namespace WinFormsApp1
{
    public partial class Form1 : Form
    {


        Button[,] buttons = new Button[4, 4];
        public Form1()
        {
            InitializeComponent();
            createBoard();
        }





        private bool colorExist(Color c)
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (buttons[i, j] != null && buttons[i, j].BackColor == c)
                        return true;
            return false;
        }

        private bool numExist(int n)
        {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (buttons[i, j] != null && int.TryParse(buttons[i, j].Text, out int val) && val == n)
                        return true;
            return false;
        }





        private void createBoard()
        {
            Random rnd = new Random();

            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {

                    buttons[i, j] = new Button();
                    buttons[i, j].Size = new Size(80, 80);
                    buttons[i, j].Location = new Point(j * buttons[i, j].Width, i * buttons[i, j].Height + 50);

                    Color c = Color.FromArgb(rnd.Next(0, 256), rnd.Next(0, 256), rnd.Next(2, 255));
                    while (colorExist(c))
                        c = Color.FromArgb(rnd.Next(0, 256), rnd.Next(0, 256), rnd.Next(0, 256));
                    buttons[i, j].BackColor = c;
                    int num = rnd.Next(1, 16);
                    if (i == 3 && j == 3)
                    {
                        num = 1000;
                    }

                    while (numExist(num))
                        num = rnd.Next(1, 16);


                    buttons[i, j].Font = new System.Drawing.Font("Comic Sans MS", 18F, System.Drawing.FontStyle.Regular);

                    buttons[i, j].TabIndex = i * 4 + j;
                    buttons[i, j].Text = num.ToString();
                    buttons[i, j].Click += btnClick;
                    buttons[i, j].Visible = true;
                    if (i == 3 && j == 3)
                        buttons[i, j].Visible = false;
                    this.Controls.Add(buttons[i, j]);

                }





            }
        }





        //הבדיקה לסיום משחק באמיתית
        //private bool checkWin()
        //{
        //    int count = 1;
        //    for (int i = 0; i < 4; i++)
        //    {
        //        for (int j = 0; j < 4; j++)
        //        {
        //            if (i == 3 && j == 3)
        //                return true;

        //            if (buttons[i, j] == null || buttons[i, j].Text != count.ToString())
        //                return false;

        //            count++;
        //        }
        //    }
        //    return true;
        //}


        private void newGameButton()
        {
            Button button = new Button();
            button.Text = "New Game";
            button.Size = new Size(80 * 4, 50);
            button.Location = new Point(0, 0);
            button.Click += newGameClick;
            this.Controls.Add(button);

        }

        private void btnClick(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int i = btn.TabIndex / 4;
            int j = btn.TabIndex % 4;

            if (j < 3 && buttons[i, j + 1].Visible == false)
            {

                buttons[i, j + 1].Visible = true;
                buttons[i, j + 1].Text = buttons[i, j].Text;
                buttons[i, j + 1].BackColor = buttons[i, j].BackColor;
                buttons[i, j].Visible = false;

            }
            if (i < 3 && buttons[i + 1, j].Visible == false)
            {
                buttons[i + 1, j].Visible = true;
                buttons[i + 1, j].Text = buttons[i, j].Text;
                buttons[i + 1, j].BackColor = buttons[i, j].BackColor;
                buttons[i, j].Visible = false;
            }
            if (i > 0 && buttons[i - 1, j].Visible == false)
            {
                buttons[i - 1, j].Visible = true;
                buttons[i - 1, j].Text = buttons[i, j].Text;
                buttons[i - 1, j].BackColor = buttons[i, j].BackColor;
                buttons[i, j].Visible = false;
            }
            if (j > 0 && buttons[i, j - 1].Visible == false)
            {
                buttons[i, j - 1].Visible = true;
                buttons[i, j - 1].Text = buttons[i, j].Text;
                buttons[i, j - 1].BackColor = buttons[i, j].BackColor;
                buttons[i, j].Visible = false;
            }
            if (winGame())
            {
                createWinBox();
            }




        }










        public void createWinBox()
        {
            DialogResult result = MessageBox.Show("New Game?", "Game over!", MessageBoxButtons.YesNo);

            if (result == DialogResult.Yes)
            {
                clearBoard();
                createBoard();
            }
            else
            {
                Environment.Exit(0);
            }
        }




        private bool winGame()
        {
            if (buttons[0, 0] != null && buttons[0, 0].Text == "1" &&
                buttons[0, 1] != null && buttons[0, 1].Text == "2")
            {
                return true;
            }
            return false;
        }


        private void clearBoard()
        {
            for (int i = 0; i < 4; i++)
            { 
                for(int j = 0; j < 4; j++) 
                {
                    if(buttons[i, j] != null)
                    {
                        this.Controls.Remove(buttons[i, j]);
                    }
                }
            }
            buttons = new Button[4,4];


        }


        public void killClick(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }



        private void newGameClick(object sender, EventArgs e)
        {
            clearBoard();
            createBoard();

        }

        private void newGameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            clearBoard();
            createBoard();
        }
    }
}

using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsApp1
{
    public partial class Form1 : Form
    {

        Button[,] buttons = new Button[4, 4];
        int counter;
        Button movingButton;


        private bool colorExist(Color c)
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (buttons[i, j] != null && buttons[i, j].BackColor == c)
                        return true;
                }
            }
            return false;
        }


        private bool numExist(int n)
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (buttons[i, j] != null && buttons[i, j].Text == n.ToString())
                        return true;

                }
            }
            return false;
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
        private void clearBoard()
        {
            for(int i = 0; i < 4;  i++)
            {
                for(int j = 0 ; j < 4 ; j++)
                {
                    if(buttons[i, j] != null)
                    {
                        this.Controls.Remove(buttons[i, j]);    
                    }
                } 
            } 
            buttons = new Button[4, 4];
        }



        private void createBoard()
        {
            Random rnd = new Random();
            
            String pos = "";

            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    buttons[i, j] = new Button();
                    buttons[i, j].Size = new Size(80, 80);
                    buttons[i, j].Location = new Point(j * buttons[i, j].Width, i * buttons[i, j].Height+50);

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


                    buttons[i, j].TabIndex = i * 4 + j;
                    buttons[i, j].Text = num.ToString();
                    buttons[i, j].Font = new System.Drawing.Font("Comic Sans MS", 18F, System.Drawing.FontStyle.Regular);
                    buttons[i, j].Click += ButtonClick;

                    Controls.Add(buttons[i, j]);

                }
            }

            Controls.Remove(buttons[3, 3]);
            buttons[3, 3] = null;



        }


       



        private void ButtonClick(object sender, EventArgs e)
        {

            Button btn = (Button)sender;
            movingButton = btn;
            counter = 0;
            timer1.Interval = 20;
            timer1.Start();


        }






        //הבדיקה סיום משחק הפשוטה 
        private bool checkWin()
        {
            return (buttons[0, 0] != null && buttons[0, 0].Text == "1"
                 && buttons[0, 1] != null && buttons[0, 1].Text == "2");
        }


        private bool free(int i, int j)
        {
            try
            {
                return buttons[i, j] == null;
            }
            catch (Exception ex)
            {
                return false;
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


        private void newGameClick(object sender, EventArgs e)
        {
           
            createBoard();

        }


        



        private void moveLeft()
        {
            int i = movingButton.TabIndex / 4;
            int j = movingButton.TabIndex % 4;
            counter++;
            if (counter == 8)
            {
                buttons[i, j + 1] = buttons[i, j];
                buttons[i, j] = null;
                movingButton.TabIndex = i * 4 + (j + 1);
                movingButton.Location = new Point(movingButton.Location.X + 10, movingButton.Location.Y);
                return;
            }
            movingButton.Location = new Point(movingButton.Location.X + 10, movingButton.Location.Y);
        }



        private void moveDown()
        {
            int i = movingButton.TabIndex / 4;
            int j = movingButton.TabIndex % 4;
            counter++;
            if (counter == 8)
            {
                buttons[i + 1, j] = buttons[i, j];
                buttons[i, j] = null;
                movingButton.TabIndex = (i + 1) * 4 + j;

            }
            movingButton.Location = new Point(movingButton.Location.X, movingButton.Location.Y + 10);
        }


        private void moveUp()
        {
            int i = movingButton.TabIndex / 4;
            int j = movingButton.TabIndex % 4;
            counter++;
            if (counter == 8)
            {
                buttons[i - 1, j] = buttons[i, j];
                buttons[i, j] = null;
                movingButton.TabIndex = (i - 1) * 4 + j;

            }
            movingButton.Location = new Point(movingButton.Location.X, movingButton.Location.Y - 10);
        }

        private void moveRight()
        {
            int i = movingButton.TabIndex / 4;
            int j = movingButton.TabIndex % 4;
            counter++;
            if (counter == 8)
            {
                buttons[i, j - 1] = buttons[i, j];
                buttons[i, j] = null;
                movingButton.TabIndex = i * 4 + (j - 1);

            }
            movingButton.Location = new Point(movingButton.Location.X - 10, movingButton.Location.Y);
        }






        public Form1()
        {
            InitializeComponent();
            createBoard();

        }




        private void timer1_Tick(object sender, EventArgs e)
        {
            if (movingButton == null)
                return;

            int i = movingButton.TabIndex / 4;
            int j = movingButton.TabIndex % 4;

            int targetJLe = j + 1;
            int targetIDo = i + 1;
            int targetIUp = i - 1;
            int targetJRi = j - 1;

            if (free(i, targetJLe) && counter < 8)
            {
                if (movingButton.Left < 80 * 3)
                    moveLeft();
            }
            else if (free(targetIDo, j) && counter < 8)
            {
                if (movingButton.Top < 80 * 3 + 50)
                    moveDown();
            }
            else if (free(targetIUp, j) && counter < 8)
            {
                if (movingButton.Top > 0)
                    moveUp();
            }
            else if (free(i, targetJRi) && counter < 8)
            {
                if (movingButton.Top > 0)
                    moveRight();
            }
            else
            {

                timer1.Stop();
                movingButton = null;
                counter = 0;
                if (checkWin())
                {
                    createWinBox();
                }
                return;
            }

        }

        private void newGameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            clearBoard();
            createBoard();
        }
    }


}

namespace CatDog_ImageText_Transport
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menuStrip1 = new MenuStrip();
            startToolStripMenuItem = new ToolStripMenuItem();
            label1 = new Label();
            label2 = new Label();
            label4 = new Label();
            label5 = new Label();
            label7 = new Label();
            label8 = new Label();
            label3 = new Label();
            label6 = new Label();
            label9 = new Label();
            label10 = new Label();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.ImageScalingSize = new Size(23, 23);
            menuStrip1.Items.AddRange(new ToolStripItem[] { startToolStripMenuItem });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Padding = new Padding(7, 2, 0, 2);
            menuStrip1.Size = new Size(2309, 33);
            menuStrip1.TabIndex = 0;
            menuStrip1.Text = "menuStrip1";
            // 
            // startToolStripMenuItem
            // 
            startToolStripMenuItem.Name = "startToolStripMenuItem";
            startToolStripMenuItem.Size = new Size(64, 29);
            startToolStripMenuItem.Text = "Start";
            startToolStripMenuItem.Click += startToolStripMenuItem_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Arial", 16.2F);
            label1.ForeColor = Color.Red;
            label1.Location = new Point(0, 562);
            label1.Name = "label1";
            label1.Size = new Size(67, 38);
            label1.TabIndex = 1;
            label1.Text = "Cat";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Font = new Font("Arial", 16.2F);
            label2.ForeColor = Color.Red;
            label2.Location = new Point(169, 403);
            label2.Name = "label2";
            label2.Size = new Size(281, 38);
            label2.TabIndex = 2;
            label2.Text = "Cat Red Transport";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Arial", 16.2F);
            label4.ForeColor = Color.FromArgb(0, 192, 0);
            label4.Location = new Point(597, 403);
            label4.Name = "label4";
            label4.Size = new Size(311, 38);
            label4.TabIndex = 4;
            label4.Text = "Cat Green Transport";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Font = new Font("Arial", 16.2F);
            label5.ForeColor = Color.FromArgb(0, 192, 0);
            label5.Location = new Point(0, 674);
            label5.Name = "label5";
            label5.Size = new Size(67, 38);
            label5.TabIndex = 5;
            label5.Text = "Cat";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Arial", 16.2F);
            label7.ForeColor = Color.Black;
            label7.Location = new Point(0, 33);
            label7.Name = "label7";
            label7.Size = new Size(92, 38);
            label7.TabIndex = 7;
            label7.Text = "From";
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Font = new Font("Arial", 16.2F);
            label8.ForeColor = Color.Black;
            label8.Location = new Point(25, 461);
            label8.Name = "label8";
            label8.Size = new Size(51, 38);
            label8.TabIndex = 8;
            label8.Text = "To";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Font = new Font("Arial", 16.2F);
            label3.ForeColor = Color.Red;
            label3.Location = new Point(0, 771);
            label3.Name = "label3";
            label3.Size = new Size(76, 38);
            label3.TabIndex = 9;
            label3.Text = "Dog";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Arial", 16.2F);
            label6.ForeColor = Color.FromArgb(0, 192, 0);
            label6.Location = new Point(0, 877);
            label6.Name = "label6";
            label6.Size = new Size(76, 38);
            label6.TabIndex = 10;
            label6.Text = "Dog";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Font = new Font("Arial", 16.2F);
            label9.ForeColor = Color.FromArgb(0, 192, 0);
            label9.Location = new Point(1459, 403);
            label9.Name = "label9";
            label9.Size = new Size(320, 38);
            label9.TabIndex = 12;
            label9.Text = "Dog Green Transport";
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Font = new Font("Arial", 16.2F);
            label10.ForeColor = Color.Red;
            label10.Location = new Point(1047, 403);
            label10.Name = "label10";
            label10.Size = new Size(290, 38);
            label10.TabIndex = 11;
            label10.Text = "Dog Red Transport";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(2309, 1570);
            Controls.Add(label9);
            Controls.Add(label10);
            Controls.Add(label6);
            Controls.Add(label3);
            Controls.Add(label8);
            Controls.Add(label7);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(menuStrip1);
            MainMenuStrip = menuStrip1;
            Margin = new Padding(3, 2, 3, 2);
            Name = "Form1";
            Text = "Form1";
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem startToolStripMenuItem;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private Label label7;
        private Label label8;
        private Label label3;
        private Label label6;
        private Label label9;
        private Label label10;
    }
}


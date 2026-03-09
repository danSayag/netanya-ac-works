namespace Client
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
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            RedGreen_Label = new Label();
            ImageText_Label = new Label();
            timer1 = new System.Windows.Forms.Timer(components);
            SuspendLayout();
            // 
            // RedGreen_Label
            // 
            RedGreen_Label.AutoSize = true;
            RedGreen_Label.Font = new Font("Arial", 16.125F, FontStyle.Bold, GraphicsUnit.Point, 204);
            RedGreen_Label.ForeColor = Color.Red;
            RedGreen_Label.Location = new Point(2325, 43);
            RedGreen_Label.Name = "RedGreen_Label";
            RedGreen_Label.Size = new Size(103, 51);
            RedGreen_Label.TabIndex = 0;
            RedGreen_Label.Text = "Red";
            // 
            // ImageText_Label
            // 
            ImageText_Label.AutoSize = true;
            ImageText_Label.Font = new Font("Arial", 16.125F, FontStyle.Bold, GraphicsUnit.Point, 204);
            ImageText_Label.ForeColor = Color.Red;
            ImageText_Label.Location = new Point(2325, 127);
            ImageText_Label.Name = "ImageText_Label";
            ImageText_Label.Size = new Size(108, 51);
            ImageText_Label.TabIndex = 1;
            ImageText_Label.Text = "Text";
            // 
            // timer1
            // 
            timer1.Interval = 1000;
            timer1.Tick += timer1_Tick;
            // 
            // Form1
            // 
            ClientSize = new Size(2472, 414);
            Controls.Add(ImageText_Label);
            Controls.Add(RedGreen_Label);
            Name = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        private Label RedGreen_Label;
        private Label ImageText_Label;
        private System.Windows.Forms.Timer timer1;
    }
}


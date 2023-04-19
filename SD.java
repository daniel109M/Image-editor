//package com.memorynotfound.image;

import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ResizeImageExample {
static void blur(String path)
		throws IOException, InterruptedException
	{

		Color color[];

		
		File fin = new File(path);

		
		BufferedImage input = ImageIO.read(fin);

		
		BufferedImage output = new BufferedImage(
			input.getWidth(), input.getHeight(),
			BufferedImage.TYPE_INT_RGB);


		int i = 0;
		int max = 400, rad = 10;
		int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
		color = new Color[max];

		

		int x = 1, y = 1, x1, y1, ex = 5, d = 0;


		for (x = rad; x < input.getHeight() - rad; x++) {
			for (y = rad; y < input.getWidth() - rad; y++) {
				for (x1 = x - rad; x1 < x + rad; x1++) {
					for (y1 = y - rad; y1 < y + rad; y1++) {
						color[i++] = new Color(
							input.getRGB(y1, x1));
					}
				}


				i = 0;
				for (d = 0; d < max; d++) {
					a1 = a1 + color[d].getAlpha();
				}

				a1 = a1 / (max);
				for (d = 0; d < max; d++) {
					r1 = r1 + color[d].getRed();
				}

				r1 = r1 / (max);
				for (d = 0; d < max; d++) {
					g1 = g1 + color[d].getGreen();
				}

				g1 = g1 / (max);
				for (d = 0; d < max; d++) {
					b1 = b1 + color[d].getBlue();
				}

				b1 = b1 / (max);
				int sum1 = (a1 << 24) + (r1 << 16)
						+ (g1 << 8) + b1;
				output.setRGB(y, x, (int)(sum1));
			}
		}


		ImageIO.write(
			output, "jpg",
			new File(path));


		System.out.println("Image blurred successfully !");
	}
// Java program to demonstrate
// colored to grayscale conversion


	static void color(String path)
		throws IOException
	{
		BufferedImage img = null;
		File f = null;

		// read image
		try {
			f = new File(path);
			img = ImageIO.read(f);
		}
		catch (IOException e) {
			System.out.println(e);
		}

		// get image's width and height
		int width = img.getWidth();
		int height = img.getHeight();

		// convert to grayscale
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				
				// Here (x,y)denotes the coordinate of image
				// for modifying the pixel value.
				int p = img.getRGB(x, y);

				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;

				// calculate average
				int avg = (r + g + b) / 3;

				// replace RGB value with avg
				p = (a << 24) | (avg << 16) | (avg << 8)
					| avg;

				img.setRGB(x, y, p);
			}
		}

		// write image
		try {
			f = new File(path);
			ImageIO.write(img, "png", f);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}

 static void Resize(String path,int height,int width) throws IOException {

        File input = new File(path);
        BufferedImage image = ImageIO.read(input);
        //int height=this.height;
        BufferedImage resized = resize(image,height,width);

        File output = new File(path);
        ImageIO.write(resized, "png", output);

    }

    static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
static void a(){
	 JFrame jf= new JFrame("IMAGE EDITOR");
	jf.setSize(800,700);
	jf.setLayout(null);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JLabel img3 = new JLabel(new ImageIcon("C:\\Users\\HP\\Desktop\\JAVAS\\project\\pain.jpg"));
	jf.add(img3);
	img3.setBounds(0,0,800,700);
JLabel l1=new JLabel("Enter image location:");
       l1.setFont(new Font("Serif", Font.BOLD, 30));
       l1.setBounds(100,150, 800,40);
l1.setForeground(Color.BLUE);
       img3.add(l1);
JLabel l2=new JLabel("Enter SIZE :");
       l2.setFont(new Font("Serif", Font.BOLD, 20));
       l2.setBounds(100,250, 800,40);
l2.setForeground(Color.BLUE);
       img3.add(l2);
JLabel l4=new JLabel("Enter ANGLE :");
       l4.setFont(new Font("Serif", Font.BOLD, 20));
       l4.setBounds(100,550, 800,40);
l4.setForeground(Color.BLUE);
       img3.add(l4);
JLabel l3=new JLabel("IMAGE EDITED SUCCESSFULLY");
       l3.setFont(new Font("Serif", Font.BOLD, 20));
       l3.setBounds(150,100, 800,40);
l3.setForeground(Color.BLUE);
       img3.add(l3);
l3.setVisible(false);
/*JLabel l3=new JLabel("Enter Colour :");
       l3.setFont(new Font("Serif", Font.BOLD, 20));
       l3.setBounds(70,350, 800,40);
l3.setForeground(Color.CYAN);
       img3.add(l3);*/
	 JButton b1=new JButton("RESIZE");
	 img3.add(b1);
	b1.setBackground(Color.RED);
	b1.setForeground(Color.WHITE);
	JButton b3=new JButton("CHANGE to B&W");
	img3.add(b3);
	b3.setBackground(Color.RED);
	b3.setForeground(Color.WHITE);
JButton b2=new JButton("CTRL +V");
	img3.add(b2);
	b2.setBackground(Color.BLUE);
	b2.setForeground(Color.WHITE);
	 b2.setBounds(600,200, 100,30);
    img3.add(b2);
 JButton b5=new JButton("ROTATE");
	 img3.add(b5);
	b5.setBackground(Color.RED);
	b5.setForeground(Color.WHITE);


JTextField t1=new JTextField(40);
t1.setFont(new Font("Serif", Font.PLAIN, 20));
img3.add(t1);
t1.setBounds(470,150, 250,40);
JTextField t2=new JTextField(10);
t2.setFont(new Font("Serif", Font.PLAIN, 20));
img3.add(t2);
t2.setBounds(280,250, 50,40);
JTextField t3=new JTextField(10);
t3.setFont(new Font("Serif", Font.PLAIN, 20));
img3.add(t3);
t3.setBounds(350,250, 50,40);
JTextField t4=new JTextField(10);
t4.setFont(new Font("Serif", Font.PLAIN, 20));
img3.add(t4);
t4.setBounds(320,550, 50,40);
/*JTextField t4=new JTextField(10);
t4.setFont(new Font("Serif", Font.PLAIN, 20));
img3.add(t4);
t4.setBounds(250,350, 120,40);*/
	/*JButton b2=new JButton("OPEN CHAT");
    b2.setBounds(260,350, 250,40); 
    img3.add(b2);
	b2.setBackground(Color.CYAN);
	b2.setForeground(Color.WHITE);*/
	JButton b4=new JButton("BLUR");
	img3.add(b4);
	b4.setBackground(Color.RED);
	b4.setForeground(Color.WHITE);
	 b1.setBounds(420,250, 250,40); 
	 b3.setBounds(260,350, 250,40); 
	 b4.setBounds(260,450, 250,40);
 b5.setBounds(420,550, 250,40);
b2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	 //jf.dispose();
t1.paste();

	}
	}); 
b5.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	 //jf.dispose();
      String path=t1.getText();
      int angle=Integer.parseInt((t4.getText()));
    rotate(path,angle);
l3.setVisible(true);
	}
	}); 
	b4.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	 jf.dispose();
String path=t1.getText();
	 try{
     blur(path);
l3.setVisible(true);
}catch(Exception e3){ e3.printStackTrace();}

	}
	});
	b3.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	 jf.dispose();
String path=t1.getText();
	 try{
     color(path);
l3.setVisible(true);}catch(IOException e2){ e2.printStackTrace();
     }
	//decryp();
	}
	});
	b1.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	 jf.dispose();
String path=t1.getText();
String h=t2.getText();
String w=t3.getText();
int h1=Integer.parseInt(h);
int w1=Integer.parseInt(w);
try{
Resize(path,h1,w1);
l3.setVisible(true);}catch(Exception e1){e1.printStackTrace();}
	//abc();
	}
	});

	 jf.setVisible(true);
	}

static BufferedImage rotate(BufferedImage img,int angle)
	{

		int width = img.getWidth();
		int height = img.getHeight();

		BufferedImage newImage = new BufferedImage(
			img.getWidth(), img.getHeight(), img.getType());

		Graphics2D g2 = newImage.createGraphics();


		g2.rotate(Math.toRadians(angle), width / 2,
				height / 2);
		g2.drawImage(img, null, 0, 0);

		return newImage;
	}

	 static void rotate(String path,int angle)
	{

		try {


			BufferedImage originalImg = ImageIO.read(
				new File(path));
			BufferedImage SubImg = rotate(originalImg,angle);
			File outputfile
				= new File(path);
ImageIO.write(SubImg, "jpg", outputfile);
		}

		catch (IOException e) {
e.printStackTrace();
		}
	}


    public static void main(String... args){

       JFrame jf1= new JFrame("IMAGE EDITOR");
jf1.setSize(1000,800);

jf1.setLayout(null);
jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
JLabel j1=new JLabel("WELCOME");
j1.setFont(new Font("Serif",Font.BOLD,40));
j1.setForeground(Color.CYAN);
j1.setBounds(370,200,300,80);
JLabel j2=new JLabel("TO");
j2.setFont(new Font("Serif",Font.BOLD,40));
j2.setForeground(Color.RED);
j2.setBounds(460,300,300,80);
JLabel j3=new JLabel("''IMAGE EDITOR''");
j3.setFont(new Font("Serif",Font.BOLD,50));
j3.setForeground(Color.CYAN);
j3.setBounds(300,400,800,80);
JLabel img = new JLabel(new ImageIcon("C:\\Users\\HP\\Desktop\\JAVAS\\project\\akastuki.jpg"));
jf1.add(img);
img.setBounds(0,0,1000,800);
img.add(j1);
img.add(j2);
img.add(j3);


JButton jb=new JButton("ENTER");
img.add(jb);
jb.setBounds(450,600,80,30);
jb.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
jf1.dispose();
a();
}
});
jf1.setVisible(true);
}


   
}

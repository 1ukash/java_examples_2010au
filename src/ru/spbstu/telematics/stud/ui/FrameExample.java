package ru.spbstu.telematics.stud.ui;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameExample {

	public static class MyJFrame extends JFrame {

		public MyJFrame() throws HeadlessException {
			super();
		}

		@Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawString("Hello world", 100, 100);
			
//			Line2D line;
//			Rectangle rect;
//			Ellipse2D ellipse;
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("/tmp/image.gif"));
		
		MyJFrame myFrame = new MyJFrame();
		myFrame.setBounds(100, 100, 200, 400);

		myFrame.getContentPane().add(new JButton("hello"));
		// myFrame.add(new Button("hello"));
		

		myFrame.setVisible(true);
	}
}

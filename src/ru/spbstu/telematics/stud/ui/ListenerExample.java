package ru.spbstu.telematics.stud.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ListenerExample {
	public static class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			label.setText("pressed");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			label.setText("released");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
	static JLabel label = new JLabel("not clicked yet");

	public static void main(String[] args) {
		final JFrame myFrame = new JFrame();
		myFrame.setBounds(100, 100, 200, 400);
		JButton b = new JButton("click me");
		
		MouseListener myListener = new MyMouseListener();
		b.addMouseListener(myListener);
		
		b.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
		
		
		myFrame.add(label, BorderLayout.CENTER);
		myFrame.add(b, BorderLayout.NORTH);
		myFrame.setVisible(true);
		
//		myFrame.setBounds(100,100,200,500);
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				myFrame.setBounds(100,100,200,500);
				
			}
		});
		
	}
}

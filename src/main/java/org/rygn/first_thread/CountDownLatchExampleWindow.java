package org.rygn.first_thread;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountDownLatchExampleWindow extends JFrame {

	JButton bouton = new JButton("D�cr�menter le compte � rebours");
	
	JLabel info = new JLabel();

	CountDownLatch lock;

	public CountDownLatchExampleWindow(CountDownLatch pLock){

	     this.lock = pLock;
	     
	     JPanel panneau = new JPanel();
	     
	     panneau.setLayout(new BorderLayout());
	     
	     this.info.setText("Compte � rebours : " + lock.getCount());
	     
	     this.info.setHorizontalAlignment(JLabel.CENTER);
	     
	     panneau.add(bouton, BorderLayout.NORTH);
	     
	     panneau.add(info, BorderLayout.SOUTH);
	     
	     this.getContentPane().add(panneau);
	     
	     this.setTitle("CountDownLatch");
	     
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     
	     this.setLocationRelativeTo(null);
	     
	     this.pack();
	     	     
	     this.bouton.addActionListener(new ActionListener() {
			
	           public void actionPerformed(ActionEvent e){
	              
	        	   lock.countDown();
	              
	        	   info.setText("Compte � rebours : " + lock.getCount());
	           }
	     });
	     
	     this.setVisible(true);
	   }
}

package blood.gui;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import blood.model.BloodManager;

public class BloodMain extends JFrame implements ActionListener{
	Choice ch;
	JButton bt; //JFrame has a JButton
	BloodManager manager;
	
	public BloodMain() {
		ch = new Choice();
		ch.add("A");
		ch.add("B");
		ch.add("O");
		ch.add("AB");
		
		bt = new JButton("Regist");
		
		//compoent will be placed in flowlayout !!
		setLayout(new FlowLayout()); 
		add(ch); //add on window 
		add(bt); //add on window
		
		setVisible(true); 
		setSize(300,400); //width, height
		setDefaultCloseOperation(EXIT_ON_CLOSE); //kill process when 
		//closing window
		
		//connect  bewteen button and Listner
		bt.addActionListener(this);
		
		manager = new BloodManager();
	}

	//program to do...
	public void actionPerformed(ActionEvent e) {
		//System.out.println("call me??");
		
		String blood=ch.getSelectedItem(); //user selected value
		String msg=manager.getAdvice(blood);
		JOptionPane.showMessageDialog(this, msg);		
	}
	public static void main(String[] args) {
		new BloodMain();			
	}

}








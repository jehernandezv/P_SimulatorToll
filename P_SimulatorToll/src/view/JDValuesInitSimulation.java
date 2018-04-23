package view;

import java.awt.BorderLayout;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import controller.Controller;
import controller.EAction;

public class JDValuesInitSimulation extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	private JPEnterDate jpEnterDate;
	private JLabel jLabelTitle;
	private JButton jButtonAcept;
	
		public JDValuesInitSimulation(Controller controller) {
			this.setModal(true);
			this.setSize(600, 600);
			this.setLocationRelativeTo(null);
			this.setLayout(new BorderLayout());
			jLabelTitle = new JLabel("SELECT VALUES SIMULATION");
			jpEnterDate = new JPEnterDate();
			jButtonAcept = new JButton("Accept");
			jButtonAcept.addActionListener(controller);
			jButtonAcept.setActionCommand(EAction.ACCEPT_CONFIG.name());
			init();
			
		}
		
		public void init(){
		this.add(jLabelTitle,BorderLayout.NORTH);
		this.add(jpEnterDate, BorderLayout.CENTER);
		this.add(jButtonAcept, BorderLayout.SOUTH);
		}
		
		public void showDialog(){
			this.setVisible(true);
		}
		
		public byte getCantStand(){
			return jpEnterDate.getCantStand();
		}
		
		public LocalTime getTimeBefore(){
			return jpEnterDate.getTimeBefore();
		}
		
		public LocalTime getTimeAfter(){
			return jpEnterDate.getTimeAfter();
		}
}

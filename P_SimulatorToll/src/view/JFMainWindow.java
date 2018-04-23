package view;

import java.awt.BorderLayout;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;

public class JFMainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPMenuSimulation jpMenuSimulation;
	private JDValuesInitSimulation jdValuesInitSimulation;
	
	public JFMainWindow(Controller controller) {
		this.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 400);
		//this.setExtendedState(MAXIMIZED_BOTH);
		jpMenuSimulation = new JPMenuSimulation(controller);
		jdValuesInitSimulation = new JDValuesInitSimulation(controller);
		this.setVisible(true);
		init();
	}
	
	private void init() {
		this.add(jpMenuSimulation,BorderLayout.CENTER);
		this.add(new JLabel("aaaaaaaa"), BorderLayout.EAST);
		this.add(new JLabel("bbbbbbbb"), BorderLayout.WEST);
		this.add(new JLabel("norte"), BorderLayout.NORTH);
	}

	public void dispouseJFMainWindow(){
		jdValuesInitSimulation.dispose();
		this.dispose();
		
	}
	
	public void showDialog(){
		this.jdValuesInitSimulation.showDialog();
	}
	
	public byte getCantStand(){
		return jdValuesInitSimulation.getCantStand();
	}
	
	public LocalTime getTimeBefore(){
		return jdValuesInitSimulation.getTimeBefore();
	}
	
	public LocalTime getTimeAfter(){
		return jdValuesInitSimulation.getTimeAfter();
	}
	
	public boolean validateDates(){
		return jdValuesInitSimulation.validateDates();
	}

}

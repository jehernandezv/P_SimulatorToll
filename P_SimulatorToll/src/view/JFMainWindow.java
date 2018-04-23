package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Controller;

public class JFMainWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPMenuSimulation jpMenuSimulation;
	private JDValuesInitSimulation jdValuesInitSimulation;
	private JLabel jLabelEast,jLabelWest;
	private ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
	private static final String NAME_APP = "SIMULATOR TOLL";
	
	public JFMainWindow(Controller controller) {
		this.setTitle(NAME_APP);
		this.setIconImage(icon.getImage());
		this.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 400);
		//this.setExtendedState(MAXIMIZED_BOTH);
		jpMenuSimulation = new JPMenuSimulation(controller);
		jdValuesInitSimulation = new JDValuesInitSimulation(controller);
		jLabelEast = new JLabel("           ");
		jLabelWest = new JLabel("           ");
		this.setVisible(true);
		init();
	}
	
	private void init() {
		jLabelEast.setBackground(Color.decode("#91DC5A"));
		jLabelWest.setBackground(Color.decode("#91DC5A"));
		
		this.add(jpMenuSimulation,BorderLayout.CENTER);
		this.add(jLabelEast, BorderLayout.EAST);
		this.add(jLabelWest, BorderLayout.WEST);
		this.add(new JLabel(), BorderLayout.NORTH);
		this.paintAll(this.getGraphics());
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

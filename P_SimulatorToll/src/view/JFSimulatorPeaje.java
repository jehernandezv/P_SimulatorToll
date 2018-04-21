package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.TypeVehicle;


public class JFSimulatorPeaje extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPLane jpLane;

	public JFSimulatorPeaje() {
		this.setSize(400, 400);
		this.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		this.jpLane = new JPLane();
	}
	
	public void init() {
		this.add(this.jpLane, BorderLayout.CENTER);
	}


	public JPLane getJpLane() {
		return jpLane;
	}
	
	public byte sizeLane(){
		return jpLane.sizeVehicles();
	}
	
	 public void addVehicleLand(TypeVehicle typeVehicle){
		 jpLane.addVehicleLand(typeVehicle);
	 }
	 
	 public ArrayList<JPanelDrawVehicle>getVehiclesLane(){
		return jpLane.getVehiclesLane();
	 }

}

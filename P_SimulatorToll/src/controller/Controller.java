package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import view.JFSimulatorPeaje;
import model.TypeVehicle;

public class Controller {
	
	private JFSimulatorPeaje jfSimulation;
	private Timer timerCreateVehicle,timerMove,timerEliminateVehicleView;
	private Random random;
	private final static int SPEED_CREATE_VEHICLE = 7000;
	
	public Controller() {
		this.jfSimulation = new JFSimulatorPeaje();
		this.randomGenerateVehicle();
		this.move();
	}
	
	public TypeVehicle randomNewVehicleAnimated(){
		this.random = new Random();
		return TypeVehicle.values()[random.nextInt(3)];
	}
	
	public void randomGenerateVehicle(){
		this.random = new Random();
		 timerCreateVehicle = new Timer(this.random.nextInt(SPEED_CREATE_VEHICLE)+ 3000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if(jfSimulation.sizeLane() < 5){
					jfSimulation.addVehicleLand(randomNewVehicleAnimated());
				jfSimulation.init();
				jfSimulation.revalidate();
		    	}
			//}
		});
		timerCreateVehicle.start();
		
	}
	
	public void moveVehicle(){
		for (int i = jfSimulation.getVehiclesLane().size() -1; i >= 0; i--) {
			if(!jfSimulation.getVehiclesLane().get(4).geteStatusJPanel().equals(TypeVehicle.EMPRY)){
				timerEliminateVehicleView = new Timer(2950, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jfSimulation.getVehiclesLane().get(4).seteStatusJPanel(TypeVehicle.EMPRY);
					}
				});
				timerEliminateVehicleView.start();
			}
			if(!jfSimulation.getVehiclesLane().get(i).geteStatusJPanel().equals(TypeVehicle.EMPRY)){
				jfSimulation.getVehiclesLane().get(i+1).seteStatusJPanel(jfSimulation.getVehiclesLane().get(i).geteStatusJPanel());
				jfSimulation.getVehiclesLane().get(i).seteStatusJPanel(TypeVehicle.EMPRY);
			}
		}
	}
	
	public void move(){
		timerMove = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveVehicle();
				jfSimulation.repaint();
				
			}
		});
		timerMove.start();
	}

}

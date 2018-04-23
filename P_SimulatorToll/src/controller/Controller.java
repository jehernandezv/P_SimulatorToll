package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;
import javax.swing.Timer;
import view.JFMainWindow;
import view.JFSimulatorPeaje;
import model.Toll;
import model.TypeVehicle;

public class Controller implements ActionListener{

	private JFSimulatorPeaje jfSimulation;
	private JFMainWindow jfMainWindow;
	private Timer timerCreateVehicle, timerMove, timerEliminateVehicleView;
	private Random random = new Random();
	private final static int SPEED_CREATE_VEHICLE = 7000;
	private Toll toll;
	private byte indexEliminate;

	public Controller() throws IOException, URISyntaxException {
		jfMainWindow = new JFMainWindow(this);
		
		}
	
	public void actionPerformed(ActionEvent e) {
		switch (EAction.valueOf(e.getActionCommand())) {
		case CONFIG_SIMULATION:
			jfMainWindow.showDialog();
			break;
		case ACCEPT_CONFIG:
			jfMainWindow.dispouseJFMainWindow();
			byte cant = jfMainWindow.getCantStand();
			try {
				initSimulation(cant);
			} catch (IOException | URISyntaxException e1) {
				e1.printStackTrace();
			}
			
			break;
		case PAUSE_SIMULATION:
			stopSimulation();
			break;
			
		case JBUTTON_RESUME_SIMULATION:
			resumeSimulation();
			break;
		default:
			break;
		}
	}
	
	public void resumeSimulation(){
		timerMove.start();
		timerEliminateVehicleView.start();
		timerCreateVehicle.start();
	}
	
	public void stopSimulation(){
		timerMove.stop();
		timerEliminateVehicleView.stop();
		timerCreateVehicle.stop();
	}

	
	private void initSimulation(byte cant) throws IOException, URISyntaxException{
		this.jfSimulation = new JFSimulatorPeaje((byte) cant,this);
		toll = new Toll((short) cant);
		if(true){
		this.randomGenerateVehicle();
		this.move();
		}
	}
	
	public TypeVehicle randomNewTypeVehicle() {
		return TypeVehicle.values()[random.nextInt(3)];
	}
	
	public void randomGenerateVehicle() {
		timerCreateVehicle = new Timer(
				this.random.nextInt(SPEED_CREATE_VEHICLE) + 3000,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							toll.addVehiclesStandRandom();
							for (int i = 0; i < toll.getListStands().size(); i++) {
								if(!toll.getListStands().get(i).getQueueGroupVehiclesLane().isEmpty()){
									jfSimulation.getGroupLane().getJpStans().get(i).addVehicleLand(toll.getListStands().get(i).getQueueGroupVehiclesLane().copyDequeue().getTypeVehicle());
								}
								jfSimulation.revalidate();
							}
						} catch (IOException | URISyntaxException e1) {
							e1.printStackTrace();
						}
					}
				});
		timerCreateVehicle.start();

	}

	public void moveVehicle() {
		for (int k = 0; k < jfSimulation.getSizeStands(); k++) {
			for (int i = jfSimulation.getSizeVehiclesAtStand((byte) k) - 1; i >= 0; i--) {
				if (!jfSimulation.getJPLaneIndex((byte) k).getTypeVehicle((byte) 4).equals(TypeVehicle.EMPRY)) {
					jfSimulation.getJPLaneIndex((byte) k).getJpStandLane().setStatus(true);
					indexEliminate = (byte) k;
					timerEliminateVehicleView = new Timer(500,new ActionListener() {
								public void actionPerformed(ActionEvent e) {
										jfSimulation.getGroupLane().getJpStans().get(indexEliminate).getVehiclesLane().get(4).seteStatusJPanel(TypeVehicle.EMPRY);
										jfSimulation.getJPLaneIndex((byte) indexEliminate).getJpStandLane().setStatus(false);
								}
							});
						timerEliminateVehicleView.start();
						
				}else  if (!jfSimulation.getJPLaneIndex((byte) k).getTypeVehicle((byte) i).equals(TypeVehicle.EMPRY)){
					if(jfSimulation.getJPLaneIndex((byte) k).getTypeVehicle((byte) ((byte) i +1) ).equals(TypeVehicle.EMPRY)){
					jfSimulation.getJPLaneIndex((byte) k).getVehiclesLane().get(i + 1).seteStatusJPanel(jfSimulation.getJPLaneIndex((byte) k).getTypeVehicle((byte) i));
					jfSimulation.getJPLaneIndex((byte) k).getVehiclesLane().get(i).seteStatusJPanel(TypeVehicle.EMPRY);
					}
				}
			}
		}
	}

	public void move() {
		timerMove = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveVehicle();
				jfSimulation.refresh();
				jfSimulation.repaint();

			}
		});
		timerMove.start();
	}



	

}

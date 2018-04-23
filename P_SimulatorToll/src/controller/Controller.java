package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import view.CustomException;
import view.JFMainWindow;
import view.JFSimulatorPeaje;
import view.ValidateDates;
import model.Toll;
import model.TypeVehicle;

public class Controller implements ActionListener{

	private JFSimulatorPeaje jfSimulation;
	private JFMainWindow jfMainWindow;
	private Timer timerCreateVehicle, timerMove, timerEliminateVehicleView,timerCronometer;
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
			ValidateDates validateDates = new ValidateDates();
			try {
				try {
					validateDates.validateTime(jfMainWindow.getTimeBefore(), jfMainWindow.getTimeAfter());
					jfMainWindow.dispouseJFMainWindow();
					byte cant = jfMainWindow.getCantStand();
					LocalTime after = jfMainWindow.getTimeAfter();
					LocalTime before = jfMainWindow.getTimeBefore();
					initSimulation(cant,before,after);
				} catch (CustomException | NullPointerException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR DE VALIDACION", JOptionPane.WARNING_MESSAGE);
				}
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
		timerCronometer.start();
	}
	
	public void stopSimulation(){
		timerMove.stop();
		timerCreateVehicle.stop();
		timerEliminateVehicleView.stop();
		timerCronometer.stop();
	}

	
	private void initSimulation(byte cant,LocalTime before , LocalTime after) throws IOException, URISyntaxException{
		this.jfSimulation = new JFSimulatorPeaje((byte) cant,this);
		toll = new Toll((short) cant);
		this.randomGenerateVehicle();
		this.move();
		this.cromometer(before,after);
	}
	
	private boolean isLimit(LocalTime actual,LocalTime limit){
		return (actual.isAfter(limit));
	}
	
	private void finalSimulation(boolean flag){
		if(flag){
		stopSimulation();
		jfSimulation.disableSimulation();
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
										toll.getListStands().get(indexEliminate).passVehicleList();
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
	
	public void cromometer(LocalTime before,LocalTime after){
		timerCronometer = new Timer(1000, new ActionListener() {
			byte second = (byte) before.getSecond();
			byte minute = (byte) before.getMinute();
			byte hour = (byte) before.getHour();
			public void actionPerformed(ActionEvent e) {
				second ++;
				if(second == 60){
					minute ++;
					second = 0;
				}
				if(minute == 60){
					hour++;
					minute = 0;
				}
				jfSimulation.setTimeJLabel("Hour : " + hour + " Minutes : " + minute + " Second : " + second);
				 LocalTime actual = LocalTime.of(hour, minute, second);
				finalSimulation(isLimit(actual, after));
			}
		});
		timerCronometer.start();
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

package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.Controller;


public class JFSimulatorPeaje extends JFrame{
	private static final long serialVersionUID = 1L;
	private GroupLane groupLane;
	private JPButtonSimulation jpButtonSimulation;
	


	public JFSimulatorPeaje(byte cant,Controller controller) {
		this.setSize(400, 400);
		this.setLayout(new BorderLayout());
		jpButtonSimulation = new JPButtonSimulation(controller);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		this.groupLane = new GroupLane((short)cant,controller);
		init();
	}
	
	public void init() {
		this.add(jpButtonSimulation, BorderLayout.NORTH);
		this.add(this.groupLane, BorderLayout.CENTER);
	}
	
	public void refresh(){
		groupLane.refresh();
	}
	
	 public GroupLane getGroupLane() {
		return groupLane;
	}
	 
	 public void setTimeJLabel(String string){
			jpButtonSimulation.setTimeJLabel(string);
		}

	public void setGroupLane(GroupLane groupLane) {
		this.groupLane = groupLane;
	}
	
	public byte getSizeStands(){
		return groupLane.getSizeStands();
	}
	
	public byte getSizeVehiclesAtStand(byte index){
		return groupLane.getSizeVehiclesAtStand(index);
	}
	
	public JPLane getJPLaneIndex(byte index){
		return groupLane.getJPLaneIndex(index);
	}

}

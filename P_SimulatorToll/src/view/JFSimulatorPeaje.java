package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;


public class JFSimulatorPeaje extends JFrame{
	private static final String NAME_APP = "SIMULATOR TOLL";
	private static final long serialVersionUID = 1L;
	private GroupLane groupLane;
	private JPButtonSimulation jpButtonSimulation;
	private JPLimitSimulation jpLimitSimulation;
	private ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
	


	public JFSimulatorPeaje(byte cant,Controller controller) {
		this.setTitle(NAME_APP);
		this.setIconImage(icon.getImage());
		this.setSize(400, 400);
		this.setLayout(new BorderLayout());
		jpButtonSimulation = new JPButtonSimulation(controller);
		jpLimitSimulation = new JPLimitSimulation();
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
		this.add(jpLimitSimulation, BorderLayout.SOUTH);
	}
	
	public void refresh(){
		groupLane.refresh();
	}
	
	 public GroupLane getGroupLane() {
		return groupLane;
	}
	 
	 public void disableSimulation(){
		 this.dispose();
	 }
	 
	 public void sentValuesJPLimitSimulationBefore(LocalTime before,LocalTime after){
			jpLimitSimulation.sentValuesJPLimitSimulationBefore(before, after);
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

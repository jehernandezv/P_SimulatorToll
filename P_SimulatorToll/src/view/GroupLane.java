package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GroupLane extends JPanel{
	private static final long serialVersionUID = 1L;
	private ArrayList<JPLane> jpStans;
	private short cantStands;


	public GroupLane(short cant) {
		this.setLayout(new GridLayout(cant,1));
		this.jpStans = new ArrayList<JPLane>();
		for (int i = 0; i < cant; i++) {
			jpStans.add(new JPLane());
			this.add(new JPLane());
		}
	}
	
	public void refresh(){
		this.removeAll();
		for (int i = 0; i < jpStans.size(); i++) {
			this.add(jpStans.get(i));
		}
	}

	public ArrayList<JPLane> getJpStans() {
		return jpStans;
	}

	public void setJpStans(ArrayList<JPLane> jpStans) {
		this.jpStans = jpStans;
	}


	public short getCantStands() {
		return cantStands;
	}
	
	public void setCantStands(short cantStands) {
		this.cantStands = cantStands;
	}
	
	public byte getSizeStands(){
		return (byte) jpStans.size();
	}
	
	public byte getSizeVehiclesAtStand(byte index){
		return jpStans.get(index).sizeLane();
	}
	
	public JPLane getJPLaneIndex(byte index){
		return jpStans.get(index);
	}
	

}

package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.TypeVehicle;
public class JPLane extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private short idLane;
	private byte numVehiclesLane;
	private ArrayList<JPanelDrawVehicle> jPanelsLand;
	
	public JPLane() {
		this.idLane = 8;
		this.setLayout(new GridLayout(1,5));
		jPanelsLand = new ArrayList<JPanelDrawVehicle>();
		for (int i = 0; i < 5; i++) {
			jPanelsLand.add(new JPanelDrawVehicle());
			this.add(jPanelsLand.get(i));
		}
	}

	public void addVehicleLand(TypeVehicle typeVehicle){
		if(this.jPanelsLand.get(0).geteStatusJPanel().equals(TypeVehicle.EMPRY)){
		this.jPanelsLand.get(0).seteStatusJPanel(typeVehicle);
		this.numVehiclesLane ++;
		}
	}
	
	public byte sizeVehicles(){
		return this.numVehiclesLane;
	}
	
	public ArrayList<JPanelDrawVehicle> getVehiclesLane(){
		return this.jPanelsLand;
	}
	
	
	//Getters and Setters

	public short getIdLane() {
		return idLane;
	}

	public void setIdLane(short idLane) {
		this.idLane = idLane;
	}
	
	public byte sizeLane(){
		return (byte) this.jPanelsLand.size();
	}
	
	public TypeVehicle getTypeVehicle(byte index){
		return jPanelsLand.get(index).geteStatusJPanel();
	}
	
	public void setTipeVehicleAtJpanel(byte index,TypeVehicle typeVehicle){
		jPanelsLand.get(index).seteStatusJPanel(typeVehicle);
	}
	
}

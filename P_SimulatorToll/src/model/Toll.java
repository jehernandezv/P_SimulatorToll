package model;

import java.util.ArrayList;
import java.util.Random;


public class Toll {
	private short idToll;
	private ArrayList<Stand> listStands;
	
	
	public Toll() {
		
	}
	
	
	public Vehicle createVehicle(){
		Random random = new Random();
		short idVehicle = (short) random.nextInt(80);
		TypeVehicle typeVehicle = TypeVehicle.values()[random.nextInt(3)];
		short numPlate = (short) random.nextInt(999);
		Vehicle vehicle = new Vehicle(idVehicle, typeVehicle, "RFG " + numPlate);
		return vehicle;
	}

}

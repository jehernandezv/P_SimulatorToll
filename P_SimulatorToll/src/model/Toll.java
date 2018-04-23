package model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

import persistence.FileManager;
import utilities.StringUtilies;


public class Toll {
	private short idToll;
	private ArrayList<Stand> listStands;
	private Random random = new Random();
	
	
	public Toll(short cantStand) throws IOException, URISyntaxException {
		listStands = new ArrayList<Stand>();
		for (int i = 0; i < cantStand; i++) {
			listStands.add(new Stand());
		}
	}
	
	
	public void addVehiclesStandRandom() throws IOException, URISyntaxException{
		this.listStands.get(random.nextInt(listStands.size())).addVehicleTail(createVehicle());
	}
	
	public Vehicle createVehicle() throws IOException, URISyntaxException{
		short idVehicle =(short) ((short) FileManager.getLastId() - 80);
		TypeVehicle typeVehicle = TypeVehicle.values()[random.nextInt(3)];
		short numPlate = (short) FileManager.getLastId();
		Vehicle vehicle = new Vehicle(idVehicle, typeVehicle, StringUtilies.randomString(3) + numPlate);
		
		return vehicle;
	}
	
	public ArrayList<Stand> getListStands(){
		return listStands;
	}
 
}

package model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

import persistence.FileManager;
import utilities.StringUtilies;


public class Toll {
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
	//=============================== Reporte ==========================================
	//General
	public long getTotalVehiclesPass(){
		long numVehicles = 0;
		for (int i = 0; i < listStands.size(); i++) {
			numVehicles += listStands.get(i).getLinkedListVehiclesPass().size();
		}
		return numVehicles;
	}
	//General
	public MyLinkedList<Vehicle> getVehiclesTypeVehiclePass(TypeVehicle typeVehicle){
		MyLinkedList<Vehicle> linkedListType = new MyLinkedList<Vehicle>();
		for (int i = 0; i < listStands.size(); i++) {
			for (int j = 0; j < listStands.get(i).getLinkedListVehiclesPass().size(); j++) {
				if(listStands.get(i).getLinkedListVehiclesPass().elementAt(j).getTypeVehicle().equals(typeVehicle));
				linkedListType.add(listStands.get(i).getLinkedListVehiclesPass().elementAt(j));
			}
		}
		return linkedListType;
	}
	
	public long getCantvehiclesCar(){
		long cant = 0;
		for (int i = 0; i < listStands.size(); i++) {
			cant += listStands.get(i).numVehicleOfTypeCar();
		}
		return cant;
	}
	
	public long getCantvehiclesVan(){
		long cant = 0;
		for (int i = 0; i < listStands.size(); i++) {
			cant += listStands.get(i).numVehicleOfTypeVan();
		}
		return cant;
	}
	
	public long getCantvehiclesTruck(){
		long cant = 0;
		for (int i = 0; i < listStands.size(); i++) {
			cant += listStands.get(i).numVehicleOfTypeTruck();
		}
		return cant;
	}
	//general
	public double payVehiclesOfTypeVehicles(TypeVehicle typeVehicle){
		double payVehicles = 0;
		MyLinkedList<Vehicle> listVehicles = getVehiclesTypeVehiclePass(typeVehicle);
		for (int i = 0; i < listVehicles.size(); i++) {
			payVehicles += listVehicles.elementAt(i).getPay();
		}
		return payVehicles;
	}
	//General
	public double dinnerTotalToll(){
		double sale = 0;
		for (int i = 0; i < listStands.size(); i++) {
			sale += listStands.get(i).totalSaleStand();
		}
		return sale;
	}
	
	
	public ArrayList<Stand> getListStands(){
		return listStands;
	}
 
}

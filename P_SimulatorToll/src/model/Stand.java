package model;

import java.io.IOException;
import java.net.URISyntaxException;

import persistence.FileManager;

public class Stand {
	private short idStand;
	private MyQueue<Vehicle> queueGroupVehiclesLane;
	private MyLinkedList<Vehicle> linkedListVehiclesPass;	
	
	public Stand() throws IOException, URISyntaxException {
		queueGroupVehiclesLane = new MyQueue<Vehicle>();
		linkedListVehiclesPass = new MyLinkedList<Vehicle>();
		idStand = (short) FileManager.getLastId();
	}

	
	
	public boolean addVehicleTail(Vehicle vehicle){
		boolean isAdd = false;
		if(queueGroupVehiclesLane.size() < 5){
			queueGroupVehiclesLane.enqueue(vehicle);
			isAdd = true;
		}
		return isAdd;
	}
	
	public long getNumVehiclesPass(){
		return linkedListVehiclesPass.size();
	}

	public short getIdStand() {
		return idStand;
	}
	
	public double totalSaleStand(){
		double sale = 0;
		for (int i = 0; i < linkedListVehiclesPass.size(); i++) {
			sale += linkedListVehiclesPass.elementAt(i).getPay();
		}
		return sale;
	}
	
	public double pay(){
		double pay = 0;
		Vehicle vehicle = queueGroupVehiclesLane.copyDequeue();
		if(vehicle != null){
			if(vehicle.getTypeVehicle().equals(TypeVehicle.CAR)){
				pay = vehicle.getTypeVehicle().getValue();
			}else if(vehicle.getTypeVehicle().equals(TypeVehicle.VAN)){
				pay = vehicle.getTypeVehicle().getValue();
			}else{
				pay = vehicle.getTypeVehicle().getValue();
			}
			vehicle.setPay(pay);
			queueGroupVehiclesLane.dequeue();
			linkedListVehiclesPass.add(vehicle);
		}
		return pay;
	}
	
	public long numVehicleOfTypeCar(){
		long cont = 0;
		for (int i = 0; i < linkedListVehiclesPass.size(); i++) {
		if(linkedListVehiclesPass.elementAt(i).getTypeVehicle().equals(TypeVehicle.CAR)){
			cont ++;
		}
	 }
		return cont;
	}
	public long numVehicleOfTypeVan(){
		long cont = 0;
		for (int i = 0; i < linkedListVehiclesPass.size(); i++) {
		if(linkedListVehiclesPass.elementAt(i).getTypeVehicle().equals(TypeVehicle.VAN)){
			cont ++;
		}
	 }
		return cont;
	}
	public long numVehicleOfTypeTruck(){
		long cont = 0;
		for (int i = 0; i < linkedListVehiclesPass.size(); i++) {
		if(linkedListVehiclesPass.elementAt(i).getTypeVehicle().equals(TypeVehicle.TRUCK)){
			cont ++;
		}
	 }
		return cont;
	}


	public void setIdStand(short idStand) {
		this.idStand = idStand;
	}


	public MyQueue<Vehicle> getQueueGroupVehiclesLane() {
		return queueGroupVehiclesLane;
	}


	public void setQueueGroupVehiclesLane(MyQueue<Vehicle> queueGroupVehiclesLane) {
		this.queueGroupVehiclesLane = queueGroupVehiclesLane;
	}


	public MyLinkedList<Vehicle> getLinkedListVehiclesPass() {
		return linkedListVehiclesPass;
	}


	public void setLinkedListVehiclesPass(MyLinkedList<Vehicle> linkedListVehiclesPass) {
		this.linkedListVehiclesPass = linkedListVehiclesPass;
	}
	
}

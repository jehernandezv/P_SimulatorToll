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

	public short getIdStand() {
		return idStand;
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


	public void setLinkedListVehiclesPass(
			MyLinkedList<Vehicle> linkedListVehiclesPass) {
		this.linkedListVehiclesPass = linkedListVehiclesPass;
	}
	
	
	

	

	


	

	
	
	
}

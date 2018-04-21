package model;

public class Stand {
	private short idStand;
	private MyQueue<Vehicle> queueGroupVehiclesLane;
	private MyLinkedList<Vehicle> linkedListVehiclesPass;
	
	
	public Stand() {
		
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

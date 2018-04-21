package model;

import java.time.LocalDate;

public class Vehicle{
	private short idVehicle;
	private TypeVehicle typeVehicle;
	private String plate;
	private LocalDate datePass;
	private double pay;
	
	public Vehicle() {
		
	}

	public Vehicle(short idVehicle, TypeVehicle typeVehicle, String plate) {
		this.idVehicle = idVehicle;
		this.typeVehicle = typeVehicle;
		this.plate = plate;
	}

	public short getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(short idVehicle) {
		this.idVehicle = idVehicle;
	}

	public TypeVehicle getTypeVehicle() {
		return typeVehicle;
	}



	public void setTypeVehicle(TypeVehicle typeVehicle) {
		this.typeVehicle = typeVehicle;
	}



	public String getPlate() {
		return plate;
	}



	public void setPlate(String plate) {
		this.plate = plate;
	}



	public LocalDate getDatePass() {
		return datePass;
	}



	public void setDatePass(LocalDate datePass) {
		this.datePass = datePass;
	}



	public double getPay() {
		return pay;
	}



	public void setPay(double pay) {
		this.pay = pay;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

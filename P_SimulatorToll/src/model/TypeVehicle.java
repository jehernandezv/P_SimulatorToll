package model;

public enum TypeVehicle {
	
	VAN(45,65.2f),
	TRUCK(78,45.8f),
	CAR(23,2.8F),
	EMPRY(0,0f);
	
	private final int value;
	private final float weigth;

	TypeVehicle(int value, float weigth){
		this.value = value;
		this.weigth = weigth;
	}

	public int getValue() {
		return value;
	}

	public float getWeigth() {
		return weigth;
	}
	
	
	
}

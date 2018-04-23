package model;

public enum TypeVehicle {
	
	VAN(35900,65.2f),
	TRUCK(78300,45.8f),
	CAR(22500,2.8F),
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

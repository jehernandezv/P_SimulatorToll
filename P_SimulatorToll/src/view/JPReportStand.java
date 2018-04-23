package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class JPReportStand extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel jLabelNumStand,jLabelTypeVehicle,jLabelCantVehicle,jLabelValuePayType,
	jLabelVehicleCar,jLabelVehicleVan,jlLabelVehicleTruck,jLabelCantVehiclesCar,jLabelValuePayCar,jLabelCantVehiclesVan,
	jLabelValuePayVan,jLabelCantVehiclesTruck,jLabelValuePayTruck,jLabelTitleStatsGeneral;
	
	public JPReportStand(ArrayList<String> arrayValue) {
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new GridLayout(7,5));
		jLabelNumStand = new JLabel(arrayValue.get(0));
		jLabelTypeVehicle = new JLabel("TypeVehicle");
		jLabelCantVehicle = new JLabel("CantVehicle");
		jLabelValuePayType = new JLabel("TotalPay");
		jLabelVehicleCar = new JLabel("Car");
		jLabelVehicleVan = new JLabel("Van");
		jlLabelVehicleTruck = new JLabel("Truck");
		jLabelCantVehiclesCar = new JLabel(arrayValue.get(1));
		jLabelValuePayCar = new JLabel(arrayValue.get(2));
		jLabelCantVehiclesVan = new JLabel(arrayValue.get(3));
		jLabelValuePayVan = new JLabel(arrayValue.get(4));
		jLabelCantVehiclesTruck = new JLabel(arrayValue.get(5));
		jLabelValuePayTruck = new JLabel(arrayValue.get(6));
		//jLabelTitleStatsGeneral = new JLabel("Stats General");
		
		
		init(arrayValue);
	}

	private void init(ArrayList<String> arrayList) {
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(jLabelNumStand);
		this.add(new JLabel());
		//2da fila
		this.add(jLabelTypeVehicle);
		this.add(jLabelCantVehicle);
		this.add(new JLabel());
		this.add(jLabelValuePayType);
		
		//3 fila
		this.add(jLabelVehicleCar);
		this.add(jLabelCantVehiclesCar);
		this.add(new JLabel());
		this.add(jLabelValuePayCar);
		
		// 4 fila
		this.add(jLabelVehicleVan);
		this.add(jLabelCantVehiclesVan);
		this.add(new JLabel());
		this.add(jLabelValuePayVan);
		
		//5 fila
		this.add(jlLabelVehicleTruck);
		this.add(jLabelCantVehiclesTruck);
		this.add(new JLabel());
		this.add(jLabelValuePayTruck);
		//Separador fila 6
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		
		
		
		
		
		
		
	}

}

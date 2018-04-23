package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPStatsGeneral extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jLabelTotalVehiclesPassed,jLabelCantVehiclesPassed,jLabelTitleDinnerTotal,jLabelDinnerTotal,
	jLabelTitleVehiclesCar,jLabelCantVehiclesCar,jLabelTitleVehiclesVan,jLabelCantVahiclesVan,jLabelTitleVehiclesTruck,
	jLabelCantVehiclesTruck;
	
	public JPStatsGeneral(ArrayList<String> list) {
		this.setLayout(new GridLayout(3,2));
		jLabelTotalVehiclesPassed = new JLabel("Total of vehicles that passed");
		jLabelCantVehiclesPassed = new JLabel(list.get(0));
		jLabelTitleDinnerTotal = new JLabel("Money collected at the toll");
		jLabelDinnerTotal = new JLabel(list.get(1));
		jLabelTitleVehiclesCar = new JLabel("Total Car");
		jLabelCantVehiclesCar = new JLabel(list.get(2));
		jLabelTitleVehiclesVan = new JLabel("Total Van");
		jLabelCantVahiclesVan = new JLabel(list.get(3));
		jLabelTitleVehiclesTruck = new JLabel("Total Truck");
		jLabelCantVehiclesTruck = new JLabel(list.get(4));
		init();
	}

	private void init() {
		this.add(new JLabel("STATS GENERAL TOLL"));
		this.add(new JLabel());
		this.add(jLabelTotalVehiclesPassed);
		this.add(jLabelCantVehiclesPassed);
		this.add(jLabelTitleDinnerTotal);
		this.add(jLabelDinnerTotal);
		this.add(jLabelTitleVehiclesCar);
		this.add(jLabelCantVehiclesCar);
		this.add(jLabelTitleVehiclesVan);
		this.add(jLabelCantVahiclesVan);
		this.add(jLabelTitleVehiclesTruck);
		this.add(jLabelCantVehiclesTruck);
		
		
	}
	
	

}

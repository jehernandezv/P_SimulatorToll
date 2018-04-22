package test;

import java.io.IOException;
import java.net.URISyntaxException;
import model.Toll;

public class TestVEhicel {
	public static void main(String[] args) throws IOException, URISyntaxException {
		Toll toll = new Toll((short) 1);
		//ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
		for (int i = 0; i < 2; i++) {
			//vehicle.add(toll.createVehicle());
			toll.addVehiclesStandRandom();
			System.out.println(toll.getListStands().size());
			System.out.println("size "  + toll.getListStands().get(0).getQueueGroupVehiclesLane().size());
			toll.getListStands().get(0).getQueueGroupVehiclesLane().print();
		}
	}

	
	
}

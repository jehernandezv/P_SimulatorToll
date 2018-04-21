package view;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GroupLane extends JPanel{
	private static final long serialVersionUID = 1L;
	private ArrayList<JPLane> jpStans;
	private short cantStands;


	public GroupLane(short cant) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for (int i = 0; i < cant; i++) {
			this.add(new JPLane());
		}
	}

	public ArrayList<JPLane> getJpStans() {
		return jpStans;
	}

	public void setJpStans(ArrayList<JPLane> jpStans) {
		this.jpStans = jpStans;
	}


	public short getCantStands() {
		return cantStands;
	}
	
	public void setCantStands(short cantStands) {
		this.cantStands = cantStands;
	}
	
	
	

}

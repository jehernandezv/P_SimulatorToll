package view;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class JPReportToll extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public JPReportToll(byte cant,ArrayList<JPReportStand> list) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		init(list);
	}

	private void init(ArrayList<JPReportStand> list) {
		for (int i = 0; i < list.size(); i++) {
			this.add(list.get(i));
		}
		
	}
	
	
	
	
	
	

}

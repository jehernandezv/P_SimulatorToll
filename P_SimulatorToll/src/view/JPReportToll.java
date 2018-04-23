package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class JPReportToll extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPStatsGeneral jpStatsGeneral;

	public JPReportToll(byte cant,ArrayList<JPReportStand> list,ArrayList<String> statsGeneral) {
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.jpStatsGeneral = new JPStatsGeneral(statsGeneral);
		init(list,jPanel);
	}

	private void init(ArrayList<JPReportStand> list,JPanel jPanel) {
		for (int i = 0; i < list.size(); i++) {
			jPanel.add(list.get(i));
		}
		this.add(jPanel);
		this.add(jpStatsGeneral);
		
	}
	
	
	
	
	
	

}

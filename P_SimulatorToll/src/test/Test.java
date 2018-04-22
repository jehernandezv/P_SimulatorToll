package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import model.TypeVehicle;
import view.JPanelDrawVehicle;

public class Test {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(1,6));
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArrayList<JPanelDrawVehicle> panelStatus = new ArrayList<JPanelDrawVehicle>();
		JPanelDrawVehicle jPanelStatus = new JPanelDrawVehicle();
		JPanelDrawVehicle jPanelStatus2 = new JPanelDrawVehicle();
		panelStatus.add(jPanelStatus);
		panelStatus.add(jPanelStatus2);
		Random random = new Random();
		frame.add(jPanelStatus);
		frame.add(jPanelStatus2); 
		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelStatus.get(0).seteStatusJPanel(TypeVehicle.values()[random.nextInt(3)]);
				panelStatus.get(1).seteStatusJPanel(TypeVehicle.values()[random.nextInt(3)]);
				System.out.println("hilo");
				frame.repaint();
			}
		});
		timer.start();
		frame.setVisible(true);
	}

}

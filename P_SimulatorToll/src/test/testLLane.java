package test;

import javax.swing.JFrame;

import view.GroupLane;
import view.JPLane;

public class testLLane {
	
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.setSize(800, 600);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPLane jpLane = new JPLane();
		GroupLane groupLane = new GroupLane((short) 4);
		jFrame.add(groupLane);
		
		
		jFrame.setVisible(true);
		
	}

}

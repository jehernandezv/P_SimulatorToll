package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPLimitSimulation extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jLabelLimit;
	
	public JPLimitSimulation() {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.decode("#91DC5A"));
		jLabelLimit = new JLabel();
		jLabelLimit.setForeground(Color.WHITE);
		jLabelLimit.setFont(new Font("Arial", Font.BOLD, 25));
		this.add(jLabelLimit);
	}
	
	public void sentValuesJPLimitSimulationBefore(LocalTime before,LocalTime after){
		jLabelLimit.setText("Limit before : " +" Hour : " +before.getHour() +" Minute : " +before.getMinute() + 
				" Second : " + before.getSecond() + "      At limit after :     " + " Hour : " + after.getHour() +
				" Minute : " + after.getMinute()+ " Second : " + after.getSecond());
	}
	
}

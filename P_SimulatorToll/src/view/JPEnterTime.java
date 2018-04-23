package view;

import java.awt.FlowLayout;
import java.time.LocalTime;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class JPEnterTime extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jLabelHour,jLabelMinute,jLabelSecond;
	private JSpinner jSpinnerHour,jSpinnerMinute,jSpinnerSecond;
	
	public JPEnterTime() {
		this.setLayout(new FlowLayout());
		this.jSpinnerHour = new JSpinner();
		this.jSpinnerMinute = new JSpinner();
		this.jSpinnerSecond = new JSpinner();
		jLabelHour = new JLabel("Hour");
		jLabelMinute = new JLabel("Minute");
		jLabelSecond = new JLabel("Second");
		init();
	}

	private void init() {
		add(jLabelHour);
		add(jSpinnerHour);
		add(jLabelMinute);
		add(jSpinnerMinute);
		add(jLabelSecond);
		add(jSpinnerSecond);
		
	}
	
	public LocalTime getTime(){
		return LocalTime.of((int)jSpinnerHour.getValue(), (int)jSpinnerMinute.getValue(), (int)jSpinnerSecond.getValue());
	}

}

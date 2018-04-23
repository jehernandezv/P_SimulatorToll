package view;

import java.awt.FlowLayout;
import java.time.LocalTime;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

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
		SpinnerNumberModel modelHour = new SpinnerNumberModel();
		modelHour.setMaximum(23);
		modelHour.setMinimum(0);
		jSpinnerHour.setModel(modelHour);
		
		SpinnerNumberModel modelMinute = new SpinnerNumberModel();
		modelMinute.setMaximum(60);
		modelMinute.setMinimum(0);
		jSpinnerMinute.setModel(modelMinute);
		
		SpinnerNumberModel modelSecond = new SpinnerNumberModel();
		modelSecond.setMaximum(60);
		modelSecond.setMinimum(15);
		modelSecond.setValue(15);
		jSpinnerSecond.setModel(modelSecond);
		
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

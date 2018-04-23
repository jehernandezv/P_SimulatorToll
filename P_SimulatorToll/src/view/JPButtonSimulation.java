package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import controller.EAction;

public class JPButtonSimulation extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton jButtonPauseSimulation, jButtonStepSimulation, jButtonResumeSimulation;
	
	public JPButtonSimulation(Controller controller) {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.decode("#91DC5A"));
		jButtonPauseSimulation = new JButton("Pause");
		jButtonStepSimulation = new JButton("Step Simulation");
		jButtonResumeSimulation = new JButton("Resume Simulation");
		jButtonStepSimulation.addActionListener(controller);
		jButtonPauseSimulation.addActionListener(controller);
		jButtonResumeSimulation.addActionListener(controller);
		jButtonStepSimulation.setActionCommand(EAction.JBUTTON_STEP_SIMULATION.name());
		jButtonPauseSimulation.setActionCommand(EAction.PAUSE_SIMULATION.name());
		jButtonResumeSimulation.setActionCommand(EAction.JBUTTON_RESUME_SIMULATION.name());
		init();
		
	}

	private void init() {
		ImageIcon image1 , image2;
		image1 = new ImageIcon(getClass().getResource("/pause1.png"));
		image2 =  new ImageIcon(getClass().getResource("/pause2.png"));
		//button pause
		jButtonPauseSimulation.setIcon(image1);
		jButtonPauseSimulation.setRolloverIcon(image2);
		customJButton(jButtonPauseSimulation);
		//button stop
		image1 = new ImageIcon(getClass().getResource("/stop1.png"));
		image2 = new ImageIcon(getClass().getResource("/stop2.png"));
		jButtonStepSimulation.setIcon(image1);
		jButtonStepSimulation.setRolloverIcon(image2);
		customJButton(jButtonStepSimulation);
		//button resume
		image1 = new ImageIcon(getClass().getResource("/play1.png"));
		image2 = new ImageIcon(getClass().getResource("/play2.png"));
		jButtonResumeSimulation.setIcon(image1);
		jButtonResumeSimulation.setRolloverIcon(image2);
		customJButton(jButtonResumeSimulation);

		
		
		this.add(jButtonResumeSimulation);
		this.add(jButtonPauseSimulation);
		this.add(jButtonStepSimulation);
		
	}
	
	public void customJButton(JButton button){
		button.setOpaque(true);
		button.setFocusable(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 25));
	}

}

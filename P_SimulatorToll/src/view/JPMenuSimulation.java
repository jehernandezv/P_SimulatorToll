package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import controller.EAction;

public class JPMenuSimulation extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton jButtonConfigSimulation,jButtonHelp,jButtonExit;
	
	public JPMenuSimulation(Controller controller) {
		this.setLayout(new GridLayout(3,1));
		jButtonConfigSimulation = new JButton("Start Config");
		jButtonHelp = new JButton("Help");
		jButtonExit = new JButton("Exit");
		jButtonConfigSimulation.addActionListener(controller);
		jButtonConfigSimulation.setActionCommand(EAction.CONFIG_SIMULATION.name());
		init();
		
	}

	private void init() {
		this.add(jButtonConfigSimulation);
		this.add(jButtonHelp);
		this.add(jButtonExit);
	}

}

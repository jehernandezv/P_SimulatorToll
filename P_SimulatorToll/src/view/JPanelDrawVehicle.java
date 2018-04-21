package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.TypeVehicle;

public class JPanelDrawVehicle extends JPanel{
	private static final long serialVersionUID = -3000715231613825331L;
	private TypeVehicle eStatusJPanel = TypeVehicle.EMPRY;
	
	public JPanelDrawVehicle() {
	}

	public JPanelDrawVehicle(TypeVehicle eStatusJPanel) {
		this.eStatusJPanel = eStatusJPanel;
	}
	
	public void paint(Graphics g) {
		ImageIcon imageOrigin, imageNew;
		ImageIcon road = new ImageIcon(getClass().getResource("/Road.jpg"));
		super.paint(g);
		if(eStatusJPanel.equals(TypeVehicle.EMPRY)){
			Image imageAux;
			imageAux = road.getImage();
			imageNew = new ImageIcon(imageAux.getScaledInstance((int) this.getWidth(), (int) this.getHeight(),
					Image.SCALE_REPLICATE));
			g.drawImage(imageNew.getImage(), 0, 0, null);
		}else{
			Image imageAux;
			imageAux = road.getImage();
			imageNew = new ImageIcon(imageAux.getScaledInstance((int) this.getWidth(), (int) this.getHeight(),
					Image.SCALE_REPLICATE));
			g.drawImage(imageNew.getImage(), 0, 0, null);
				if (TypeVehicle.TRUCK.equals(eStatusJPanel)) {
					imageOrigin = new ImageIcon(getClass().getResource(
							"/camion.png"));
					imageAux = imageOrigin.getImage();
					imageNew = new ImageIcon(imageAux.getScaledInstance(
							(int) this.getWidth(),
							(int) this.getHeight(), Image.SCALE_REPLICATE));
					g.drawImage(imageNew.getImage(), 0, 0, null);
				} else if (TypeVehicle.VAN.equals(eStatusJPanel)) {
					imageOrigin = new ImageIcon(getClass().getResource("/van.PNG"));
					imageAux = imageOrigin.getImage();
					imageNew = new ImageIcon(imageAux.getScaledInstance(
							(int) this.getWidth(),
							(int) this.getHeight(), Image.SCALE_REPLICATE));
					g.drawImage(imageNew.getImage(), 0, 0, null);
				} else {
					imageOrigin = new ImageIcon(getClass().getResource("/car.PNG"));
					imageAux = imageOrigin.getImage();
					imageNew = new ImageIcon(imageAux.getScaledInstance(
							(int) this.getWidth(),
							(int) this.getHeight(), Image.SCALE_REPLICATE));
					g.drawImage(imageNew.getImage(), 0, 0, null);
				}
			
			}
	}

	public TypeVehicle geteStatusJPanel() {
		return eStatusJPanel;
	}

	public void seteStatusJPanel(TypeVehicle eStatusJPanel) {
		this.eStatusJPanel = eStatusJPanel;
	}

	
	
	
	
	
	

}

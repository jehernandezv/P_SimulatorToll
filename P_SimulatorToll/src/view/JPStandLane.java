package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPStandLane extends JPanel{

	private static final long serialVersionUID = 1L;
	private ImageIcon newImage;
	private Image auxImage;
	private boolean status = false;
	
	public JPStandLane() {
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		ImageIcon road = new ImageIcon(getClass().getResource("/Road.jpg"));
		auxImage = road.getImage();
		newImage = new ImageIcon(auxImage.getScaledInstance((int) this.getWidth(), (int) this.getHeight(),Image.SCALE_REPLICATE));
		g.drawImage(newImage.getImage(), 0, 0, null);
		
		
		auxImage = fillStandStatus(status).getImage();
		newImage = new ImageIcon(auxImage.getScaledInstance((int) this.getWidth(), (int) this.getHeight(),Image.SCALE_REPLICATE));
		g.drawImage(newImage.getImage(), 0, 0, null);
	}

	public ImageIcon fillStandStatus(boolean status){
		ImageIcon stand;
		if(!this.status){
			stand = new ImageIcon(getClass().getResource("/stand.png"));
		}else{
			stand = new ImageIcon(getClass().getResource("/standChange.png"));
		}
		return stand;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}

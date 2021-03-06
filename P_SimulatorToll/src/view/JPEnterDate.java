package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalTime;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPEnterDate extends JPanel{

	private static final long serialVersionUID = 1L;
	private final static byte LIMIT_STANDS = 10;
	private JComboBox<Byte> jComboBoxSizeStands;
	private JLabel jLabelDateAfter,jLabelDateBefore,jLabelNumLane;
	private JPEnterTime jpEnterTimeBefore,jpEnterTimeAfter;
	
	public JPEnterDate() {
		this.setLayout(new GridLayout(3,2));
		jComboBoxSizeStands = new JComboBox<Byte>();
		jLabelDateAfter = new JLabel("Time After");
		jLabelDateBefore = new JLabel("Time before");
		jLabelNumLane = new JLabel("Cant Lane");
		jpEnterTimeBefore = new JPEnterTime();
		jpEnterTimeAfter = new JPEnterTime();
		generateRangeStand(LIMIT_STANDS);
		init();
	}
	
	public void init(){
		setCustomJLabel(jLabelDateAfter);
		setCustomJLabel(jLabelDateBefore);
		setCustomJLabel(jLabelNumLane);
		
		this.add(jLabelNumLane);
		this.add(jComboBoxSizeStands);
		this.add(jLabelDateBefore);
		this.add(jpEnterTimeBefore);
		this.add(jLabelDateAfter);
		this.add(jpEnterTimeAfter);
	}
	public void setCustomJLabel(JLabel jlabel){
		jlabel.setForeground(Color.WHITE);
		jlabel.setFont(new Font("Arial", Font.BOLD,35));
		jlabel.setBackground(Color.decode("#91DC5A"));
		jlabel.setOpaque(true);
	}

	
	private void generateRangeStand(byte cant){
		byte value = 1;
		for (int i = 0; i < cant; i++) {
			this.jComboBoxSizeStands.addItem(value);
			value ++;
		}
		
	}
	
	public boolean validateDates(){
		return (getTimeBefore().compareTo(getTimeAfter())) < 0;
	}
	
	public byte getCantStand(){
		return (byte)jComboBoxSizeStands.getSelectedItem();
	}
	
	public LocalTime getTimeBefore(){
		return jpEnterTimeBefore.getTime();
	}
	
	public LocalTime getTimeAfter(){
		return jpEnterTimeAfter.getTime();
	}
	
	
	
	
}

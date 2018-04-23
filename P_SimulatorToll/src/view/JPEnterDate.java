package view;

import java.awt.GridLayout;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

public class JPEnterDate extends JPanel{

	private static final long serialVersionUID = 1L;
	private final static byte LIMIT_STANDS = 10;
	private JDateChooser chooserAfter, chooserBefore;
	private JComboBox<Byte> jComboBoxSizeStands;
	private JLabel jLabelDateAfter,jLabelDateBefore,jLabelNumLane;
	
	
	public JPEnterDate() {
		this.setLayout(new GridLayout(3,2));
		chooserAfter = new JDateChooser();
		chooserBefore = new JDateChooser();
		jComboBoxSizeStands = new JComboBox<Byte>();
		jLabelDateAfter = new JLabel("Date After");
		jLabelDateBefore = new JLabel("Date before");
		jLabelNumLane = new JLabel("Cant Lane");
		generateRangeStand(LIMIT_STANDS);
		init();
	}
	
	public void init(){
		this.add(jLabelNumLane);
		this.add(jComboBoxSizeStands);
		this.add(jLabelDateAfter);
		this.add(jLabelDateBefore);
		this.add(chooserAfter);
		this.add(chooserBefore);
	}

	
	private void generateRangeStand(byte cant){
		byte value = 1;
		for (int i = 0; i < cant; i++) {
			this.jComboBoxSizeStands.addItem(value);
			value ++;
		}
		
	}
	
	public LocalDate[] getDates(){
		return new LocalDate[] {getDate(chooserAfter),getDate(chooserBefore)};
	}
	
	private LocalDate getDate(JDateChooser chooser){
		if(chooser.getDate() != null){
			Date input = chooser.getDate();
			Instant instant = input.toInstant();
			ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
			LocalDate date = zdt.toLocalDate();
			return date;
		}
		return null;
	}
	
	public byte getCantStand(){
		return (byte)jComboBoxSizeStands.getSelectedItem();
	}
	
	
}

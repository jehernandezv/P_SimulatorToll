package view;

import java.time.LocalTime;

public class ValidateDates {
	
	public ValidateDates() {
		
	}
	
	public void validateTime(LocalTime before,LocalTime after) throws CustomException{
		if (before.compareTo(after) > 0) {
			throw new CustomException("El limite inferior de tiempo es mayor que el limite superior");
		}
		
		if(before == null || after == null){
			throw new CustomException("Los limites de tiempo no pueden quedar vacios");
		}
		
		if(before.getHour() == 0 && before.getMinute() == 0 && before.getSecond() == 0 && after.getHour() == 0 &&
				after.getMinute() == 0 && after.getSecond() == 0){
			throw new CustomException("Los campos de limite de tiempo no pueden quedar vacios");
		}
	}

}

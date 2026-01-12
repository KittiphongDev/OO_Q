package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		/* FILL CODE */
		type = (type <0 || type >2)? 1 : type;

		this.type = type;

		switch (type){
			case 0:
				priceperstation = 30;
				break;
			case 1:
				priceperstation = 30;
				break;
			case 2:
				priceperstation = 25;
				break;
		}
	}
	
	public void setStation(Station start,Station end) {
		/* FILL CODE */
		this.start = start;
		this.end = end;
	}
	
	public double calculatePrice() {
		/* FILL CODE */
		if(isStationValid(start,end)){
			if(type == 0 && getStationDistance(start,end)>4){
				return (priceperstation * getStationDistance(start,end))*0.8;
			}
			else if(type == 2 && getStationDistance(start,end)<=6){
				return (priceperstation * getStationDistance(start,end))*0.6;
			}
			else{
				return priceperstation * getStationDistance(start,end);
			}
		}
		else{
			return -1f;
		}
	}
	
	public String getDescription() {

		if (!isStationValid(start, end)) {
			return "Invalid Ticket, from " + start.getName() + " to " + end.getName();
		}

		String typename;
		
		switch(type) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			typename = "Adult";
			break;
		case 2:
			//FILL CODE
			typename = "Elderly";
			break;
		default:
			typename = "Invalid";
			break;
		}
		
		return typename+" Ticket, from "+start.getName()+" to "+end.getName();
	}
	
	public boolean isStationValid(Station start,Station end) {

		if (start == null || end == null) {
			return false;
		}

		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}

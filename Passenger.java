
public class Passenger {
	private TravelClass passClass;
	private int passengerID;
	private int arrivalTime;
	private int passNum;

	
	public Passenger() {
	}

	public Passenger(TravelClass p, int pID, int time) {
		 passClass = p;
		 passengerID = pID;
		 arrivalTime = time;
		 
		 if (passClass == TravelClass.FIRSTCLASS) {//allcates a number to a passenger for sorting the array class wise
			 passNum = 1;
			} else if (passClass == TravelClass.BUSINESSCLASS) {
				passNum = 2;
			} else if (passClass == TravelClass.PREMIUMECONOMY) {
				passNum = 3;
			} else if (passClass == TravelClass.ECONOMY) {
				passNum = 4;
			}
	}
	public int getID() {
		return passengerID;
	}
	public int getTime() {
		return arrivalTime;
	}
	public int getNum() {
		return passNum;
	}

	public TravelClass getPass() {//returns class of pass
		return passClass;
	}
}


public class Flight {
	private String destination;
	private BoardingQueue boardQueue;
	private Passenger firstClass[];
	private Passenger businessClass[];
	private Passenger premiumEconomy[];
	private Passenger economy[];
	private int minutesLeftBoarding;
	private int minutesLeftDeparting;
	private int firstClassInd;
	private int businessClassInd;
	private int premiumEconomyInd;
	private int economyInd;
	private boolean boarding;
	private int size;

	public Flight() {
		firstClass = new Passenger[2];
		businessClass = new Passenger[3];
		premiumEconomy = new Passenger[4];
		economy = new Passenger[6];
		minutesLeftBoarding = 25;
		minutesLeftDeparting = 15;
		firstClassInd = 0;
		businessClassInd = 0;
		premiumEconomyInd =0;
		economyInd = 0;
		boarding = true;
		destination = "NYC";
		

	}

	public Flight(int mlb, int mld, int fci, int bci, int pei, int ei, boolean b,String den) {
		boardQueue = new BoardingQueue();
		firstClass = new Passenger[2];
		businessClass = new Passenger[3];
		premiumEconomy = new Passenger[4];
		economy = new Passenger[6];
		minutesLeftBoarding = mlb;
		minutesLeftDeparting = mld;
		firstClassInd = fci;
		businessClassInd = bci;
		premiumEconomyInd = pei;
		economyInd = ei;
		boarding = b;
		destination=den;
	}
	
	public int getMinBoard() {
		return minutesLeftBoarding;
	}
	public int getSize() {
		return size;
	}
	public int getMinDepart() {
		return minutesLeftDeparting;
	}
	public int getFirstClass() {
		return firstClassInd;
	}
	public int getBissClass() {
		return businessClassInd;
	}
	public int getPreEcoClass() {
		return premiumEconomyInd;
	}
	public int getEcoClass() {
		return economyInd;
	}
	public boolean getBoarding() {
		return boarding;
	}
	public String getDestination() {
		return destination;
	}
	public void setMinBoard(int a) {
		minutesLeftBoarding=a;
	}
	public void setMinDepart(int b) {
		minutesLeftDeparting=b;
	}
	public void setFirstClass(int c) {
		firstClassInd=c;
	}
	public void setBissClass(int d) {
		businessClassInd=d;
	}
	public void setPreEcoClass(int e) {
		premiumEconomyInd=e;
	}
	public void setEcoClass(int f ) {
		 economyInd =f;
	}
	public void setSize(int s) {
		 size=s;
	}
	public void setBoarding(boolean g) {
		 boarding=g;
	}
	public void setDestination(String h) {
		destination =h;
	}
	public BoardingQueue getBoardingQueue() {
		return boardQueue;
	}
	public void addToFlight(Passenger boardedPass) {
		if (boardedPass.getPass().toString().equals("First Class")) {
			firstClass[firstClassInd] = boardedPass;
			firstClassInd++;
		} else if (boardedPass.getPass().toString().equals("Business Class")) {
			businessClass[businessClassInd] = boardedPass;
			businessClassInd++;

		} else if (boardedPass.getPass().toString().equals("Premium Economy")) {
			premiumEconomy[premiumEconomyInd] = boardedPass;
			premiumEconomyInd++;

		}else if (boardedPass.getPass().toString().equals("Economy")) {
			economy[economyInd] = boardedPass;
			economyInd++;
		}

	}
	
	public void sort() {//sorts the queue so that proprity is maintained
		for(int i =0; i<boardQueue.getSize();i++) {
			for(int j =1; j<boardQueue.getSize()-1;j++) {
				if(boardQueue.getArray()[i].getNum()>boardQueue.getArray()[j].getNum()) {
					Passenger s = boardQueue.getArray()[i];
					boardQueue.getArray()[i] = boardQueue.getArray()[j];
					boardQueue.getArray()[j]= s;
					
				}
				else if(boardQueue.getArray()[i].getID()>boardQueue.getArray()[j].getID()) {
					Passenger s = boardQueue.getArray()[i];
					boardQueue.getArray()[i] = boardQueue.getArray()[j];
					boardQueue.getArray()[j]= s;
				}
			}
		}
	}
	
	public void print() {//prints the flight rooster
		System.out.format("%-17s|%-20s|%-15s|\n", "Travel Class", " ID ", " Arrival Time ");
		System.out.println("=========================================================================\n ");
		for(int i =0;i<firstClass.length;i++) {
			System.out.format("%-17s|%-20s|%-15s|\n", firstClass[i].getPass().toString(), firstClass[i].getID(), firstClass[i].getTime());
		}
		for(int i =0;i<businessClass.length;i++) {
			System.out.format("%-17s|%-20s|%-15s|\n", businessClass[i].getPass().toString(), businessClass[i].getID(), businessClass[i].getTime());
		}
		for(int i =0;i<economy.length;i++) {
			System.out.format("%-17s|%-20s|%-15s|\n", economy[i].getPass().toString(), economy[i].getID(), economy[i].getTime());
		}
		
		
	}
}


public enum TravelClass {
	FIRSTCLASS,BUSINESSCLASS,PREMIUMECONOMY,ECONOMY;
	
	public String toString() {//converts Enum to a string
		String a="";
		switch (this) {
		case FIRSTCLASS:
			a = "First Class";
			break;
		case BUSINESSCLASS:
			a = "Business Class";
			break;
		case PREMIUMECONOMY:
			a = "Premium Economy";
			break;
		case ECONOMY:
			a = "Economy";
			break;
		default:
			System.out.println("Not valid Condition");
			break;
		}
		return a;
	}

}

import java.util.Random;
import java.util.Scanner;

public class FlightSimulator {
	private static Flight flightTerminals[] = new Flight[20];
	private static Random randomNumberGenerator;

	public static void main(String[] args) {
		randomNumberGenerator = new Random();
		Scanner s = new Scanner(System.in);
		int count = 0;

		System.out.println("Welcome to RFK Private International Airport!");

		System.out.println("Enter a seed for this simulation");
		long seed = s.nextLong();
		randomNumberGenerator.setSeed(seed);
		System.out.println("Enter the probability of a passenger arrival:");
		double pa = s.nextDouble();
		System.out.println("Enter the probability that a passenger is dequeued");
		double pq = s.nextDouble();
		System.out.println("Enter the probability that there is a new flight at RFK:");
		double nf = s.nextDouble();
		System.out.println("Enter how many minutes this simulation should take:");
		double min = s.nextDouble();

		if ((pq < 0.0 || pq > 1.0) || (pa < 0.0 || pa > 1.0) || (nf < 0.0 || nf > 1.0)) {//checks if the probability is valid
			throw new IllegalArgumentException();
		}

		for (int a = 0; a < min; a++) {
			System.out.println("Minute: " + a);//minute 

			if (randomNumberGenerator.nextFloat() < nf) {// new filght

				float num = randomNumberGenerator.nextFloat();
				if (num < 0.95) {//normal flight
					System.out.println("Enter the denstination of the flight:");
					String des = s.next();
					flightTerminals[count] = new Flight(25, 5, 2, 3, 4, 6, true, des);

					System.out.println("Events:");
					System.out.println("Flight has begun boarding to " + des);
					

				} else if (num >= 0.95) {//air force
					System.out.println("Enter the denstination of the flight:");
					String fin = s.next();
					flightTerminals[count] = new Flight(25, 5, 2, 3, 4, 6, true, fin);
					System.out.println("Air Force 1 has begun boarding to " + fin);

				}
				if (randomNumberGenerator.nextFloat() < pa) {// passenger arrival
					int c = 0;
					float num1 = randomNumberGenerator.nextFloat();
					if (num1 < 0.1) {
						c++;
						Passenger p = new Passenger(TravelClass.FIRSTCLASS, c, a);

						try {
							flightTerminals[count].getBoardingQueue().enqueuePassenger(p);
							System.out.println("First Class passenger " + p.getID() + " on flight to "
									+ flightTerminals[count].getDestination()
									+ " has entered the flight’s boarding queue!");

						} catch (FullQueueException e) {
							System.out.println("Line is Empty");
						}
					} else if (num1 >= 0.1 && num1 > 0.2) {
						c++;
						Passenger p = new Passenger(TravelClass.BUSINESSCLASS, c, a);

						try {
							flightTerminals[count].getBoardingQueue().enqueuePassenger(p);
							System.out.println("Business Class passenger " + p.getID() + " on flight to "
									+ flightTerminals[count].getDestination()
									+ " has entered the flight’s boarding queue!");

						} catch (FullQueueException e) {
							System.out.println("Line is Empty");
						}

					} else if (num1 >= 0.2 && num1 < 0.5) {
						c++;
						Passenger p = new Passenger(TravelClass.PREMIUMECONOMY, c, a);

						try {
							flightTerminals[count].getBoardingQueue().enqueuePassenger(p);
							System.out.println("Premium Economy passenger" + p.getID() + " on flight to "
									+ flightTerminals[count].getDestination()
									+ " has entered the flight’s boarding queue!");

						} catch (FullQueueException e) {
							System.out.println("Line is Empty");
						}

					} else if (num1 >= 0.5 && num1 < 0.9) {
						c++;
						Passenger p = new Passenger(TravelClass.ECONOMY, c, a);
						try {
							flightTerminals[count].getBoardingQueue().enqueuePassenger(p);
							System.out.println("Economy passenger " + p.getID() + " on flight to "
									+ flightTerminals[count].getDestination()
									+ " has entered the flight’s boarding queue!");

						} catch (FullQueueException e) {
							System.out.println("Line is Empty");
						}

					} else if (num1 >= 0.9 && num1 < 1) {
						
						for(int q=0;q<count;q++) {
						int i = flightTerminals[q].getMinBoard();
						flightTerminals[q].setMinBoard(i + 10);
						}
						System.out.println(" COVID positive passenger found attempting to board flight to"
								+ flightTerminals[count].getDestination() + "! All current departures and "
								+ "boarding extended by 10 minutes!");
					}
					flightTerminals[count].sort();

					if ((randomNumberGenerator.nextFloat() < pq)) {
						System.out.println(" ");
						System.out.println("Currently Boarding:");

						try {
							Passenger temp = flightTerminals[count].getBoardingQueue().dequeuePassenger();
							flightTerminals[count].addToFlight(temp);
							System.out.println(temp.getPass().toString() + " passenger (ID " + temp.getID()
									+ ") on flight to " + flightTerminals[count].getDestination()
									+ " has boarded on  a" + temp.getPass().toString() + " seat!");

							System.out.println("Flight to " + flightTerminals[count].getDestination() + " has "
									+ flightTerminals[count].getMinBoard() + " minutes to board,"
									+ flightTerminals[count].getSize() + " passenger(s), and"
									+ flightTerminals[count].getBoardingQueue().getSize()
									+ " person(s) waiting to board.");

						} catch (EmptyQueueException e) {
							System.out.println("Line is Empty");
						}
						catch (ArrayIndexOutOfBoundsException ex) {
						System.out.print(" ");
					}
						
					} else {
						System.out.println("Currently Boarding:");
						System.out.println("Nothing to note.....");
					}

				}
				
				
				else {

				}
			} else {
				System.out.println("Nothing to note.....");
				System.out.println(" ");
				System.out.println("Currently Boarding:");
				System.out.println("Nothing to note.....");
			}
			
			for (int i = 0; i < count; i++) {
			try {
				int y = flightTerminals[i].getMinBoard();
				flightTerminals[i].setMinBoard(y--);
			} catch (NullPointerException ex) {
				System.out.print(" ");
			} catch (ArrayIndexOutOfBoundsException ex) {
				System.out.print(" ");
			}
			}
			if (flightTerminals[count] != null) {

				System.out.println("Flight to " + flightTerminals[count].getDestination() + " has "
						+ flightTerminals[count].getMinBoard() + " minutes to board," + flightTerminals[count].getSize()
						+ " passenger(s), and" + flightTerminals[count].getBoardingQueue().getSize()
						+ " person(s) waiting to board.");
			}

			for (int i = 0; i < count; i++) {
				try {
					if (flightTerminals[i].getMinBoard() == 0) {
						flightTerminals[i].setBoarding(false);
					}
					if (!flightTerminals[i].getBoarding()) {
						try {
							if (flightTerminals[i].getMinDepart() > 0) {
								System.out.println("Departing:");
								System.out.println("Flight to" + flightTerminals[i].getDestination() + " has "
										+ flightTerminals[i].getSize() + " passengers and is "
										+ flightTerminals[i].getMinDepart() + " minutes away from departure");
								int q = flightTerminals[i].getMinDepart();
								flightTerminals[i].setMinDepart(q--);
							} else if (flightTerminals[i].getMinDepart() != 0) {
								System.out.println("Departing:");
								System.out.println("Nothing to note.....");
							}
							System.out.println(" ");
							if (flightTerminals[i].getMinDepart() == 0) {
								System.out.println("Final Departures:");
								System.out.println("RFK -> " + flightTerminals[count].getDestination());
								flightTerminals[i].print();

							} else {
								System.out.println("Final Departures:");
								System.out.println("Nothing to note.....");
							}
							System.out.println(" ");
						} catch (NullPointerException ex) {
							System.out.println("Departing:");
							System.out.println("Nothing to note.....");
							System.out.println(" ");
							System.out.println("Final Departures:");
							System.out.println("Nothing to note.....");
							System.out.println(" ");

						}
					}
					else {
						System.out.println("Departing:");
						System.out.println("Nothing to note.....");
						System.out.println(" ");
						System.out.println("Final Departures:");
						System.out.println("Nothing to note.....");
						System.out.println(" ");

					}

				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.print(" ");
				} catch (NullPointerException ex) {
					System.out.print("");
				}
			}
			count++;

		}

		System.out.println("Minute" + min);
		System.out.println("Simulation terminated. Thank you for choosing RFK!");
	}

}

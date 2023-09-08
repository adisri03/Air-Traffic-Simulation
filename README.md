# Air Traffic Simulation
![Java](https://img.shields.io/badge/Java-8%2B-blue)
![License](https://img.shields.io/badge/License-MIT-green)



## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
   - [Setting Probabilities](#setting-probabilities)
- [Usage](#usage)
- [Notes](#notes)

## Introduction
This is a simulation program for modeling the outgoing air traffic at Robert F. Kennedy (RFK) Airport in Montana. The program uses random probabilities to simulate various events and sub-events related to passenger boarding and flight departures. Here's how the simulation works:

## Features
1. Passenger Boarding: Passengers are dequeued from a flight's BoardingQueue and counted against the plane's capacity.
2. Passenger Arrival: Passengers arrive at a flight's BoardingQueue. The probability of arriving depends on the passenger's class (First Class, Business Class, Premium Economy, Economy) and the possibility of having COVID-19, which can extend boarding and departure times.
3. New Flight: A new flight begins boarding. Flights can be normal or Air Force One, which pauses all other departures and boarding until its departure.

## Getting Started
To run the simulation, you need to provide probabilities for each event and sub-event. The program uses Java's nextFloat() from java.util.Random with a specified seed for randomness.

### Setting Probabilities
You must set the following probabilities:

Probability of a passenger boarding (P_boarding)
Probability of a passenger arriving (P_arrival)
Probability of a passenger being First Class (P_first_class)
Probability of a passenger being Business Class (P_business_class)
Probability of a passenger being Premium Economy (P_premium_economy)
Probability of a passenger being Economy (P_economy)
Probability of a passenger having COVID-19 (P_covid)
Probability of a new flight (P_new_flight)
Probability of a new flight being normal (P_normal_flight)
Probability of a new flight being Air Force One (P_air_force_one_flight)

## Usage
1. Compile the program using a Java compiler.
2. Run the compiled program, providing the required probabilities as command-line arguments. For example:
   ```bash
   java RFKAirportSimulation 0.2 0.5 0.1 0.1 0.3 0.4 0.1 0.7 0.3 0.05
## Notes
All events are independent and can occur every minute.
Sub-events are mutually exclusive.
Passengers with COVID-19 cannot enter a BoardingQueue.
Refusal of new flights or passengers may occur if terminals or queues are full.


package p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverClass {

	public static ArrayList<Crime> crimeList = new ArrayList<Crime>();

	public static void main(String[] args) {

		// Coordinates for West Belfast
		double LatitudeS = 54.5595277;
		double LatitudeL = 54.6015288;
		double LongitudeS = -5.9404023;
		double LongitudeL = -6.0536429;
		
		int crimeNum = 0;
		int result;

		readData();

		Scanner scan = new Scanner(System.in);

		int option;

		do {

			System.out.println("1) Show the full list of crimes");
			System.out.println("2) Show all the instances of crime in Albert Street, Belfast");
			System.out.println("3) Show all crime from West Belfast GPS Coordinates");
			System.out.println("4)");

			option = scan.nextInt();

			switch (option) {
			case 1:
				System.out.println("One");
				showAll(crimeList);
				System.out.println("Amount of crimes: " + crimeList.size());
				System.out.println();
				crimeNum = crimeList.size();
				result = crimeNum / 28;
				System.out.println("Average daily crime rate: " + result);
				break;
			case 2:
				System.out.println("Two");
				showCrimeLocation(getCrimeLocation("Albert Street"));
				ArrayList<Crime> locationSelection = getCrimeLocation("Albert Street");
				showCrimeLocation(locationSelection);
				break;
			case 3:
				System.out.println("Three");
				//showCrimeLocation(westBelfastRangeGPS(LongitudeS, LongitudeL, LatitudeS, LatitudeL));
				ArrayList<Crime> WestBelfastGPS = westBelfastRangeGPS(LongitudeS, LongitudeL, LatitudeS, LatitudeL);
				displayByLocationLatitudeLongitideCrimeType(WestBelfastGPS);
				break;
			case 4:
				System.out.println("Four");
				break;
			default:
				System.out.println("Error");
			}

		} while (option != 5);

		scan.close();

	}

	public static void displayByLocationLatitudeLongitideCrimeType(ArrayList<Crime> crimeList) {
		for (Crime crimes : crimeList) {
			crimes.displayLocationCrimeLatLong();
		}
	}

	public static ArrayList<Crime> westBelfastRangeGPS(double LongS, double LongL, double LatS, double LatL) {
		ArrayList<Crime> GPSLocation = new ArrayList<Crime>();

		for (Crime crimes : crimeList) {
			if (crimes.getLongitude() < LongS && crimes.getLongitude() > LongL
					&& (crimes.getLatitude() > LatS && crimes.getLatitude() < LatL)) {
				GPSLocation.add(crimes);
			}
		}
		return GPSLocation;
	}

	public static void showCrimeLocation(ArrayList<Crime> crimeLocation) {
		for (Crime crimes : crimeLocation) {
			System.out.println(crimes);
		}
	}

	/**
	 * This Method returns a list based on a search for a specified location
	 * 
	 * @param location
	 * @return
	 */
	public static ArrayList<Crime> getCrimeLocation(String location) {
		ArrayList<Crime> crimeLocation = new ArrayList<Crime>();

		for (Crime crimes : crimeList) {
			if (crimes.getLocation().equalsIgnoreCase(location))
				crimeLocation.add(crimes);
		}
		return crimeLocation;
	}

	public static void readData() {

		File file = new File("2022-02-northern-ireland-street.csv");

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fileReader);
			String line = bReader.readLine();

			do {
				line = bReader.readLine();
				Crime crime = new Crime();
				String[] readFile = line.split(",");

				crime.setMonth(readFile[0]);
				if (crime.month.equalsIgnoreCase("2022-02")) {
					crime.month = ("February");
				}

				crime.setReportedBy(readFile[1]);
				if (crime.reportedBy.equalsIgnoreCase("Police Service of Northern Ireland")) {
					crime.reportedBy = ("PSNI");
				}

				crime.setFallsWithin(readFile[2]);
				if (crime.fallsWithin.equalsIgnoreCase("Police Service of Northern Ireland")) {
					crime.fallsWithin = ("PSNI");
				}

				if (readFile[3].isEmpty()) {
					// Do Nothing
				} else {
					crime.setLongitude((Double.parseDouble(readFile[3])));
				}

				if (readFile[4].isEmpty()) {
					// Do Nothing
				} else {
					crime.setLatitude((Double.parseDouble(readFile[4])));
				}

				crime.setLocation(readFile[5]);
				
				if (crime.location.contains("On or near ")) {
					String target = "On or near ";
					String replacement = "";
					String processed = crime.location.replace(target, replacement);
					crime.location = processed;
				}
				if(crime.location.isEmpty()) {
					crime.location = ("Location not Given");
				}

				crime.setCrimeType(readFile[6]);

				crimeList.add(crime);

			} while ((line = bReader.readLine()) != null);

			bReader.close();
			fileReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void showAll(ArrayList<Crime> crimeList) {
		for (Crime crime : crimeList) {
			System.out.print(crime);
			System.out.println();
		}
	}

}

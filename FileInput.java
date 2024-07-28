
/* Name: Tony Tan
 * Date: May 7, 2024
 * Course Code: ICS 3U
 * Title: Cellphone and Rating File Input
 * 
 * Description: Uses the Scanner class to read and load the cellphone and rating objects using the 
 * cellphone.txt and rating.txt file
 * 
 * Major skills: reading and loading txt files with Scanner class
 * 
 * Added features: Another array for all the rating scores of the cellphones.
 * Areas of concerns: How to utilize this in other classes.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
	
	//Create arrays
	public static Cellphone[] cellphoneArray = new Cellphone[20];
	public static Rating[] ratingArray = new Rating[20];

	public static void main(String[] args) {
		//Run all the methods
		fillCellphoneArray();
		fillRatingArray();
		displayCellphoneArray();
		displayRatingArray();
	}
	
	//Method to fill the index of the cellphone array
	public static void fillCellphoneArray() {
		//Try catch statement to read and load txt files
		try {
		
			//Create scanner object to read files
			Scanner inputFile = new Scanner(new File("data/cellphone.txt"));
		
			//Excludes these arguments from getting scanned
			inputFile.useDelimiter(",|\r\n");
		
			//For loop to create new object for each index
			for (int index = 0; index < cellphoneArray.length; index++) {
				//Declares and assigns a value to all the fields using .txt file
				String brand = inputFile.next();
				String model = inputFile.next();
				String type = inputFile.next();
				double price = inputFile.nextDouble();
				String operatingSystem = inputFile.next();
				String cpu = inputFile.next();
				String gpu = inputFile.next();
				int ram = inputFile.nextInt();
				int storage = inputFile.nextInt();
				double displaySize = inputFile.nextDouble();
				String displayResolution = inputFile.next();
				int cameraRear = inputFile.nextInt();
				double cameraFront = inputFile.nextDouble();
				int batteryCapacity = inputFile.nextInt();
				double weight = inputFile.nextDouble();
				String hyperlink = inputFile.next();
			
				//Create a new object for each index
				cellphoneArray[index] = new Cellphone(brand, model, type, price, operatingSystem, cpu,
						gpu, ram, storage, displaySize, displayResolution, cameraRear, cameraFront, 
						batteryCapacity, weight, hyperlink);
			}
		
			//Close scanner object
			inputFile.close(); //External file can now be used while this program is running
			
		} catch (FileNotFoundException e) {
			
			System.out.println("File error");
		}
		
	}
	
	//Method to fill the library of the rating array
	public static void fillRatingArray() {
		
		//Try catch statement to read files
		try {
			
			//Create scanner object to read the .txt file
			Scanner inputFile = new Scanner(new File("data/rating.txt"));
			
			//Delimiter to exclude certain arguments from scanner object
			inputFile.useDelimiter(",|\r\n");
		
			//For loop to create an object for each index of the array
			for (int index = 0; index < ratingArray.length; index++) {
				
				//Declares and assigns a value for all the fields using the .txt file
				String model = inputFile.next();
				int quality = inputFile.nextInt();
				double processorPerformance = inputFile.nextDouble();
				int memory = inputFile.nextInt();
				int display = inputFile.nextInt();
				int camera = inputFile.nextInt();
				int battery = inputFile.nextInt();
				double finalOverall = inputFile.nextDouble();
			
				//Creates a new object for each index of the array
				ratingArray[index] = new Rating(model, quality, processorPerformance, memory, display, camera,
					battery, finalOverall);
			} 
			
			//Close the scanner object
			inputFile.close(); //External file can now be used while this program is running
			
		} catch (FileNotFoundException e)  {
			System.out.println("File error");
		}
	}
	
	//Method to display the cellphone array
	public static void displayCellphoneArray() {
		//For loop to show every index of the cellphone array
		for (int index = 0; index < cellphoneArray.length; index++) {
			System.out.println(cellphoneArray[index]);
		}
	}
	
	//Method to display the rating array
	public static void displayRatingArray() {
		//For loop to show every index of the rating array
		for (int index = 0; index < ratingArray.length; index++) {
			System.out.println(ratingArray[index]);
		}
	}
}

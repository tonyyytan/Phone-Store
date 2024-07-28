/*
 * Group 1, Alina Yeung
 * Date: May 7 2024
 * Course: ICS3U
 * Application Class
 * The purpose of this project is to show the inventory frame and 
 * connect the frames together 
 */
public class CellPhoneApplicationClass {
	public static void main (String [] args) {
		//add a main method to the class application file
		//this shows the code
		
		//fills the rating and cellphone arrays
		FileInput.fillCellphoneArray();
		FileInput.fillRatingArray();
		
		MainMenuFrame Frame = new MainMenuFrame();
	}
	

}

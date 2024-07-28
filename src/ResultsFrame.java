/* Name: Tony Tan - Group 1
 * Date: May 12, 2024
 * Course Code: ICS 3U
 * Title: Results Frame 
 * 
 * Description: Receives input from survey frame and compares answers
 * to a scoring system to determine best results. Displays these answers by creating a 
 * constructor for Results frame containing all its JPanels, JButtons, and JLabels. 
 * 
 * Major skills: Creating JLabels, JButtons, JPanels, JScroll, etc. Using arrays, java swing,
 * switch, and if-else-if decision structures.
 * 
 * Added features: Scroll bar: https://docs.oracle.com/javase%2Ftutorial%2F/uiswing/components/scrollpane.html
 * Image resizing: https://stackoverflow.com/questions/5895829/resizing-image-in-java
 * 
 * Areas of concerns: How to receive input from survey frame
 * 
 * Contribution to Class: 98% Tony, 2% Ivan
 */

//import java packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

//Create class for the GUI frame

public class ResultsFrame extends JFrame implements ActionListener{
	
	//Create and declare arrays outside of constructor, so it can be accessed throughout
	public static int[] userAnswersArray = new int[7];
	public static double[] scoreArray = new double[20];
	private static int[] choiceArray = new int[3];
	private String[] BUTTON_TEXT = {"home", "education", "inventory", "survey"};
	private JButton[] buttons = new JButton[BUTTON_TEXT.length];;
	
	//Declare widgets and panels outside constructor so accessible throughout program
	JButton cartButton = new JButton();
	JButton buy1 = new JButton();
	JButton buy2 = new JButton();
	JButton buy3 = new JButton();
	JButton surveyButton = new JButton();
	JPanel topBar1 = new JPanel();
	JPanel topBar2 = new JPanel();
	JPanel topBar3 = new JPanel();
	JPanel scrollPanel = new JPanel();
	JScrollPane scroll = new JScrollPane(scrollPanel);
	JPanel displayPanel1 = new JPanel();
	JPanel displayPanel2 = new JPanel();
	JPanel displayPanel3 = new JPanel();
	JPanel surveyPanel = new JPanel();
	
	//constructor to create and place widgets
	ResultsFrame() {
		
		//Declare and create Images
		//Create and resize cart image
		ImageIcon cart = new ImageIcon("images/cartDD.png");
		Image cartImage = cart.getImage();
		Image cartScaled = cartImage.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH);
		ImageIcon cartFinal = new ImageIcon(cartScaled);
		
		//Create and resize the logo image
		ImageIcon logo = new ImageIcon("images/logoDD.png");
		Image logoImage = logo.getImage(); //get the image
		Image logoScaled = logoImage.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH); //scale
		ImageIcon logoFinal = new ImageIcon(logoScaled); //create new ImageIcon from scaled image
		
		//place panels
		topBar1.setBackground(new Color(0xFFFEE7)); //set color beige
		topBar1.setBounds(0, 0, 1200, 75); //set bounds
		topBar1.setLayout(null); //in order to set absolute coordinates
		add(topBar1); //add to the frame
		topBar1.setVisible(true); //set visible
		
		//create topBar2 panel
		topBar2.setBackground(new Color(0x004AAD)); //set color blue
		topBar2.setBounds(0, 75, 1200, 75);
		topBar2.setLayout(null);
		topBar2.setVisible(true);
		add(topBar2);
		
		//create topBar3 panel
		topBar3.setBackground(Color.white); //set color white
		topBar3.setBounds(0, 125, 1200, 75);
		topBar3.setLayout(null);
		add(topBar3);
		topBar3.setVisible(true);
		
		//Credit: Ivan helped setting up scroll
		//Place scroll panel
		scrollPanel.setLayout(null);
		scrollPanel.setBackground(Color.white);
		scrollPanel.setPreferredSize(new Dimension(1200, 1900));
		
		//Place scroll bar
		scroll.setBounds(0, 150, 1186, 575);
		scroll.setBackground(Color.white);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); //vertical scrolling
		scroll.getVerticalScrollBar().setUnitIncrement(15); //scroll by 15 pixel increments
		scroll.setHorizontalScrollBar(null);
		topBar3.add(scroll); //add to the panel
		
		//Create first display panel for choice1
		displayPanel1.setBackground(new Color(0xFFFEE7));
		displayPanel1.setBounds(84, 100, 1000, 500);
		displayPanel1.setLayout(null);
		scrollPanel.add(displayPanel1);
		displayPanel1.setVisible(true);
		
		//Create second display panel for choice2
		displayPanel2.setBackground(new Color(0xFFFEE7)); 
		displayPanel2.setBounds(84, 650, 484, 550);
		displayPanel2.setLayout(null);
		scrollPanel.add(displayPanel2);
		displayPanel2.setVisible(true);
		
		//Create third display panel for choice3
		displayPanel3.setBackground(new Color(0xFFFEE7));
		displayPanel3.setBounds(600, 650, 484, 550);
		displayPanel3.setLayout(null);
		scrollPanel.add(displayPanel3);
		displayPanel3.setVisible(true);
		
		//Create a panel to display retaking survey questions
		surveyPanel.setBackground(new Color(0xFFFEE7));
		surveyPanel.setBounds(200, 1300, 800, 300);
		surveyPanel.setLayout(null);
		scrollPanel.add(surveyPanel);
		surveyPanel.setVisible(true);
		
		//for loop to place top bar buttons
		for (int count = 0; count < BUTTON_TEXT.length; count++) {
			buttons[count] = new JButton(BUTTON_TEXT[count]);
			buttons[count].setBounds(600 + 125 * count, 22, 140, 25);
			buttons[count].addActionListener(this); //action listener tracking if button is pressed
			buttons[count].setFocusPainted(false); //doesn't highlight/focus when hovering
			buttons[count].setFocusable(true); //focuses when clicked
			buttons[count].setFont(new Font("Canva Sans", Font.CENTER_BASELINE, 22)); //font and size
			buttons[count].setOpaque(true);
			buttons[count].setBackground(new Color(0x004AAD));
			buttons[count].setBorderPainted(false);
			buttons[count].setForeground(Color.white);
			topBar2.add(buttons[count]);
		}
		
		//Create cart button
		cartButton.setBounds(1100, 11, 50, 50);
		cartButton.addActionListener(this);
		cartButton.setFocusPainted(false);
		cartButton.setOpaque(true);
		cartButton.setBorderPainted(false);
		cartButton.setIcon(cartFinal);
		topBar1.add(cartButton);
		
		//JLabel company icon image
		JLabel logoIcon = new JLabel(logoFinal);
        logoIcon.setBounds(50, 11, 50, 50);
        topBar2.add(logoIcon);
        
        //JLabel company name text
        JLabel companyName = new JLabel();
    	companyName.setText("Device Depot Electronics");
		companyName.setFont(new Font("Canva Sans", Font.BOLD, 30));
		companyName.setForeground(Color.WHITE);
		companyName.setBounds(125, 11, 500, 50);
		topBar2.add(companyName);
		
		//Calls method to analyze the survey response answers
		analyzeAnswers();
		
		//Calls method to display the top3 choices based on survey responses
		displayChoice1();
		displayChoice2();
		displayChoice3();
		
		//Calls a method to display the "retake survey" box
		displayRetakeSurvey();
		
		//windows settings
		this.setTitle("Results Frame"); //name of frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits program
		this.setResizable(false); //can't resize window
		this.setSize(1200, 625); //window dimensions
		this.setVisible(true); //set visible
		
	}
	
	//void method to display phone choice 1
	public void displayChoice1() {
		
		//create variable for the index of the best choice
		int maxIndex1 = choiceArray[0];
		
		//create variables for the #1 phone's price, brand, and model name
		double phonePrice = FileInput.cellphoneArray[maxIndex1].getPrice();
		String brandName = FileInput.cellphoneArray[maxIndex1].getBrand();
		String modelName = FileInput.cellphoneArray[maxIndex1].getModel();
		
		//Create and resize image of choice #1's phone
		ImageIcon phone = new ImageIcon("images/" + modelName +".png");
		Image phoneIcon = phone.getImage();
		Image phoneScaled = phoneIcon.getScaledInstance(400, 500, java.awt.Image.SCALE_SMOOTH);
		ImageIcon phoneImageFinal = new ImageIcon(phoneScaled);
		
		//Create and resize image for the "buy" button
		ImageIcon buy = new ImageIcon("images/buy.png");
		Image buyImage = buy.getImage();
		Image buyScaled = buyImage.getScaledInstance(180, 60, java.awt.Image.SCALE_SMOOTH);
		ImageIcon buyImageFinal = new ImageIcon(buyScaled);
		
		//Create JLabel text for brand name
		JLabel brand = new JLabel();
		brand.setText(brandName);
		brand.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		brand.setForeground(Color.black);
		brand.setBounds(50, 25, 300, 50);
		displayPanel1.add(brand);
		
		//Create JLabel text for model name
		JLabel model = new JLabel();
		model.setText(modelName);
		model.setFont(new Font("Canva Sans", Font.BOLD, 30));
		model.setForeground(Color.black);
		model.setBounds(50, 60, 300, 50);
		displayPanel1.add(model);
		
		//Create JLabel text for "first choice"
		JLabel choice = new JLabel();
		choice.setText("#1 CHOICE");
		choice.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		choice.setForeground(Color.black);
		choice.setBounds(50, 95, 300, 50);
		displayPanel1.add(choice);
		
		//Create JLabel text for price
		JLabel price = new JLabel();
		price.setText("Starting at $" + phonePrice);
		price.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		price.setForeground(Color.black);
		price.setBounds(50, 325, 300, 50);
		displayPanel1.add(price);
		
		//Create JButton to "buy" the phone
		buy1.setBounds(60, 385, 180, 50);
		buy1.addActionListener(this);
		buy1.setFocusPainted(false);
		buy1.setOpaque(true);
		buy1.setBorderPainted(false);
		buy1.setIcon(buyImageFinal);
		displayPanel1.add(buy1);
		
		//Create JLabel image of the phone
		JLabel phoneImage = new JLabel(phoneImageFinal);
		phoneImage.setBounds(500, 50, 500, 400);
		displayPanel1.add(phoneImage);
	}
	
	//void method to display choice 2
	public void displayChoice2() {
		
		//create variable for the index of the second choice
		int maxIndex2 = choiceArray[1];
		
		//create variables for the #2 phone's price, brand, and model name
		double phonePrice = FileInput.cellphoneArray[maxIndex2].getPrice();
		String brandName = FileInput.cellphoneArray[maxIndex2].getBrand();
		String modelName = FileInput.cellphoneArray[maxIndex2].getModel();
		
		//Create and resize image of choice #2's phone
		ImageIcon phone = new ImageIcon("images/" + modelName +".png");
		Image phoneIcon = phone.getImage();
		Image phoneScaled = phoneIcon.getScaledInstance(300, 375, java.awt.Image.SCALE_SMOOTH);
		ImageIcon phoneImageFinal = new ImageIcon(phoneScaled);

		//Create and resize image for the "buy" button
		ImageIcon buy = new ImageIcon("images/buy.png");
		Image buyImage = buy.getImage();
		Image buyScaled = buyImage.getScaledInstance(180, 60, java.awt.Image.SCALE_SMOOTH);
		ImageIcon buyImageFinal = new ImageIcon(buyScaled);
		
		//Create JLabel text for brand name
		JLabel brand = new JLabel();
		brand.setText(brandName);
		brand.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		brand.setForeground(Color.black);
		brand.setBounds(50, 25, 150, 50);
		displayPanel2.add(brand);
		
		//Create JLabel text for model name
		JLabel model = new JLabel();
		model.setText(modelName);
		model.setFont(new Font("Canva Sans", Font.BOLD, 30));
		model.setForeground(Color.black);
		model.setBounds(50, 60, 300, 50);
		displayPanel2.add(model);
		
		//Create JLabel text for "second choice"
		JLabel choice = new JLabel();
		choice.setText("#2 CHOICE");
		choice.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		choice.setForeground(Color.black);
		choice.setBounds(50, 95, 300, 50);
		displayPanel2.add(choice);
		
		//Create JLabel text for price
		JLabel price = new JLabel();
		price.setText("Starting at $" + phonePrice);
		price.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		price.setForeground(Color.black);
		price.setBounds(125, 400, 300, 50);
		displayPanel2.add(price);
	
		//Create JButton to buy the phone
		buy2.setBounds(140, 460, 180, 50);
		buy2.addActionListener(this);
		buy2.setFocusPainted(false);
		buy2.setOpaque(true);
		buy2.setBorderPainted(false);
		buy2.setIcon(buyImageFinal);
		displayPanel2.add(buy2);
		
		//Create JLabel image of the phone
		JLabel phoneImage = new JLabel(phoneImageFinal);
		phoneImage.setBounds(125, 150, 250, 250);
		displayPanel2.add(phoneImage);
	}

	//void method to display choice 3
	public void displayChoice3() {
		
		//create variable for the index of the third choice
		int maxIndex3 = choiceArray[2];
		
		//create variables for the #3 phone's price, brand, and model name
		double phonePrice = FileInput.cellphoneArray[maxIndex3].getPrice();
		String brandName = FileInput.cellphoneArray[maxIndex3].getBrand();
		String modelName = FileInput.cellphoneArray[maxIndex3].getModel();

		//Create and resize image of choice #3's phone
		ImageIcon phone = new ImageIcon("images/" + modelName +".png");
		Image phoneIcon = phone.getImage();
		Image phoneScaled = phoneIcon.getScaledInstance(300, 375, java.awt.Image.SCALE_SMOOTH);
		ImageIcon phoneImageFinal = new ImageIcon(phoneScaled);
		
		//Create and resize image for the "buy" button
		ImageIcon buy = new ImageIcon("images/buy.png");
		Image buyImage = buy.getImage();
		Image buyScaled = buyImage.getScaledInstance(180, 60, java.awt.Image.SCALE_SMOOTH);
		ImageIcon buyImageFinal = new ImageIcon(buyScaled);
		
		//Create JLabel text for brand name
		JLabel brand = new JLabel();
		brand.setText(brandName);
		brand.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		brand.setForeground(Color.black);
		brand.setBounds(50, 25, 150, 50);
		displayPanel3.add(brand);
		
		//Create JLabel text for model name
		JLabel model = new JLabel();
		model.setText(modelName);
		model.setFont(new Font("Canva Sans", Font.BOLD, 30));
		model.setForeground(Color.black);
		model.setBounds(50, 60, 300, 50);
		displayPanel3.add(model);
		
		//Create JLabel text for "third choice"
		JLabel choice = new JLabel();
		choice.setText("#3 CHOICE");
		choice.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		choice.setForeground(Color.black);
		choice.setBounds(50, 95, 300, 50);
		displayPanel3.add(choice);
		
		//Create JLabel text for price
		JLabel price = new JLabel();
		price.setText("Starting at $" + phonePrice);
		price.setFont(new Font("Canva Sans", Font.PLAIN, 26));
		price.setForeground(Color.black);
		price.setBounds(125, 400, 300, 50);
		displayPanel3.add(price);
		
		//Create JButton to "buy" the phone
		buy3.setBounds(140, 460, 180, 50);
		buy3.addActionListener(this);
		buy3.setFocusPainted(false);
		buy3.setOpaque(true);
		buy3.setBorderPainted(false);
		buy3.setIcon(buyImageFinal);
		displayPanel3.add(buy3);
		
		//Create JLabel image of the phone
		JLabel phoneImage = new JLabel(phoneImageFinal);
		phoneImage.setBounds(125, 150, 250, 250);
		displayPanel3.add(phoneImage);
	}
	
	//void method to display retake survey panel
	public void displayRetakeSurvey() {
		
		//Create and resize image of taking a survey cartoon
		ImageIcon survey = new ImageIcon("images/survey.png");
		Image surveyIcon = survey.getImage();
		Image surveyScaled = surveyIcon.getScaledInstance(150, 200, java.awt.Image.SCALE_SMOOTH);
		ImageIcon surveyImageFinal = new ImageIcon(surveyScaled);
		
		//Create and resize image of the survey button
		ImageIcon surveyButtonImage = new ImageIcon("images/surveyButton.png");
		Image surveyButtonIcon = surveyButtonImage.getImage();
		Image surveyButtonScaled = surveyButtonIcon.getScaledInstance(180, 60, java.awt.Image.SCALE_SMOOTH);
		ImageIcon surveyButtonImageFinal = new ImageIcon(surveyButtonScaled);
		
		//Create JLabel text to ask user if they'd like to retake survey
		JLabel question = new JLabel();
		question.setText("<html>Don't like your options? <br>Try our survey again!<html>");
		question.setFont(new Font("Canva Sans", Font.BOLD, 30));
		question.setForeground(Color.black);
		question.setBounds(210, 75, 350, 150);
		surveyPanel.add(question);
		
		//Create JButton to redirect to survey page
		surveyButton.setBounds(580, 125, 180, 50);
		surveyButton.addActionListener(this);
		surveyButton.setFocusPainted(false);
		surveyButton.setOpaque(true);
		surveyButton.setBorderPainted(false);
		surveyButton.setIcon(surveyButtonImageFinal);
		surveyPanel.add(surveyButton);
		
		//Create JLabel image of the survey cartoon
		JLabel surveyImage = new JLabel(surveyImageFinal);
		surveyImage.setBounds(0, 50, 225, 225);
		surveyPanel.add(surveyImage);
	}
	
	//method to analyze the answers
	private void analyzeAnswers() {
		
		//assign values to userAnswerArray from survey frame
		
		for (int index = 0; index < userAnswersArray.length; index++) {
			userAnswersArray[index] = SurveyFrame.selectedValues.get(index);
		}

		//for loop to check all phones in the cellphone array
		for (int index = 0; index < scoreArray.length; index++) {
			//create a variable to track the answer of each question
			//changes answer with each question number
			int questionAnswer;
			
			//answer for the first question
			questionAnswer = userAnswersArray[0];
			double price = FileInput.cellphoneArray[index].getPrice(); //get the price of the phone
			
			//switch case structure to check first question
			switch (questionAnswer){
			
			case 1: { //$299 or less
				if (price < 300) {
					scoreArray[index]+= 3;
				}
				break;
			}
			
			case 2: { //$300-$599
				if (price >= 300 && price < 600) {
					scoreArray[index]+= 3;
				}
				break;
			}
			
			case 3: { //$600-$999
				if (price >= 600 && price < 1000) {
					scoreArray[index]+= 3;
				}
				break;
			}
			
			case 4: { //$1000+
				if (price >= 1000) {
					scoreArray[index]+= 3;
				}
				break;
			}
			default: //if an error occurs, doesn't skew results
				break;
			}
			
			//answer for the second question
			questionAnswer = userAnswersArray[1];	
			
			//switch case statement to check second question
			switch (questionAnswer) {
			
			case 1: { //checks highest camera quality
				
				//get the camera quality rating of the phone
				int cameraQuality = FileInput.ratingArray[index].getCamera();
				
				if (cameraQuality <= 5) { //if rating is below or equal to 5
					scoreArray[index]+= 1; //lowest increment
				}
				
				else if (cameraQuality > 5 && cameraQuality < 8) { //if the rating is 5-8
					scoreArray[index]+= 1.5;//middle increment
				}
				
				else { //if rating is above or equal to 8
					scoreArray[index]+= 2.5;//highest increment
				}
				break;
			}
				
			case 2: { //checks the highest processor performance
				
				//get processor rating for the phone
				double performanceQuality = FileInput.ratingArray[index].getProcessorPerformance();
				
				if (performanceQuality <= 5) { //if the rating is below or equal to 5
					scoreArray[index]+= 1; //lowest increment
				}
				
				else if (performanceQuality > 5 && performanceQuality <= 8) { //if rating is 5-8
					scoreArray[index]+= 1.5; //middle increment
				}
				
				else { //if rating is above 8
					scoreArray[index]+= 2.5; //highest increment
				}
				break;
			}
			
			case 3: { //checks the highest display rating
				
				//gets the display rating of the phone
				int displayQuality = FileInput.ratingArray[index].getDisplay();
				
				if (displayQuality <= 7) { //if the rating is below or equal to 7
					scoreArray[index]+= 1; //lowest increment
				}
				
				else if (displayQuality > 7 && displayQuality <= 8) { //if the rating is 7-8
					scoreArray[index]+= 1.5; //middle increment
				}
				
				else { //if the rating is above 8
					scoreArray[index]+= 2.5; //highest rating
				}
				break;
			}
			
			case 4: { //other, so no increment whatsoever
				break;
			}
			
			default: //if an error occurs, doesn't skew results
				break;
			}
			
			//answer for the third question
			questionAnswer = userAnswersArray[2];
			
			//get the weight of the phone
			double weight = FileInput.cellphoneArray[index].getWeight();
			
			//switch case statement to check third question
			switch (questionAnswer) {
			
			case 1: { //up to 199g
				if (weight < 200) {
					scoreArray[index]+= 1; //increment score
				}
				break;		
			}
			
			case 2: { //200g-209g
				if (weight >= 200 && weight < 210) {
					scoreArray[index]+= 1; //increment score
				}
				break;
			}
			
			case 3: { //210g-219g
				if (weight >= 210 && weight < 220) {
					scoreArray[index]+= 1; //increment score
				}
				break;
			}
			
			case 4: { //220g+
				if (weight >= 220) {
					scoreArray[index]+= 1; //increment score
				}
				break;
			}
			
			default: //if an error occurs, doesn't skew results
				break;
			
			}
			
			//answer for the 4th question
			questionAnswer = userAnswersArray[3];
			
			//get the battery capacity of the phone
			int battery = FileInput.cellphoneArray[index].getBatteryCapacity();
			
			//switch case statement to check fourth question
			switch (questionAnswer) {
			
			case 1: { //up to 3999mAh
				if (battery < 4000) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;			
			}
			
			case 2: { //4000mAh-4499mAh
				if (battery >= 4000 && battery < 4500) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 3: { //4500mAh-4999mAh
				if (battery >= 4500 && battery < 5000) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 4: { //5000mAh
				if (battery >= 5000) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			default: //if an error occurs, doesn't skew results
				break;
			
			}
			
			//answer for the fifth question
			questionAnswer = userAnswersArray[4];
			
			//get the storage of the phone
			int storage = FileInput.cellphoneArray[index].getInternalStorage();
			
			//switch case statement to check fifth question
			switch (questionAnswer) {
			
			case 1: { //32gb storage
				if (storage == 32) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;		
			}
			
			case 2: { //64gb storage
				if (storage == 64) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 3: { //128gb storage
				if (storage == 128) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 4: { //256gb storage
				if (storage == 256) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 5: { //512gb storage
				if (storage == 512) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			default: //if an error occurs, doesn't skew results
				break;
			
			}
			
			//answer for the sixth question
			questionAnswer = userAnswersArray[5];
			
			//get the ram of the phone
			int ram = FileInput.cellphoneArray[index].getrAM();
			
			//switch case statement to check sixth question
			switch (questionAnswer) {
			
			case 1: { //3gb ram
				if (ram == 3) {
					scoreArray[index]+= 1; //increment score
				}
				break;				
			}
			
			case 2: { //4gb ram
				if (ram == 4) {
					scoreArray[index]+= 1; //increment score
				}
				break;
			}
			
			case 3: { //8gb ram
				if (ram == 8) {
					scoreArray[index]+= 1; //increment score
				}
				break;
			}
			
			case 4: { //12gb ram
				if (ram == 12) {
					scoreArray[index]+= 1; //increment score
				}
				break;
			}
			
			case 5: { //16gb ram
				if (ram == 16) {
					scoreArray[index]+= 1; //increment score
				}
				break;
			}
			
			default: //if an error occurs, doesn't skew results
				break;
			
			}
			
			//answer for the last question
			questionAnswer = userAnswersArray[6];
			
			//get the operating system of the phone
			String os = FileInput.cellphoneArray[index].getOperatingSystem();
			
			//switch case statement to check sixth question
			switch (questionAnswer) {
			
			case 1: { //selects android 11
				if (os.equals("Android 11")) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;				
			}
			
			case 2: { //selects android 12
				if (os.equals("Android 12")) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 3: { //selects android 13
				if (os.equals("Android 13")) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 4: { //selects android 14
				if (os.equals("Android 14")) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 5: { //selects ios 15
				if (os.equals("iOS 15")) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			case 6: { //selects ios 17
				if (os.equals("iOS 17")) {
					scoreArray[index]+= 1.5; //increment score
				}
				break;
			}
			
			default: //if an error occurs, doesn't skew results
				break;
			
			}
		}
		
		getMaxScores();

	}
	
	public static void getMaxScores() {
		
		//create variables for the max scores
		double maxScore1 = Double.MIN_VALUE;
		double maxScore2 = Double.MIN_VALUE;
		double maxScore3 = Double.MIN_VALUE;
		
		//set the max indexes to -1 so no false results show up
		//the array will show an error accessing -1
		int maxIndex1 = -1;
		int maxIndex2 = -1;
		int maxIndex3 = -1;

		//for loop to check each score on the array
		for (int index = 0; index < scoreArray.length; index++) {
			
			//if checked score is higher than the previous max score
			if (scoreArray[index] > maxScore1) {
				maxIndex3 = maxIndex2; //move previous #2 index to #2
				maxScore3 = maxScore2; //move previous #2 score to #3
				maxIndex2 = maxIndex1; //move previous max index to #2
				maxScore2 = maxScore1; //move previous max score to #2
				maxIndex1 = index; //set newest max index
				maxScore1 = scoreArray[index]; //set newest max score
			}
			
			//if checked score is bigger than #2
			else if (scoreArray[index] > maxScore2) {
				maxIndex3 = maxIndex2; //move previous #2 max index to #3
				maxScore3 = maxScore2; //move previous #2 max score to #3
				maxIndex2 = index; //set new #2 max index
				maxScore2 = scoreArray[index]; //set new #2 max score
			}
			
			//if checked score is bigger than #3
			else if (scoreArray[index] > maxScore3) {
				maxIndex3 = index; //set new #3 max index
				maxScore3 = scoreArray[index]; //set new #3 score
			}
			
		}
		
		//assigns the max index values to the choice array
		choiceArray[0] = maxIndex1;
		choiceArray[1] = maxIndex2;
		choiceArray[2] = maxIndex3;

	}
	
	//method to determine which frame a phone's buy page is called
	public void getBuyFrame(int maxIndex) {
		
		//switch case to get which frame the phone is
		//matches the index with each frame
		switch (maxIndex){
		
		case 0:
			MotoGPlayFrame motoGPlayFrame = new MotoGPlayFrame();
			break;
			
		case 1:
			TCL20SFrame tCL20SFrame = new TCL20SFrame();
			break;

		case 2:
			GalaxyA15Frame galaxyA15Frame = new GalaxyA15Frame();
			break;

		case 3:
			MotoGPowerFrame motoGPowerFrame = new MotoGPowerFrame();
			break;

		case 4:
			GalaxyA23Frame galaxyA23Frame = new GalaxyA23Frame();
			break;

		case 5:
			Pixel7AFrame pixel7AFrame = new Pixel7AFrame();
			break;

		case 6:
			iPhoneSEFrame iPhoneSEFrame = new iPhoneSEFrame();
			break;

		case 7:
			GalaxyA35Frame galaxyA35Frame = new GalaxyA35Frame();
			break;

		case 8:
			MotoGFrame motoGFrame = new MotoGFrame();
			break;

		case 9:
			NordN30Frame nordN30Frame = new NordN30Frame();
			break;

		case 10:
			Pixel8ProFrame pixel8ProFrame = new Pixel8ProFrame();
			break;

		case 11:
			iPhone13Frame iPhone13Frame = new iPhone13Frame();
			break;

		case 12:
			GalaxyS23FEFrame galaxyS23FEFrame = new GalaxyS23FEFrame();
			break;

		case 13:
			Pixel8Frame pixel8Frame = new Pixel8Frame();
			break;

		case 14:
			GalaxyZFlip5Frame galaxyZFlip5Frame = new GalaxyZFlip5Frame();
			break;

		case 15:
			iPhone15Frame iPhone15Frame = new iPhone15Frame();
			break;

		case 16:
			GalaxyS24UltraFrame galaxyS24UltraFrame = new GalaxyS24UltraFrame();
			break;

		case 17:
			GalaxyZFold5Frame galaxyZFoldFrame = new GalaxyZFold5Frame();
			break;

		case 18:
			OnePlus12Frame onePlus12Frame = new OnePlus12Frame();
			break;

		case 19:
			iPhone15MaxProFrame iPhone15MaxProFrame = new iPhone15MaxProFrame();
			break;
		
		default:
			break;
		}
	}

	//Method called if action listener detects a button
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		//if its from the cart button
		if (event.getSource() == cartButton) {
			setVisible(false);
			//goes to cart frame
			CartFrame cartFrame = new CartFrame();
		}
		
		//if its from the home button
		else if (event.getSource() == buttons[0]) {
			setVisible(false);
			//goes to main menu frame
			MainMenuFrame menuFrame = new MainMenuFrame();
		}
		
		//if its from the education button
		else if (event.getSource() == buttons[1]) {
			setVisible(false);
			//goes to the education frame
			EducationFrame educationFrame = new EducationFrame();
		}
		
		//if its from the inventory button
		else if (event.getSource() == buttons[2]) {
			setVisible(false);
			//goes to the inventory frame
			InventoryFrame inventoryFrame = new InventoryFrame();
		}
		
		//if its from the survey button at top bar
		else if (event.getSource() == buttons[3]) {
			//resets the scoring of all the phones
			for (int index = 0; index < scoreArray.length; index++) {
				scoreArray[index] = 0;
			}
			
			setVisible(false);
			//goes to the survey frame
			SurveyFrame surveyFrame = new SurveyFrame();
	        surveyFrame.initWindow();
	        surveyFrame.setVisible(true);
		}
		
		//if its from the buy button on #1 choice
		else if (event.getSource() == buy1) {
			setVisible(false);
			//goes to the #1 choice buy page
			int maxIndex1 = choiceArray[0];
			
			//method to determine which frame that is
			getBuyFrame(maxIndex1);
		}
		
		//if its from the buy button on #2 choice
		else if (event.getSource() == buy2) {
			setVisible(false);
			//goes to the #2 choice buy page
			int maxIndex2 = choiceArray[1];
			
			//method to determine which frame that is
			getBuyFrame(maxIndex2);
		}
		
		//if its from the buy button on #3 choice
		else if (event.getSource() == buy3) {
			setVisible(false);
			//goes to the #3 phone buy page
			int maxIndex3 = choiceArray[2];
			
			//method to determine which frame that is
			getBuyFrame(maxIndex3);
		}
		
		//if the retake survey button is clicked
		else if (event.getSource() == surveyButton) {
			
			//resets the scoring of all the phones
			for (int index = 0; index < scoreArray.length; index++) {
				scoreArray[index] = 0;
			}
			
			setVisible(false);
			//goes back to the survey frame
			SurveyFrame surveyFrame = new SurveyFrame();
	        surveyFrame.initWindow();
	        surveyFrame.setVisible(true);
		}
	
		//otherwise any other button closes frame
		else {
			setVisible(false);
		}
		
	}
	
}

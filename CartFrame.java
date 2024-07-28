/* Name: Tony Tan - Group 1
 * Date: May 14, 2024
 * Course Code: ICS 3U
 * Title: Cart Frame 
 * 
 * Description: Receives input from inventory frames. Finds out what the phone is
 * and displays it to the cart. Constantly expands the cart as well.
 * 
 * Major skills: Creating JLabels, JButtons, JPanels, JScroll, etc. Using arrays, java swing,
 * switch, and if-else-if decision structures.
 * 
 * Added features: Scroll bar: https://docs.oracle.com/javase%2Ftutorial%2F/uiswing/components/scrollpane.html
 * Image resizing: https://stackoverflow.com/questions/5895829/resizing-image-in-java
 * 
 * Areas of concerns: Displaying price
 * 
 * Contribution to Class: 80% Tony, 20% Aaron - some logic
 */

//import java packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

//Create class for GUI frame
public class CartFrame extends JFrame implements ActionListener{
	
	public static boolean[] cartContentArray = new boolean[20]; //determine if the cart slot is full
	public static int[] cartIndexArray = new int[20]; //determines what phone is in cart slot
	public static int[] cartQuantityArray = new int[20]; //determine the quantity of the phone model
	
	//array to create buttons
	private String[] BUTTON_TEXT = {"home", "education", "inventory", "survey"};
	private JButton[] buttons = new JButton[BUTTON_TEXT.length];
	
	//array to create the cart slots and details
	private JPanel[] cartImagePanel = new JPanel[20];
	private JPanel[] cartDetailsPanel = new JPanel[20];
	private JLabel[] productImage = new JLabel[20];
	private JLabel[] productName = new JLabel[20];
	private JLabel[] price = new JLabel[20];
	private JLabel[] quantity = new JLabel[20];
	private JLabel[] subTotal = new JLabel[20];
	
	
	//Declare widgets and panels outside constructor so accessible throughout program
	JButton clearCartButton = new JButton();
	JButton checkoutButton = new JButton();
	JPanel topBar1 = new JPanel();
	JPanel topBar2 = new JPanel();
	JPanel topbar3 = new JPanel();
	JPanel shoppingBar1 = new JPanel();
	JPanel shoppingBar2 = new JPanel();
	JPanel scrollPanel = new JPanel();
	JScrollPane scroll = new JScrollPane(scrollPanel);
	JLabel emptyText = new JLabel();
	JLabel cartDetailsText = new JLabel();
	JLabel paymentMethods = new JLabel();
	
	//declare border color variable outside of constructor to be accessed throughout
	Border whiteline = BorderFactory.createLineBorder(Color.white, 4);
	
	//constructor to create and place widgets
	CartFrame() { 
		
		//Declare and create Images
		//Create and resize the logo image
		ImageIcon logo = new ImageIcon("images/logoDD.png");
		Image logoImage = logo.getImage(); //get the image
		Image logoScaled = logoImage.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH); //scale
		ImageIcon logoFinal = new ImageIcon(logoScaled); //create new ImageIcon from scaled image
		
		//Create and resize the clear cart button
		ImageIcon clearCart = new ImageIcon("images/clearCart.png");
		Image clearCartImage = clearCart.getImage(); //get the image
		Image clearCartScaled = clearCartImage.getScaledInstance(120, 50, java.awt.Image.SCALE_SMOOTH); //scale
		ImageIcon clearCartImageFinal = new ImageIcon(clearCartScaled); //create new ImageIcon from scaled image
		
		//place panels
		topBar1.setBackground(new Color(0xFFFEE7)); //set color beige
		topBar1.setBounds(0, 0, 1200, 75);
		topBar1.setLayout(null);
		add(topBar1);
		topBar1.setVisible(true);
		
		topBar2.setBackground(new Color(0x004AAD)); //set color blue
		topBar2.setBounds(0, 75, 1200, 75);
		topBar2.setLayout(null);
		topBar2.setVisible(true);
		add(topBar2);
		
		topbar3.setBackground(Color.white); //set color white
		topbar3.setBounds(0, 125, 1200, 75);
		topbar3.setLayout(null);
		add(topbar3);
		topbar3.setVisible(true);
		
		//Credit: Ivan helped code scroll
		//Place scroll panel
		scrollPanel.setLayout(null);
		scrollPanel.setBackground(Color.white);
		scrollPanel.setPreferredSize(new Dimension(1200, 850));
		
		//Place scroll bar
		scroll.setBounds(0, 150, 1186, 575);
		scroll.setBackground(Color.white);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.getVerticalScrollBar().setUnitIncrement(15);
		scroll.setHorizontalScrollBar(null);
		topbar3.add(scroll);
		
		//Create panels to store cart contents
		shoppingBar1.setBackground(new Color(0xD1E9FF));
		shoppingBar1.setBounds(200, 75, 800, 50);
		shoppingBar1.setLayout(null);
		shoppingBar1.setVisible(true);
		scrollPanel.add(shoppingBar1);
		
		shoppingBar2.setBackground(new Color(0x004AAD));
		shoppingBar2.setBounds(200, 75, 800, 300);
		shoppingBar2.setLayout(null);
		shoppingBar2.setVisible(true);
		scrollPanel.add(shoppingBar2);
		
		//for loop to place top bar buttons
		for (int count = 0; count < BUTTON_TEXT.length; count++) {
			buttons[count] = new JButton(BUTTON_TEXT[count]);
			buttons[count].setBounds(600 + 125 * count, 22, 140, 25);
			buttons[count].addActionListener(this);
			buttons[count].setFocusPainted(false);
			buttons[count].setFocusable(true);
			buttons[count].setFont(new Font("Canva Sans", Font.CENTER_BASELINE, 20));
			buttons[count].setOpaque(true);
			buttons[count].setBackground(new Color(0x004AAD));
			buttons[count].setBorderPainted(false);
			buttons[count].setForeground(Color.white);
			topBar2.add(buttons[count]);
		}
		
		//clear cart button to clear cart of items
		clearCartButton.setIcon(clearCartImageFinal);
		clearCartButton.setBounds(1050, 15, 120, 50);
		clearCartButton.addActionListener(this);
		clearCartButton.setFocusable(true);
		clearCartButton.setBorderPainted(false);
        topBar1.add(clearCartButton);
		
		//JLabel images
		//Icon image
		JLabel logoIcon = new JLabel(logoFinal);
        logoIcon.setBounds(50, 11, 50, 50);
        topBar2.add(logoIcon);
        
        //JLabel text
        JLabel companyName = new JLabel();
    	companyName.setText("Device Depot Electronics");
		companyName.setFont(new Font("Canva Sans", Font.BOLD, 30));
		companyName.setForeground(Color.WHITE);
		companyName.setBounds(125, 11, 500, 50);
		topBar2.add(companyName);
		
		//JLabel text for the "Shopping cart" title
		JLabel cartName = new JLabel();
		cartName.setText("Shopping Cart");
		cartName.setFont(new Font("Canva Sans", Font.BOLD, 24));
		cartName.setForeground(Color.black);
		cartName.setBounds(20, 0, 250, 50);
		shoppingBar1.add(cartName);
		
		//JLabel text for the "Product" tab
		JLabel productNameText = new JLabel();
		productNameText.setText("Product");
		productNameText.setFont(new Font("Canva Sans", Font.PLAIN, 17));
		productNameText.setForeground(Color.black);
		productNameText.setBounds(225, 0, 250, 50);
		shoppingBar1.add(productNameText);
		
		//JLabel text for the "Price" tab
		JLabel priceText = new JLabel();
		priceText.setText("Price");
		priceText.setFont(new Font("Canva Sans", Font.PLAIN, 17));
		priceText.setForeground(Color.black);
		priceText.setBounds(375, 0, 250, 50);
		shoppingBar1.add(priceText);
		
		//JLabel text for the quantity number
		JLabel quantityText= new JLabel();
		quantityText.setText("Quantity");
		quantityText.setFont(new Font("Canva Sans", Font.PLAIN, 17));
		quantityText.setForeground(Color.black);
		quantityText.setBounds(525, 0, 250, 50);
		shoppingBar1.add(quantityText);
		
		//JLabel text for the "Subtotal" tab
		JLabel subTotalText= new JLabel();
		subTotalText.setText("Sub Total");
		subTotalText.setFont(new Font("Canva Sans", Font.PLAIN, 17));
		subTotalText.setForeground(Color.black);
		subTotalText.setBounds(675, 0, 250, 50);
		shoppingBar1.add(subTotalText);
		
		//JLabel text to say "cart empty"
		emptyText.setText("EMPTY");
		emptyText.setFont(new Font("Canva Sans", Font.BOLD, 100));
		emptyText.setForeground(Color.white);
		emptyText.setBounds(225, 50, 500, 250);
		shoppingBar2.add(emptyText);
		
		//windows settings
		this.setTitle("Results Frame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(1200, 625);
		this.setVisible(true);
		
		//displays, if any, cart items
		displayCartItems();
		
	}
	
	//method to display content of cart items, if any
	public void displayCartItems() {
		
		//for loop to check if the slots of the cart is full
		for (int index = 0; index < cartContentArray.length; index++) {
			
			//if the slot is full
			if (cartContentArray[index] == true) {
				
				//Get rid of default "EMPTY" cart text
				emptyText.setVisible(false);
				
				//create variables for each of the phone's properties
				int phoneNumber = cartIndexArray[index];
				double phonePrice = FileInput.cellphoneArray[phoneNumber].getPrice();
				String modelName = FileInput.cellphoneArray[phoneNumber].getModel();
				int phoneQuantity = cartQuantityArray[index];
				String phoneSubTotal = String.format("%.2f", phoneQuantity * phonePrice);
				
				//Create and resize image of the phone
				ImageIcon phone = new ImageIcon("images/" + modelName +".png");
				Image phoneIcon = phone.getImage();
				Image phoneScaled = phoneIcon.getScaledInstance(75, 100, java.awt.Image.SCALE_SMOOTH);
				ImageIcon phoneImageFinal = new ImageIcon(phoneScaled);
				
				//Expand the shopping cart as there are more slots added
				shoppingBar2.setBounds(200, 75, 800, 300 + 160 * index);
				scrollPanel.setPreferredSize(new Dimension(1200, 850 + 160 * index));
				
				//Create the panels of the cart slots
				cartImagePanel[index] = new JPanel();
				cartImagePanel[index].setBackground(new Color(0xD1E9FF));
				cartImagePanel[index].setBounds(25, 75 + 175 * index, 160, 160);
				cartImagePanel[index].setBorder(whiteline);
				cartImagePanel[index].setLayout(null);
				cartImagePanel[index].setVisible(true);
				shoppingBar2.add(cartImagePanel[index]);
				
				cartDetailsPanel[index] = new JPanel();
				cartDetailsPanel[index].setBackground(new Color(0xD1E9FF));
				cartDetailsPanel[index].setBounds(200, 75 + 175 * index, 575, 160);
				cartDetailsPanel[index].setBorder(whiteline);
				cartDetailsPanel[index].setLayout(null);
				cartDetailsPanel[index].setVisible(true);
				shoppingBar2.add(cartDetailsPanel[index]);
				
				//Create and add the image of the phone
				productImage[index] = new JLabel();
				productImage[index].setIcon(phoneImageFinal);
				productImage[index].setBounds(40, 30, 300, 100);
				cartImagePanel[index].add(productImage[index]);
				
				//Create and add in all the JLabels of the phones' properties
				//Add the phone's model name
				productName[index] = new JLabel();
				productName[index].setText(modelName);
				productName[index].setFont(new Font("Canva Sans", Font.PLAIN, 17));
				productName[index].setForeground(Color.black);
				productName[index].setBounds(40, 40, 100, 75);
				cartDetailsPanel[index].add(productName[index]);
				
				//Add the phone's price
				price[index] = new JLabel();
				price[index].setText("$" + Double.toString(phonePrice)); //convert double to string
				price[index].setFont(new Font("Canva Sans", Font.PLAIN, 17));
				price[index].setForeground(Color.black);
				price[index].setBounds(180, 40, 250, 75);
				cartDetailsPanel[index].add(price[index]);
				
				//Add the number of phones bought per model
				quantity[index] = new JLabel();
				quantity[index].setText(Integer.toString(phoneQuantity));
				quantity[index].setFont(new Font("Canva Sans", Font.PLAIN, 17));
				quantity[index].setForeground(Color.black);
				quantity[index].setBounds(340, 40, 250, 75);
				cartDetailsPanel[index].add(quantity[index]);
				
				//Add subtotal of model price * quantity
				subTotal[index] = new JLabel();
				subTotal[index].setText("$" + phoneSubTotal);
				subTotal[index].setFont(new Font("Canva Sans", Font.PLAIN, 17));
				subTotal[index].setForeground(Color.black);
				subTotal[index].setBounds(490, 40, 250, 75);
				cartDetailsPanel[index].add(subTotal[index]);
				
			}	
			
		}
		
		//for loop to ensure that all cart slots are checked to have something
		for (int index = 0; index < cartContentArray.length; index++) {
			
			//only when there is something in the cart does the checkout button pop up
			if (cartContentArray[index] == true) {

				//Create and resize the checkout button image
				ImageIcon checkout = new ImageIcon("images/checkout.png");
				Image checkoutImage = checkout.getImage(); //get the image
				Image checkoutScaled = checkoutImage.getScaledInstance(120, 50, java.awt.Image.SCALE_SMOOTH); //scale
				ImageIcon checkoutImageFinal = new ImageIcon(checkoutScaled); //create new ImageIcon from scaled image
				
				//Check out button to purchase
				checkoutButton.setIcon(checkoutImageFinal);
		        checkoutButton.setBounds(20, 15, 120, 50);
		        checkoutButton.addActionListener(this);
		        checkoutButton.setFocusable(true);
		        checkoutButton.setBorderPainted(false);
		        topBar1.add(checkoutButton);
		        
		        break; //break loop
			}
		}
	}
	
	//method to clear the cart
	private void clearCart() {
		//for loop to run through all cart slots
		for (int i = 0; i < cartContentArray.length; i++) {
			
			//turns all the cart slots to false (meaning its empty)
			//turns all phone indexes to default 0
			cartContentArray[i] = false;
			cartIndexArray[i] = 0;
			cartQuantityArray[i] = 0;
		}
	}
		
	//method to receive the "add to cart" input from inventory frame
	public static void setCartInput(int index) {
		//find the first empty slot in cartArray and assign the input
		for (int i = 0; i < cartContentArray.length; i++) {
			if (cartContentArray[i] == true) { //if it is taken
				
				//look if the index is same as the incoming one
				if (cartIndexArray[i] == index) {
					
					//if it is, increment the quantity
					cartQuantityArray[i]++;
					break; //breaks loop
				}
			}
			//other wise if its false
			else {
				cartIndexArray[i] = index; //assign the received index into the array
				cartQuantityArray[i]++; //increment the quantity
				cartContentArray[i] = true; //set the array to true so cart views it as full
				break; //exit loop once found
			}
		}
	}

	//button methods
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		if (event.getSource() == clearCartButton) {
			clearCart(); //call the clear cart method
			
			//refreshes the cart frame
			setVisible(false);
			new CartFrame();
		}
		
		else if (event.getSource() == checkoutButton) {
			clearCart(); //call the clear cart method

			//goes to the purchase frame if cart has items
			setVisible(false);
			PurchaseFrame purchaseFrame = new PurchaseFrame();
		}
		
		else if (event.getSource() == buttons[0]) {
			//goes to the main menu frame
			setVisible(false);
			MainMenuFrame menuFrame = new MainMenuFrame();
		}
		
		else if (event.getSource() == buttons[1]) {
			//goes to the education frame
			setVisible(false);
			EducationFrame educationFrame = new EducationFrame();
		}
		
		else if (event.getSource() == buttons[2]) {
			//goes to the inventory frame
			setVisible(false);
			InventoryFrame inventoryFrame = new InventoryFrame();
		}
		
		else if (event.getSource() == buttons[3]) {
			//goes to the survey frame
			setVisible(false);
			SurveyFrame surveyFrame = new SurveyFrame();
			surveyFrame.initWindow();
	        surveyFrame.setVisible(true);
		}
	
		//otherwise close screen
		else {
			setVisible(false);
		}
		
	}
	
}


/* Group 1: Aaron Chow, Tony Tan, Duo Qu, Alina Yeung
 * 05/07/24
 * ICS3U/C - 02/01 Mrs. Biswas
 * 
 * This GUI program allows the user to search through a catalogue of smartphones, and take a survey to match 
 * a user with a phone that they will most likely enjoy. 
 * The program allows them to buy, shop, add to cart, view specifications, 
 * navigate pages, filter phone categories, see ratings, view cart
 * 
 * Added Features: View Cart/Add to cart, Buy Phone, Filter phones, Navigate pages
 * Additional code features: Scaled images, scrollpane, functional cart
 * (learned via youtube, stackoverflow, reddit, github, various code forums/tutorials)
 * 
 * Areas of Concern: Implement "hand" pointer
 * 
 * Quality of Life changes to add: cursor "hand" pointer when 
 * hovering over a button, methods to improve code readability
 * 
 * Contribution, Aaron: MainMenuFrame, InventoryFrame, StarterFrame, MidRangeFrame, HighEndFrame, LuxuryFrame,
 * BestsellersFrame, AllPhonesFrame, PurchaseFrame
 * Frames for each phone, for instance GalaxyZFlip5Frame or iPhone15Frame are all created by Aaron
 * 100% of these frames are created and designed by Aaron
 * 
 * Debugged by Tony, Ivan, Aaron
 * 
 * Credit to Tony, Ivan, Mrs. Biswas for code logic help. All implemented and modified by Aaron
 * Tony: button action logic
 * Ivan: Scrollpane logic
 * Mrs. Biswas: optimization; for loops and arrays logic
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//the purpose of this class is to creaate and place widgets on the window
public class GalaxyZFlip5Frame extends JFrame implements ActionListener {
	
    //scroll pane
    JPanel specs;
    JScrollPane scroll;
	
	private static JButton[] buttonsDD; //array to store buttons at the top
	private static String[] BUTTON_TEXTS = {"education", "inventory", "survey"};
	
	JButton cartButton;
	JButton cart; //view cart button
	JButton buy; //buy now button
	JButton inventory2; //shop other deals button
	
	
	//constructor: create and place widgets, setup window 
	GalaxyZFlip5Frame() {
        specs = new JPanel();
        specs.setLayout(null);
        specs.setBackground(Color.LIGHT_GRAY);
        specs.setPreferredSize(new Dimension(1000, 1000));
        
        //create the scroll pane
        scroll = new JScrollPane(specs);
        scroll.setBounds(80, 175, 500, 300); 
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        
        //create JTextArea to hold specifications text
        JTextArea specifications = new JTextArea();
        specifications.setText("Phone Specifications\nOS: Android 13 \nCPU: Ualcomm Snapdragon 8 Gen 2\nGPU: Adreno 740"
                + "\nRAM(GB): 8 \nStorage (GB): 256 \nDisplay: 6.7\" \nResolution: 2640 x 1080"
                + "\nCamera Rear (MP): 12 \nCamera Front (MP): 10 \nBattery Capacity (mAh): 3700"
                + "\nWeight (g): 187");
        Font font = new Font("Canva Sans", Font.PLAIN, 20);
        specifications.setFont(font);
        specifications.setEditable(false); //make it non-editable
        specifications.setLineWrap(true); //enable line wrapping
        specifications.setWrapStyleWord(true); //wrap at word boundaries


        //add JTextArea to JScrollPane
        scroll.setViewportView(specifications);

		//panels
		JPanel beige = new JPanel(); //panel to make the beige stripe
		JPanel blue = new JPanel(); //panel to make the blue stripe
		JPanel white = new JPanel(); //panel to make the white page background
		
		//place panels
		beige.setBackground(new Color(0xfffee7));
		beige.setBounds(0, 0, 1200, 75);
		beige.setLayout(null);
		beige.setVisible(true);
		
		blue.setBackground(new Color(0x004AAD));
		blue.setBounds(0, 75, 1200, 50);
		blue.setLayout(null);
		blue.setVisible(true);
		
		white.setBackground(new Color(0xfffffff));
		white.setBounds(0, 125, 1200, 600);
		white.setLayout(null);
		white.setVisible(true);
		
		//main Device Depot images
		
		//Get the original image
		ImageIcon logoIcon = new ImageIcon("images/logoDD.png");
		//Get the image from the logoIcon
		Image logoImage = logoIcon.getImage();
		//Scale the image
		Image logoScaled = logoImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		//Create a new ImageIcon from the scaled image
		ImageIcon logoFinal = new ImageIcon(logoScaled);
		
		ImageIcon eStarIcon = new ImageIcon("images/emptystarDD.jpg");
		Image eStarImage = eStarIcon.getImage();
		Image eStarScaled = eStarImage.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon eStarFinal = new ImageIcon(eStarScaled);
	
		ImageIcon fStarIcon = new ImageIcon("images/filledstarDD.jpg");
		Image fStarImage = fStarIcon.getImage();
		Image fStarScaled = fStarImage.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon fStarFinal = new ImageIcon(fStarScaled);
		
		ImageIcon cartIcon = new ImageIcon("images/cartDD.png");
		Image cartImage = cartIcon.getImage();
		Image cartScaled = cartImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		ImageIcon cartFinal = new ImageIcon(cartScaled);
		
		ImageIcon GalaxyZFlip5Icon = new ImageIcon("images/Galaxy Z Flip 5.png");
		Image GalaxyZFlip5Image = GalaxyZFlip5Icon.getImage();
		Image GalaxyZFlip5Scaled = GalaxyZFlip5Image.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
		ImageIcon GalaxyZFlip5Final = new ImageIcon(GalaxyZFlip5Scaled); 
	
		//place Device Depot images
		JLabel logo = new JLabel(logoFinal);
		logo.setBounds(50, -1, 50, 50);
		blue.add(logo);

		JLabel eStar = new JLabel(eStarFinal);
		eStar.setBounds(500, 50, 50, 50); 
		white.add(eStar);
		
//		JLabel eStar2 = new JLabel(eStarFinal);
//		eStar2.setBounds(475, 50, 50, 50); 
//		white.add(eStar2);
		
		JLabel[] filledStars = new JLabel[4];

		for (int i = 0; i < 4; i++) {
		    filledStars[i] = new JLabel(fStarFinal);
		    filledStars[i].setBounds(400 + 25 * i, 50, 50, 50);
		    white.add(filledStars[i]);
		}
	
		JLabel cart = new JLabel(cartFinal);
		cart.setBounds(1100, 12, 50, 50); 
		beige.add(cart);

		JLabel GalaxyZFlip5 = new JLabel(GalaxyZFlip5Final);
		GalaxyZFlip5.setBounds(750, -50, 300, 500); 
		white.add(GalaxyZFlip5);
		
		//labels
		JLabel DD = new JLabel(); //dd company name
		JLabel brand = new JLabel(); //phone brand name
		JLabel model = new JLabel(); //phone model name
		JLabel rating = new JLabel(); //phone rating out of 10
		JLabel price = new JLabel(); //phone price
		
		//place labels
		
		//company label
		DD.setText("Device Depot Electronics");
		DD.setFont(new Font("Canva Sans", Font.BOLD, 30));
		DD.setForeground(Color.WHITE);
		DD.setBounds(125, 0, 500, 50);
		blue.add(DD);
		
		//brand name
		brand.setText("Samsung");
		brand.setFont(new Font("Canva Sans", Font.PLAIN, 20));
		brand.setForeground(Color.BLACK);
		brand.setBounds(80, 50, 500, 50);
		white.add(brand);
		
		//model name
		model.setText("Galaxy Z Flip 5");
		model.setFont(new Font("Canva Sans", Font.BOLD, 30));
		model.setForeground(Color.BLACK);
		model.setBounds(80, 80, 500, 50);
		white.add(model);
		
		//price
		price.setText("$648.99");
		price.setFont(new Font("Canva Sans", Font.PLAIN, 20));
		price.setForeground(Color.BLACK);
		price.setBounds(80, 110, 500, 50);
		white.add(price);
		
		//rating
		rating.setText("8.83/10");
		rating.setFont(new Font("Canva Sans", Font.PLAIN, 20));
		rating.setForeground(Color.BLACK);
		rating.setBounds(420, 80, 500, 50);
		white.add(rating);
		
		//create buttons
		//buy now button
		buy = new JButton();
		buy.setBounds(900, 400, 225, 50);
		buy.setText("ADD TO CART");
		buy.addActionListener(this);
		white.add(buy);
		
		//shop button
		cartButton = new JButton();
		cartButton.setBounds(1100, 12, 50, 50); 
		cartButton.setOpaque(false);
		cartButton.setContentAreaFilled(false);
		cartButton.setBorderPainted(false);
		cartButton.addActionListener(this);
		beige.add(cartButton);
		
		//shop other deals button
		inventory2 = new JButton();
		inventory2.setBounds(650, 400, 225, 50);
		inventory2.setText("BUY NOW");
		inventory2.addActionListener(this);
		white.add(inventory2);
		
		buttonsDD = new JButton[BUTTON_TEXTS.length];

		//use a for loop to efficiently place buttons
		for (int i = 0; i < BUTTON_TEXTS.length; i++) {
			buttonsDD[i] = new JButton(BUTTON_TEXTS[i]);
			buttonsDD[i].setBounds(750 + 125 * i , 12, 200, 25);
			buttonsDD[i].addActionListener(this);
			buttonsDD[i].setFocusable(false);
			buttonsDD[i].setFont(new Font("Canva Sans", Font.CENTER_BASELINE, 20));
			buttonsDD[i].setOpaque(false);
			buttonsDD[i].setContentAreaFilled(false);
			buttonsDD[i].setBorderPainted(false);
			buttonsDD[i].setForeground(Color.WHITE);
			blue.add(buttonsDD[i]);
		}
		
		//window setup
		this.setTitle("Device Depot Electronics"); //sets title of window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fully exits out of application 
		this.setResizable(false); //fixed window size
		this.setSize(1200, 650); //window size
		this.setVisible(true); //makes window visible
		this.setLayout(null);
		this.add(blue);
		this.add(beige);
		this.add(white);
		white.add(scroll);
		
	}

	//this method handles the button actions
    @Override
    public void actionPerformed(ActionEvent event) {
        //if its from the cart button
        if (event.getSource() == cartButton) {
            setVisible(false);
            //goes to cart frame
            CartFrame cartFrame = new CartFrame();
        }

        //if its from the home button
        else if (event.getSource() == buttonsDD[1]) {
            setVisible(false);
            //goes to main menu frame
            InventoryFrame inventoryFrame = new InventoryFrame();
        }

        //if its from the education button
        else if (event.getSource() == buttonsDD[0]) {
            setVisible(false);
            //goes to the education frame
            EducationFrame educationFrame = new EducationFrame();
        }

        //if its from the survey button
        else if (event.getSource() == buttonsDD[2]) {
            setVisible(false);
            //goes to the survey frame
            SurveyFrame surveyFrame = new SurveyFrame();
            surveyFrame.initWindow();
            surveyFrame.setVisible(true);
        }
        
        //buy now button
        else if (event.getSource() == inventory2) {
            setVisible(false);
            //goes to the survey frame
            PurchaseFrame purchaseFrame = new PurchaseFrame();
        }
        
        //add to cart button action
        else if (event.getSource() == buy) {
            CartFrame.setCartInput(14); //passes down the index of the phone
        }

    }
}
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


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//the purpose of this class is to create and place widgets on the window
public class PurchaseFrame extends JFrame implements ActionListener {
	
	private static JButton[] buttonsDD; //array to store buttons at the top
	private static String[] BUTTON_TEXTS = {"home", "education", "survey"};
	
	JButton buy; //buy now button
	JButton inventory2; //shop other deals button
	
	
	//constructor: create and place widgets, setup window 
	PurchaseFrame() {
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

		
		//place Device Depot images
		JLabel logo = new JLabel(logoFinal);
		logo.setBounds(50, -1, 50, 50);
		blue.add(logo);
		
		//labels
		JLabel DD = new JLabel(); //dd company name
		
		//place labels
		
		//company label
		DD.setText("Device Depot Electronics");
		DD.setFont(new Font("Canva Sans", Font.BOLD, 30));
		DD.setForeground(Color.WHITE);
		DD.setBounds(125, 0, 500, 50);
		blue.add(DD);
		
		//purchase successful 
		JLabel purchase = new JLabel();
		purchase.setText("Thank you for your purchase.");
		purchase.setFont(new Font("Canva Sans", Font.PLAIN, 30));
		purchase.setForeground(Color.BLACK);
		purchase.setBounds(400, 100, 500, 50);
		white.add(purchase);
	
		//create buttons
		//buy now button
		buy = new JButton();
		buy.setBounds(450, 250, 250, 50);
		buy.setText("SHOP OTHER DEALS");
		buy.addActionListener(this);
		white.add(buy);
		
		//top buttons
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
		
	}
	//this method handles the button actions
	@Override
	public void actionPerformed(ActionEvent event) {
        //if its from the home button
        if (event.getSource() == buttonsDD[0]) {
            setVisible(false);
            //goes to main menu frame
            MainMenuFrame mainMenuFrame = new MainMenuFrame();
        }

        //if its from the education button
        else if (event.getSource() == buttonsDD[1]) {
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
        
        //see other deals button 
        else if (event.getSource() == buy) {
        	setVisible(false);
        	InventoryFrame inventoryFrame = new InventoryFrame();
        }
    }
}

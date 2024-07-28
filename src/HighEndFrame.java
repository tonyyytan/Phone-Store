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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//the purpose of this class is to create and place widgets on the window
public class HighEndFrame extends JFrame implements ActionListener {
	//declare Scroll pane
    JPanel white;
    JScrollPane scroll;
    //declare widgets
    private JButton cartButton; //add to cart button
    private JButton goBack; //return to inventory button
    private JButton[][] learnMoreArray; //array to hold the learn more buttons
    private JButton learnMore; //5th learn more button
    
    //create array for top buttons at the top (blue stripe)
    private JButton[] buttonsDD;
    private static final String[] BUTTON_TEXTS = {"home", "education", "survey"};
    
    //constructor
    public HighEndFrame() {
        //initialize the white panel
        white = new JPanel();
        white.setLayout(null);
        white.setBackground(Color.white);
        white.setPreferredSize(new Dimension(1000, 1500));

        //add components to the white panel
        JLabel intro = new JLabel("Shop High End:");
        intro.setBounds(50, 20, 500, 30);
        intro.setFont(new Font("Canva Sans", Font.BOLD, 25));
        white.add(intro);

        JLabel intro2 = new JLabel("High Quality. High Performance.");
        intro2.setBounds(50, 50, 500, 30);
        intro2.setFont(new Font("Canva Sans", Font.PLAIN, 25));
        white.add(intro2);

        //create the scroll pane
        scroll = new JScrollPane(white);
        scroll.setBounds(0, 125, 1185, 525);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        
        //2d array to store images
        JLabel[][] imageArray = new JLabel[5][4];

        //array to store image path directories
        String[] imagePaths = {
            "images/Pixel 8 Pro.png", "images/iPhone 13.png", "images/Galaxy S23 FE.png", "images/Pixel 8.png",
            "images/Galaxy Z Flip 5.png", "images/blank.jpg", "images/blank.jpg", "images/blank.jpg",
            "images/blank.jpg", "images/blank.jpg", "images/blank.jpg", "images/blank.jpg",
            "images/blank.jpg", "images/blank.jpg", "images/blank.jpg", "images/blank.jpg",
            "images/blank.jpg", "images/blank.jpg", "images/blank.jpg", "images/blank.jpg"
        };

        //fill imageArray with JLabels that hold the images 
        for (int r = 0; r < imageArray.length; r++) {
            for (int c = 0; c < imageArray[r].length; c++) {
                int index = r * imageArray[r].length + c;
                //check if the index is within the bounds of imagePaths array (avoid outofboundsexception error)
                if (index < imagePaths.length) {
                    //get the ImageIcon from the file path
                    ImageIcon originalIcon = new ImageIcon(imagePaths[index]);
                    //get the image from the ImageIcon
                    Image originalImage = originalIcon.getImage();
                    //scale the image
                    Image scaledImage = originalImage.getScaledInstance(300, 500, Image.SCALE_SMOOTH);
                    //create a new ImageIcon from the scaled image
                    ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    //create a JLabel with the scaled ImageIcon
                    imageArray[r][c] = new JLabel(scaledIcon);
                    imageArray[r][c].setBounds(10 + (280 * c), 200 + (650 * r), 300, 500);
                    white.add(imageArray[r][c]);
                }
            }
        }

        //2D array to store names
        JLabel[][] namesArray = new JLabel[5][4];
        String[][] phoneArrayIndex = {
            {"Pixel 8 Pro", "iPhone 13", "Galaxy S23 FE", "Pixel 8"},
            {"Galaxy Z Flip 5", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""}
        };

        //fill namesArray with JLabels that hold the model names
        for (int r = 0; r < namesArray.length; r++) {
            for (int c = 0; c < namesArray[r].length; c++) {
            	//check if the index is within the bounds of phoneArrayIndex array (avoid outofboundsexception error)
                if (c < phoneArrayIndex[r].length) {
                	//create JLabels with the phone name
                    namesArray[r][c] = new JLabel(phoneArrayIndex[r][c]);
                    namesArray[r][c].setBounds(100 + (290 * c), 150 + (650 * r), 271, 20);
                    white.add(namesArray[r][c]);
                }
            }
        }
        
        //2D array to store prices
        JLabel[][] priceArray = new JLabel[5][4];
        String[][] priceArrayIndex = {
            {"$599.99", "$579.99", "$529.99", "$349.99"},
            {"$379.99", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""}
        };

        //fill priceArray with JLabels that hold the model prices
        for (int r = 0; r < priceArray.length; r++) {
            for (int c = 0; c < priceArray[r].length; c++) {
                //check if the index is within the bounds of priceArrayIndex array (avoid outofboundsexception error)
                if (c < priceArrayIndex[r].length) {
                	//create JLabels with the prices
                	priceArray[r][c] = new JLabel(priceArrayIndex[r][c]);
                	priceArray[r][c].setBounds(100 + (290 * c), 165 + (650 * r), 271, 20);
                    white.add(priceArray[r][c]);
                }
            }
        }
        
        //2D array to store buttons
        learnMoreArray = new JButton[1][4];
        String[] learnMoreIndex = {"Learn More", "Learn More", "Learn More", "Learn More"};

        //fill learnMoreArray with JLabels (spammed learnMore to later reference the buttons)
        for (int c = 0; c < learnMoreArray[0].length; c++) {
            //create JButtons
            learnMoreArray[0][c] = new JButton(learnMoreIndex[c]);
            learnMoreArray[0][c].setBounds(25 + (290 * c), 700, 271, 20);
            learnMoreArray[0][c].addActionListener(this);
            learnMoreArray[0][c].setFocusable(false);
            white.add(learnMoreArray[0][c]);
        }
        
        //create 5th JButton
        learnMore = new JButton();
        learnMore.setText("Learn More");
        learnMore.setBounds(25, 1350, 271, 20);
        learnMore.addActionListener(this);
        learnMore.setFocusable(false);
        white.add(learnMore);
        
        //panels
        JPanel beige = new JPanel(); //panel to make the beige stripe
        JPanel blue = new JPanel(); //panel to make the blue stripe

        //place panels
        beige.setBackground(new Color(0xfffee7));
        beige.setBounds(0, 0, 1200, 75);
        beige.setLayout(null);
        beige.setVisible(true);

        blue.setBackground(new Color(0x004AAD));
        blue.setBounds(0, 75, 1200, 50);
        blue.setLayout(null);
        blue.setVisible(true);

        //main DeviceDepot images
        //get the original image: logo
        ImageIcon logoIcon = new ImageIcon("images/logoDD.png");
        //get the image from the logoIcon
        Image logoImage = logoIcon.getImage();
        //scale the image
        Image logoScaled = logoImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        //create a new ImageIcon from the scaled image
        ImageIcon logoFinal = new ImageIcon(logoScaled);

        //cart
        ImageIcon cartIcon = new ImageIcon("images/cartDD.png");
        Image cartImage = cartIcon.getImage();
        Image cartScaled = cartImage.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        ImageIcon cartFinal = new ImageIcon(cartScaled);

        //display images
        JLabel logo = new JLabel(logoFinal);
        logo.setBounds(50, -1, 50, 50);
        blue.add(logo);

        JLabel cartLabel = new JLabel(cartFinal);
        cartLabel.setBounds(1100, 12, 50, 50);
        beige.add(cartLabel);

        //company label
        JLabel DD = new JLabel(); //dd company name
        DD.setText("Device Depot Electronics");
        DD.setFont(new Font("Canva Sans", Font.BOLD, 30));
        DD.setForeground(Color.WHITE);
        DD.setBounds(125, 0, 500, 50);
        blue.add(DD);

        //create buttons
        buttonsDD = new JButton[BUTTON_TEXTS.length];

        //use a for loop to efficiently place buttons
        for (int i = 0; i < BUTTON_TEXTS.length; i++) {
            buttonsDD[i] = new JButton(BUTTON_TEXTS[i]);
            buttonsDD[i].setBounds(750 + 125 * i, 12, 200, 25);
            buttonsDD[i].addActionListener(this);
            buttonsDD[i].setFocusable(false);
            buttonsDD[i].setFont(new Font("Canva Sans", Font.CENTER_BASELINE, 20));
            buttonsDD[i].setOpaque(false);
            buttonsDD[i].setContentAreaFilled(false);
            buttonsDD[i].setBorderPainted(false);
            buttonsDD[i].setForeground(Color.WHITE);
            blue.add(buttonsDD[i]);
        }
        
        //return to inventory button
        goBack = new JButton("Return to Inventory");
        goBack.setBounds(750, 20, 500, 30);
        goBack.setFont(new Font("Canva Sans", Font.BOLD, 25));
        goBack.setOpaque(false);
        goBack.setContentAreaFilled(false);
        goBack.setBorderPainted(false);
        goBack.addActionListener(this);
        white.add(goBack);
        
        //view cart button
        cartButton = new JButton();
        cartButton.setBounds(1100, 12, 50, 50);
        cartButton.setOpaque(false);
        cartButton.setContentAreaFilled(false);
        cartButton.setBorderPainted(false);
        cartButton.addActionListener(this);
        beige.add(cartButton);
        
        //setup window
        this.setTitle("Device Depot Electronics"); //sets title of window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fully exits out of application
        this.setResizable(false); //fixed window size
        this.setSize(1200, 650); //window size
        this.setVisible(true); //makes window visible
        this.setLayout(null);
        this.add(blue);
        this.add(beige);
        this.add(scroll);
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
        else if (event.getSource() == buttonsDD[0]) {
            setVisible(false);
            //goes to main menu frame
            MainMenuFrame menuFrame = new MainMenuFrame();
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
        
        //if its from the inventory button
        else if (event.getSource() == goBack) {
            setVisible(false);
            //goes to the inventory frame
            InventoryFrame inventoryFrame = new InventoryFrame();
        }

        //learn more button actions
        else if (event.getSource() == learnMore) {
        	setVisible(false);
        	GalaxyZFlip5Frame galaxyZFlip5 = new GalaxyZFlip5Frame();
        }
        
        for (int r = 0; r < learnMoreArray.length; r++) {
            for (int c = 0; c < learnMoreArray[r].length; c++) {
                if (event.getSource() == learnMoreArray[r][c]) {
                    if (r == 0 && c == 0) {
                        new Pixel8ProFrame();
                        dispose();
                    } else if (r == 0 && c == 1) {
                        new iPhone13Frame();
                        dispose();
                    } else if (r == 0 && c == 2) {
                        new GalaxyS23FEFrame();
                        dispose();
                    } else if (r == 0 && c == 3) {
                        new Pixel8Frame();
                        dispose();
                    } 
                }
            }
        }
    }
}

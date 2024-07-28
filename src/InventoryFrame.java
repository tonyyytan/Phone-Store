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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InventoryFrame extends JFrame implements ActionListener {
    //scroll pane
    JPanel white;
    JScrollPane scroll;
    //declare widgets
    private static JButton[] buttonsDD; // array to store buttons at the top
    private static String[] BUTTON_TEXTS = { "home", "education", "survey" };
    
    private static JButton[] categoryDD; // array to store buttons on the white page
    private static String[] CATEGORY_TEXT = { "Starter", "Mid Range", "High End", "Luxury",
    									       "Bestsellers", "Shop All" };
	JButton cartButton; //add to cart button
	JButton cart; //view cart button
	JButton buy; //buy now button
	JButton inventory2; //shop other deals button
	JButton survey2;

	//buy/cart buttons
    JButton buyOnePlus12;
    JButton cartOnePlus12; 
    JButton buyGalaxyZFlip5; 
    JButton cartGalaxyZFlip5; 
    JButton buyiPhoneSE;
    JButton cartiPhoneSE; 
    JButton buyButton1;
    JButton cartButton1; 
    JButton buyGalaxyZFold5; 
    JButton cartGalaxyZFold5; 
    JButton buyGalaxyS23FE; 
    JButton cartGalaxyS23FE;
	
    //constructor
    InventoryFrame() {
        //create the white panel
        white = new JPanel();
        white.setLayout(null);
        white.setBackground(Color.white);
        white.setPreferredSize(new Dimension(1000, 1900));
        
        //add components to the white panel
        JLabel intro = new JLabel("Shop for all of your");
        intro.setBounds(50, 20, 500, 30);
        intro.setFont(new Font("Canva Sans", Font.PLAIN, 25));
        white.add(intro);
        
        JLabel intro2 = new JLabel("favourite smartphones.");
        intro2.setBounds(50, 50, 500, 30);
        intro2.setFont(new Font("Canva Sans", Font.BOLD, 25));
        white.add(intro2);
        
        JLabel overwhelmed = new JLabel("Overwhelmed?");
        overwhelmed.setBounds(950, 20, 500, 30);
        overwhelmed.setFont(new Font("Canva Sans", Font.PLAIN, 25));
        white.add(overwhelmed);

        //create the scroll pane
        scroll = new JScrollPane(white);
        scroll.setBounds(0, 125, 1185, 525); // Adjusted size to fit within frame
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setUnitIncrement(15);

        //panels
        JPanel beige = new JPanel(); // panel to make the beige stripe
        JPanel blue = new JPanel(); // panel to make the blue stripe

        //place panels
        beige.setBackground(new Color(0xfffee7));
        beige.setBounds(0, 0, 1200, 75);
        beige.setLayout(null);
        beige.setVisible(true);

        blue.setBackground(new Color(0x004AAD));
        blue.setBounds(0, 75, 1200, 50);
        blue.setLayout(null);
        blue.setVisible(true);

        //main Device Depot images
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

		//featured phone image
		ImageIcon OnePlus12Icon = new ImageIcon("images/OnePlus 12.png");
		Image OnePlus12Image = OnePlus12Icon.getImage();
		Image OnePlus12Scaled = OnePlus12Image.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
		ImageIcon OnePlus12Final = new ImageIcon(OnePlus12Scaled); 
		
		//featured phone image 2
		ImageIcon GalaxyZFlip5Icon = new ImageIcon("images/Galaxy Z Flip 5.png");
		Image GalaxyZFlip5Image = GalaxyZFlip5Icon.getImage();
		Image GalaxyZFlip5Scaled = GalaxyZFlip5Image.getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH);
		ImageIcon GalaxyZFlip5Final = new ImageIcon(GalaxyZFlip5Scaled); 
		
		//featured phone image 3
		ImageIcon iPhoneSEIcon = new ImageIcon("images/iPhone SE.png");
		Image iPhoneSEImage = iPhoneSEIcon.getImage();
		Image iPhoneSEScaled = iPhoneSEImage.getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH);
		ImageIcon iPhoneSEFinal = new ImageIcon(iPhoneSEScaled); 
		
		//bestseller phone image
		//oneplus 12
		
		//bestseller phone image 2
		ImageIcon GalaxyZFold5Icon = new ImageIcon("images/Galaxy Z Fold 5.png");
		Image GalaxyZFold5Image = GalaxyZFold5Icon.getImage();
		Image GalaxyZFold5Scaled = GalaxyZFold5Image.getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH);
		ImageIcon GalaxyZFold5Final = new ImageIcon(GalaxyZFold5Scaled); 
		
		//bestseller phone image 3
		ImageIcon GalaxyS23FEIcon = new ImageIcon("images/Galaxy S23 FE.png");
		Image GalaxyS23FEImage = GalaxyS23FEIcon.getImage();
		Image GalaxyS23FEScaled = GalaxyS23FEImage.getScaledInstance(300, 400, java.awt.Image.SCALE_SMOOTH);
		ImageIcon GalaxyS23FEFinal = new ImageIcon(GalaxyS23FEScaled); 
		
        // JLabel
        // Display images
        JLabel logo = new JLabel(logoFinal);
        logo.setBounds(50, -1, 50, 50);
        blue.add(logo);
        
        JLabel cart = new JLabel(cartFinal);
		cart.setBounds(1100, 12, 50, 50); 
		beige.add(cart);
		
		//place labels
		//company label
		JLabel DD = new JLabel(); //dd company name
		DD.setText("Device Depot Electronics");
		DD.setFont(new Font("Canva Sans", Font.BOLD, 30));
		DD.setForeground(Color.WHITE);
		DD.setBounds(125, 0, 500, 50);
		blue.add(DD);
		
		//shop categories label
		JLabel catalogue = new JLabel(); //shop categories label
		catalogue.setText("Browse through our phone catalogues.");
		catalogue.setFont(new Font("Canva Sans", Font.PLAIN, 20));
		catalogue.setForeground(Color.BLACK);
		catalogue.setBounds(425, 125, 500, 50);
		white.add(catalogue);
		
		//thelatest label
		JLabel thelatest = new JLabel(); //shop the latest phones categories
		thelatest.setText("The Latest:");
		thelatest.setFont(new Font("Canva Sans", Font.BOLD, 30));
		thelatest.setForeground(Color.BLACK);
		thelatest.setBounds(50, 400, 500, 50);
		white.add(thelatest);
		
		//thelatest label
		JLabel thelatest2 = new JLabel(); //shop the latest phones categories
		thelatest2.setText("Check out the next trendsetters.");
		thelatest2.setFont(new Font("Canva Sans", Font.PLAIN, 20));
		thelatest2.setForeground(Color.BLACK);
		thelatest2.setBounds(50, 430, 500, 50);
		white.add(thelatest2);
		
		//thelatest featured phone
		JLabel OnePlus12 = new JLabel(OnePlus12Final);
		OnePlus12.setBounds(50, 565, 300, 400); 
		white.add(OnePlus12);
		
		//text
		JLabel textOnePlus12 = new JLabel();
		textOnePlus12.setText("OnePlus 12");
		textOnePlus12.setFont(new Font("Canva Sans", Font.BOLD, 20));
		textOnePlus12.setForeground(Color.BLACK);
		textOnePlus12.setBounds(150, 450, 300, 100); 
		white.add(textOnePlus12);
		
		//price
		JLabel priceOnePlus12 = new JLabel();
		priceOnePlus12.setText("$1199.99");
		priceOnePlus12.setFont(new Font("Canva Sans", Font.PLAIN, 15));
		priceOnePlus12.setForeground(Color.BLACK);
		priceOnePlus12.setBounds(170, 515, 300, 30); 
		white.add(priceOnePlus12);
		
		//thelatest featured phone 2
		JLabel GalaxyZFlip5 = new JLabel(GalaxyZFlip5Final);
		GalaxyZFlip5.setBounds(450, 565, 300, 400); 
		white.add(GalaxyZFlip5);
		
		//text
		JLabel textGalaxyZFlip5 = new JLabel();
		textGalaxyZFlip5.setText("Samsung Galaxy Z Flip 5");
		textGalaxyZFlip5.setFont(new Font("Canva Sans", Font.BOLD, 20));
		textGalaxyZFlip5.setForeground(Color.BLACK);
		textGalaxyZFlip5.setBounds(500, 450, 300, 100); 
		white.add(textGalaxyZFlip5);
		
		//price
		JLabel priceGalaxyZFlip5 = new JLabel();
		priceGalaxyZFlip5.setText("$648.99");
		priceGalaxyZFlip5.setFont(new Font("Canva Sans", Font.PLAIN, 15));
		priceGalaxyZFlip5.setForeground(Color.BLACK);
		priceGalaxyZFlip5.setBounds(595, 515, 300, 30); 
		white.add(priceGalaxyZFlip5);
		
		//thelatest featured phone 3
		JLabel iPhoneSE = new JLabel(iPhoneSEFinal);
		iPhoneSE.setBounds(850, 565, 300, 400); 
		white.add(iPhoneSE);
		
		//text
		JLabel textiPhoneSE = new JLabel();
		textiPhoneSE.setText("Apple iPhone SE");
		textiPhoneSE.setFont(new Font("Canva Sans", Font.BOLD, 20));
		textiPhoneSE.setForeground(Color.BLACK);
		textiPhoneSE.setBounds(915, 450, 300, 100); 
		white.add(textiPhoneSE);
		
		//price
		JLabel priceiPhoneSE = new JLabel();
		priceiPhoneSE.setText("$579.99");
		priceiPhoneSE.setFont(new Font("Canva Sans", Font.PLAIN, 15));
		priceiPhoneSE.setForeground(Color.BLACK);
		priceiPhoneSE.setBounds(970, 515, 300, 30); 
		white.add(priceiPhoneSE);
		
		//shop the best selling phones categories
		JLabel bestsellers = new JLabel(); 
		bestsellers.setText("Bestsellers:");
		bestsellers.setFont(new Font("Canva Sans", Font.BOLD, 30));
		bestsellers.setForeground(Color.BLACK);
		bestsellers.setBounds(50, 1100, 500, 50);
		white.add(bestsellers);
		
		//shop the best selling phones categories
		JLabel bestsellers2 = new JLabel(); 
		bestsellers2.setText("What's hot, right now.");
		bestsellers2.setFont(new Font("Canva Sans", Font.PLAIN, 20));
		bestsellers2.setForeground(Color.BLACK);
		bestsellers2.setBounds(50, 1130, 500, 50);
		white.add(bestsellers2);
		
		//bestseller featured phone 1
		JLabel bsOnePlus12 = new JLabel(OnePlus12Final);
		bsOnePlus12.setBounds(50, 1265, 300, 400); 
		white.add(bsOnePlus12);
		
		//text
		JLabel bstextOnePlus12 = new JLabel();
		bstextOnePlus12.setText("OnePlus 12");
		bstextOnePlus12.setFont(new Font("Canva Sans", Font.BOLD, 20));
		bstextOnePlus12.setForeground(Color.BLACK);
		bstextOnePlus12.setBounds(150, 1150, 300, 100); 
		white.add(bstextOnePlus12);
		
		//price
		JLabel bspriceOnePlus12 = new JLabel();
		bspriceOnePlus12.setText("$1199.99");
		bspriceOnePlus12.setFont(new Font("Canva Sans", Font.PLAIN, 15));
		bspriceOnePlus12.setForeground(Color.BLACK);
		bspriceOnePlus12.setBounds(170, 1215, 300, 30); 
		white.add(bspriceOnePlus12);
		
		//thelatest featured phone 2
		JLabel GalaxyZFold5 = new JLabel(GalaxyZFold5Final);
		GalaxyZFold5.setBounds(450, 1265, 300, 400); 
		white.add(GalaxyZFold5);
		
		//text
		JLabel textGalaxyZFold5 = new JLabel();
		textGalaxyZFold5.setText("Samsung Galaxy Z Fold 5");
		textGalaxyZFold5.setFont(new Font("Canva Sans", Font.BOLD, 20));
		textGalaxyZFold5.setForeground(Color.BLACK);
		textGalaxyZFold5.setBounds(500, 1150, 300, 100); 
		white.add(textGalaxyZFold5);
		
		//price
		JLabel priceGalaxyZFold5 = new JLabel();
		priceGalaxyZFold5.setText("$2399.99");
		priceGalaxyZFold5.setFont(new Font("Canva Sans", Font.PLAIN, 15));
		priceGalaxyZFold5.setForeground(Color.BLACK);
		priceGalaxyZFold5.setBounds(590, 1215, 300, 30); 
		white.add(priceGalaxyZFold5);
		
		//thelatest featured phone 3
		JLabel GalaxyS23FE = new JLabel(GalaxyS23FEFinal);
		GalaxyS23FE.setBounds(850, 1265, 300, 400); 
		white.add(GalaxyS23FE);
		
		//text
		JLabel textGalaxyS23FE = new JLabel();
		textGalaxyS23FE.setText("Samsung Galaxy S23 FE");
		textGalaxyS23FE.setFont(new Font("Canva Sans", Font.BOLD, 20));
		textGalaxyS23FE.setForeground(Color.BLACK);
		textGalaxyS23FE.setBounds(880, 1150, 300, 100); 
		white.add(textGalaxyS23FE);
		
		//price
		JLabel priceGalaxyS23FE = new JLabel();
		priceGalaxyS23FE.setText("$869.99");
		priceGalaxyS23FE.setFont(new Font("Canva Sans", Font.PLAIN, 15));
		priceGalaxyS23FE.setForeground(Color.BLACK);
		priceGalaxyS23FE.setBounds(970, 1215, 300, 30); 
		white.add(priceGalaxyS23FE);	
		
		//place buttons
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
		
		//shop button
		cartButton = new JButton();
		cartButton.setBounds(1100, 12, 50, 50); 
		cartButton.setOpaque(false);
		cartButton.setContentAreaFilled(false);
		cartButton.setBorderPainted(false);
		cartButton.addActionListener(this);
		beige.add(cartButton);
		
		//survey button
		survey2 = new JButton();
		survey2.setText("Take our survey here!");
		survey2.setBounds(765, 50, 500, 30);
		survey2.setFont(new Font("Canva Sans", Font.BOLD, 20));
		survey2.setOpaque(false);
		survey2.setContentAreaFilled(false);
		survey2.setBorderPainted(false);
		survey2.addActionListener(this);
		white.add(survey2);		
		
		//place shop other categories button
		categoryDD = new JButton[CATEGORY_TEXT.length];

		//use a for loop to efficiently place buttons
		for (int i = 0; i < CATEGORY_TEXT.length; i++) {
			categoryDD [i] = new JButton(CATEGORY_TEXT[i]);
			categoryDD [i].setBounds(150 + 150 * i, 200, 125, 125);
			categoryDD [i].addActionListener(this);
			categoryDD [i].setFocusable(false);
			categoryDD [i].setFont(new Font("Canva Sans", Font.CENTER_BASELINE, 16));
			categoryDD [i].setOpaque(true);
			categoryDD [i].setContentAreaFilled(true);
			categoryDD [i].setBorderPainted(true);
			categoryDD [i].setForeground(Color.BLACK);
			white.add(categoryDD [i]);
		}
		
		//create buttons to buy and add to cart for each phone

		//OnePlus12
		buyOnePlus12 = new JButton("Buy Now");
		buyOnePlus12.setBounds(90, 1000, 100, 30);
		buyOnePlus12.addActionListener(this);
		white.add(buyOnePlus12);

		cartOnePlus12 = new JButton("Learn More");
		cartOnePlus12.setBounds(200, 1000, 100, 30);
		cartOnePlus12.addActionListener(this);
		white.add(cartOnePlus12);

		//GalaxyZFlip5
		buyGalaxyZFlip5 = new JButton("Buy Now");
		buyGalaxyZFlip5.setBounds(490, 1000, 100, 30);
		buyGalaxyZFlip5.addActionListener(this);
		white.add(buyGalaxyZFlip5);

		cartGalaxyZFlip5 = new JButton("Learn More");
		cartGalaxyZFlip5.setBounds(600, 1000, 100, 30);
		cartGalaxyZFlip5.addActionListener(this);
		white.add(cartGalaxyZFlip5);

		//iPhoneSE
		buyiPhoneSE = new JButton("Buy Now");
		buyiPhoneSE.setBounds(890, 1000, 100, 30);
		buyiPhoneSE.addActionListener(this);
		white.add(buyiPhoneSE);

		cartiPhoneSE = new JButton("Learn More");
		cartiPhoneSE.setBounds(1000, 1000, 100, 30);
		cartiPhoneSE.addActionListener(this);
		white.add(cartiPhoneSE);
		
		//OnePlus12
		buyButton1 = new JButton("Buy Now");
		buyButton1.setBounds(90, 1700, 100, 30);
		buyButton1.addActionListener(this);
		white.add(buyButton1);

		cartButton1 = new JButton("Learn More");
		cartButton1.setBounds(200, 1700, 100, 30);
		cartButton1.addActionListener(this);
		white.add(cartButton1);

		//GalaxyZFold5
		buyGalaxyZFold5 = new JButton("Buy Now");
		buyGalaxyZFold5.setBounds(490, 1700, 100, 30);
		buyGalaxyZFold5.addActionListener(this);
		white.add(buyGalaxyZFold5);

		cartGalaxyZFold5 = new JButton("Learn More");
		cartGalaxyZFold5.setBounds(600, 1700, 100, 30);
		cartGalaxyZFold5.addActionListener(this);
		white.add(cartGalaxyZFold5);

		//GalaxyS23FE
		buyGalaxyS23FE = new JButton("Buy Now");
		buyGalaxyS23FE.setBounds(890, 1700, 100, 30);
		buyGalaxyS23FE.addActionListener(this);
		white.add(buyGalaxyS23FE);

		cartGalaxyS23FE = new JButton("Learn More");
		cartGalaxyS23FE.setBounds(1000, 1700, 100, 30);
		cartGalaxyS23FE.addActionListener(this);
		white.add(cartGalaxyS23FE);

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
        
        //overwhelmed button
        else if (event.getSource() == survey2) {
        	setVisible(false);
        	//goes to survey frame
        	SurveyFrame surveyFrame = new SurveyFrame();
        	surveyFrame.initWindow();
        	surveyFrame.setVisible(true);
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
            //goes to education frame
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
        
        //oneplus12 buy/cart 
        else if (event.getSource() == buyOnePlus12) {
            setVisible(false);
            //goes to the survey frame
            OnePlus12Frame buyOnePlus12 = new OnePlus12Frame();
        }
        else if (event.getSource() == cartOnePlus12) {
            setVisible(false);
            //goes to the survey frame
            OnePlus12Frame cartOnePlus12 = new OnePlus12Frame();
        }
        
        //galaxyzflip5 buy/cart
        else if (event.getSource() == buyGalaxyZFlip5) {
            setVisible(false);
            //goes to the survey frame
            GalaxyZFlip5Frame buyGalaxyZFlip5 = new GalaxyZFlip5Frame();
        }
        else if (event.getSource() == cartGalaxyZFlip5) {
            setVisible(false);
            //goes to the survey frame
            GalaxyZFlip5Frame cartGalaxyZFlip5 = new GalaxyZFlip5Frame();
        }
        
        //iphonese buy/cart
        else if (event.getSource() == buyiPhoneSE) {
            setVisible(false);
            //goes to the survey frame
            iPhoneSEFrame buyiPhoneSE = new iPhoneSEFrame();
        }
        else if (event.getSource() == cartiPhoneSE) {
            setVisible(false);
            //goes to the survey frame
            iPhoneSEFrame cartiPhoneSE = new iPhoneSEFrame();
        }
        
        //oneplus12 buy/cart
        else if (event.getSource() == buyButton1) {
            setVisible(false);
            //goes to the survey frame
            OnePlus12Frame buyOnePlus12 = new OnePlus12Frame();
        }
        else if (event.getSource() == cartButton1) {
            setVisible(false);
            //goes to the survey frame
            OnePlus12Frame cartOnePlus12 = new OnePlus12Frame();
        }

        //galaxyzfold5 buy/cart
        else if (event.getSource() == buyGalaxyZFold5) {
            setVisible(false);
            //goes to the survey frame
            GalaxyZFold5Frame buyGalaxyZFold5 = new GalaxyZFold5Frame();
        }
        else if (event.getSource() == cartGalaxyZFold5) {
            setVisible(false);
            //goes to the survey frame
            GalaxyZFold5Frame cartGalaxyZFold5 = new GalaxyZFold5Frame();
        }
        
        //galaxys23fe buy/cart
        else if (event.getSource() == buyGalaxyS23FE) {
            setVisible(false);
            //goes to the survey frame
            GalaxyS23FEFrame buyGalaxyS23FE = new GalaxyS23FEFrame();
        }
        else if (event.getSource() == cartGalaxyS23FE) {
            setVisible(false);
            //goes to the survey frame
            GalaxyS23FEFrame cartGalaxyS23FE = new GalaxyS23FEFrame();
        }
        
        //button action for the categories
        for (int i = 0; i < categoryDD.length; i++) {
            if (event.getSource() == categoryDD[i]) {
                //check which button was clicked
                switch (i) {
                    case 0: //starter
                    	setVisible(false);
                        new StarterFrame();
                        break;
                    case 1: //midrange
                    	setVisible(false);
                        new MidRangeFrame();
                        break;
                    case 2: //highend
                    	setVisible(false);
                        new HighEndFrame();
                        break;
                    case 3: //luxury
                    	setVisible(false);
                        new LuxuryFrame();
                        break;
                    case 4: //bestsellers
                    	setVisible(false);
                        new BestsellersFrame();
                        break;
                    case 5: //shopall
                    	setVisible(false);
                        new AllPhonesFrame();
                        break;
                    default:
                        break;
                }
                //exit the loop once the button is found
                break;
            }
        }
    }
}

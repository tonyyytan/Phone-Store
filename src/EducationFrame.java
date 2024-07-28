/*
 * Title: Education Frame
 * Group 1: Alina Yeung, Tongy Tan, Aaron Chow, Dup Qu
 * Date: May 14, 2024
 * Course: ICS3U1/05 Mrs. Biswas
 * Major Skills: JPanel, JButtons, JTextField etc. 
 * Description: The purpoe of this code is to display and tell
 * the user about the techincal parts of the phone
 * Credit: Vivian Phan (4%) 
 */

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EducationFrame extends JFrame implements ActionListener {

    // Create buttons
    private JButton GPUButton, CPUButton, RAMButton, MemoryButton, StorageButton, DisplayButton, PriceButton, CartButton, BackButton, EducationButton, InventoryButton, SurveyButton, HomeButton, SearchButton;
    private JTextField searchField;

    public EducationFrame() {
        // Set frame properties
    	this.setTitle("Education Frame"); // add title
        this. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 625); //set bounds
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout()); //set layout

        // Initialize components
        initComponents();

        // Set visible to true
        setVisible(true);
    }
    //constructor for education GUI Frame
    public void initComponents() {
        // Top panel with logo and company name
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0x0056B3));
        
        //create JLabels for the logo and the companyName
        JLabel logoLabel = new JLabel(loadImageIcon("Images/logoDD.jpg", 50, 50));
        JLabel companyName = new JLabel("Device Depot Electronics", SwingConstants.CENTER);
        companyName.setForeground(Color.WHITE); //change color to white 
        companyName.setFont(new Font("Canva Sans", Font.BOLD, 24)); // change font, and bold the text
        
        JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(new Color(0x0056B3)); //change color 
        logoPanel.add(logoLabel, BorderLayout.WEST); //change to west
        logoPanel.add(companyName, BorderLayout.CENTER);

        topPanel.add(logoPanel, BorderLayout.WEST);

        // Navigation bar
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        navBar.setBackground(new Color(0x0056B3)); //change color 
        
        //display buttons 
        HomeButton = createNavButton("Home");
        EducationButton = createNavButton("Education");
        InventoryButton = createNavButton("Inventory");
        SurveyButton = createNavButton("Survey");
        BackButton = createNavButton("Back");
        CartButton = new JButton(loadImageIcon("Images/cartDD.jpg", 30, 30));
        CartButton.addActionListener(this); //add action listeer 
        
        //add buttons to navBar
        navBar.add(HomeButton);
        navBar.add(EducationButton);
        navBar.add(InventoryButton);
        navBar.add(SurveyButton);
        navBar.add(BackButton);
        navBar.add(CartButton);
        
        //make topPanel to center
        topPanel.add(navBar, BorderLayout.CENTER);
        
        //add topPanel
        add(topPanel, BorderLayout.NORTH);

        // Search bar
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBackground(Color.WHITE);
        
        searchField = new JTextField(20);
        SearchButton = new JButton("Search");
        SearchButton.addActionListener(this);
        
        //create a searchPanel
        searchPanel.add(searchField);
        searchPanel.add(SearchButton);
        
        //add the searchPanel and use the border layout to the
        //center
        add(searchPanel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 20, 20)); //use grid layout
        buttonPanel.setBackground(Color.WHITE); //change background to white
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //create empty border
        
        //Import the GPU, CPU, etc buttons
        GPUButton = createIconButton("GPU","Images/GPUText.png");
        GPUButton.setForeground(Color.WHITE);//since text appears twice (in image)//change text to white
        
        CPUButton = createIconButton("CPU", "Images/CPUText.png");
        CPUButton.setForeground(Color.WHITE);
       
        RAMButton = createIconButton("RAM", "Images/RAMText.png");
        RAMButton.setForeground(Color.WHITE);
        
        MemoryButton = createIconButton("Memory", "Images/MemoryText.png");
        MemoryButton.setForeground(Color.WHITE);
        
        StorageButton = createIconButton("Storage", "Images/StorageText.png");
        StorageButton.setForeground(Color.WHITE);
        
        DisplayButton = createIconButton("Display Range", "Images/DisplayText.png");
        DisplayButton.setForeground(Color.WHITE);
        DisplayButton.setBounds (180, 150, 140, 75);
       
        PriceButton = createIconButton("Price Range", "Images/PriceText.png");
        PriceButton.setForeground(Color.WHITE);
        
        //add the buttons to the panel
        buttonPanel.add(GPUButton);
        buttonPanel.add(CPUButton);
        buttonPanel.add(MemoryButton);
        buttonPanel.add(RAMButton);
        buttonPanel.add(PriceButton);
        buttonPanel.add(DisplayButton);
        buttonPanel.add(StorageButton);
        
        //add the button panel
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    public JButton createNavButton(String text) {
        JButton button = new JButton(text);//add text
        button.setForeground(Color.WHITE); //chage text color to white
        button.setBackground(new Color(0x0056B3)); //change background color to blue
        button.setBorderPainted(false);
        button.setFocusPainted(false); 
        button.addActionListener(this); //add action listener
        return button; //return to button
    }

    public JButton createIconButton(String text, String imagePath) {
        ImageIcon icon = loadImageIcon(imagePath, 200, 200); //change height and width
        JButton button = new JButton(text, icon);//create JButton 
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.addActionListener(this);
        return button;
    }
    //create image constructor 
    private ImageIcon loadImageIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage(); //get image 
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH); //helps change size of image
        return new ImageIcon(resizedImg); //resize image
    }

    //add action performed constctor
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions
        Object source = e.getSource();
        if (source == GPUButton) {
        	//credit Vivian Phan
        	//display the information when the gpu button is clicked
            JOptionPane.showMessageDialog(this, "GPU: The GPU is a graphics processing unit. It's a specialized circuit"
            		+ " designed to accelerate the image output in a frame buffer "
            		+ "intended for  or an output to a display. "
            		+ "\nThey were originally designed to display 3D graphics as well"
            		+ " as calulates the graphics at a high speed. To tell if the phone GPU is good, it should be able to "
            		+ "\nproduce 60 fps (frames per second). "); //display message 
        } else if (source == CPUButton) {
        	//credit Vivian Phan
            JOptionPane.showMessageDialog(this, "CPU: On phones they have a central processing unit call a 'CPU'"
            		+ "it's similar to the CPU in computers, however its use in the phones is to operate"
            		+ "\nin low powered environments. As well as aset of an electronic circuit that runs the phone's operating systems and"
            		+ " \napps. To check if the phone CPU is goo is when the clock speed per core is better. A 'clock speed' is the numbr of "
            		+ " \ntimes that a circuit operates. ");
        } else if (source == RAMButton) {
        	//credit Vivian Phan
            JOptionPane.showMessageDialog(this, "RAM: The RAM is the part of a phone that is used to store an"
            		+ " operating system. The RAM is where you also keep the apps and the data that is being stored."
            		+ "\nRAM stands for 'random access memory'. The more RAM in a phone the quicker you can switch between apps without"
            		+ " lag.");
        } else if (source == MemoryButton) {
        	//credit Vivian Phan
            JOptionPane.showMessageDialog(this, "Memory: The memory of the phone is where you run programs."
            		+ " For example the apps on a phone or a computer.");
        } else if (source == StorageButton) {
        	//credit Vivian Phan
            JOptionPane.showMessageDialog(this, "Storage: The storage in a phone is where you keep things"
            		+ "like your music and photos. Overall, the storage in phones are around 128 GB and 256 GB, which is"
            		+ "\nenough to use your phone for doing basic things. For example, playing mobile games, "
            		+ "and taking high resoluton");
        } else if (source == DisplayButton) {
        	//credit Vivian Phan
            JOptionPane.showMessageDialog(this, "Display Range: When getting a phone, they're is a variety of "
            		+ "\nscreens avalible. from 4.7 inches to 9.7 inches. One of the common phone screen is 720 x 1280. "
            		+ "\nThe higher the resolution the better quality.");
        } else if (source == PriceButton) {
        	//credit Vivian Phan
            JOptionPane.showMessageDialog(this, "Price Range: The phone price ranges between $100 to over $1,000 depending on"
            		+ "what type of phone you are looking for. "
            		+ "\nFor example if you want a high end phone then the price range is going to be"
            		+ "$800 - $1,500.\"");
        } else if (source == SearchButton) { //add action listener for search button
            String searchText = searchField.getText();
            JOptionPane.showMessageDialog(this, "Searching for: " + searchText);
        } else if (e.getSource () == CartButton) {
        	setVisible(false);
        	new CartFrame().setVisible(true);
        } else if (source == InventoryButton){
        	setVisible(false);
        	new InventoryFrame().setVisible(true); //add inventory frame
        } else if (source == HomeButton) {
        	setVisible(false);
        	new MainMenuFrame().setVisible(true); 
        }
        else if (source == SurveyButton) {
        	setVisible(false);
        	SurveyFrame surveyFrame = new SurveyFrame(); //add survey frame
        	surveyFrame.initWindow();
	        surveyFrame.setVisible(true);
        }
    }
}


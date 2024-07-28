import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
public class SurveyFrame extends JFrame implements ActionListener{
	private JButton nextButton;
    private JButton backButton;
    private JButton homeButton;
    private JButton inventoryButton;
    private JButton educationButton;
    private JButton cartButton;
    private JButton submitButton;
    public static List<Integer> selectedValues;

    private int currentPage = 1;
    private JLabel backgroundLabel;
    private Stack<Integer> pageHistory;

    // Add multiple sets of radio buttons and button groups
    private ButtonGroup[] buttonGroups;
    private JRadioButton[][] radioButtons;

  /*  public static void main(String[] args) {
        Survey app = new Survey();
        app.initWindow();
        app.setVisible(true);
    }*/

    public SurveyFrame() {
        pageHistory = new Stack<>();
        selectedValues = new ArrayList<>();
    }

    public void initWindow() {
        setTitle("Survey Window - Page " + currentPage);
        setSize(1200, 625);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        addBackgroundImage("images/Page" + currentPage + ".png");
        addNavigationButtons();
        // Initialize multiple sets of radio buttons
        addRadioButtons();
    }

    private void addBackgroundImage(String imagePath) {
        ImageIcon backgroundImage = new ImageIcon(imagePath);

        if (backgroundLabel != null) {
            remove(backgroundLabel);
        }
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1200, 625);
        add(backgroundLabel);
    }

    private void addNavigationButtons() {
        nextButton = new JButton("Next");
        nextButton.setBounds(1000, 480, 130, 50);
        add(nextButton);
        nextButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(1030, 360, 130, 50);
        add(backButton);
        backButton.addActionListener(this);

        homeButton = new JButton("Home");
        homeButton.setBounds(760, 55, 100, 30);
        add(homeButton);
        homeButton.addActionListener(this);

        inventoryButton = new JButton("Inventory");
        inventoryButton.setBounds(1055, 55, 106, 30);
        add(inventoryButton);
        inventoryButton.addActionListener(this);

        educationButton = new JButton("Education");
        educationButton.setBounds(895, 55, 115, 30);
        add(educationButton);
        educationButton.addActionListener(this);

        cartButton = new JButton();
        // Use a cart icon on the Cart button
        ImageIcon cartIcon = new ImageIcon("images/cartDD.png");
        cartButton.setIcon(cartIcon);
        // Place the button at the top right corner
        cartButton.setBounds(1130, 0, 40, 40);
        add(cartButton);
        cartButton.addActionListener(this);

        submitButton = new JButton("Submit");
        submitButton.setBounds(1000, 480, 130, 50);
        add(submitButton);
        submitButton.addActionListener(this);
    }

    private void addRadioButtons() {
        // Initialize multiple sets of radio buttons
        buttonGroups = new ButtonGroup[7];
        radioButtons = new JRadioButton[7][6];

        for (int i = 0; i < 7; i++) {
            buttonGroups[i] = new ButtonGroup();
            for (int j = 0; j < 6; j++) {
                radioButtons[i][j] = new JRadioButton(Integer.toString(j + 1));
                // Set the position of each button as desired
                if (i == 0) { //1
                    int[] xCoordinates = {26, 280, 540, 800,1900,1900}; 
                    radioButtons[i][j].setBounds(xCoordinates[j], 236, 20, 25);
                } else if (i == 1) {//2
                    int[] xCoordinates = {34, 246, 480, 791,1900,1900}; 
                    radioButtons[i][j].setBounds(xCoordinates[j], 338, 20, 25);
                } else if (i == 2) {//3
                    int[] xCoordinates = {57, 277, 509, 755,1900,1900}; 
                    radioButtons[i][j].setBounds(xCoordinates[j], 478, 20, 25);
                } else if (i == 3) {//4
                	int[] xCoordinates = {38, 315, 560, 773,1900,1900}; 
                    radioButtons[i][j].setBounds(xCoordinates[j], 210, 20, 25);
                } else if (i == 4) {//5
                	int[] xCoordinates = {198, 540, 814, 363, 675,1900}; 
                	int[] yCoordinates = {350, 350, 350, 430, 430, 410};
                	radioButtons[i][j].setBounds(xCoordinates[j], yCoordinates[j], 20, 25);
                } else if (i == 5) {//6
                	int[] xCoordinates = {108, 282, 498, 696, 891,1900}; 
                    radioButtons[i][j].setBounds(xCoordinates[j], 210, 20, 25);
                } else {//7
                	int[] xCoordinates = {119, 361, 602, 802, 348, 662}; 
                	int[] yCoordinates = {344, 344, 344, 344, 435, 435};
                	radioButtons[i][j].setBounds(xCoordinates[j], yCoordinates[j], 20, 25);
                }
                add(radioButtons[i][j]);
                buttonGroups[i].add(radioButtons[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            pageHistory.push(currentPage);
            openNextPage();
        } else if (e.getSource() == backButton) {
            openPreviousPage();
        } else if (e.getSource() == homeButton) {
        	setVisible(false);
            MainMenuFrame mainMenuFrame = new MainMenuFrame();
        } else if (e.getSource() == inventoryButton) {
        	setVisible(false);
            InventoryFrame inventoryFrame = new InventoryFrame();
        } else if (e.getSource() == educationButton) {
        	setVisible(false);
            EducationFrame educationFrame = new EducationFrame();
        } else if (e.getSource() == cartButton) {
        	setVisible(false);
            CartFrame cartFrame = new CartFrame();
        }
        
        else if (e.getSource() == submitButton) {
            Submit();
        }
    }

    private void openNextPage() {
        currentPage++;
        updateWindow();
    }

    private void openPreviousPage() {
        if (!pageHistory.isEmpty()) {
            currentPage = pageHistory.pop();
            updateWindow();
        }
    }

    private void updateWindow() {
    	setTitle("Survey Window - Page " + currentPage);
        addBackgroundImage("images/Page" + currentPage + ".png");
        // Hide button groups from the first page when the second page is opened
        for (int i = 0; i < buttonGroups.length; i++) {
            for (int j = 0; j < radioButtons[i].length; j++) {
                radioButtons[i][j].setVisible(false);
            }
        }
        
        // Display the corresponding button group based on the current page
        if (currentPage == 1) {
            for (int j = 0; j < radioButtons[0].length; j++) {
                radioButtons[0][j].setVisible(true);
                radioButtons[1][j].setVisible(true);
                radioButtons[2][j].setVisible(true);
            }
        } else if (currentPage == 2) {
            for (int j = 0; j < radioButtons[1].length; j++) {
                radioButtons[3][j].setVisible(true);
                radioButtons[4][j].setVisible(true);
            }
        } else if (currentPage == 3) {
            for (int j = 0; j < radioButtons[2].length; j++) {
                radioButtons[5][j].setVisible(true);
                radioButtons[6][j].setVisible(true);
            }
        }
        // Control Next and Submit buttons visibility
        if (currentPage == 1 || currentPage == 2) {
            nextButton.setVisible(true);
            submitButton.setVisible(false);
        } else {
            nextButton.setVisible(false);
            submitButton.setVisible(true);
        }
        revalidate();
        repaint();
    }

    private void Submit() {
    	 selectedValues.clear();
         // Get the value of the selected radio button in each button group and save it to a list
  
         for (int i = 0; i < buttonGroups.length; i++) {
             int selectedValue = getSelectedRadioButtonValue(buttonGroups[i]);
             // add to the Array
             selectedValues.add(selectedValue);
         }
         // Print saved characters
         System.out.println(selectedValues);
         ResultsFrame resultsFrame = new ResultsFrame();
         setVisible(false);

     }

    private int getSelectedRadioButtonValue(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return Integer.parseInt(button.getText());
            }
        }
        return -1;
    }
}
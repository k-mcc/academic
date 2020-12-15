


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * This Calculator class represents the JFrame on containing the
 * Roth IRA calculator.
 * @author Kate McCarthy
 *
 */
public class CalorieCalculator extends JFrame{

	/**
	 * Instance variables for State of Calculator
	 * Don't change the variable names they are used by test
	 * case
	 */
	protected int weight;
	protected int height;
	protected int currentAge;
	protected double physAct;
	protected double calories;
	protected int futureAge;

	/**
	 * This represents the elements that are displayed on screen.
	 * Don't change the name of these variables they ar used by the
	 * test cases.
	 */
	protected JLabel ageLabel;
	protected JSpinner ageSpinner;
	protected JLabel weightLabel;
	protected JSlider weightSlider;
	protected JLabel weightDisplayAmount;
	protected JLabel heightDisplay;
	protected JLabel futureAgeLabel;
	protected JLabel investmentDisplayValue;
	protected JLabel physActDisplay;
	protected JLabel heightLabel;
	protected JSlider heightSlider;

	/**
	 * Inner classes that implement the handler form listeners
	 *  These classes implement the change listeners.
	 */
	protected class HeightListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
          	int value = source.getValue();
          	setHeight(value);
          	setFutureAge();
          	setCalories(calculateCalories());
          	heightDisplay.setText(getheight() + " in");
		}
    }

	/**(
	 *
	 *	Listener for age change events.
	 */

	 protected class AgeListener implements ChangeListener{

		 public void stateChanged(ChangeEvent e) {
	          	JSpinner source = (JSpinner)e.getSource();
	          	Object value = source.getValue();
	          	setCurrentAge((int)value);
	          	setFutureAge();
	          	setCalories(calculateCalories());
	     }

	 }


	/**
	 *
	 * Listener for month change events.
	 *
	 */
	protected class WeightListener implements ChangeListener{
		  public void stateChanged(ChangeEvent e) {
          	JSlider source = (JSlider)e.getSource();
          	int value = source.getValue();
          	setWeight(value);
          	setCalories(calculateCalories());
          	//TODO: Update appropriate values and labels
          	weightDisplayAmount.setText(value + " lb");
          }
	}

 /**
	 * Class represents the frame. That we will create
	 * @param weight
	 * @param height
	 * @param currentAge
	 * @param physAct
	 */
	public CalorieCalculator(int weight, int height, int currentAge, double physAct) {
		super();
		/*
		 * Set up the default values
		 */
		this.weight = weight;
		this.height = height;
		this.currentAge = currentAge;
		this.physAct = physAct;
		/*
		 * Setup close window behavior
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 363);
		getContentPane().setLayout(null);


        /*------------------------------------------------------------
         * Logo Section Value Section.
         * Doesn't show up in the designer.
         *  You will need to run the program to see it.
      	 * ------------------------------------------------------------
      	 */
        ImageIcon iconLogo = new ImageIcon("/Images/logo-uvacs.png");
        JLabel logoCS = new JLabel();
        logoCS.setIcon(iconLogo);
        logoCS.setBounds(350, 28, 165, 63);
        getContentPane().add(logoCS);

		/*------------------------------------------------------------
		 * monthly contribution section
		 * ------------------------------------------------------------
		 */
        //Month Saving Title Label
        weightLabel = new JLabel("Weight");
        weightLabel.setBounds(31, 131, 118, 26);
        getContentPane().add(weightLabel);
        // Month Saving Display Label
        weightDisplayAmount = new JLabel(getWeight() + " lb");
        weightDisplayAmount.setBounds(469, 137, 46, 14);
        getContentPane().add(weightDisplayAmount);

        //Slide for selecting Month Savings
        weightSlider = new JSlider();
        //Sets the maximum value of the slide
        weightSlider.setMaximum(500);
        //Sets the sliders default value
        weightSlider.setValue(getWeight());
        //Set the location (x,y, .., ..) and the
        // width and height (..., ..., width, height)
        weightSlider.setBounds(169, 122, 266, 45);
        //Show the ruler style lines
        weightSlider.setPaintTicks(true);
        //Spacing between major Ticks
        weightSlider.setMajorTickSpacing(150);
        //Spacing between minor Ticks
        weightSlider.setMinorTickSpacing(10);
        //Show labels on Ticks
        weightSlider.setPaintLabels(true);
        //Add Change listener.
        weightSlider.addChangeListener(new WeightListener());
        getContentPane().add(weightSlider);

        heightLabel = new JLabel("Height");
        heightLabel.setBounds(31, 177, 118, 26);
        getContentPane().add(heightLabel);
        // Month Saving Display Label
        heightDisplay = new JLabel(getheight() + " in");
        heightDisplay.setBounds(469, 177, 94, 14);
        getContentPane().add(heightDisplay);

      //Slide for selecting Month Savings
        heightSlider = new JSlider();
        //Sets the maximum value of the slide
        heightSlider.setMaximum(100);
        //Sets the sliders default value
        heightSlider.setValue(getheight());
        //Set the location (x,y, .., ..) and the
        // width and height (..., ..., width, height)
        heightSlider.setBounds(169, 172, 266, 45);
        //Show the ruler style lines
        heightSlider.setPaintTicks(true);
        //Spacing between major Ticks
        heightSlider.setMajorTickSpacing(15);
        //Spacing between minor Ticks
        heightSlider.setMinorTickSpacing(5);
        //Show labels on Ticks
        heightSlider.setPaintLabels(true);
        //Add Change listener.
        heightSlider.addChangeListener(new HeightListener());
        getContentPane().add(heightSlider);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(31, 65, 118, 26);
        getContentPane().add(ageLabel);

        futureAge = currentAge + height;
        futureAgeLabel = new JLabel(getfutureAgeDisplayText());
        futureAgeLabel.setBounds(31, 292, 129, 26);
        getContentPane().add(futureAgeLabel);

        ageSpinner = new JSpinner();
        ageSpinner.setBounds(169, 65, 54, 26);
        ageSpinner.setValue(getCurrentAge());
        ageSpinner.addChangeListener(new AgeListener());
        getContentPane().add(ageSpinner);

        physActDisplay = new JLabel("Physical Activity: 1.3");
        physActDisplay.setBounds(199, 292, 118, 26);
        getContentPane().add(physActDisplay);

        calories = calculateCalories();
        investmentDisplayValue = new JLabel(getCaloriesDisplayText());
        investmentDisplayValue.setBounds(338, 292, 243, 26);
        getContentPane().add(investmentDisplayValue);

	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalorieCalculator frame = new CalorieCalculator(77, 70, 18, 0.07);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public double calculateCalories() {

		double amount = ((4.536*this.weight) + (15.88*this.height) + (5.0*this.currentAge) - 161.0);

		return amount;
	}

	public java.lang.String getCaloriesDisplayText() {
		return "Calorie Intake: " + Math.round(this.calories);
	}

	public int getCurrentAge() {
		return this.currentAge;
	}

	public java.lang.String getfutureAgeDisplayText() {
		//future age display text
		return "Future Age: " + (this.futureAge);
	}

	/**
	 * A getter for the monthlySaving instance variable
	 * @return the monthSavings
	 */
	public int getWeight() {
		return this.weight;
	}

	public int getheight() {
		return this.height;
	}

	public void setCurrentAge(int currentAge) {
		this.currentAge = currentAge;
		setFutureAge();
	}

	public void setFutureAge() {
		//calculates the new future age and updates the future age label.
		this.futureAge = this.currentAge + this.height;
		futureAgeLabel.setText(getfutureAgeDisplayText());
	}

	public void setCalories(double calories) {
		this.calories = calories;
		investmentDisplayValue.setText(getCaloriesDisplayText());

	}

	public void setWeight(int weight) {
		this.weight = weight;
		weightDisplayAmount.setText(weight + "lb");
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
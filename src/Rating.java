
/* Name: Tony Tan
 * Date: May 7, 2024
 * Course Code: ICS 3U
 * Title: Rating Class Template
 * Description: Creates the fields, constructor method, and getters and setters of an
 * object to act as a template for other classes.
 * Added features: none
 * Areas of concerns: none
 */

public class Rating {
	//Declaring the fields
	private String model;
	private int quality;
	private double processorPerformance;
	private int memory;
	private int display;
	private int camera;
	private int battery;
	private double finalOverallScore;
	
	//Constructor for class
	public Rating(String model, int quality, double processorPerformance, int memory, int display, int camera,
			int battery, double finalOverallScore) {
		super();
		this.model = model;
		this.quality = quality;
		this.processorPerformance = processorPerformance;
		this.memory = memory;
		this.display = display;
		this.camera = camera;
		this.battery = battery;
		this.finalOverallScore = finalOverallScore;
	}

	//Getters and setters of fields
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public double getProcessorPerformance() {
		return processorPerformance;
	}

	public void setProcessorPerformance(double processorPerformance) {
		this.processorPerformance = processorPerformance;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

	public int getCamera() {
		return camera;
	}

	public void setCamera(int camera) {
		this.camera = camera;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public double getFinalOverallScore() {
		return finalOverallScore;
	}

	public void setFinalOverallScore(double finalOverallScore) {
		this.finalOverallScore = finalOverallScore;
	}

	//To string to read object in console
	@Override
	public String toString() {
		return "Rating [model=" + model + ", quality=" + quality + ", processorPerformance=" + processorPerformance
				+ ", memory=" + memory + ", display=" + display + ", camera=" + camera + ", battery=" + battery
				+ ", finalOverallScore=" + finalOverallScore + "]";
	}
	
}

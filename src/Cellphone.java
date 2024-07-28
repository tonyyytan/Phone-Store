/*
 * 
 */
public class Cellphone {
	private String brand;
	private String model;
	private String type;
	private double price;
	private String operatingSystem;
	private String cPU;
	private String gPU;
	private int rAM;
	private int internalStorage;
	private double displaySize;
	private String display;
	private int cameraRear;
	private double cameraFront;
	private int batteryCapacity;
	private double weight;
	private String hyperlink;

	public Cellphone(String brand, String model, String type, double price, String operatingSystem, String cPU,
			String gPU, int rAM, int internalStorage, double displaySize, String display, int cameraRear,
			double cameraFront, int batteryCapacity, double weight, String hyperlink) {
		super();
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.price = price;
		this.operatingSystem = operatingSystem;
		this.cPU = cPU;
		this.gPU = gPU;
		this.rAM = rAM;
		this.internalStorage = internalStorage;
		this.displaySize = displaySize;
		this.display = display;
		this.cameraRear = cameraRear;
		this.cameraFront = cameraFront;
		this.batteryCapacity = batteryCapacity;
		this.weight = weight;
		this.hyperlink = hyperlink;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getcPU() {
		return cPU;
	}

	public void setcPU(String cPU) {
		this.cPU = cPU;
	}

	public String getgPU() {
		return gPU;
	}

	public void setgPU(String gPU) {
		this.gPU = gPU;
	}

	public int getrAM() {
		return rAM;
	}

	public void setrAM(int rAM) {
		this.rAM = rAM;
	}

	public int getInternalStorage() {
		return internalStorage;
	}

	public void setInternalStorage(int internalStorage) {
		this.internalStorage = internalStorage;
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public int getCameraRear() {
		return cameraRear;
	}

	public void setCameraRear(int cameraRear) {
		this.cameraRear = cameraRear;
	}

	public double getCameraFront() {
		return cameraFront;
	}

	public void setCameraFront(double cameraFront) {
		this.cameraFront = cameraFront;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	@Override
	public String toString() {
		return "Cellphone [brand=" + brand + ", model=" + model + ", type=" + type + ", price=" + price
				+ ", operatingSystem=" + operatingSystem + ", cPU=" + cPU + ", gPU=" + gPU + ", rAM=" + rAM
				+ ", internalStorage=" + internalStorage + ", displaySize=" + displaySize + ", display=" + display
				+ ", cameraRear=" + cameraRear + ", cameraFront=" + cameraFront + ", batteryCapacity=" + batteryCapacity
				+ ", weight=" + weight + ", hyperlink=" + hyperlink + "]";
	}
}

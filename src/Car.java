public class Car{
    private int carID;
    private boolean automaticGear;
    private boolean airCondition;
    private boolean cruiseControl;
    private int amountOfSeats;
    private int hp;
    private String brand;
    private String model;
    private String fuelType;
    private int plateNumber;
    private String registrationDate;
    private int odometer;
    private int ccm;
    private boolean leatherseats;

    public Car(int carID, boolean automaticGear, boolean airCondition, boolean cruiseControl, int amountOfSeats, int hp, String brand, String model, String fuelType, int plateNumber, String registrationDate, int odometer, int ccm, boolean leatherseats) {
        this.carID = carID;
        this.automaticGear = automaticGear;
        this.airCondition = airCondition;
        this.cruiseControl = cruiseControl;
        this.amountOfSeats = amountOfSeats;
        this.hp = hp;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.plateNumber = plateNumber;
        this.registrationDate = registrationDate;
        this.odometer = odometer;
        this.ccm = ccm;
        this.leatherseats = leatherseats;
    }

    public void getRentalGroup(){
        if(ccm > 3000 && leatherseats == true){
            System.out.println("Luxury");
        }else if(amountOfSeats >= 7){
            System.out.println("Family");
        }else if(hp > 200){
            System.out.println("Sport");
        }else{
            System.out.println("everything else");
        }
    }

    public int getCcm() {
        return ccm;
    }

    public void setCcm(int ccm) {
        this.ccm = ccm;
    }

    public boolean isLeatherseats() {
        return leatherseats;
    }

    public void setLeatherseats(boolean leatherseats) {
        this.leatherseats = leatherseats;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public boolean isAutomaticGear() {
        return automaticGear;
    }

    public void setAutomaticGear(boolean automaticGear) {
        this.automaticGear = automaticGear;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}

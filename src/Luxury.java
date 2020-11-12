public class Luxury extends Car {
    private int ccm;
    private boolean automaticGear;
    private boolean airCondition;
    private boolean cruiseControl;

    public Luxury(int carID, String brand, String model, String fuelType, int plateNumber, String registrationDate, int odometer, int ccm, boolean automaticGear, boolean airCondition, boolean cruiseControl) {
        super(carID, brand, model, fuelType, plateNumber, registrationDate, odometer);
        this.ccm = ccm;
        this.automaticGear = automaticGear;
        this.airCondition = airCondition;
        this.cruiseControl = cruiseControl;
    }

    @Override
    public String toString() {
        return "Luxury{" +
                "ccm=" + ccm +
                ", automaticGear=" + automaticGear +
                ", airCondition=" + airCondition +
                ", cruiseControl=" + cruiseControl +
                '}';
    }

    public int getCcm() {
        return ccm;
    }

    public void setCcm(int ccm) {
        this.ccm = ccm;
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
}

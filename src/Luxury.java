public class Luxury extends Car {
    private boolean ccm;
    private boolean automaticGear;
    private boolean airCondition;
    private boolean cruiseControl;

    public Luxury(int carID, String brand, String model, String fuelType, String plateNumber, String registrationDate, int odometer, boolean ccm, boolean automaticGear, boolean airCondition, boolean cruiseControl) {
        super(carID, brand, model, fuelType, plateNumber, registrationDate, odometer);
        this.ccm = ccm;
        this.automaticGear = automaticGear;
        this.airCondition = airCondition;
        this.cruiseControl = cruiseControl;
    }

    @Override
    public String toString() {
        return "Luxury{" + "carID = " + getCarID() +
                ", brand = " + getBrand() +
                ", model = " + getModel() +
                ", fuelType = " + getFuelType() +
                ", platNumber = " + getPlateNumber() +
                ", registrationDate = " + getRegistrationDate() +
                ", odometer = " + getOdometer() +
                "ccm=" + ccm +
                ", automaticGear=" + automaticGear +
                ", airCondition=" + airCondition +
                ", cruiseControl=" + cruiseControl +
                '}';
    }

    public boolean isCcm() {
        return ccm;
    }

    public void setCcm(boolean ccm) {
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

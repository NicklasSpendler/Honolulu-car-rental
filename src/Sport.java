public class Sport extends Car {
    private boolean manualGear;
    private boolean hp;

    public Sport(int carID, String brand, String model, String fuelType, String plateNumber, String registrationDate, int odometer, boolean manualGear, boolean hp) {
        super(carID, brand, model, fuelType, plateNumber, registrationDate, odometer);
        this.manualGear = manualGear;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Sport{" + "carID = " + getCarID() +
                ", brand = " + getBrand() +
                ", model = " + getModel() +
                ", fuelType = " + getFuelType() +
                ", platNumber = " + getPlateNumber() +
                ", registrationDate = " + getRegistrationDate() +
                ", odometer = " + getOdometer() +
                "manualGear = " + manualGear +
                ", hp = " + hp +
                '}';
    }

    public boolean isManualGear() {
        return manualGear;
    }

    public void setManualGear(boolean manualGear) {
        this.manualGear = manualGear;
    }

    public boolean isHp() {
        return hp;
    }

    public void setHp(boolean hp) {
        this.hp = hp;
    }
}

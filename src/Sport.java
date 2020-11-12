public class Sport extends Car {
    private boolean manualGear;
    private int hp;

    public Sport(int carID, String brand, String model, String fuelType, int plateNumber, String registrationDate, int odometer, boolean manualGear, int hp) {
        super(carID, brand, model, fuelType, plateNumber, registrationDate, odometer);
        this.manualGear = manualGear;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "manualGear=" + manualGear +
                ", hp=" + hp +
                '}';
    }

    public boolean isManualGear() {
        return manualGear;
    }

    public void setManualGear(boolean manualGear) {
        this.manualGear = manualGear;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

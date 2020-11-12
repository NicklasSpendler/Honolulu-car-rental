public class Family extends Car {
    private boolean manuelGear;
    private boolean airCondition;
    private boolean cruiseControl;
    private boolean sevenSeatsOrMore;

    public Family(int carID, String brand, String model, String fuelType, int plateNumber, String registrationDate, int odometer, boolean manuelGear, boolean airCondition, boolean cruiseControl, boolean sevenSeatsOrMore) {
        super(carID, brand, model, fuelType, plateNumber, registrationDate, odometer);
        this.manuelGear = manuelGear;
        this.airCondition = airCondition;
        this.cruiseControl = cruiseControl;
        this.sevenSeatsOrMore = sevenSeatsOrMore;
    }

    @Override
    public String toString() {
        return "Family{" +
                "manuelGear=" + manuelGear +
                ", airCondition=" + airCondition +
                ", cruiseControl=" + cruiseControl +
                ", sevenSeatsOrMore=" + sevenSeatsOrMore +
                '}';
    }

    public boolean isManuelGear() {
        return manuelGear;
    }

    public void setManuelGear(boolean manuelGear) {
        this.manuelGear = manuelGear;
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

    public boolean isSevenSeatsOrMore() {
        return sevenSeatsOrMore;
    }

    public void setSevenSeatsOrMore(boolean sevenSeatsOrMore) {
        this.sevenSeatsOrMore = sevenSeatsOrMore;
    }
}

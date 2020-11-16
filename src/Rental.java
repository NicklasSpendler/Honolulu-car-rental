public class Rental {
    private int rentalID;
    private int customerID;
    private int carID;
    private String fromDate;
    private String toDate;
    private int maxKm;
    private int odometerStart;
    private String plateNumber;

    public Rental(int rentalID, int customerID, int carID, String fromDate, String toDate, int maxKm, int odometerStart, String plateNumber) {
        this.rentalID = rentalID;
        this.customerID = customerID;
        this.carID = carID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.maxKm = maxKm;
        this.odometerStart = odometerStart;
        this.plateNumber = plateNumber;
    }

    public Rental(){

    }

    @Override
    public String toString() {
        return "Rental{" +
                "contractID=" + rentalID +
                ", customerID=" + customerID +
                ", carID=" + carID +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", maxKm=" + maxKm +
                ", odometerStart=" + odometerStart +
                ", plateNumber=" + plateNumber +
                '}';
    }

    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public int getOdometerStart() {
        return odometerStart;
    }

    public void setOdometerStart(int odometerStart) {
        this.odometerStart = odometerStart;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
public class Contract {
    private int customerID;
    private String fromDate;
    private String toDate;
    private int maxKm;
    private int odometerStart;
    private int plateNumber;

    public Contract(int customerID, String fromDate, String toDate, int maxKm, int odometerStart, int plateNumber) {
        this.customerID = customerID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.maxKm = maxKm;
        this.odometerStart = odometerStart;
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "customerID=" + customerID +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", maxKm=" + maxKm +
                ", odometerStart=" + odometerStart +
                ", plateNumber=" + plateNumber +
                '}';
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

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }
}
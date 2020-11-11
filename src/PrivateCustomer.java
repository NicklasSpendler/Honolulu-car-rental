public class PrivateCustomer extends Customer {
    int licenseNumber;
    String driver_since_date;


    public PrivateCustomer(int ID, String name, String address, int zip_code, String city, int mobile_number, int phone_number, String email, int licenseNumber, String driver_since_date) {
        super(ID, name, address, zip_code, city, mobile_number, phone_number, email);
        this.licenseNumber = licenseNumber;
        this.driver_since_date = driver_since_date;
    }

    public PrivateCustomer() {
    }

    @Override
    public String toString() {
        return "PrivateCustomer{" +
                "ID=" + getCustomerID() + "\'" +
                ", Name=" + getName() + "\'" +
                ", licenseNumber=" + licenseNumber +
                ", driver_since_date='" + driver_since_date + '\'' +
                '}';
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDriver_since_date() {
        return driver_since_date;
    }

    public void setDriver_since_date(String driver_since_date) {
        this.driver_since_date = driver_since_date;
    }
}

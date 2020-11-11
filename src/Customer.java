public class Customer {
    private int CustomerID;
    private String name;
    private String address;
    private int zip_code;
    private String city;
    private int mobile_number;
    private int phone_number;
    private String email;


    public Customer(int CustomerID, String name, String address, int zip_code, String city, int mobile_number, int phone_number, String email) {
        this.CustomerID = CustomerID;
        this.name = name;
        this.address = address;
        this.zip_code = zip_code;
        this.city = city;
        this.mobile_number = mobile_number;
        this.phone_number = phone_number;
        this.email = email;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + CustomerID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zip_code=" + zip_code +
                ", city='" + city + '\'' +
                ", mobile_number=" + mobile_number +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                '}';
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int ID) {
        this.CustomerID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

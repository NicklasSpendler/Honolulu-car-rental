public class CompanyCustomer extends Customer {

    private String company_name;
    private String company_address;
    private int company_phone_number;
    private int CRN;

    public CompanyCustomer(int ID, String name, String address, int zip_code, String city, int mobile_number, int phone_number, String email, String company_name, String company_address, int company_phone_number, int CRN) {
        super(ID, name, address, zip_code, city, mobile_number, phone_number, email);
        this.company_name = company_name;
        this.company_address = company_address;
        this.company_phone_number = company_phone_number;
        this.CRN = CRN;
    }

    @Override
    public String toString() {
        return "CompanyCustomer{" +
                "company_name='" + company_name + '\'' +
                ", company_address='" + company_address + '\'' +
                ", company_phone_number=" + company_phone_number +
                ", CRN=" + CRN +
                '}';
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public int getCompany_phone_number() {
        return company_phone_number;
    }

    public void setCompany_phone_number(int company_phone_number) {
        this.company_phone_number = company_phone_number;
    }

    public int getCRN() {
        return CRN;
    }

    public void setCRN(int CRN) {
        this.CRN = CRN;
    }
}

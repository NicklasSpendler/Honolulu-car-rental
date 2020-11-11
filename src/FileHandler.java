import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<Contract> contractList = new ArrayList<>();
    private ArrayList<Car> carList = new ArrayList<>();

    public FileHandler(){

    }

    public void writeCustomerToFile(){
        try{
            FileWriter clearFile = new FileWriter("customerData.txt", false);
            clearFile.write("");

            FileWriter myWriter = new FileWriter("customerData.txt", true);
            for (int i = 0; i <= customerList.size() -1; i++){
                if(customerList.get(i).getClass().getName() == "PrivateCustomer"){
                    PrivateCustomer tempPrivateCustomer;
                    tempPrivateCustomer = (PrivateCustomer) customerList.get(i);
                    myWriter.write("PrivateCustomer: " + tempPrivateCustomer.getCustomerID() + " " + tempPrivateCustomer.getName() + " " + tempPrivateCustomer.getAddress() + " " + tempPrivateCustomer.getZip_code() + " " + tempPrivateCustomer.getCity() + " " + tempPrivateCustomer.getMobile_number() + " " + tempPrivateCustomer.getPhone_number() + " " + tempPrivateCustomer.getEmail() + " " + tempPrivateCustomer.getLicenseNumber() + " " + tempPrivateCustomer.getDriver_since_date());
                }else if (customerList.get(i).getClass().getName() == "CompanyCustomer"){
                    CompanyCustomer tempCompanyCustomer;
                    tempCompanyCustomer = (CompanyCustomer) customerList.get(i);
                    myWriter.write("CompanyCustomer: " + tempCompanyCustomer.getCustomerID() + " " + tempCompanyCustomer.getName() + " " + tempCompanyCustomer.getAddress() + " " + tempCompanyCustomer.getZip_code() + " " + tempCompanyCustomer.getCity() + " " + tempCompanyCustomer.getMobile_number() + " " + tempCompanyCustomer.getPhone_number() + " " + tempCompanyCustomer.getEmail() + " " + tempCompanyCustomer.getCompany_name() + " " + tempCompanyCustomer.getCompany_address() + " " + tempCompanyCustomer.getCompany_phone_number() + " " + tempCompanyCustomer.getCRN());
                }
                if(i != customerList.size()-1){
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        }catch (IOException e){
            System.out.println("Couldn't write customers to file");
            e.printStackTrace();
        }
    }

    public void writeContractToFile(){
        try {
            FileWriter clearFile = new FileWriter("contractData.txt", false);
            clearFile.write("");

            FileWriter myWriter = new FileWriter("contractData.txt", true);
            for (int i = 0; i <= contractList.size() - 1; i++){
                myWriter.write(contractList.get(i).getContractID() + " " + contractList.get(i).getCustomerID() + " " + contractList.get(i).getFromDate() + " " + contractList.get(i).getToDate() + " " + contractList.get(i).getMaxKm() + " " + contractList.get(i).getOdometerStart() + " " + contractList.get(i).getPlateNumber());
                if (i != contractList.size() - 1){
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCarToFile(){
        try {
            FileWriter clearContent = new FileWriter("CarData.txt", false);
            clearContent.write("");

            FileWriter myWriter = new FileWriter("carData.txt", true);
            for (int i = 0; i <= carList.size() - 1; i++) {
                myWriter.write(carList.get(i).getCarID() + " " + carList.get(i).isAutomaticGear() + " " + carList.get(i).isAirCondition() + " " + carList.get(i).isCruiseControl() + " " +  carList.get(i).getAmountOfSeats() + " " + carList.get(i).getHp() + " " + carList.get(i).getBrand() + " " + carList.get(i).getModel() + " " + carList.get(i).getFuelType() + " " + carList.get(i).getPlateNumber() + " " + carList.get(i).getRegistrationDate() + " " + carList.get(i).getOdometer());
                if (i != carList.size() - 1) {
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCustomerFromFile(){
        try{
            File customerFile = new File("customerData.txt");
            Scanner myReader = new Scanner(customerFile);
            while (myReader.hasNextLine()){
                String dataType = myReader.next();
                if(dataType.contains("PrivateCustomer:")){
                    PrivateCustomer tempPrivateCustomer = new PrivateCustomer(myReader.nextInt(), myReader.next(), myReader.next(), myReader.nextInt(), myReader.next(), myReader.nextInt(), myReader.nextInt(), myReader.next(), myReader.nextInt(), myReader.next());
                    customerList.add(tempPrivateCustomer);
                }else if(dataType.contains("CompanyCustomer:")){
                    CompanyCustomer tempCompanyCustomer = new CompanyCustomer(myReader.nextInt(), myReader.next(), myReader.next(), myReader.nextInt(), myReader.next(), myReader.nextInt(), myReader.nextInt(), myReader.next(), myReader.next(), myReader.next(), myReader.nextInt(), myReader.nextInt());
                    customerList.add(tempCompanyCustomer);
                }
            }

        } catch (FileNotFoundException e){
            System.out.println("Can't read the Customer file");
            e.printStackTrace();
        }
    }
    public static void readContractFromFile(){
        ArrayList<Contract> contractArray = new ArrayList<>();

        try {
            File contractFile = new File("contractData.txt");
            Scanner myReader = new Scanner(contractFile);

            while (myReader.hasNextLine()){
                int contractID = myReader.nextInt();
                int customerID = myReader.nextInt();
                String fromDate = myReader.next();
                String toDate = myReader.next();
                int maxKm = myReader.nextInt();
                int odometerStart = myReader.nextInt();
                int plateNumber = myReader.nextInt();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createFiles(String filename){
        try {
            File myObj = new File(filename + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public ArrayList<Contract> getContractList() {
        return contractList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }



}

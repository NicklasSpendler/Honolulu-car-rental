import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {

    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<Rental> rentalList = new ArrayList<>();
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
            for (int i = 0; i <= rentalList.size() - 1; i++){
                myWriter.write(rentalList.get(i).getContractID() + " " + rentalList.get(i).getCustomerID() + " " + rentalList.get(i).getFromDate() + " " + rentalList.get(i).getToDate() + " " + rentalList.get(i).getMaxKm() + " " + rentalList.get(i).getOdometerStart() + " " + rentalList.get(i).getPlateNumber());
                if (i != rentalList.size() - 1){
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
            FileWriter clearContent = new FileWriter("carData.txt", false);
            clearContent.write("");

            FileWriter myWriter = new FileWriter("carData.txt", true);
            for (int i = 0; i <= carList.size() - 1; i++) {
                if (carList.get(i).getClass().getName() == "Family"){
                    Family tempFamily;
                    tempFamily = (Family) carList.get(i);
                    myWriter.write("Family: " + tempFamily.getCarID() + " " + tempFamily.getBrand() + " " + tempFamily.getModel() + " " + tempFamily.getFuelType() + " " + tempFamily.getPlateNumber() + " " + tempFamily.getRegistrationDate() + " " + tempFamily.getOdometer() + " " + tempFamily.isManualGear() + " " + tempFamily.isAirCondition() + " " + tempFamily.isCruiseControl() + " " + tempFamily.isSevenSeatsOrMore());
                }else if (carList.get(i).getClass().getName() == "Luxury"){
                    Luxury tempLuxury;
                    tempLuxury = (Luxury) carList.get(i);
                    myWriter.write("Luxury: " + tempLuxury.getCarID() + " " + tempLuxury.getBrand() + " " + tempLuxury.getModel() + " " + tempLuxury.getFuelType() + " " + tempLuxury.getPlateNumber() + " " + tempLuxury.getRegistrationDate() + " " + tempLuxury.getOdometer() + " " + tempLuxury.isCcm() + " " + tempLuxury.isAutomaticGear() + " " + tempLuxury.isAirCondition() + " " + tempLuxury.isCruiseControl());
                }else if (carList.get(i).getClass().getName() == "Sport"){
                    Sport tempSport;
                    tempSport = (Sport) carList.get(i);
                    myWriter.write("Sport: " + tempSport.getCarID() + " " + tempSport.getBrand() + " " + tempSport.getModel() + " " + tempSport.getFuelType() + " " + tempSport.getPlateNumber() + " " + tempSport.getRegistrationDate() + " " + tempSport.getOdometer() + " " + tempSport.isManualGear() + " " + tempSport.isHp());
                }
                if (i != carList.size() - 1){
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Cant write car to file");
            e.printStackTrace();
        }
    }

    public void readCarFromFile(){
        try {
            File carFile = new File("carData.txt");
            Scanner myReader = new Scanner(carFile);
            while (myReader.hasNextLine()) {
                String carType = myReader.next();
                if (carType.contains("Family: ")) {
                    Family tempFamily = new Family(myReader.nextInt(), myReader.next(), myReader.next(), myReader.next(), myReader.nextInt(), myReader.next(), myReader.nextInt(), myReader.nextBoolean(), myReader.nextBoolean(), myReader.nextBoolean(), myReader.nextBoolean());
                    carList.add(tempFamily);
                } else if (carType.contains("Luxury: ")) {
                    Luxury tempLuxury = new Luxury(myReader.nextInt(), myReader.next(), myReader.next(), myReader.next(), myReader.nextInt(), myReader.next(), myReader.nextInt(), myReader.nextBoolean(), myReader.nextBoolean(), myReader.nextBoolean(), myReader.nextBoolean());
                    carList.add(tempLuxury);
                } else if (carType.contains("Sport: ")) {
                    Sport tempSport = new Sport(myReader.nextInt(), myReader.next(), myReader.next(), myReader.next(), myReader.nextInt(), myReader.next(), myReader.nextInt(), myReader.nextBoolean(), myReader.nextBoolean());
                    carList.add(tempSport);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Can't read the Car File");
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
        ArrayList<Rental> rentalArray = new ArrayList<>();

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

    public void saveFiles(){
        writeContractToFile();
        writeCarToFile();
        writeCustomerToFile();
    }

    public ArrayList<Rental> getContractList() {
        return rentalList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }



}

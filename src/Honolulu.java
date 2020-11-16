import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Honolulu {
    public static void main(String[] args) {
        FileHandler filehandler = new FileHandler();
        Scanner input = new Scanner(System.in);

        filehandler.createFiles("customerData");
        filehandler.createFiles("carData");
        filehandler.createFiles("contractData");

        Rental rental1 = new Rental(1, 1, 2, "lol", "lol", 2, 2, 2);
        filehandler.getRentalList().add(rental1);

/*
        ArrayList<Customer> customers = new ArrayList<>();

        PrivateCustomer customer1 = new PrivateCustomer(1, "Lol", "lol1", 1919, "lol", 20201919, 50502000, "omegalul@lol.com", 299199, "lol");

        CompanyCustomer customer2 = new CompanyCustomer(1, "Lol", "lol1", 1919, "lol", 20201919, 50502000, "omegalul@lol.com", "omegalul", "lol", 22222222, 2222);


        filehandler.getCustomerList().add(customer1);
        filehandler.getCustomerList().add(customer2);

 */
        
        filehandler.readCustomerFromFile();
        mainmenu(filehandler, input);
    }

    public static void mainmenu(FileHandler filehandler, Scanner input){
        System.out.println("D = Show Data\nC = Create Data\nS = Save Data\nQ = Quit");

        String choice = input.next();
        if(choice.equalsIgnoreCase("d")){
            showMenu(filehandler, input);
        }else if(choice.equalsIgnoreCase("c")){
            createMenu(filehandler, input);
        }else if(choice.equalsIgnoreCase("s")){
            filehandler.saveFiles();
            mainmenu(filehandler,input);
        }
    }

    public static void showMenu(FileHandler filehandler, Scanner input){
        System.out.println("C = Show Cars\nU = Show Customers\nR = Show rentals\nB = Back");

        String choice = input.next();
        if(choice.equalsIgnoreCase("c")){
            showCar(filehandler, input);
        }else if(choice.equalsIgnoreCase("u")){
            showCustomer(filehandler, input);
        }else if(choice.equalsIgnoreCase("r")){

        }else if(choice.equalsIgnoreCase("b")){
            mainmenu(filehandler,input);
        }
    }

    public static void createMenu(FileHandler filehandler, Scanner input){
        System.out.println("C = Create Car\nE = Create Customer\nR = Create Rental\nB = Back");

        String choice = input.next();
        if(choice.equalsIgnoreCase("c")){
            createCar(filehandler, input);
        }else if(choice.equalsIgnoreCase("e")){
            createCustomer(filehandler, input);
        }else if(choice.equalsIgnoreCase("r")){
            createRental(filehandler, input);
        }else if(choice.equalsIgnoreCase("B")){
            mainmenu(filehandler, input);
        }else{
            mainmenu(filehandler, input);
        }
    }

    public static void showCar(FileHandler filehandler, Scanner input){
        ArrayList<Family> familyList = new ArrayList<>();
        ArrayList<Luxury> luxuryList = new ArrayList<>();
        ArrayList<Sport> sportList = new ArrayList<>();
        System.out.println("======List of all cars======");
        for (int i = 0; i <= filehandler.getCarList().size() - 1; i++){
            if (filehandler.getCarList().get(i).getClass().getName() == "Family"){
                familyList.add((Family) filehandler.getCarList().get(i));
            }else if (filehandler.getCarList().get(i).getClass().getName() == "Luxury"){
                luxuryList.add((Luxury) filehandler.getCarList().get(i));
            }else if (filehandler.getCarList().get(i).getClass().getName() == "Sport"){
                sportList.add((Sport) filehandler.getCarList().get(i));
            }
        }
        System.out.println("======Family======");
        for (int i = 0; i <= familyList.size() - 1; i++){
            System.out.println(familyList.get(i));
        }
        System.out.println("======Luxury======");
        for (int i = 0; i <= luxuryList.size() - 1; i++){
            System.out.println(luxuryList.get(i));
        }
        System.out.println("======Sport======");
        for (int i = 0; i <= sportList.size() - 1; i++){
            System.out.println(sportList.get(i));
        }
    }

    public static void showCustomer(FileHandler filehandler,Scanner input){
        ArrayList<CompanyCustomer> companyCustomerList = new ArrayList<>();
        ArrayList<PrivateCustomer> privateCustomerList = new ArrayList<>();
        for (int i = 0; i<= filehandler.getCustomerList().size() -1; i++){
            if(filehandler.getCustomerList().get(i).getClass().getName() == "CompanyCustomer"){
                companyCustomerList.add((CompanyCustomer) filehandler.getCustomerList().get(i));
            }else if(filehandler.getCustomerList().get(i).getClass().getName() == "PrivateCustomer"){
                privateCustomerList.add((PrivateCustomer) filehandler.getCustomerList().get(i));
            }
        }
        System.out.println("======Company Custormers======");
        for (int i = 0; i<= companyCustomerList.size() -1; i++){
            System.out.println(companyCustomerList.get(i));
        }
        System.out.println("======Private Custormers======");
        for (int i = 0; i<= privateCustomerList.size() -1; i++){
            System.out.println(privateCustomerList.get(i));
        }
    }

    public static void createCustomer(FileHandler filehandler, Scanner input){
        int newID = getFreeCustomerID(filehandler);

        System.out.println("======Create Customer======");
        System.out.println("Which type of customer? P = Private / C = Company");
        String customerType = input.next();

        if(customerType.equalsIgnoreCase("P")){
            System.out.println("Private customer Chosen\nEnter Customer Name:");
        }else if(customerType.equalsIgnoreCase("c")){
            System.out.println("Company customer Chosen\nEnter Customer Name:");
        }
        String customerName = input.next();
        System.out.println("Enter Customers address:");
        String customerAddress = input.next();
        System.out.println("Enter Customers Zip-code:");
        int customerZipcode = input.nextInt();
        System.out.println("Enter Customer City:");
        String customerCity = input.next();
        System.out.println("Enter Customer mobile number:");
        int customerMobileNumber = input.nextInt();
        System.out.println("Enter Customer phone number:");
        int customerPhoneNumber = input.nextInt();
        System.out.println("Enter Customer mail:");
        String customerMail = input.next();
        if(customerType.equalsIgnoreCase("p")){
            System.out.println("Enter customers driver license number:");
            int customerLicenseNumber = input.nextInt();
            System.out.println("Enter the date when customer got his/her license:");
            String driver_since_date = input.next();

            PrivateCustomer tempCustomer = new PrivateCustomer(newID, customerName, customerAddress, customerZipcode, customerCity, customerMobileNumber,customerPhoneNumber,customerMail,customerLicenseNumber,driver_since_date);
            filehandler.getCustomerList().add(tempCustomer);
        }else if(customerType.equalsIgnoreCase("c")){
            System.out.println("Enter company name:");
            String customerCompanyName = input.next();
            System.out.println("Enter company address:");
            String customerCompanyAddress = input.next();
            System.out.println("Enter company phone number:");
            int customerCompanyPhoneNumber = input.nextInt();
            System.out.println("Enter company CRN (Company registration number):");
            int customerCompanyCrn = input.nextInt();

            CompanyCustomer tempCustomer = new CompanyCustomer(newID, customerName, customerAddress, customerZipcode, customerCity, customerMobileNumber,customerPhoneNumber,customerMail,customerCompanyName,customerCompanyAddress,customerCompanyPhoneNumber,customerCompanyCrn);
            filehandler.getCustomerList().add(tempCustomer);
        }
        System.out.println("Would you like to create another Customer?");
        String option = input.next();
        if(option.equalsIgnoreCase("y")){
            createCar(filehandler,input);
        }else if(option.equalsIgnoreCase("n")){
            createMenu(filehandler, input);
        }
    }

    public static void createCar(FileHandler filehandler, Scanner input){
        int newID = getFreeCarID(filehandler);

        System.out.println("======Create Car======");
        System.out.println();
        System.out.println("Which car would you like to create?\nF = Family\nL = Luxury\nS = Sport");
        String carType = input.next();

        if (carType.equalsIgnoreCase("F")){
            System.out.println("Family car");
        } else if (carType.equalsIgnoreCase("L")){
            System.out.println("Luxury car");
        } else if (carType.equalsIgnoreCase("S")){
            System.out.println("Sport car");
        }
        System.out.println("Enter brand");
        String carBrand = input.next();
        System.out.println("Enter model");
        String carModel = input.next();
        System.out.println("Enter fuel type");
        String carFuelType = input.next();
        System.out.println("Enter registration number (Plate)");
        int carPlateNumber = input.nextInt();
        System.out.println("Enter registration date");
        String carRegistrationDate = input.next();
        System.out.println("Enter how many km the car has driven (odometer)");
        int carOdometer = input.nextInt();
        if (carType.equalsIgnoreCase("F")){
            System.out.println("Enter true for manual gear");
            boolean familyManual = input.nextBoolean();
            System.out.println("Enter true for air condition");
            boolean familyAirCondition = input.nextBoolean();
            System.out.println("Enter true for cruise control");
            boolean familyCruiseControl = input.nextBoolean();
            System.out.println("Enter true for 7 seats or more");
            boolean familySevenSeatsOrMore = input.nextBoolean();

            Family tempFamily = new Family(newID, carBrand, carModel, carFuelType, carPlateNumber, carRegistrationDate, carOdometer, familyManual, familyAirCondition, familyCruiseControl, familySevenSeatsOrMore);
            filehandler.getCarList().add(tempFamily);
        } else if (carType.equalsIgnoreCase("L")){
            System.out.println("Enter true for a higher ccm than 3000");
            boolean luxuryCcm = input.nextBoolean();
            System.out.println("Enter true for automatic gear");
            boolean luxuryAutomatic = input.nextBoolean();
            System.out.println("Enter true for air condition");
            boolean luxuryAirCondition = input.nextBoolean();
            System.out.println("Enter true for cruise control");
            boolean luxuryCruiseControl = input.nextBoolean();

            Luxury tempLuxury = new Luxury(newID, carBrand, carModel, carFuelType, carPlateNumber, carRegistrationDate, carOdometer, luxuryCcm, luxuryAutomatic, luxuryAirCondition, luxuryCruiseControl);
            filehandler.getCarList().add(tempLuxury);
        } else if (carType.equalsIgnoreCase("S")){
            System.out.println("Enter true for manual gear");
            boolean sportManualGear = input.nextBoolean();
            System.out.println("Enter true if horsepower is over 200");
            boolean sportHp = input.nextBoolean();

            Sport tempSport = new Sport(newID, carBrand, carModel, carFuelType, carPlateNumber, carRegistrationDate, carOdometer, sportManualGear, sportHp);
            filehandler.getCarList().add(tempSport);
        }
        System.out.println("Would you like to create another car? Y/N");
        String option = input.next();
        if (option.equalsIgnoreCase("y")){
            createCar(filehandler, input);
        }else if (option.equalsIgnoreCase("n")){
            mainmenu(filehandler, input);
        }


    }

    public static void createRental(FileHandler filehandler, Scanner input){
        Customer selectedCustomer = new Customer();

        System.out.println("======Create Rental======");
        System.out.println("Select or create a new customer (S = Select / C = Create)");
        String choice = input.next();
        if(choice.equalsIgnoreCase("s")){
            for (int i = 0; i <= filehandler.getCustomerList().size() -1; i++){
                System.out.println(filehandler.getCustomerList().get(i).getCustomerID() + " " + filehandler.getCustomerList().get(i).getName());
            }
            System.out.println("Select the customer by ID: ");
            int selectedCustomerID = input.nextInt();
            selectedCustomer = filehandler.getCustomerByID(selectedCustomerID);
            System.out.println(selectedCustomer.getName() + " has been selected");
        }else if(choice.equalsIgnoreCase("c")){

        }
    }

    public static int getFreeCustomerID(FileHandler filehandler){
        ArrayList<Integer> alreadyUsedIDs = new ArrayList<>();

        for (int i = 0; i <= filehandler.getCustomerList().size() -1; i++){
            alreadyUsedIDs.add(filehandler.getCustomerList().get(i).getCustomerID());
        }

        int newID = 1;

        if(alreadyUsedIDs.size() != 0){
            newID = Collections.max(alreadyUsedIDs) + 1;
        }

        return newID;
    }

    public static int getFreeCarID(FileHandler fileHandler){
        ArrayList<Integer> usedID = new ArrayList<>();

        for (int i = 0; i <= fileHandler.getCarList().size() - 1; i++){
            usedID.add(fileHandler.getCarList().get(i).getCarID());
        }

        int newID = 1;

        if (usedID.size() != 0){
            newID = Collections.max(usedID) + 1;
        }

        return newID;
    }
}
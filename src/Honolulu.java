import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Honolulu {
    public static void main(String[] args) {
        FileHandler filehandler = new FileHandler();
        Scanner input = new Scanner(System.in);

        filehandler.createFiles("customerData");
        filehandler.createFiles("carData");
        filehandler.createFiles("rentalData");

        filehandler.readCarFromFile();
        filehandler.readCustomerFromFile();
        filehandler.readRentalFromFile();

/*
        ArrayList<Customer> customers = new ArrayList<>();

        PrivateCustomer customer1 = new PrivateCustomer(1, "Lol", "lol1", 1919, "lol", 20201919, 50502000, "omegalul@lol.com", 299199, "lol");

        CompanyCustomer customer2 = new CompanyCustomer(1, "Lol", "lol1", 1919, "lol", 20201919, 50502000, "omegalul@lol.com", "omegalul", "lol", 22222222, 2222);


        filehandler.getCustomerList().add(customer1);
        filehandler.getCustomerList().add(customer2);

 */
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
            showRental(filehandler, input);
        }else{
            mainmenu(filehandler,input);
        }
    }

    public static void createMenu(FileHandler filehandler, Scanner input){
        System.out.println("C = Create Car\nE = Create Customer\nR = Create Rental\nB = Back");

        String choice = input.next();
        if(choice.equalsIgnoreCase("c")){
            createCar(filehandler, input);
        }else if(choice.equalsIgnoreCase("e")){
            createCustomer(filehandler, input, true);
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
        if (!familyList.isEmpty()){
            for (int i = 0; i <= familyList.size() - 1; i++){
                System.out.println("======Family======");
                System.out.println(familyList.get(i));
            }
        }
        if (!luxuryList.isEmpty()){
            for (int i = 0; i <= luxuryList.size() - 1; i++){
                System.out.println("======Luxury======");
                System.out.println(luxuryList.get(i));
            }
        }
        if (!sportList.isEmpty()){
            for (int i = 0; i <= sportList.size() - 1; i++) {
                System.out.println("======Sport======");
                System.out.println(sportList.get(i));
            }
        }
        System.out.println("E = Edit cars | D = Delete cars | B = Back");
        String option = input.next();
        if (option.equalsIgnoreCase("e")){
            System.out.println("Give the ID of the car you would like to edit");
            int chooseID = input.nextInt();
            editCar(filehandler, input, chooseID);
        }else if (option.equalsIgnoreCase("d")){
            System.out.println("Give the ID of the car you would like to delete");
            int chooseID = input.nextInt();
            deleteCar(filehandler, input, chooseID);
        }else{
            mainmenu(filehandler, input);
        }
    }

    public static void showRental(FileHandler filehandler, Scanner input){
        System.out.println("======Show Rentals======");
        if(filehandler.getRentalList().isEmpty()){
            System.out.println("There's no rentals");
        }else{
            for (int i = 0; i<= filehandler.getRentalList().size()-1; i++){
                filehandler.getRentalList().get(i);
            }
        }
        System.out.println("E = Edit / D = Delete / B = Back");
        String option = input.next();
        if(option.equalsIgnoreCase("e")){
            System.out.println("Please select ID: ");
            int selectedID = input.nextInt();
            editRental(filehandler, input, selectedID);
        }else if(option.equalsIgnoreCase("d")){

        }else{
            showMenu(filehandler, input);
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
        System.out.println("======Company Customers======");
        for (int i = 0; i<= companyCustomerList.size() -1; i++){
            System.out.println(companyCustomerList.get(i));
        }
        System.out.println("======Private Customers======");
        for (int i = 0; i<= privateCustomerList.size() -1; i++){
            System.out.println(privateCustomerList.get(i));
        }
        System.out.println("E = Edit / D = Delete / B = Back");
        String option = input.next();
        if(option.equalsIgnoreCase("e")){
            System.out.println("Please select ID");
            int selectedID = input.nextInt();
            editCustomer(filehandler, input, selectedID);
        }else if(option.equalsIgnoreCase("d")){

        }else{
            showMenu(filehandler, input);
        }
    }

    public static void createCustomer(FileHandler filehandler, Scanner input, Boolean redirectBackToMenu){
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
        if(redirectBackToMenu == true){
            if(option.equalsIgnoreCase("y")){
                createCar(filehandler,input);
            }else if(option.equalsIgnoreCase("n")){
                createMenu(filehandler, input);
            }
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
        String carPlateNumber = input.next();
        System.out.println("Enter registration date");
        String carRegistrationDate = input.next();
        System.out.println("Enter how many km the car has driven (odometer)");
        int carOdometer = input.nextInt();
        if (carType.equalsIgnoreCase("F")){
            Family tempFamily = new Family(newID, carBrand, carModel, carFuelType, carPlateNumber, carRegistrationDate, carOdometer, true, true, true, true);
            filehandler.getCarList().add(tempFamily);
        } else if (carType.equalsIgnoreCase("L")){
            Luxury tempLuxury = new Luxury(newID, carBrand, carModel, carFuelType, carPlateNumber, carRegistrationDate, carOdometer, true, true, true, true);
            filehandler.getCarList().add(tempLuxury);
        } else if (carType.equalsIgnoreCase("S")){
            Sport tempSport = new Sport(newID, carBrand, carModel, carFuelType, carPlateNumber, carRegistrationDate, carOdometer, true, true);
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
        int selectedCustomerID = 0;

        ArrayList<Family> familyList = new ArrayList<>();
        ArrayList<Luxury> luxuryList = new ArrayList<>();
        ArrayList<Sport> sportList = new ArrayList<>();

        for (int i = 0; i <= filehandler.getCarList().size() - 1; i++){
            if (filehandler.getCarList().get(i).getClass().getName() == "Family"){
                familyList.add((Family) filehandler.getCarList().get(i));
            }else if (filehandler.getCarList().get(i).getClass().getName() == "Luxury"){
                luxuryList.add((Luxury) filehandler.getCarList().get(i));
            }else if (filehandler.getCarList().get(i).getClass().getName() == "Sport"){
                sportList.add((Sport) filehandler.getCarList().get(i));
            }
        }

        System.out.println("======Create Rental======");
        System.out.println("Select or create a new customer (S = Select / C = Create)");
        String choice = input.next();
        if(choice.equalsIgnoreCase("s")){
            for (int i = 0; i <= filehandler.getCustomerList().size() -1; i++){
                System.out.println(filehandler.getCustomerList().get(i).getCustomerID() + " " + filehandler.getCustomerList().get(i).getName());
            }
            System.out.println("Select the customer by ID: ");
            selectedCustomerID = input.nextInt();
            selectedCustomer = filehandler.getCustomerByID(selectedCustomerID);
        }else if(choice.equalsIgnoreCase("c")){
            int newCustomerID = getFreeCustomerID(filehandler);
            createCustomer(filehandler, input, false);
            selectedCustomer = filehandler.getCustomerByID(newCustomerID);
            selectedCustomerID = newCustomerID;
        }
        System.out.println(selectedCustomer.getName() + " has been selected");
        System.out.println("======Family======");
        if(familyList.size() == 0){
            System.out.println("There's no family car");
        }else{
            for (int i = 0; i <= familyList.size() - 1; i++){
                System.out.println(familyList.get(i));
            }
        }
        System.out.println("======Luxury======");
        if(luxuryList.size() == 0){
            System.out.println("There is no luxury car");
        }else {
            for (int i = 0; i <= luxuryList.size() - 1; i++){
                System.out.println(luxuryList.get(i));
            }
        }
        System.out.println("======Sport======");
        if (sportList.size() == 0){
            System.out.println("There is no sport car");
        }else{
            for (int i = 0; i <= sportList.size() - 1; i++){
                System.out.println(sportList.get(i));
            }
        }
        System.out.println("Please select car by id");
        int selectedCarID = input.nextInt();
        System.out.println("Enter start date");
        String startDate = input.next();
        System.out.println("Enter end date");
        String endDate = input.next();
        System.out.println("Enter max KM");
        int maxKM = input.nextInt();

        int odometer = filehandler.getCarByID(selectedCarID).getOdometer();
        String platenumber = filehandler.getCarByID(selectedCarID).getPlateNumber();

        Rental newRental = new Rental(getFreeRentalID(filehandler), selectedCustomerID, selectedCarID, startDate, endDate, maxKM, odometer, platenumber);
        System.out.println(newRental);
        System.out.println("Does this look good? (Y = yes / Redo = R / C = Cancel");
        String option = input.next();
        if(option.equalsIgnoreCase("y")){
            filehandler.getRentalList().add(newRental);
            createMenu(filehandler, input);
        }else if(option.equalsIgnoreCase("r")){
            createRental(filehandler,input);
        }else if(option.equalsIgnoreCase("c")){
            createMenu(filehandler,input);
        }
    }

    // Skal have lavet edit customer
    public static void editCustomer(FileHandler filehandler, Scanner input, int selectedID){
        int index = 0;
        Customer selectedCustomer = new Customer();

        for(int i = 0; i <= filehandler.getCustomerList().size() -1; i++){
            if(selectedID == filehandler.getCustomerList().get(i).getCustomerID()){
                index = i;
                selectedCustomer = filehandler.getCustomerList().get(i);
            }
        }

        System.out.println("Change name from: " + selectedCustomer.getName());
        String newName = input.next();
        if (newName != "0"){
            selectedCustomer.setName(newName);
        }

        System.out.println("Change address from: " + selectedCustomer.getAddress());
        String newAddress = input.next();
        if (newAddress != "0"){
            selectedCustomer.setAddress(newAddress);
        }
        System.out.println("Change zip-code from" + selectedCustomer.getZip_code());
        int newZipcode = input.nextInt();
        if(newZipcode != 0){
            selectedCustomer.setZip_code(newZipcode);
        }
        System.out.println("Change city from: " + selectedCustomer.getCity());
        String newCity = input.next();
        if(newCity != "0"){
            selectedCustomer.setCity(newCity);
        }
        System.out.println("Change mobile number from: " + selectedCustomer.getMobile_number());
        int newMobileNumber = input.nextInt();
        if(newMobileNumber != 0){
            selectedCustomer.setMobile_number(newMobileNumber);
        }

        System.out.println("Change phone number from: " + selectedCustomer.getPhone_number());
        int newPhoneNumber = input.nextInt();
        if(newPhoneNumber != 0){
            selectedCustomer.setPhone_number(newPhoneNumber);
        }

        System.out.println("Change email from: " + selectedCustomer.getEmail());
        String newEmail = input.next();
        if(newEmail != "0"){
            selectedCustomer.setEmail(newEmail);
        }
        if(selectedCustomer.getClass().getName() == "PrivateCustomer"){
            System.out.println("Change car license number from: " + ((PrivateCustomer) selectedCustomer).getLicenseNumber());
            int newCarLicenseNumber = input.nextInt();
            if(newCarLicenseNumber != 0){
                ((PrivateCustomer) selectedCustomer).setLicenseNumber(newCarLicenseNumber);
            }

            System.out.println("Change drivers acquired license date");
            String newDriverSinceDate = input.next();
            if(newCarLicenseNumber != 0){
                ((PrivateCustomer) selectedCustomer).setDriver_since_date(newDriverSinceDate);
            }
        }else if(selectedCustomer.getClass().getName() == "CompanyCustomer") {
            System.out.println("Change company name from: " + ((CompanyCustomer) selectedCustomer).getCompany_name());
            String newCustomerName = input.next();
            if(newCustomerName != "0"){
                ((CompanyCustomer) selectedCustomer).setCompany_name(newCustomerName);
            }
            System.out.println("Change company address from: " + ((CompanyCustomer) selectedCustomer).getCompany_address());
            String newCustomerAddress = input.next();
            if(newCustomerAddress != "0"){
                ((CompanyCustomer) selectedCustomer).setCompany_address(newCustomerAddress);
            }
            System.out.println("Change company phone number from: " + ((CompanyCustomer) selectedCustomer).getCompany_phone_number());
            int newCustomerPhoneNumber = input.nextInt();
            if(newCustomerPhoneNumber != 0){
                ((CompanyCustomer) selectedCustomer).setCompany_phone_number(newCustomerPhoneNumber);
            }
            System.out.println("Change company CRN from: " + ((CompanyCustomer) selectedCustomer).getCRN());
            int newCustomerCRN = input.nextInt();
            if(newCustomerCRN != 0){
                ((CompanyCustomer) selectedCustomer).setCRN(newCustomerCRN);
            }
        }
        System.out.println("The new Customer looks like this:\n" + selectedCustomer + "\nPlease confirm (Y = Yes / R = Redo edit / C = Cancel)");
        String option = input.next();
        if(option.equalsIgnoreCase("y")){
            filehandler.getCustomerList().set(index, selectedCustomer);
            System.out.println(selectedCustomer.getName() + " Has been edited");
            showCustomer(filehandler, input);
        }else if(option.equalsIgnoreCase("r")){
            editCustomer(filehandler, input, selectedID);
        }else{
            showCustomer(filehandler, input);
        }


    }

    // Laver videre senere
    public static void editRental(FileHandler filehandler, Scanner input, int selectedID){
        int index = 0;
        Rental selectedRental = new Rental();

        for (int i = 0; i <= filehandler.getRentalList().size() -1; i++){
            if(selectedID == filehandler.getRentalList().get(i).getRentalID()){
                index = i;
                selectedRental = filehandler.getRentalList().get(i);
            }
        }

        System.out.println("Change the customer from: " + filehandler.getCustomerByID(selectedRental.getCustomerID()).getName());
        for (int i = 0; i<= filehandler.getCustomerList().size() -1; i++){
            System.out.println(filehandler.getCustomerList().get(i).getCustomerID() + " " + filehandler.getCustomerList().get(i).getName());
        }
        System.out.println("Select new customer by ID");
        int newCustomerID = input.nextInt();
        if(newCustomerID != 0){
            selectedRental.setCustomerID(newCustomerID);
        }
        System.out.println("Change the car from: " + filehandler.getCarByID(selectedRental.getCarID()).getCarID() + " " + filehandler.getCarByID(selectedRental.getCarID()).getModel());
        for (int i = 0; i <= filehandler.getCarList().size() -1; i++){
            System.out.println(filehandler.getCarList().get(i).getCarID() + " " + filehandler.getCarList().get(i).getModel());
        }
        System.out.println("Select the new Car by ID");

    }

    public static void editCar(FileHandler fileHandler, Scanner input, int chooseID){
        Car tempCar = new Car();
        int indexNumber = 0;

        for (int i = 0; i <= fileHandler.getCarList().size() - 1; i++){
            if (fileHandler.getCarList().get(i).getCarID() == chooseID){
                tempCar = fileHandler.getCarList().get(i);
                indexNumber = i;
            }
        }
        System.out.println("Change brand from: " + tempCar.getBrand() + " to: ");
        String newBrand = input.next();
        if (!newBrand.equalsIgnoreCase("0")){
            tempCar.setBrand(newBrand);
        }
        System.out.println("Change model from: " + tempCar.getModel() + " to: ");
        String newModel = input.next();
        if (!newModel.equalsIgnoreCase("0")){
            tempCar.setModel(newModel);
        }
        System.out.println("Change fuel type from: " + tempCar.getFuelType() + " to: ");
        String newFuelType = input.next();
        if (!newFuelType.equalsIgnoreCase("0")){
            tempCar.setFuelType(newFuelType);
        }
        System.out.println("Change plate number from: " + tempCar.getPlateNumber() + " to: ");
        String newPlateNumber = input.next();
        if (newPlateNumber != "0"){
            tempCar.setPlateNumber(newPlateNumber);
        }
        System.out.println("Change registration date from: " + tempCar.getRegistrationDate() + " to: ");
        String newRegistrationDate = input.next();
        if (!newRegistrationDate.equalsIgnoreCase("0")){
            tempCar.setRegistrationDate(newRegistrationDate);
        }
        System.out.println("Change odometer from: " + tempCar.getOdometer() + " to: ");
        int newOdometer = input.nextInt();
        if (newOdometer != 0){
            tempCar.setOdometer(newOdometer);
        }
        System.out.println("Confirm these changes?\n" + tempCar + "\nPress Y: for yes\nPress N: to remake\nPress C: to show car");
        String ans = input.next();
        if (ans.equalsIgnoreCase("y")){
            fileHandler.getCarList().set(indexNumber, tempCar);
            System.out.println("Edited Car: \n" + fileHandler.getCarList().get(indexNumber));
        } else if (ans.equalsIgnoreCase("n")){
            editCar(fileHandler, input, chooseID);
        } else if (ans.equalsIgnoreCase("c")){
            showCar(fileHandler, input);
        } else {
            System.out.println("Invalid input");
            showCar(fileHandler, input);
        }
    }

    public static void deleteCar(FileHandler filehandler, Scanner input, int selectedID){

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

    public static int getFreeRentalID(FileHandler fileHandler){
        ArrayList<Integer> usedRentalID = new ArrayList<>();

        for (int i = 0; i <= fileHandler.getRentalList().size() - 1; i++){
            usedRentalID.add(fileHandler.getRentalList().get(i).getRentalID());
        }
        int newID = 1;

        if (usedRentalID.size() != 0){
            newID = Collections.max(usedRentalID) +1;
        }
        return newID;
    }
}
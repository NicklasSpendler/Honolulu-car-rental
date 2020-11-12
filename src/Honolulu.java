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

        Contract contract1 = new Contract(1, 1, 2, "lol", "lol", 2, 2, 2);
        filehandler.getContractList().add(contract1);

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
        System.out.println("S = Show Data\nC= Create Data\nQ = Quit");

        String choice = input.next();
        if(choice.equalsIgnoreCase("s")){
            showMenu(filehandler, input);
        }else if(choice.equalsIgnoreCase("c")){
            createMenu(filehandler, input);
        }
    }

    public static void showMenu(FileHandler filehandler, Scanner input){
        System.out.println("C = Show Cars\nU = Show Customers\nR = Show rentals");

        String choice = input.next();
        if(choice.equalsIgnoreCase("c")){
            showCar(filehandler, input);
        }else if(choice.equalsIgnoreCase("u")){

        }else if(choice.equalsIgnoreCase("r")){

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

        }else if(choice.equalsIgnoreCase("B")){
            mainmenu(filehandler, input);
        }else{
            mainmenu(filehandler, input);
        }
    }

    public static void showCar(FileHandler filehandler, Scanner input){
        System.out.println("======Car======");
        if(filehandler.getCarList().size() == 0){
            System.out.println("There's no cars in the system.");
        }else{
            for (int i = 0; i <= filehandler.getCarList().size() - 1; i++){
                System.out.println(filehandler.getCarList().get(i));
            }
        }
    }

    public static void createCustomer(FileHandler filehandler, Scanner input){
        int newID = getFreeCustomerID(filehandler);


        System.out.println("======Create Customer======");
        System.out.println("Which type of customer? P = Private / C = Company");
        String customerType = input.next();

        if(customerType.equalsIgnoreCase("P")){
            System.out.println("Private customer Chosen\nWrite Customer Name:");
        }else if(customerType.equalsIgnoreCase("c")){
            System.out.println("Private customer Chosen\nWrite Customer Name:");
        }
        String customerName = input.next();
        System.out.println("Write Customers address:");
        String customerAddress = input.next();
        System.out.println("Write Customers Zip-code:");
        int customerZipcode = input.nextInt();
        System.out.println("Write Customer City:");
        String customerCity = input.next();
        System.out.println("Write Customer mobile number");
        int customerMobileNumber = input.nextInt();
        System.out.println("Write Customer phone number");
        int customerPhoneNumber = input.nextInt();

    }

    public static void createCar(FileHandler filehandler, Scanner input){
        System.out.println("======Create Car======");

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

}
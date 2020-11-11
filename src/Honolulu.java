import java.util.ArrayList;

public class Honolulu {
    public static void main(String[] args) {
        FileHandler filehandler = new FileHandler();

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
        System.out.println(filehandler.getContractList());
    }
}
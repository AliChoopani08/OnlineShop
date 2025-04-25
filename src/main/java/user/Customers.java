package user;

import java.util.HashMap;
import java.util.Map;

public class Customers extends Users{

    public static Map<String , Customers> customerDateBase=new HashMap<>();

    public Customers(String phoneNumber, String userName, String password, int stock) {
        super(phoneNumber,userName, password, stock);
    }

    static {
        addPerson("09330825474", "Ali Choopani","Ali.Choopani_@13", 2500000);
        addPerson("09365462541","Hasan Sadeghi","Hasan.@28",800000);
        addPerson("09367854629", "Fatemeh Majd","Majd@F#.",1500000);
        addPerson("09217365201", "Hoseyn mohammadi","14@Hosseyn",500000);
    }


    private static void addPerson(String phoneNumber,String userName, String password, int stock){
        final Customers customer = new Customers(phoneNumber, userName, password, stock);
        customer.setPhoneNumber(phoneNumber);
        customer.setUserName(userName);
        customer.setPassword(password);
        customer.setStock(stock);
        customerDateBase.put(phoneNumber + ":" + password, customer);
    }
}

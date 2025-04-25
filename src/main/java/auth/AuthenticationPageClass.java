package auth;

import example.InputAndOutput;
import user.Customers;
import user.Users;
import java.util.Map;
import java.util.Optional;
import static example.ConsoleColor.*;

public class AuthenticationPageClass implements Manage_authentication_pageClass{


    private final InputAndOutput io;

    public AuthenticationPageClass(InputAndOutput io) {
        this.io=io;
    }


  public Customers sign_in(Map<String , Customers > customerDateBase){
        io.nextLine();
      io.println(YELLOW + "Enter your phone number" + RESET);
      String phoneNumberInput= io.nextLine();
     io.println(YELLOW + "Enter your password" + RESET);
      String passwordInput= io.nextLine();
      String keyInfo=phoneNumberInput + ":" + passwordInput;
      Optional<Customers> findCustomer=
              Optional.ofNullable(customerDateBase.get(keyInfo));
      findCustomer.ifPresentOrElse(acc->
              io.println( "Welcome "+acc)
              ,
              ()-> io.println(RED + "Account there's no !!" + RESET));
      return findCustomer.orElse(null);
  }

   public Customers sign_up(Map<String , Customers > customersDateBase2){
           final Users usersClass = new Users();
           String phoneNumber, userName, password;
           int stock;
           while (true){
            phoneNumber = usersClass.setPhoneNumber(readInput(io, "Enter your phone number..."));
            userName = usersClass.setUserName(readInput(io, "Enter your user name..."));
            password = usersClass.setPassword(readInput(io, "Enter your password..."));
           io.println(YELLOW + "Enter your stock..." + RESET);
            stock = io.nextInt();

               if (phoneNumber != null && userName != null && password != null && stock != 0)
                   break;
               else
                   io.println(RED + "Please insert empty spaces with correct values ! " + RESET);
           }
           final Customers customer = new Customers(phoneNumber, userName, password, stock);
           customersDateBase2.put(customer.getPhoneNumber() + " : " + customer.getPassword(), customer);
           io.println("Welcome " + userName);
           return customer;
   }
   private String readInput(InputAndOutput io, String message){
       io.println(YELLOW + message + RESET);
       return io.nextLine();
   }


}

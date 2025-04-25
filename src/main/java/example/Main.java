package example;

import auth.AuthenticationPageClass;
import auth.Manage_authentication_pageClass;
import auth.SignInClass;
import auth.SignUpClass;
import exceptions.InputInvalid;
import seeProduct.BuySelectedProduct;
import seeProduct.ManageProductsActions;
import seeProduct.ProductsActions;
import user.Customers;

import static example.ConsoleColor.*;
import static example.ConsoleColor.RESET;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        final static InputAndOutput io = new InputAndOutput();
       static Manage_authentication_pageClass manageAuthentication =new AuthenticationPageClass(io);

    public static void main(String[] args) {

        final SignInClass signInClass = new SignInClass(manageAuthentication);

        final SignUpClass signUpClass = new SignUpClass(manageAuthentication);

        ProductsActions productsActions=new ManageProductsActions(io);

        final BuySelectedProduct buySelectedProduct = new BuySelectedProduct(productsActions);

        io.println(YELLOW + "Please specify..... \n1. I have an account ,  2. I don't have an account" + RESET);
           int answer = io.nextInt();

           if (answer==1 || answer==2) {
               switch (answer) {
                   case 1:
                       final Customers customers = signInClass.signIn();
                       if (customers!= null)
                       buySelectedProduct.buySelectedProduct();
                       else
                           createNewAccountIfAccoutnThereIsNo();
                       buySelectedProduct.buySelectedProduct();
                       break;
                   case 2:
                       signUpClass.signUp();
                       buySelectedProduct.buySelectedProduct();
               }
           }else
               throw new InputInvalid(RED + "Your input is invalid !!" + RESET);


    }

    private static void createNewAccountIfAccoutnThereIsNo(){
        io.println(YELLOW + "Do you want to create new account ?" + RESET);
        String answer;
        while (true){
            answer=io.nextLine();
            if (answer.equalsIgnoreCase("yes")){
                final SignUpClass signUpClass = new SignUpClass(manageAuthentication);
                signUpClass.signUp();
                break;
            }
            else if (answer.equalsIgnoreCase("no")){
                io.println("Request canceled.");
                break;
            }
            else
                io.println(RED + "Your answer is invalid !! \n Please try again...." + RESET);

        }
    }
}
package user;

import java.util.logging.Logger;

public class Users {
    protected  String phoneNumber;
    protected  String userName;
   protected  String password;
   protected  int stock;

    private static final Logger logger=Logger.getLogger(Users.class.getName());

    public Users(){}
    public Users(String phoneNumber, String userName, String password, int stock) {
        this.phoneNumber = phoneNumber;
        this.userName=userName;
        this.password = password;
       this.stock = stock;
    }

//---------------------------------------------------
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String setPhoneNumber(String phoneNumber){
        final int numberOfCharactersInPhoneNumber=11;
     if (phoneNumber.startsWith("09") && phoneNumber.length()==numberOfCharactersInPhoneNumber)
          return this.phoneNumber=phoneNumber;
     else {
         logger.warning("Your phone number is invalid !!");
         return null;
     }
    }

    //---------------------------------------------------


    public String setUserName(String userName) {
       return this.userName = userName;
    }

    //--------------------------------------

    public String getPassword() {
        return password;
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$";
       return password.matches(regex);
    }

    public String setPassword(String password){
        if (isValidPassword(password))
          return this.password = password;
        else
            logger.warning("Your password should be combined from (a-z),(A-Z)," +
                    "(At least has a number),(Use from punctuation marks),(Should be more 8 character).");

        return "Your password is invalid !!";
    }
    //-----------------------------------------------------

    public void setStock(int stock) {
        if (stock > 0)
        this.stock = stock;
        else
            logger.warning("Stock should not be negative or zero !!");
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", stock=" + stock +
                '}';
    }
}

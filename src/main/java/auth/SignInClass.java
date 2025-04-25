package auth;

import user.Customers;

public class SignInClass {
   private final Manage_authentication_pageClass manageAuthenticationPageClass;

    public SignInClass(Manage_authentication_pageClass manageAuthenticationPageClass){
        this.manageAuthenticationPageClass=manageAuthenticationPageClass;
    }
    public Customers signIn(){
      return   manageAuthenticationPageClass.sign_in(Customers.customerDateBase);
    }
}

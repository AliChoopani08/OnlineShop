package auth;

import user.Customers;

public class SignUpClass {
    private final Manage_authentication_pageClass manageAuthenticationPageClass;

    public SignUpClass(Manage_authentication_pageClass manageAuthenticationPageClass) {
        this.manageAuthenticationPageClass = manageAuthenticationPageClass;
    }

    public Customers signUp(){
       return manageAuthenticationPageClass.sign_up(Customers.customerDateBase);
    }
}

package auth;

import user.Customers;
import java.util.Map;

public interface Manage_authentication_pageClass {
    Customers sign_in(Map<String , Customers> customerDateBase);
    Customers sign_up(Map<String , Customers > customerDateBase);}

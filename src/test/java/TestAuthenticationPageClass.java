import auth.AuthenticationPageClass;
import auth.Manage_authentication_pageClass;
import auth.SignInClass;
import auth.SignUpClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user.Customers;
import user.Users;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAuthenticationPageClass {

    private Users users;
    Manage_authentication_pageClass manageAuthenticationPageClass;

    @BeforeEach
    void setUp(){
        users=new Users();
         manageAuthenticationPageClass = mock(AuthenticationPageClass.class);
    }
    @Test
    void should_test_add_user_name_method() {
        String inputUserName="AliChoopani_18";

        final String userName = users.setUserName(inputUserName);

        assertThat(Objects.equals(userName, inputUserName)).isTrue();
    }

    @Test
    void should_test_add_password_methode() {
        String inputPassword="Ali.choopani@-18";

        final String password = users.setPassword(inputPassword);

        assertThat(Objects.equals(password, inputPassword)).isTrue();
    }

    @Test
    void should_test_createNewAccount_method_of_authentication_page_class() {
        final SignUpClass signUpClass = new SignUpClass(manageAuthenticationPageClass);

        Customers fakeCustomer=new Customers("09330825474","AliChoopani","Ali.87.@",500000);

        when(signUpClass.signUp()).thenReturn(fakeCustomer);

        assertThat(signUpClass.signUp()).isEqualTo(fakeCustomer);
    }

    @Test
    void should_test_loginOrSing_method_of_authentication_page_class() {
        final SignInClass signInClass = new SignInClass(manageAuthenticationPageClass);

        Customers customer1 = new Customers("09330825474", "AliChoopani", "Ali.87.@", 500000);
        final Customers customer2 = new Customers("Mohammad", "Mohamman_21", "M.sobhan_@", 30000);

        Map<String, Customers> fakeMapOfCustomers = new HashMap<>();
        fakeMapOfCustomers.put(customer1.getPhoneNumber() + ":" + customer2.getPassword(), customer1);
        fakeMapOfCustomers.put(customer2.getPhoneNumber() + ":" + customer2.getPassword(), customer2);

        when(signInClass.signIn()).thenReturn(customer2);

        assertThat(signInClass.signIn()).isEqualTo(customer2);

    }
}

package axsos.academy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserAuthenticationTest {

    private final UserAuthentication auth = new UserAuthentication();

    @DataProvider(name = "Cases")
    public Object[][] Cases() {
        return new Object[][]{
                {"admin", "password123", true},
                {"admin", "wrong", false},
                {"user", "password123", false},
                {"user", "wrong", false},
                {"", "password123", false},     
                {"admin", "", false},          
                {null, "password123", false},   
                {"admin", null, false},         
                {null, null, false},            
                {" ADMIN ", "password123", false}
        };
    }

    @Test(dataProvider = "Cases")
    public void authenticate(String username, String password, boolean expected) {
        boolean actual = auth.authenticate(username, password);
        Assert.assertEquals(actual, expected,
                "Mismatch for username=" + username + ", password=" + password);
    }
}

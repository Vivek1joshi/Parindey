
package testcases.android;
import org.springframework.context.annotation.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.TestBase;
import screens.androidpageobjects.Logout;
import screens.androidpageobjects.SignIn;


public class ParindeyLoginTest extends TestBase {
    public SignIn LandingPage = new SignIn();
    public Logout LogoutPage = new Logout();
    @Test(priority = 1, enabled = true)
    @Description("Verify Valid login for Parindey")
    @Parameters({"entername", "bornplace"})
    public void verifyValidLogin(String entername,String bornplace) throws Exception {
        LandingPage.SignUp(entername,bornplace);
    }
    @Test(priority = 2, enabled = true)
    @Description("Logout from Parindey")
    public void verifyLogout()  throws Exception {
       LogoutPage.logout();
   }
}
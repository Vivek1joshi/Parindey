package testcases.android;
import base.TestBase;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.androidpageobjects.FindTravelPartner;
import screens.androidpageobjects.SignIn;


public class VerifyFindTravelPartner extends TestBase{
   public SignIn LoginPage = new SignIn();
   public FindTravelPartner TravelPartner = new FindTravelPartner();
    @Test(priority = 1, enabled = true)
    @Description("Verify Valid login for Parindey")
    @Parameters({"entername", "bornplace"})
    public void verifyValidLogin(String entername,String bornplace) throws Exception {
        LoginPage.SignUp(entername,bornplace);
    }
    @Test(priority = 2, enabled = true)
    @Description("Logout from Parindey")
    @Parameters({"writeplan"})
    public void verifyLogout(String writeplan)  throws Exception {
       TravelPartner.ClickOnPlusTab();
       TravelPartner.TravelPartner(writeplan);
    }
}

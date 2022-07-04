package testcases.android;

import base.TestBase;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.androidpageobjects.EditParindeyProfile;
import screens.androidpageobjects.FilterModule;
import screens.androidpageobjects.SignIn;

public class VerifyFilterModule extends TestBase {
    public SignIn LandingPage = new SignIn();
    public FilterModule Filter = new FilterModule ();
    @Test(priority = 1, enabled = true)
    @Description("Verify Valid login for Parindey")
    @Parameters({"entername", "bornplace"})
    public void verifyValidLogin(String entername,String bornplace) throws Exception {
        LandingPage.SignUp(entername,bornplace);
    }
    @Test(priority = 2,enabled = true)
    @Description("Click on search tab")
    public void verifyFilter()
    {
        Filter.ApplyFilter();
        Filter.ClearFilter();
    }
}


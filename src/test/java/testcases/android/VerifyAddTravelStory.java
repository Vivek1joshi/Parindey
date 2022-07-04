package testcases.android;
import base.TestBase;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import screens.androidpageobjects.AddStory;
import screens.androidpageobjects.SignIn;
public class VerifyAddTravelStory extends TestBase {
    public SignIn LandingPage = new SignIn();
    public AddStory story = new AddStory();
    @Test(priority = 1, enabled = true)
    @Description("Verify Valid login for Parindey")
    @Parameters({"entername", "bornplace"})
    public void verifyValidLogin(String entername,String bornplace) throws Exception {
        LandingPage.SignUp(entername,bornplace);
    }
    @Test(priority = 2,enabled = true)
    @Description("Click on search tab")
    @Parameters({"writestrory"})
    public void verifySearchTab(String writestory) {
        story.ClickOnPlusTab();
        story.AddTravelStory(writestory);
    }
}


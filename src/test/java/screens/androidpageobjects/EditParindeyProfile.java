package screens.androidpageobjects;
import base.ScreenBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EditParindeyProfile extends ScreenBase {
    By Profile = By.xpath("//android.widget.FrameLayout[@index=4]");
    By Click_On_EditButton = By.xpath("//android.widget.Button[@text='EDIT']");
    By Enter_Name = By.xpath("//android.widget.EditText[@resource-id='com.travelpartner.parindey:id/inputName']");
    By Action_Button = By.xpath("//android.widget.ImageButton[@resource-id='com.travelpartner.parindey:id/done_btn']");
    By Enter_Username = By.xpath("//android.widget.EditText[@resource-id='com.travelpartner.parindey:id/inputUsername']");
    By Enter_Bio = By.xpath("//android.widget.EditText[@resource-id='com.travelpartner.parindey:id/inputAbout']");
    By Select_TravellerType = By.xpath("//android.widget.RadioButton[@resource-id='com.travelpartner.parindey:id/local_business']");
    By Click_Location = By.xpath("//android.widget.EditText[@resource-id='com.travelpartner.parindey:id/inputLocation']");
    By Select_Location = By.xpath("//android.widget.EditText[@text='1589 Manor']");
    By Click_Interest = By.xpath("//android.widget.EditText[@resource-id='com.travelpartner.parindey:id/inputInterest']");
    By Select_Interest = By.xpath("//android.widget.CheckBox[@resource-id='com.travelpartner.parindey:id/checkbox']");
    By Click_CheckButton = By.xpath("//android.widget.ImageButton[@resource-id='com.travelpartner.parindey:id/continue_btn']");
    By Click_LanguageButton = By.xpath("//android.widget.EditText[@resource-id='com.travelpartner.parindey:id/inputLanguage']");
    By Select_Language = By.xpath("//android.widget.CheckBox[@index=2]");
    By Switch_Language = By.xpath("//android.widget.CheckBox[@resource-id='com.travelpartner.parindey:id/cardView']");
    By Click_ContinueButton = By.xpath("//android.widget.ImageButton[@resource-id='com.travelpartner.parindey:id/continue_btn']");
    By Click_DoneButton = By.xpath("//android.widget.ImageButton[@resource-id='com.travelpartner.parindey:id/done_btn']");
    @Test
    public void EditProfile(String name) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        String abc = getSaltString();
        driver.findElement(Profile).click();
        driver.findElement(Click_On_EditButton).click();
        driver.findElement(Enter_Name).clear();
        driver.findElement(Enter_Name).click();
        actions.sendKeys(name).build().perform();
        driver.findElement(Action_Button).click();
        driver.findElement(Enter_Username).clear();
        driver.findElement(Enter_Username).click();
        actions.sendKeys(abc).build().perform();
        driver.findElement(Action_Button).click();
        driver.findElement(Enter_Bio).click();
        actions.sendKeys(abc).build().perform();
        driver.findElement(Action_Button).click();
        driver.findElement(Select_TravellerType).click();
        String scrollElement1 = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"1 Interests (Change)\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement1).click();
        String scrollElement2 = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Natural Trails\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement2).click();
        driver.findElement(Click_CheckButton).click();
        driver.findElement(Click_Location).click();
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"3 R Distributary\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.findElement(Click_LanguageButton).click();
        driver.findElement(Click_ContinueButton).click();
        driver.findElement(Click_DoneButton).click();
    }
    @Test
    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }


}

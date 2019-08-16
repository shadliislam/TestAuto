package supportClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUP {

    ProjectWebDriver projectWebDriver;
    WebDriver driver;
    ClickIcon signUpButton;
    ScreenShot screenShot;
    //Xpaths
    //String signInXpath="//input[@id=\"u_0_2\"]";
    String signInXpath="//a[@class='login']";
    String emailXpath="//input[@id=\"email_create\"]";

    //Login Info
    String userName="ishad_29@yahoo.com";
    String firstName="Shadli";
    String lastName="Islam";
    String password="12345678";

    //URLs
    //private String logURl="http://automationpractice.com/index.php";

    public SignUP(String logURl) {
      //  this.logURl = logURl;
        projectWebDriver=new ProjectWebDriver();
        driver=projectWebDriver.getWebDriver();
        this.screenShot = new ScreenShot(driver);
        System.out.println("driver: "+driver);
        driver.get(logURl);
        this.screenShot.CaptureScreenShot("logURl");
        signUpButton=new ClickIcon(driver);
        this.screenShot.CaptureScreenShot("SignUpPage");
    }

    public void doSignUp(){
        signUpButton.clickIcon(signInXpath);
    }


}

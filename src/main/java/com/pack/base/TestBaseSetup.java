package com.pack.base;

/*This the main class for page object model.
Here we will create Webdriver object based on the browser type passed as a parameter in textng.xml file.
We will also need to pass the base page application URL in testng.xml as parameter.
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetup {

    private WebDriver driver;
    static String driverPath="C:\\Users\\shadl\\IdeaProjects\\TestAuto\\src\\main\\java\\com\\pack\\drivers\\chromedriver.exe";


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(String browserType,String appURL) {
        switch (browserType){
            case "chrome":
                driver=initChromeDriver(appURL);
                break;

            case "firefox":
                driver=initFireFoxDriver(appURL);
                break;
                default:
                    System.out.println("browser: "+browserType+ "is invalid, launchind Chrome as browser of choice..");
                    driver=initChromeDriver(appURL);

        }
    }

    private static WebDriver initChromeDriver(String appURL){
        System.out.println("Launching google chrome with new profile..");

        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to(appURL);

        return driver;

    }
    private static WebDriver initFireFoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.navigate().to(appURL);

        return driver;
    }

    @Parameters({"browserType","appURL"})

    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL){
        try {
            setDriver(browserType,appURL);
        }catch (Exception e){
            System.out.println("Error...."+ e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }




}

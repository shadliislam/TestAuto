package supportClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;

public class Methods{
    WebDriver driver;

    //Methods for the automation framework
    //this method is used for loading webdriver (Chrome Driver)
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shadl\\IdeaProjects\\TestAuto\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        this.driver=driver;
        return driver;
    }

    //for clicking any clickable webelement by providing its xpath
    public void clickIcon(String xpath){
        this.driver=driver;
        try{
            WebDriverWait wait=new WebDriverWait(driver,20);
            WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            ele.click();
        }
        catch(Exception e){
            System.out.println("not clickable"+e);
        }
    }


    // This method captures the screenshot of the page everytime its called
    public void CaptureScreenShot(String fileName) {
        this.driver=driver;
        String destPath="C:\\Users\\shadl\\IdeaProjects\\TestAuto\\src\\main\\logReports\\";
        //driver.get(url);
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(destPath + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
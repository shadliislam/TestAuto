package supportClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickIcon {

    ProjectWebDriver projectWebDriver;
    WebDriver driver;

    public ClickIcon() {
        projectWebDriver=new ProjectWebDriver();
        driver=projectWebDriver.getWebDriver();
    }

    public ClickIcon(WebDriver driver) {
        this.driver = driver;
    }

    public void clickIcon(String xpath){

        try{
            WebDriverWait wait=new WebDriverWait(driver,20);
            WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            ele.click();
        }
        catch(Exception e){
            System.out.println("not clickable"+e);
        }
    }
}

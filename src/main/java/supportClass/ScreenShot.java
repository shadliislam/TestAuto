package supportClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot{

    ProjectWebDriver projectWebDriver;
    WebDriver driver;
    String destPath="C:\\Users\\shadl\\IdeaProjects\\TestAuto\\src\\main\\logReports\\";

    public ScreenShot() {
        projectWebDriver=new ProjectWebDriver();
        driver=projectWebDriver.getWebDriver();
    }
    public ScreenShot(WebDriver driver){
        this.driver=driver;
    }

    public void CaptureScreenShot(String fileName) {

        //driver.get(url);
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src,new File(this.destPath+fileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }




}




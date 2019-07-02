package ru.sberbank;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class TestLogin extends JUnitHTMLReporter{

    Loginform loginform;
    WebDriver webDriver;
    Wait wait;


    @Before
    public void gotoonline(){
        System.setProperty("webdriver.chrome.driver", "/Users/serg/Desktop/chromedriver-2");
        webDriver =  new ChromeDriver();
        loginform = new Loginform(webDriver);
        wait = new WebDriverWait(webDriver, 30);



    }

    @Test
    public void logintestfalce(){
        webDriver.get("https://boka.hertzfleetservices.se");
        driver.findElement(By.cssSelector("a[href*='#/vehicles/2']")).click();

//        loginform.clickonline();
//
//        loginform.setlogin(generateString());
//
//        System.out.print(generateString()+"\n");
//
//        loginform.setpass(generateString());
//
//        System.out.print(generateString());
//
//        loginform.clicksubmit();
//
//        loginform.accessdenied();
//
//        try {
//            getscreen();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Test
    public void logintestfalce2(){

        loginform.clickonline();

        loginform.setlogin(generateString());

        System.out.print(generateString()+"\n");

        loginform.setpass(generateString());

        System.out.print(generateString());

        loginform.clicksubmit();

        loginform.accessdenied();

        try {
            getscreen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @After
    public void close () {

        webDriver.quit();
    }


    public void getscreen() throws IOException {
        File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File(("test/test.png")));

    }
    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return  uuid;
    }

}

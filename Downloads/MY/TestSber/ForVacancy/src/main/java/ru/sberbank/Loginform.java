package ru.sberbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;

public class Loginform {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath ="//*[@id=\"main\"]/div[1]/div/div/div/div[2]/div[1]/div/div/div[2]/div[2]/a")
    WebElement gotoonline;



    @FindBy(id ="login")
    WebElement filllogin;

    @FindBy(id ="password")
    WebElement fillpassword;

    @FindBy(xpath="//*[@id=\"buttonSubmit\"]/div[1]/button")
    WebElement submit;

    @FindBy(xpath ="//*[@id=\"AccessDenied\"]/div/div/p[1] [contains(text(),'Неверный логин или пароль')]")
    WebElement access;

    public Loginform (WebDriver driver){

        webDriver = driver;
        wait = new WebDriverWait(webDriver, 5);
        PageFactory.initElements(webDriver,this);
    }

    public void clickonline(){
        wait.until(ExpectedConditions.elementToBeClickable(gotoonline));
        gotoonline.click();
    }

    public void setlogin(String login){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        filllogin.sendKeys(login);
    }
    public void setpass(String pass) {

        fillpassword.sendKeys(pass);
    }

    public void clicksubmit(){

        submit.click();
    }

    public void accessdenied(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("AccessDenied")));
      access.isDisplayed();

    }
    }

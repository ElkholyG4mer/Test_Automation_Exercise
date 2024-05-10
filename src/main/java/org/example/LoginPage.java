package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    //Constructor
    public LoginPage (WebDriver driver){this.driver =driver ;}

    //Variables
    private String pageURL = "https://automationexercise.com";

    //Locators
    private By loginNavBar = By.xpath("//a[@href=\"/login\"]");
    private By loginHeader = By.xpath("//div[@class=\"login-form\"]//h2");
    private By registerHeader = By.xpath("//div[@class=\"signup-form\"]//h2");
    private By loginEmailTextBox = By.xpath("data-qa=\"login-email\"");
    private By loginPasswordTextBox = By.xpath("//input[@data-qa=\"login-password\"]");
    private By registerNameTestBox = By.xpath("//input[@data-qa=\"signup-name\"]");
    private By registerEmailTextBox = By.xpath("//input[@data-qa=\"signup-email\"]");
    private By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    private By registerButton = By.xpath("//button[@data-qa=\"signup-button\"]");
    private By optionText = By.xpath("//h2[@class=\"or\"]");
    private By logoutButton = By.xpath("//a[@href='/logout']");

    //Actions
    public void urlNavigation(){
        driver.get(pageURL);
    }

    public void clickLoginNavBar (){
        driver.findElement(loginNavBar).click();
    }

    public void fillLoginData (String email , String password){
        driver.findElement(loginEmailTextBox).clear();
        driver.findElement(loginEmailTextBox).sendKeys(email);
        driver.findElement(loginPasswordTextBox).clear();
        driver.findElement(loginPasswordTextBox).sendKeys(password);
    }

    public void clickLoginButton (){
        driver.findElement(loginButton).click();
    }

    //Assertion
    public void validateLoginHeader (String expectedLoginHeader){
        String actualLoginHeader = driver.findElement(loginHeader).getText();
        Assert.assertEquals(actualLoginHeader,expectedLoginHeader,"Login Header Text Doesn't Match");
    }

    public void validateLoginButton (String expectedLoginButtonText){
        String actualLoginButtonText = driver.findElement(loginButton).getText();
        Assert.assertEquals(actualLoginButtonText,expectedLoginButtonText,"Login Button Text Doesn't Match");
    }

    public void validateLogin (String logoutText){
        String actualText = driver.findElement(logoutButton).getText();
        Assert.assertEquals(actualText,logoutText,"Text Doesn't Match");
    }

}

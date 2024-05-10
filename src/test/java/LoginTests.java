import org.example.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.urlNavigation();
    }

    @Test
    public void validateLogin(){
        loginPage.clickLoginNavBar();
        loginPage.fillLoginData("mostafa@gmail.com","abcd123456");
        loginPage.clickLoginButton();
        loginPage.validateLogin("Logout");
    }

    @AfterTest
    public void tearDown(){
        if(driver != null)
            driver.quit();
    }
}

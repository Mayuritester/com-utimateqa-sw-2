//1. userShouldNavigateToLoginPageSuccessfully()
//* click on the ‘Sign In’ link
//* Verify the text ‘Welcome Back!’
//2. verifyTheErrorMessage()
//* click on the ‘Sign In’ link
//* Enter the invalid username
//* Enter the invalid password
//* Click on the ‘Sign in’ button
//* Verify the error message ‘Invalid email
//or password.’
package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseURL = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        loginLink.click();
        String expectedText = "Welcome Back!";
        WebElement welcomeText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]"));
        String actualText = welcomeText.getText();
        Assert.assertEquals("not varified", expectedText, actualText);

        }
    @Test
    public void verifyTheErrorMessage () {
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        loginLink.click();
        driver.findElement(By.id("user[email]")).sendKeys("mayuri123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("mayuri123");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        String expectedText = "Invalid email or password.";
        WebElement invalidtext = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualText = invalidtext.getText();
        Assert.assertEquals("not error message", expectedText, actualText);

    }

    @After
    public void teardown (){
        driver.quit();
    }
}

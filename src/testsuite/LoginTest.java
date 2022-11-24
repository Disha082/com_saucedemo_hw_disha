package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseurl = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseurl);
    }
     @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){

        //Find Username field and Enter standard_user
         driver.findElement(By.name("user-name")).sendKeys("standard_user");
         //Find password field and Enter secret_sauce
         driver.findElement(By.name("password")).sendKeys("secret_sauce");
         //Clock on Login button
         driver.findElement(By.xpath("//input[@name = 'login-button']")).click();

         //Verify the text "PRODUCTS"
         String expectedMessage = "PRODUCTS";
         WebElement actualTestMessageElement = driver.findElement(By.xpath("//span[text() = 'Products']"));
         String actualMessage = actualTestMessageElement.getText();

         //Validate actual and expected
         Assert.assertEquals(expectedMessage,actualMessage);


     }
     @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
         //Find Username field and Enter standard_user
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
         //Find password field and Enter secret_sauce
         driver.findElement(By.name("password")).sendKeys("secret_sauce");
         //Click on Login button
         driver.findElement(By.xpath("//input[@class = 'submit-button btn_action']")).click();
         //Verify that six products are displayed on page

         List<WebElement> listProducts = driver.findElements(By.className("inventory_item_name")); //class name locators
         int size = listProducts.size();
         System.out.println("Number of products are displayed = " + size);


     }
     @After
    public void tearDown(){
        closeBrowser();
     }


}

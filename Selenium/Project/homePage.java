import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class homePage {
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.name("Login")).click();
    }
    @Test
    public void verifyHomePage() {
        
    	String actualUrl = "https://alchemy.hguy.co/crm/index.php?module=Home&action=index";
    	String expectedUrl = driver.getCurrentUrl();
        
        
        System.out.println("expected Url is: " + expectedUrl);     
        Assert.assertEquals(expectedUrl, actualUrl);
            
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

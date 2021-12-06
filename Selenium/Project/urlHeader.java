import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class urlHeader {
WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        
        //Open browser
        driver.get("https://alchemy.hguy.co/crm/");
//        driver.findElement(By.id("user_name")).sendKeys("admin");
//        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
    }
    @Test
    public void urlHeader() {
        
    	WebElement link = driver.findElement(By.tagName("img"));
    	String urlHeader = link.getAttribute("src");
            
        System.out.println("url Header is: " + urlHeader);        
            
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
	
	
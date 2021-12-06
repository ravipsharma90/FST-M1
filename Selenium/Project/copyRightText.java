import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class copyRightText {
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
    public void copyRightText() {
        
    	WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'© Supercharged by SuiteCRM')]"));
        String text = ele.getText(); 
            
        //Print the title of the page
        System.out.println("copyRight Text is: " + text);
            
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class colorsMenu {
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
    public void colorsNavigationMenu() {
        
    	WebElement wb = driver.findElement(By.xpath("//*[contains(@class, 'desktop-toolbar')]"));
    	
    	String color = wb.getCssValue("background-color");
    	
    	System.out.println("Backgroud color is :" +color);
    	String hex = Color.fromString(color).asHex();
    	System.out.println(hex);
    }
    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class addInfo {
	@Test
	public void addPopUp() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://alchemy.hguy.co/crm/");
	    driver.findElement(By.id("user_name")).sendKeys("admin");
	    driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	    driver.findElement(By.name("Login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement wb = driver.findElement(By.xpath("//a[text()= 'Sales']"));
		Actions act = new Actions(driver);
		
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("//a[text()= 'Sales']/..//a[text()='Leads']")).click();
		
		driver.findElement(By.xpath("//span[@title = 'Additional Details']")).click();
		WebElement web = driver.findElement(By.xpath("//span[text() = '1234567890']"));
		String text = web.getText();
		System.out.println("Text is :" +text);
				
		driver.close();
		
	}
}

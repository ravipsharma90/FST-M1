import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class traversetable2 {

	@Test
	public void TT2() {
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
		List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'list view table-responsive')]/tbody/tr[1]/td"));
        //Get rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'list view table-responsive')]/tbody/tr"));

        for(int i=1; i<=10;i++) {
        	List<WebElement> firstTenRow = driver.findElements(By.xpath("//table[contains(@class, 'list view table-responsive')]/tbody/tr/td[2]"));
        }
        for (int i = 1; i <= 10; i++) {
			
				System.out.print(i + " ");
				WebElement nameCol =  driver.findElement(By.xpath(("(//td[@field='name']//a)["+i+"]")));
				
				String names = nameCol.getText();
				WebElement userCol =  driver.findElement(By.xpath(("(//td[@field='assigned_user_name']//a)["+i+"]")));
				String User = userCol.getText();
				
				System.out.println(names);
				System.out.println(User);
			}
        
		
		driver.close();
	}
}

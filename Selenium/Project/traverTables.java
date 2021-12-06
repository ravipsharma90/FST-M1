import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class traverTables {

	@Test
	public void TT1() {
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
		driver.findElement(By.xpath("//a[text()= 'Sales']/..//a[text()='Accounts']")).click();
		
		        List<WebElement> cols = driver.findElements(By.xpath("//table[contains(@class, 'list view table-responsive')]/tbody/tr[1]/td"));
		        //Get rows
		        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'list view table-responsive')]/tbody/tr"));

		        //Number of columns
		        System.out.println("Number of columns are: " + cols.size());
		        //Number of rows
		        System.out.println("Number of rows are: " + rows.size());

		        for (int i = 1; i <= 10; i++) {
					if (i % 2 != 0) {
						System.out.print(i + " ");
						WebElement oddNames =  driver.findElement(By.xpath(("(//td[@field='name']//a)["+i+"]")));
						String names = oddNames.getText();
						System.out.println(names);
					}
		        }

		driver.close();
	
}
	}

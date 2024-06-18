package projecttowqa;

import java.lang.StackWalker.Option;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v123.css.model.Value;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.api.trace.Span;

public class myTest {
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void setUP() {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		
		
	}
	
	@Test (priority = 1)
	public void myfirstTest() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	}
	
	@Test (priority = 2)
	public void mytest() {
		String expectedResult = "Products";
		String actualResult = driver.findElement(By.xpath("//span[@data-test='title']")).getText();
		Assert.assertEquals(actualResult, expectedResult);
		
	} 
	
	@Test(priority = 3)
	public void filtertest() throws InterruptedException{
		WebElement soso = driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select myselector = new Select (soso);
		myselector.selectByVisibleText("Price (low to high)");	
//		Thread.sleep(3000);
//		driver.navigate().refresh();
//		myselector.selectByValue("az");
//		driver.navigate().refresh();

	}
	
	@Test(priority = 4)
	public void getPrice() {
		String  expectedResult = "$7.99";
		List<WebElement> theprices = driver.findElements(By.className("inventory_item_price"));
		for(int i=0; i<theprices.size(); i++) {
			String actualResult = theprices.get(0).getText();
					Assert.assertEquals(actualResult, expectedResult);
		}
		
	}
	
	@Test(priority = 5)
	public void getenditem() {
		String expectedresult = "$49.99";
		List<WebElement> theenditem = driver.findElements(By.className("inventory_item_price"));
		for (int i=0; i<theenditem.size(); i++) {
			String actualresult= theenditem.get(theenditem.size()-1).getText();
			Assert.assertEquals(actualresult, expectedresult);
		}
	}

}

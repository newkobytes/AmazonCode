package Amazon;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(500000, TimeUnit.MILLISECONDS);
		
		WebElement searchbar = driver.findElement(By.id("twotabsearchtextbox"));
		searchbar.sendKeys("Samsung");
		
		WebElement searchicon = driver.findElement(By.id("nav-search-submit-button"));
		searchicon.click();
		
		System.out.println("All results");
		WebElement txt = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(txt.getText());
		
		
		//List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		//products.size();
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2"));
		products.size();
		
		for(int i=0; i<products.size(); i++)
		{
			System.out.println(products.get(i).getText());
			
		}
		
		//for(WebElement product : products)
		//{
			//System.out.println(product.getText());
		//}
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']"));
		prices.size();
		
		for(WebElement price : prices)
		{
			System.out.println(price.getText());
		}
		
				
		WebElement firstproduct = driver.findElement(By.xpath("//*[@data-image-index='1']"));
		firstproduct.click();
		
		
		String Parentwindow = driver.getWindowHandle();
		System.out.println("Before clicking the tab button the handle is " + Parentwindow);
		String parenttxt= products.get(0).getText();
		
		Set<String> allwindowhandles =driver.getWindowHandles();
		for(String eachwindowhandle : allwindowhandles)
		{
			System.out.println(eachwindowhandle);
			if(!eachwindowhandle.equals(Parentwindow))
			{
				driver.switchTo().window(eachwindowhandle);
				
				WebElement childtxt = driver.findElement(By.xpath("//span[@id='productTitle']"));
				childtxt.getText();
				if(childtxt.getText().equals(parenttxt))
				{
					System.out.println("Matching");
				}
				else
				{
					System.out.println("Not matching");
				}
			}
			else {
				System.out.println("Its a prent window");
				}
		
		}
	}

}

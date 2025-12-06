import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bismillah {

	public static void main(String[] args) {
		
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/client/");

				driver.manage().window().maximize();
				driver.manage().timeouts().getImplicitWaitTimeout();
				

				driver.findElement(By.id("userEmail")).sendKeys("acchu2687@gmail.com");
				driver.findElement(By.id("userPassword")).sendKeys("Safamarwa@786");
				driver.findElement(By.id("login")).click();
				WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'mb-3')]")));
				
				List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));
				System.out.println(products.size());

				 WebElement prod = products.stream().filter(product->
				product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals(product)).findFirst().orElse(null);
				prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
				driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
				driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();
				WebElement textBox=driver.findElement(By.cssSelector("input[value='4542 9931 9292 2293']"));
				textBox.clear();
				textBox.sendKeys("1234567890");
				WebElement staticDropdown= driver.findElement(By.xpath("//body//app-root//select[1]"));
		        Select dropdown= new Select(staticDropdown);
		        dropdown.selectByIndex(4);
		        
		        WebElement dropdown1= driver.findElement(By.xpath("//body//app-root//select[2]"));
		        Select secondDropdown= new Select(dropdown1);
		        dropdown.selectByIndex(4);
				driver.findElement(By.xpath("//div[@class='payment__cc']//div[2]//input[1]")).sendKeys("198");
//				driver.findElement(By.xpath("//div[@class='payment__info']//div[3]//div[1]//input[1]")).sendKeys("Akira");
//				driver.findElement(By.xpath("//input[@name='coupon']")).sendKeys("786");
//				driver.findElement(By.xpath("//button[@type='submit']")).click();
				Actions a= new Actions(driver);
				a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
				//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
				driver.findElement(By.xpath("//body//app-root//button[2]")).click();
				driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
				//String successMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
		       // Assert.assertTrue(successMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		        driver.close();
		        
		        
				
				
				
				
				
				

			}

		}



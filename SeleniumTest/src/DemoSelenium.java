import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoSelenium {

	
	
	public static void main(String[] args) {
		

			
		WebDriver driver = new ChromeDriver();
		
		//Loading the WebPage
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize();
	   
	    //clicks Sign In 
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//a[@class='login']")).click();
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	   
	  // username and Password
	    driver.findElement(By.xpath("//*[@id='email']")).sendKeys("training.qaprep@gmail.com");
	    driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("Testing123");
	    
	    //clicks login 
	    driver.findElement(By.name("SubmitLogin")).click();
	   
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //clicks on women's tab and moves down to T-shirts a
	    Actions action = new Actions(driver);
	    WebElement women = driver.findElement(By.xpath("//li/a[@title='Women']"));
	    action.moveToElement(women).perform();
	   
	    //clicks on T-shirts
	    driver.findElement(By.xpath("//li/ul/li/a[@title='T-shirts']")).click();
	      
	    //mouses over to the image and clicks "more" button
	    WebElement tShirt = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
	    action.moveToElement(tShirt).perform();
	    WebElement move = driver.findElement(By.xpath("//a[@title='View']"));
	    action.click(move).perform();	    
	   
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //updates the quantitiy
	    driver.findElement(By.name("qty")).sendKeys(Keys.BACK_SPACE);  
	    driver.findElement(By.name("qty")).sendKeys("2");
       
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    WebElement dropdown = driver.findElement(By.id("group_1"));
	    Select size = new Select(dropdown);
	    size.selectByVisibleText("L");
	    
	    // selecting color of the T-shirt
    	 WebElement color = driver.findElement(By.id("color_14"));
    	 action.click(color).perform();
    	 
    	 // Clicking Add to Cart
    	 WebElement AddToCart = driver.findElement(By.name("Submit"));
    	 action.click(AddToCart).perform(); 
    	 
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 //clicking Proceed to checkout
    	 driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
    	 
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 //checkout
         driver.findElement(By.xpath("//p/a[@title='Proceed to checkout']")).click();
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //address checkout
         driver.findElement(By.name("processAddress")).click();
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //Clicking box agreements
         driver.findElement(By.id("cgv")).click();
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //clicking checkout after selecting checkbox
         driver.findElement(By.name("processCarrier")).click();
     
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //Payment Method selection
         WebElement paymentMethod = driver.findElement(By.xpath("//a[@class='cheque']"));
         action.click(paymentMethod).perform();
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //Order confirmation
         WebElement confirmation = driver.findElement(By.xpath("//p[@id='cart_navigation']/button"));
         action.click(confirmation).perform();
         
         //Getting title of of the order confirmation page
         String str  = driver.getTitle();
        
         if(str.contains("Order confirmation - My Store")) 
        	 System.out.println("Ordered Placed");
        else
        	 System.out.println("Ordered Not Placed");
         
         driver.quit();
	
	}
	
		
	}
	


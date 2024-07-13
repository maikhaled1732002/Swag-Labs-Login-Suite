package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestsRequired {
    private WebDriver driver;
    private  int count =1;
    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup(); // setup chrome driver
		driver = new ChromeDriver();

    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.saucedemo.com/"); // open url and reset the form
        driver.manage().window().maximize();
        System.out.println("Test" + count + "started");
        
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException
    {
        System.out.println("Test finished successfully");
       Thread.sleep(2000);  // not the best practice it deals good with this task just to see teach test case 

    }
    //test1
    

	
	@Test(priority=1,description="this is a the username and password fields are on the main screen of the application test")

    public void aTest1()
	 {
		
		
        WebElement User_Name =driver.findElement(By.id("user-name"));
       WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        Assert.assertTrue(User_Name.isDisplayed(), "Username field is not displayed");
        Assert.assertTrue(password.isDisplayed(), "Password field is not displayed");
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed");
	}

	
	//test 2

	@Test(priority=2,description="this is a valid credentials work test")

    public void bTest2()
	 {
		
        count++;
		String Expected_Div ="Swag Labs";
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
       WebElement SwagDiv = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")) ;
       String actual_Div = SwagDiv.getText();
       Assert.assertEquals(actual_Div, Expected_Div, "The text of the Swag Labs div does not match the expected value");
       
	}
	

	//test3

	@Test(priority=3,description="this is a wrong credentials work test")

    public void cTest3()
	 {    count++;
		String Expected_Div ="Epic sadface: Username and password do not match any user in this service";
		
        driver.findElement(By.id("user-name")).sendKeys("wrong_username");
        driver.findElement(By.id("password")).sendKeys("wrong_pasword");
        driver.findElement(By.id("login-button")).click();
        WebElement error_div  =driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String actual_Div=error_div.getText();
        Assert.assertEquals(actual_Div, Expected_Div, "The error message for invalid credentials does not match the expected value");
	}
	


	
	//test4
	
	@Test(priority=4,description="this is a empty Username test")

    public void dTest4()
	 {
		count++;
		String  UsernameExpected_Div="Epic sadface: Username is required";
        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement UsernameError_div  =driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String UsernameActual_Div=UsernameError_div.getText();
        Assert.assertEquals(UsernameActual_Div, UsernameExpected_Div, "The error message for empty username does not match the expected value");
        
       
        
        
	}
	
	
	
	//test5
	
		
		@Test(priority=5,description="this is a empty password test")

	    public void eTest5()
		 {
			
			count++;
	        String  PasswordExpected_Div="Epic sadface: Password is required";
	        driver.findElement(By.id("user-name")).sendKeys("standard_user");
	        driver.findElement(By.id("password")).clear();
	        driver.findElement(By.id("login-button")).click();
	        WebElement PasswordError_div  =driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
	        String PasswordActual_Div=PasswordError_div.getText();
	        Assert.assertEquals(PasswordActual_Div, PasswordExpected_Div, "The error message for empty Password does not match the expected value");
	        
	        
	        
		}
		
		
	
	
	
	
}

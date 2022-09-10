package Weektwo.dayone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//Login
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(1000);
		//Go to Create Lead page
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		//Create Lead
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pavithra");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("G");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Pavithra Gnanasoundari");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("TestLeaf week two assignment");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("pavithra11297@gmail.com");
		//Choose drop down value
		WebElement State=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select ddvalue=new Select(State);
		ddvalue.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(1000);
		System.out.println("The Page Title is : " +driver.getTitle());
        //Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("LeafTabs org");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kiruba");
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(1000);
		System.out.println("After create duplicate lead,the page title is : " +driver.getTitle());
		

		
	}

}

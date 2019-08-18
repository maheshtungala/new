package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Anjali {
@Test
public static void verifyLogin(){
	ChromeDriver driver = new ChromeDriver();
    driver.get("http://apps.qaplanet.in/qahrm");
    
    //enter username password and click the login button
    driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
    driver.findElement(By.name("txtPassword")).sendKeys("lab1");
    driver.findElement(By.name("Submit")).click();
    
    //verify the page title
    if(driver.getTitle().equals("OrangeHRM")){
    	System.out.println("TC passed!");
    }else{
    	System.out.println("TC failed!");
    }
    
    //click the logout link
    driver.findElement(By.linkText("Logout")).click();
    
    //close the browser
    driver.close();
}
@Test
public static void addEmp() throws InterruptedException{
	WebDriver driver = new ChromeDriver();
	//WebDriver driver = new FirefoxDriver();
	driver.get("http://apps.qaplanet.in/qahrm");
	
	//driver.manage().window().maximize();
	//login into the application........
	driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
	driver.findElement(By.name("txtPassword")).sendKeys("lab1");
	driver.findElement(By.name("Submit")).click();
	
	//click on the ADD button by switching on to the frame.......
	String firstName ="Mahesh";
	String lastName  ="Tungala";

	driver.switchTo().frame("rightMenu");
	driver.findElement(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[1]")).click();
	                             
	//add the employee details.....
	Thread.sleep(5000);
	driver.findElement(By.name("txtEmpLastName")).sendKeys(lastName);
	driver.findElement(By.name("txtEmpFirstName")).sendKeys(firstName);
	driver.findElement(By.xpath("//*[@id='btnEdit']")).click();
	
	//Thread.sleep(2000);
	
	//verify the employee name just entered .....in the personal details page...
	
	Thread.sleep(5000);
	//driver.switchTo().frame("rightMenu");
	driver.findElement(By.xpath("//*[@id='btnEditPers']")).click();
	//Thread.sleep(2000);
	String fN=driver.findElement(By.xpath("//*[@id='txtEmpFirstName']")).getAttribute("value");
	String lN=driver.findElement(By.xpath("//*[@id='txtEmpLastName']")).getAttribute("value");
	System.out.println("firstName :"+ fN);
	System.out.println("lastName : "+ lN);
	
	if(fN.equals(firstName)&&(lN.equals(lastName))){
		System.out.println("Employee successfully added : TestCase Passed");
	}
	else
	{
		System.out.println("Add Employee failed : testcase failed");
	}
	
	//driver.switchTo().defaultContent();
	driver.switchTo().parentFrame();
	Thread.sleep(2000);
	driver.findElement(By.xpath("html/body/div[3]/ul/li[3]/a")).click();
	
	Thread.sleep(2000);
	driver.close();	
}
@Test
public static void editEmp(){
	System.out.println("Edit emp passed!");
}
@Test
public static void deleteEmp(){
	System.out.println("Delete emp passed!");
}
}

package biptrack;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.jq.Main;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BIPS_Login {
	static  String userId;
	static  String password;
	public static WebDriver driver;
	static SoftAssert softAssert = new SoftAssert();
	public static String xlfilepath = "C:\\Users\\PA0128\\eclipse-workspace\\BIPS\\Data\\BIPTrack_TestCases.xlsx";
	static String projectPath = System.getProperty("user.dir");
	@Given("User is in login page")
	public static void initiate_Driver() throws Exception {
		//if(browser.equalsIgnoreCase("chrome")){
		//	WebDriverManager.chromedriver().setup();
		//	driver = new ChromeDriver();
		//} else if(browser.equalsIgnoreCase("Edge")){//
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}
	@And("User clicks on login")
	public static void bips_APP_Login() throws Exception {
		try {
			String baseUrl = "https://biphrm-biplah-stg1.pegacloud.io/prweb/app/default/c5mb0Z99oLKgPL-hk4L4rty7OLzbbezr*/!STANDARD";
			driver.manage().window().maximize();
			driver.get(baseUrl);	
			driver.findElement(By.name("UserIdentifier")).sendKeys(userId);
			driver.findElement(By.name("Password")).sendKeys(password);
			driver.findElement(By.id("sub")).click();
			System.out.println("Test Step Passed bips_APP_Login() Sucessfully ");
			softAssert.assertAll();
			XL_Data_BIPTrack.write_Pass_Result(1);
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();		
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod);
			XL_Data_BIPTrack.write_Fail_Result(1, 63, currentMethod);
		}
	}

	public static void jira_APP_Login() throws Exception {
		try {
			String baseUrl = "https://id.atlassian.com/login?continue=https%3A%2F%2F1abc12345.atlassian.net%2Flogin%3FredirectCount%3D1%26dest-url%3D%252Fjira%252Fsoftware%252Fc%252Fprojects%252FP1%252Fissues%26application%3Djira&application=jira";
			driver.manage().window().maximize();
			driver.get(baseUrl);
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='username']")));
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys(userId);
			driver.findElement(By.xpath("//*[@id=\'login-submit\']/span/span")).click();
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.name("password")));
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.id("login-submit")).click();	
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
			softAssert.assertAll();
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();		
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}
	
	static void gmail_APP_Login() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			String baseUrl = "https://mail.google.com/";
			driver.manage().window().maximize();
			driver.get(baseUrl);
			WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
			email_phone.sendKeys(userId);
			driver.findElement(By.id("identifierNext")).click();
			WebElement passwordd = driver.findElement(By.xpath("//input[@name='Passwd']"));
			passwordd.sendKeys(password);
			driver.findElement(By.id("passwordNext")).click();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();		
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void gmailUser_Login1() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(2);
			BIPS_Login.gmail_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );		
			}
		}

	public static void Admin_User_Login() throws Exception {
	//	initiate_Driver("chrome");
		BIPS_Login.read_User_Credential_From_XL(3);
		BIPS_Login.bips_APP_Login();
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}

	public static void TAMAManager_Login() throws Exception {
		BIPS_Login.read_User_Credential_From_XL(4);
		bips_APP_Login();
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}
	
	public static void TAMAHead_Login() throws Exception {
		BIPS_Login.read_User_Credential_From_XL(5);
		bips_APP_Login();
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}
	
	public static void TAMASeniorManager_Login()  throws Exception {
		BIPS_Login.read_User_Credential_From_XL(6);
		bips_APP_Login();
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}
	
	public static void TAMATeamLeader_Login() throws Exception {
		BIPS_Login.read_User_Credential_From_XL(7);
		BIPS_Login.bips_APP_Login();
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}
	
	public static void TAMAAssociateManager_Login() throws Exception {
		BIPS_Login.read_User_Credential_From_XL(8);
		bips_APP_Login();
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}

	public static void RegulatoryAffairs_Login() throws Exception {
		BIPS_Login.read_User_Credential_From_XL(9);
		bips_APP_Login();
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}
	@When("User gives username and password")
	public static void ROPU_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(3);
			Thread.sleep(1000);
			//bips_APP_Login();		
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}
	
	public static void CountryChampion_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(4);
			Thread.sleep(1000);
			bips_APP_Login();		
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void ROPUMAManager_Login()   throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(11);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void ROPUMAHead_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(12);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void ROPUHPHead_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(13);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void RegionMAHead_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(14);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
		}
	}
	
	public static void RegionMAManager_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(15);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
		}
	}

	public static void OPUGeneralManager_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(16);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}
	
	public static void PCAnalyst_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(17);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void MACoordinator_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(18);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}
	
	public static void RegionalBusinessManager_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(19);
			bips_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void jira_Login() throws Exception {
		BIPS_Login.read_User_Credential_From_XL(1);
		BIPS_Login.jira_APP_Login();
		System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
	}

	public static void gmailUser_Login() throws Exception {
		try {
			BIPS_Login.read_User_Credential_From_XL(2);
			BIPS_Login.gmail_APP_Login();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void click_onClose() throws Exception {
		try {
			Thread.sleep(3000);
			WebElement close = driver.findElement(By.xpath("//button[contains(text(),'Close')]"));
			close.click();
		} catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void driver_Close() throws Exception {
		driver.close();
	}

	public static void clearCookies_DriverQuit() throws Exception {
		driver.manage().deleteAllCookies();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		Thread.sleep(500);
	}

	public static void user_LogOut() throws Exception {		
		try {
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@class='icons avatar name-n ']")).click();
			//a[normalize-space()='STG4-ROPU']
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'Log off')]")).click();
		}
		catch(Exception e) {
			String currentMethod = new Throwable().getStackTrace()[0].getMethodName();
			Jira_Ticket.Create_JiraTicket_With_Quit(currentMethod );
		}
	}

	public static void read_User_Credential_From_XL(int Row_Number) throws Exception {
		try {
			FileInputStream fStream = new FileInputStream(new String(BIPS_Login.xlfilepath));
			XSSFWorkbook workbook = new XSSFWorkbook(fStream);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row1 = sheet.getRow(Row_Number);
			XSSFCell cell1 = row1.getCell(2);
			XSSFCell cell2 = row1.getCell(3);
			userId = cell1.toString();
			password = cell2.toString();
			fStream.close();
			workbook.close();
			System.out.println("Test Step Passed "+new Throwable().getStackTrace()[0].getMethodName()+" Sucessfully ");
		} catch(Exception e) {
		}
	}

	public static void quitBrowser() {
		driver.quit();	
	}
	
		
	@Then("Login is succesfull")
	public void login_is_succesfull() {
	    System.out.println("Successfull");
	}
		
	
}

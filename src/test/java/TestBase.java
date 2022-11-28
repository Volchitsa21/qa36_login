import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver wd;

    //before
    @BeforeTest
    public void prepare() {
        wd = new ChromeDriver();
        //wd.get("https://derrick686.softr.app/"); // main page
        wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();
        // wd.findElement(By.xpath("//*[@id=\"home-header2\"]/div/div[1]/ul/li[2]/a")).click(); //go from main page to login


    }




    public void badAuthorization() throws InterruptedException {

        WebElement emailNegativeTest = wd.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailNegativeTest.click();
        emailNegativeTest.clear();
        emailNegativeTest.sendKeys("billye@example.com");
        //Thread.sleep(1000);

        WebElement passNegativeTest = wd.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passNegativeTest.click();
        passNegativeTest.clear();
        passNegativeTest.sendKeys("654321");
        //Thread.sleep(1000);

        wd.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(2000);

    }

    public void managerAuthorization() throws InterruptedException {
        //Enter manager's email
        WebElement  emailPositiveTest = wd.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailPositiveTest.click();
        emailPositiveTest.clear();
        emailPositiveTest.sendKeys("billye@example.com");

        //Enter manager's password
        WebElement passPositiveTest = wd.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passPositiveTest.click();
        passPositiveTest.clear();
        passPositiveTest.sendKeys("123456");


        //Submit the form
        wd.findElement(By.id("sw-sign-in-submit-btn")).click();

        Thread.sleep(2000);
    }

    public void checkClientsLink(){
        WebElement clients = wd.findElement(By.xpath("//*[@id=\"home-header1\"]/div/div[1]/ul/li[2]/a"));
    }

    public void  clientByName() throws InterruptedException {
        WebElement clientsLink = wd.findElement(By.xpath("//*[@id=\"home-header1\"]/div/div[1]/ul/li[2]/a"));
        clientsLink.click();

        WebElement searchname = wd.findElement(By.xpath("//*[@id=\"list2\"]/div[1]/div/div/div/input"));

        searchname.sendKeys("lucie");
        Thread.sleep(2000);
        searchname.sendKeys(Keys.RETURN);
        Thread.sleep(2000);

    }




}

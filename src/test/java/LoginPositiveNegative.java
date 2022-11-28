import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPositiveNegative {
    WebDriver wd;

    //before
    @BeforeTest
    public void prepare() {
        wd = new ChromeDriver();
        wd.get("https://derrick686.softr.app/");
        //wd.get("https://derrick686.softr.app/login");
        wd.manage().window().maximize();
         wd.findElement(By.xpath("//*[@id=\"home-header2\"]/div/div[1]/ul/li[2]/a")).click();


    }

    //test
    @Test
    public void ourTestPositive() throws InterruptedException {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement  emailPositiveTest = wd.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailPositiveTest.click();
        emailPositiveTest.clear();
        emailPositiveTest.sendKeys("billye@example.com");
        Thread.sleep(1000);

        WebElement passPositiveTest = wd.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passPositiveTest.click();
        passPositiveTest.clear();
        passPositiveTest.sendKeys("123456");
        Thread.sleep(1000);

        wd.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(5000);

        String source = wd.getPageSource();
        String bugReport = "Invalid email or password";
        System.out.println(source.contains(bugReport));
       // Assert.assertEquals(source.contains(bugReport), Boolean.FALSE);
        Assert.assertFalse(source.contains("Invalid email or password"));
    }

    @Test
    public void ourNegativeTest() throws InterruptedException {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement  emailNegativeTest = wd.findElement(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        emailNegativeTest.click();
        emailNegativeTest.clear();
        emailNegativeTest.sendKeys("billye@example.com");
        Thread.sleep(1000);

        WebElement passNegativeTest = wd.findElement(By.xpath("//*[@id=\"sw-form-password-input\"]"));
        passNegativeTest.click();
        passNegativeTest.clear();
        passNegativeTest.sendKeys("654321");
        Thread.sleep(1000);

        wd.findElement(By.id("sw-sign-in-submit-btn")).click();
        Thread.sleep(5000);
        String source = wd.getPageSource();
        String bugReport = "Invalid email or password";
        System.out.println(source.contains(bugReport));
        Assert.assertEquals(source.contains(bugReport), Boolean.TRUE);



    }







    //after
        @AfterTest
        public void afterTest(){
            wd.manage().window().minimize();
            try {
                Thread.sleep(5000);
            }catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
            wd.close();
            try {
                Thread.sleep(4000);
            }catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
            wd.quit();
        }
    }
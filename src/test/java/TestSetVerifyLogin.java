import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSetVerifyLogin extends TestBase{


    //test
    @Test
    public void ManagerAuthorizationTest() throws InterruptedException {

        //auth as a manager
        managerAuthorization();

        //Check for Clients link on the page
        checkClientsLink();        //Verify there's no error message on the screen

        String text = "Invalid email or password";
//        Assert.assertEquals(wd.getPageSource().contains(text), Boolean.FALSE);   // another writing
        Assert.assertFalse(wd.getPageSource().contains("Invalid email or password"));
    }

    @Test
    public void BadAuthorization() throws InterruptedException {

        //try to authorization with bad creds
        badAuthorization();

        //Verify there's an error message displayed

        String text = "Invalid email or password";
        Assert.assertEquals(wd.getPageSource().contains(text), Boolean.TRUE);


    }

    @Test
    public void GoodAuthorizationAfterBadAuthorization() throws InterruptedException {
        //try bad auth
        badAuthorization();
        //try manager auth
        managerAuthorization();
        checkClientsLink();
    }

//    @Test   //test work
//    public void SearchClientByName() throws InterruptedException {
//        // manager auth
//        managerAuthorization();
//        Thread.sleep(2000);
//        WebElement clientsLink = wd.findElement(By.xpath("//*[@id=\"home-header1\"]/div/div[1]/ul/li[2]/a"));
//        clientsLink.click();
//
//        Thread.sleep(2000);
//
//        WebElement searchname = wd.findElement(By.xpath("//*[@id=\"list2\"]/div[1]/div/div/div/input"));
//
//        searchname.sendKeys("lucie");
//        Thread.sleep(2000);
//        searchname.sendKeys(Keys.RETURN);
//        Thread.sleep(2000);
//
//        String text = wd.getPageSource();
//        String seleniumText = "lucie";
//        System.out.println(text.contains(seleniumText));
//        Thread.sleep(2000);
//
//    }









        @Test
    public void SearchClientByName() throws InterruptedException {
        // manager auth
        managerAuthorization();
        Thread.sleep(2000);
        //checkClientsLink();
        clientByName();

        String text = wd.getPageSource();
        String seleniumText = "lucie";
        System.out.println(text.contains(seleniumText));
        Thread.sleep(2000);

          String texts = "lucie";
          Assert.assertEquals(wd.getPageSource().contains(texts), Boolean.TRUE);


    }


//    @Test
//    public void PositiveSearchClientByCompany() throws InterruptedException {
//        // manager auth
//        managerAuthorization();
//        Thread.sleep(2000);
//        //checkClientsLink();
//        positiveClientByCompany();
//
//        String text = wd.getPageSource();
//        String seleniumText = "Montag";
//        System.out.println(text.contains(seleniumText));
//        Thread.sleep(2000);
//
//        String texts = "Montag";
//        Assert.assertEquals(wd.getPageSource().contains(texts), Boolean.TRUE);
//    }




   
//    public void  positiveClientByCompany() throws InterruptedException {
//        WebElement clientCompanyLink = wd.findElement(By.xpath("//*[@id=\"home-header1\"]/div/div[1]/ul/li[2]/a"));
//        clientCompanyLink.click();
//
//        WebElement searchname = wd.findElement(By.xpath("//*[@id="list2"]/div[2]/div/div/div[1]/div[2]/a"));
//
//        searchname.sendKeys("Montag");
//        Thread.sleep(2000);
//        searchname.sendKeys(Keys.RETURN);
//        Thread.sleep(2000);
//
//    }


}








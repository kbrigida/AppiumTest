import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class FirstTest {

    WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "emulator-5554");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "5.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.ford.cchmi");

        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.ford.cchmi.view.MainActivity");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
       // wearDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);


    }

    @Test
    public void testFirstCalculator() {


        // Click on DELETE/CLR button to cleaadb der result text box before running test.
        driver.findElements(By.xpath("//*[@text='Cancel']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='SDL']")).get(0).click();
        driver.findElements(By.id("com.ford.cchmi:id/sdl_fr_network_base_url_input")).get(0).clear();
        driver.findElements(By.id("com.ford.cc10hmi:id/sdl_fr_network_user_id_input")).get(0).clear();
        driver.findElements(By.id("com.ford.cchmi:id/sdl_fr_network_base_url_input")).get(0).sendKeys("http://10.0.2.2:3002/");
        driver.findElements(By.id("com.ford.cchmi:id/sdl_fr_network_user_id_input")).get(0).sendKeys("1337");
        driver.findElements(By.id("com.ford.cchmi:id/sdl_fr_save_network_settings")).get(0).click();
        driver.findElements(By.xpath("//*[@text='Time']")).get(0).click();
        driver.findElements(By.id("com.ford.cchmi:id/upload_statistic_fab")).get(0).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //logEntries = driver.manage().logs().get("logcat").getAll();
        // Click on number 2 button.
        //driver.findElement(By.name("7")).click();

        //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }

   // @After
    //public void End() {
     //   driver.quit();
    //}
}

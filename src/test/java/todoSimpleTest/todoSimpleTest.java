//package todoSimpleTest;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.By;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class todoSimpleTest {
//    public AppiumDriver<MobileElement> driver;
//    public WebDriverWait wait;
//
//
//    @BeforeMethod
//    public void setup () throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "Galaxy S9+");
//        caps.setCapability("udid", "22520a632f017ece"); //DeviceId from "adb devices" command
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("platformVersion", "9");
//        caps.setCapability("skipUnlock","true");
//        caps.setCapability("appPackage", "com.example.android.architecture.blueprints.todomvp.mock");
//        caps.setCapability("appActivity","com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity");
//        caps.setCapability("noReset","false");
//        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
//        wait = new WebDriverWait(driver, 10);
//    }
//
//    @Test
//    public void basicTest () throws InterruptedException {
//
//
//
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.example.android.architecture.blueprints.todomvp.mock:id/fab_add_task"))).click();
//
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.example.android.architecture.blueprints.todomvp.mock:id/add_task_title"))).sendKeys("hepsiburada1");
//
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.example.android.architecture.blueprints.todomvp.mock:id/add_task_description"))).sendKeys("test1");
//
//
//
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.example.android.architecture.blueprints.todomvp.mock:id/fab_edit_task_done"))).click();
//
//    }
//
//    @AfterMethod
//    public void teardown(){
//        driver.quit();
//    }
//
//}

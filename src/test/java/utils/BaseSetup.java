package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class BaseSetup {
    public static AppiumDriver<WebElement> driver;
    public static WebDriverWait wait;
/*    static String scrShotDir = "screenshots";
    File scrFile;
    static File scrShotDirPath = new java.io.File("./"+ scrShotDir+ "//");
    String destFile;*/




    @BeforeTest
    public static void Setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Galaxy S9+");
        caps.setCapability("udid", "22520a632f017ece"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "9");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.example.android.architecture.blueprints.todomvp.mock");
        caps.setCapability("appActivity","com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity");
        caps.setCapability("noReset","false");
        driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }


    //Check the List Add Functionality Tests
    @Test
    public void ListAddTest(){
        NewTodoPage newTodoPage = new NewTodoPage(driver);
        TodoListPage todoListPage = new TodoListPage(driver);
        //Step one
        todoListPage.AddTask();
        if (newTodoPage.VerifyNewPage("Title"))
            System.out.println("Page Validate Success!");
        else
            System.out.println("Page Validate Fail!");

        //Step Two
        newTodoPage.EnterFullTitleAndDesc(1);
        newTodoPage.SaveTaskDone();
        //sleep(2000);
        if (todoListPage.TitleControl("hepsiburada"))
            System.out.println("TO-DO save success!");
        else
            System.out.println("TO-DO save fail!");
        //Step Three
        todoListPage.AddTask();
        newTodoPage.EnterTitleEmptyAndFullDesc();
        newTodoPage.SaveTaskDone();
        try {
            if (todoListPage.TitleControl(""))
                System.out.println("TO-DO empty title and full desc save success!");
        }
        catch (NoSuchElementException e)
        {
            System.out.println("TO-DO empty title and full desc save fail!");
            driver.resetApp();
        }
        //Step Four
        todoListPage.AddTask();
        newTodoPage.EnterEmptyTitleAndEmptyDesc();
        newTodoPage.SaveTaskDone();
        try {
            if (todoListPage.TitleControl(""))
                System.out.println("TO-DO empty title and empty desc save success!");
        }
        catch (NoSuchElementException e)
        {
            System.out.println("TO-DO empty title and empty desc save fail!");
            driver.resetApp();
        }
        //Step Five
        todoListPage.AddTask();
        newTodoPage.EnterFullTitleAndEmptyDesc();
        newTodoPage.SaveTaskDone();
        try {
            if (todoListPage.TitleControl("hepsiburada3"))
                System.out.println("TO-DO full title and empty desc save success!");
        }
        catch (NoSuchElementException e)
        {
            System.out.println("TO-DO full title and empty desc save fail!");
            driver.resetApp();
        }
        //List Add Data
        for (int i =1;i<=3;i++){
            todoListPage.AddTask();
            newTodoPage.EnterFullTitleAndDesc(i);
            newTodoPage.SaveTaskDone();
        }
        System.out.println("List Created");

        //String toast = readToastMessage();
        //Assert.assertTrue("TO-DO saved success!", toast.contains("TO-DO saved"));

    }

    //Check To do List Edit Page Functionality Tests
    @Test
    public void ListEditTest() {
        TodoListPage todoListPage = new TodoListPage(driver);
        TodoDetailPage todoDetailPage = new TodoDetailPage(driver);
        TodoEditPage todoEditPage = new TodoEditPage(driver);

        try {
            todoListPage.TodoTitleClick();
            todoDetailPage.TodoDetailEditClick();
            todoEditPage.EnterEditPageTitleAndDesc();
            todoEditPage.ClickEditDone();
            System.out.println("Edit process Success!");
        }
        catch (NoSuchElementException e){
            System.out.println("Edit process Fail!");
        }



    }

    //Check Save Task later Task Deleted Tests
    @Test
    public void TaskDeleteTest() {
        NewTodoPage newTodoPage = new NewTodoPage(driver);
        TodoListPage todoListPage = new TodoListPage(driver);
        TodoDetailPage todoDetailPage = new TodoDetailPage(driver);


        try {
            todoListPage.TodoTitleClick();
            todoDetailPage.TodoDeleteClick();
            System.out.println("TO-DO deleted success!");
            todoListPage.AddTask();
            newTodoPage.EnterTitleEmptyAndFullDesc();
            newTodoPage.SaveTaskDone();
            System.out.println("TO-DO again added success !");
        }
        catch (NoSuchElementException e){
            System.out.println("TO-DO delete fail!");
        }
    }

    //Check Statistics Page Tests
    @Test
    public void StatisticsPageControl() {
        TodoListPage todoListPage = new TodoListPage(driver);
        StatisticsPage statisticsPage = new StatisticsPage(driver);

        todoListPage.navbarClick();
        statisticsPage.navBarStatisticsMenuClick();
        if(statisticsPage.StatisticsPageTextActiveControl() == todoListPage.TitleCount())
            System.out.println("Statistics match success!");
        else
            System.out.println("Statistics match fail!");
    }

    //Check Active-Completed-All Task Page Tests
    @Test
    public void FilterTaskListPage(){
        NewTodoPage newTodoPage = new NewTodoPage(driver);
        TodoListPage todoListPage = new TodoListPage(driver);
        driver.resetApp();

        int allTask = 6;

        //List Add Data
        for (int i =1;i<=allTask;i++) {
            todoListPage.AddTask();
            newTodoPage.EnterFullTitleAndDesc(i);
            newTodoPage.SaveTaskDone();
        }

        for (int check=1;check<=(allTask/2);check++)
            todoListPage.CheckCompleteClick();

        boolean statusActive = todoListPage.FilterActiveTaskControl((allTask/2));
        if(statusActive)
            System.out.println("Active Task Count Check Successful!");
        else
            System.out.println("Active Task Count Check Failed!");

        boolean statusCompleted = todoListPage.FilterCompletedTaskControl((allTask/2));
        if(statusCompleted)
            System.out.println("Completed Task Count Check Successful!");
        else
            System.out.println("Completed Task Count Check Failed!");

        boolean statusAllTask = todoListPage.FilterAllTaskControl(allTask);
        if(statusAllTask)
            System.out.println("ALL Task Count Check Successful!");
        else
            System.out.println("ALL Task Count Check Failed!");

    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }



    //Alternatif toast Control with OCR  -- MESUT BEYSULEN
/*
        public String readToastMessage() throws TesseractException {
            String imgName = takeScreenShot();
            String result = null;
            File imageFile = new File(scrShotDirPath, imgName);
            System.out.println("Image name is :" + imageFile.toString());
            ITesseract instance = new Tesseract();

            File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Extracts

            instance.setDatapath(tessDataFolder.getAbsolutePath()); // sets tessData


            result = instance.doOCR(imageFile);
            System.out.println(result);
            return result;
        }

        *//**
         * Takes screenshot of active screen
         *
         * @return ImageFileName
         *//*
        public String takeScreenShot() {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
            new File(scrShotDir).mkdirs();
            destFile = dateFormat.format(new Date()) + ".png"; // Set file name
            try {
                FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile)); // Copy

            } catch (IOException e) {
                System.out.println("Image not transfered to screenshot folder");
                e.printStackTrace();
            }
            return destFile;
        }*/
}
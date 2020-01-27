package pages;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.BaseSetup;

import java.util.List;


public class TodoListPage extends BaseSetup {



    public TodoListPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "fab_add_task")
    public WebElement addTask;

    @AndroidFindBy(id = "title")
    public WebElement titleHeader;

    @AndroidFindBy(id = "task_detail_title")
    public WebElement taskDetail;

    @AndroidFindBy(accessibility = "Yukarı git")
    public WebElement navBar;

    @AndroidFindBy(id = "title")
    public List<WebElement> TitleList;

    @AndroidFindBy(id = "all")
    public WebElement ListAll;

    @AndroidFindBy(id = "active")
    public WebElement ListActive;

    @AndroidFindBy(id = "completed")
    public WebElement ListCompleted;

    @AndroidFindBy(id = "menu_filter")
    public WebElement menu_filter;

    @AndroidFindBy(id = "content")
    public List<WebElement> content;

    @AndroidFindBy(id = "complete")
    public List<WebElement> complete_checkboxList;

    public void AddTask(){
        addTask.click();
    }

    public boolean TitleControl(String result){
        return titleHeader.getText().equals(result);
    }

    public void TodoTitleClick(){
        titleHeader.click();
        taskDetail.click();
    }

    public void navbarClick(){
        navBar.click();
    }

    public int TitleCount(){
        int countTitle = 0;
        for(WebElement el : TitleList){
            if (el != null)
                countTitle++;
        }

        return countTitle;
    }

    public boolean FilterActiveTaskControl(int count){
        menu_filter.click();
        content.get(1).click();
        return TitleCount() == count;
    }

    public void CheckCompleteClick(int check){
        complete_checkboxList.get(check).click();
    }

    public boolean FilterCompletedTaskControl(int count){
        menu_filter.click();
        content.get(2).click();
        return TitleCount() == count;
    }

    public boolean FilterAllTaskControl(int count){
        menu_filter.click();
        content.get(0).click();
        return TitleCount() == count;
    }
}

package pages;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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

    @AndroidFindBy(id = "tasks_list")
    public List<WebElement> TitleList;

    @AndroidFindBy(id = "all")
    public WebElement ListAll;

    @AndroidFindBy(id = "active")
    public WebElement ListActive;

    @AndroidFindBy(id = "completed")
    public WebElement ListCompleted;

    @AndroidFindBy(id = "complete_checkbox")
    public WebElement complete_checkbox;

    public void AddTask(){
        addTask.click();
    }

    public boolean TitleControl(String result){
        if (titleHeader.getText().equals(result))
            return true;
        else
            return false;
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
        String expected = "Title";
        for(WebElement el : TitleList){
            if (el.getText().equalsIgnoreCase(expected))
                countTitle++;
        }

        return countTitle;
    }

    public boolean FilterActiveTaskControl(int count){
        ListActive.click();
        return TitleCount() == count;

    }

    public void CheckCompleteClick(){
        complete_checkbox.click();
    }

    public boolean FilterCompletedTaskControl(int count){
        ListCompleted.click();
        return TitleCount() == count;
    }

    public boolean FilterAllTaskControl(int count){
        ListAll.click();
        return TitleCount() == count;
    }
}

package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TodoEditPage {


    public TodoEditPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    @AndroidFindBy(id = "add_task_title")
    public WebElement add_task_title;

    @AndroidFindBy(id = "add_task_description")
    public WebElement add_task_description;

    @AndroidFindBy(id = "fab_edit_task_done")
    public WebElement fab_edit_task_done;



    public void EnterEditPageTitleAndDesc(){
        add_task_title.sendKeys("edit title test");
        add_task_description.sendKeys("edit description test");
    }

    public void ClickEditDone(){
        fab_edit_task_done.click();
    }
}

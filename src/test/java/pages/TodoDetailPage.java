package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TodoDetailPage {


    public TodoDetailPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    @AndroidFindBy(id = "fab_edit_task")
    public WebElement taskDetailEdit;

    @AndroidFindBy(id = "menu_delete")
    public WebElement menu_delete;

    public void TodoDetailEditClick(){
        taskDetailEdit.click();
    }

    public void TodoDeleteClick(){
        menu_delete.click();
    }
}

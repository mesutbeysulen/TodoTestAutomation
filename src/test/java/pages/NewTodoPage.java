package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class NewTodoPage {

    public NewTodoPage(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "add_task_title")
    public WebElement titleInput;

    @AndroidFindBy(id = "add_task_description")
    public WebElement descriptionInput;

    @AndroidFindBy(id = "fab_edit_task_done")
    public WebElement taskDone;

    //İlk sayfanın doğrulanması
    public boolean VerifyNewPage(String result) {
        if (titleInput.getText().equals(result))
            return true;
        else
            return false;
    }
    //Title ve Description ALanlarını doldurulması
    public void EnterFullTitleAndDesc(int i) {
        titleInput.sendKeys("hepsiburada" + i);
        descriptionInput.sendKeys("hepsirada description" + i);
    }

    public void EnterTitleEmptyAndFullDesc() {
        titleInput.sendKeys("");
        descriptionInput.sendKeys("hepsirada description empty title");
    }

    public void EnterEmptyTitleAndEmptyDesc() {
        titleInput.sendKeys("");
        descriptionInput.sendKeys("");
    }

    public void EnterFullTitleAndEmptyDesc() {
        titleInput.sendKeys("hepsiburada3");
        descriptionInput.sendKeys("");
    }

    public void EnterLengthTitleAndyDesc() {
        titleInput.sendKeys("hepsiburada3hepsiburada3hepsiburada3hepsiburada3hepsiburada3");
        descriptionInput.sendKeys("hepsirada description2hepsirada description2hepsirada description2hepsirada description2");
    }

    public void SaveTaskDone() {
        taskDone.click();
    }

}

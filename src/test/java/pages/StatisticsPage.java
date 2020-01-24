package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StatisticsPage {

    public StatisticsPage(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[2]/android.widget.CheckedTextView")
    public WebElement statisticsMenu;

    @AndroidFindBy(id = "statistics")
    public WebElement statisticText;

    public void navBarStatisticsMenuClick(){
        statisticsMenu.click();
    }
    public int StatisticsPageTextActiveControl(){
        String resultText = statisticText.getText();
        String activeCount = resultText.split("\n")[0];
        String completeCount = resultText.split("\n")[1];

        return Integer.parseInt(activeCount.replaceAll("[^0-9]", ""));

    }

}

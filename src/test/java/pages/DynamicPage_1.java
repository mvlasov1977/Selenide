package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class DynamicPage_1 extends Selenide {
    private final Long waiter = 5000L; // milli`seconds
    private final String extendUrl = "/dynamic_loading/1";
    private final String pageName = "Example 1: Element on page that is hidden";
    private SelenideElement pageSignX = $x("//*[@class=\"example\"]/h4");
    private SelenideElement startButton = $x("//*[@id=\"start\"]/button");
    private SelenideElement finishSignX = $x("//*[@id=\"finish\"]/h4");
    private final String finishText = "Hello World!";


    public DynamicPage_1(String bUrl){
        Configuration.baseUrl = bUrl;
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = waiter;
        open(extendUrl);
    }
    public String getPageName() {
        return pageName;
    }
    public SelenideElement getPageSign() {
        return pageSignX;
    }

    public SelenideElement getStartButton() {
        return startButton;
    }

    public SelenideElement getFinishSignX() {
        return finishSignX;
    }

    public String getFinishText() {
        return finishText;
    }
}

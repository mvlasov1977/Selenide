package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class DynamicPage_2 extends Selenide {
    private final Long waiter = 5000L; // milli`seconds
    private final String extendUrl = "/dynamic_loading/2";
    private final String pageName = "Example 2: Element rendered after the fact";
    private SelenideElement pageSignX = $x("//*[@class=\"example\"]/h4");
    private SelenideElement startButton = $x("//*[@id=\"start\"]/button");
    private SelenideElement finishSignX = $x("//*[@id=\"finish\"]/h4");
    private final String finishText = "Hello World!";
    public DynamicPage_2(String bUrl){
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

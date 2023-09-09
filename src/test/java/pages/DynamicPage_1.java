package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class DynamicPage_1 extends Selenide {
    private final String extendUrl = "/dynamic_loading/1";
    public DynamicPage_1(String bUrl){
        Configuration.baseUrl = bUrl;
        Configuration.holdBrowserOpen = true;
        open(extendUrl);
    }
}

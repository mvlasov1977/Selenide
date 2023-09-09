package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class DynamicPage_2 extends Selenide {
    private final String extendUrl = "/dynamic_loading/2";
    public DynamicPage_2(String bUrl){
        Configuration.baseUrl = bUrl;
        Configuration.holdBrowserOpen = true;
        open(extendUrl);
    }

}

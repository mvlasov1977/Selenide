package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class UploadPage extends Selenide {
    private final String extendUrl = "/upload";
    public UploadPage(String bUrl){
        Configuration.baseUrl = bUrl;
        Configuration.holdBrowserOpen = true;
        open(extendUrl);
    }
}

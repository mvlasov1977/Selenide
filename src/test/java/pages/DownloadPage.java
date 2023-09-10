package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DownloadPage {
    private final Long waiter = 5000L; // milli`seconds
    private final String extendUrl = "/download";
    private final String pageName = "File Downloader";
    private final String downloadPath = "src/test/myDownloads";
    private SelenideElement pageSignX = $x("//h3");
    private String fileListElement = "//*[@class=\"example\"]/a";
    public DownloadPage(String bUrl){
        Configuration.baseUrl = bUrl;
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = waiter;
        Configuration.downloadsFolder = downloadPath;
        open(extendUrl);
    }
    public String getPageName() {
        return pageName;
    }
    public SelenideElement getPageSign() {
        return pageSignX;
    }
    public String getFileListElementName(int itemNumber) {
        return $$x(fileListElement).get(itemNumber).getText();
    }
    public String getFileListElementPath(int itemNumber) {
        return $$x(fileListElement).get(itemNumber).getAttribute("href");
    }
    public SelenideElement getFileListElement(int itemNumber) {
        return $$x(fileListElement).get(itemNumber);
    }
    public long getFileListElementsCount(){
        return $$x(fileListElement).stream().count();
    }
}

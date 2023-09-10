package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class UploadPage extends Selenide {
    private final Long waiter = 5000L; // milli`seconds
    private final String extendUrl = "/upload";
    private final String pageName = "File Uploader";
    private final String uploadPath = "src/test/myUploads";
    private SelenideElement pageSignX = $x("//h3");
    private final String pageCompleteName = "File Uploaded!";
    private SelenideElement pageCompleteSignX = $x("//h3");
    private String fileContainer = "//*[@id=\"file-upload\"]";
    private String uploadButton = "//*[@id=\"file-submit\"]";

    public UploadPage(String bUrl){
        Configuration.baseUrl = bUrl;
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = waiter;
        Configuration.downloadsFolder = uploadPath;
        open(extendUrl);
    }
    public String getPageName() {
        return pageName;
    }
    public SelenideElement getPageSign() {
        return pageSignX;
    }
    public SelenideElement setUploadFile(String fileName) {
        File myFile = new File(uploadPath + "/" + fileName);
        $x(fileContainer).uploadFile(myFile);
        return $$x(uploadButton).get(0);
    }
    public String getPageCompleteName() {
        return pageCompleteName;
    }
    public SelenideElement getPageCompleteSign() {
        return pageCompleteSignX;
    }
}

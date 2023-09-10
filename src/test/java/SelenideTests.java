
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DownloadOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pages.DownloadPage;
import pages.DynamicPage_1;
import pages.DynamicPage_2;
import pages.UploadPage;

import java.io.FileNotFoundException;
import java.time.Duration;

public class SelenideTests {
    private final String baseUrl = "https://the-internet.herokuapp.com";
    private final String downloadFileName = "some-file.txt";
    private final String uploadFileName = "3September.jpg";
    private final Long waiter = 10L; // seconds
    @Test
    public void downloadTest() throws FileNotFoundException {
        DownloadPage myPage = new DownloadPage(baseUrl);
        myPage.getPageSign().shouldBe(Condition.exactText(myPage.getPageName()));

        boolean isFileFound = false;
        for(int item=0;item<myPage.getFileListElementsCount();item++){
            if (myPage.getFileListElementName(item).equals(downloadFileName)) {
                myPage.getFileListElement(item).download();
                isFileFound = true;
                break;
            }
        }
        if ( !isFileFound) {
            throw new IllegalStateException("File: " + downloadFileName + " not found on page: " + baseUrl + " !");
        }
    }
    @Test
    public void uploadTest(){
        UploadPage myPage = new UploadPage(baseUrl);
        myPage.getPageSign().shouldBe(Condition.exactText(myPage.getPageName()));
        myPage.setUploadFile(uploadFileName).click();
        myPage.getPageCompleteSign().shouldBe(Condition.exactText(myPage.getPageCompleteName()));
    }
    @Test
    public void dynamicTest1(){
        DynamicPage_1 myPage = new DynamicPage_1(baseUrl);
        myPage.getPageSign().shouldBe(Condition.exactText(myPage.getPageName()));
        myPage.getStartButton().click();
        myPage.getFinishSignX().shouldHave(Condition.exactText(myPage.getFinishText()), Duration.ofSeconds(waiter));
    }
    @Test
    public void dynamicTest2(){
        DynamicPage_2 myPage = new DynamicPage_2(baseUrl);
        myPage.getPageSign().shouldBe(Condition.exactText(myPage.getPageName()));
        myPage.getStartButton().click();
        myPage.getFinishSignX().shouldHave(Condition.exactText(myPage.getFinishText()), Duration.ofSeconds(waiter));
    }
}

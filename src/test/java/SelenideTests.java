import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class SelenideTests {
    @Test
    public void start(){
        Configuration.baseUrl = "https://the-internet.herokuapp.com/download";
        //Configuration.browser = "firefox";
        Configuration.screenshots = true;
        Configuration.holdBrowserOpen = true;
        Selenide.open("https://the-internet.herokuapp.com/download");
    }
}

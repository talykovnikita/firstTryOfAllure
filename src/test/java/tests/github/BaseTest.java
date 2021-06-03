package tests.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setup(){
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }
}

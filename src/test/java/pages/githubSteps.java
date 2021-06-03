package pages;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class githubSteps {

    @Step("Open repository {repositoryName}")
    public static void openRepository(String repositoryName){
        open(Configuration.baseUrl + '/' + repositoryName);
    }

    @Step("Click on issues tab")
    public static void clickOnIssueTab(){
        $(".js-repo-nav").$(byText("Issues")).click();
    }

    @Step("Check if issue with {issueId} visible")
    public static void isIssueWithIdVisible(int issueId){
        $("#issue_" + issueId).shouldBe(visible);
    }
}

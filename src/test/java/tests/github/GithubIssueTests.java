package tests.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.GithubSteps;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class GithubIssueTests extends BaseTest{
    @Test
    void checkIssueWithNumberPresentSelenide(){
        int issueId = 577;
        open(Configuration.baseUrl + "/allure-framework/allure-java");
        $(".js-repo-nav").$(byText("Issues")).click();
        $("#issue_" + issueId).shouldBe(visible);
    }

    @Test
    void checkIssueWithNumberPresentLambda(){
        int issueId = 576;
        step("Открыть репозиторий", (stepContext) -> {
            stepContext.parameter("URL", Configuration.baseUrl + "/allure-framework/allure-java");
            open(Configuration.baseUrl + "/allure-framework/allure-java");
        });

        step("Кликаем на вкладку Issues", () -> {
            $(".js-repo-nav").$(byText("Issues")).click();
        });

        step("Проверяем, что issue с номером " + issueId + " есть в списке", (stepContext) -> {
            stepContext.parameter("issueId", issueId);
            $("#issue_" + issueId).shouldBe(visible);
        });
    }

    @Test
    void checkIssueWithNumberPresentAnnotation(){
        int issueId = 576;
        GithubSteps.openRepository("allure-framework/allure-java");
        GithubSteps.clickOnIssueTab();
        GithubSteps.isIssueWithIdVisible(issueId);
    }
}

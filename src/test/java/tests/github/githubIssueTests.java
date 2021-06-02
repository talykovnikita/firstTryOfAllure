package tests.github;

import org.junit.jupiter.api.Test;
import tests.pages.githubSteps;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class githubIssueTests {
    private String repoUrl = "https://github.com/allure-framework/allure-java";
    private int issueId = 577;

    @Test
    void checkIssueWithNumberPresentSelenide(){
        open(repoUrl);
        $(".js-repo-nav").$(byText("Issues")).click();
        $("#issue_" + issueId).shouldBe(visible);
    }

    @Test
    void checkIssueWithNumberPresentLambda(){
        step("Открыть репозиторий", (stepContext) -> {
            stepContext.parameter("URL", repoUrl);
            open(repoUrl);
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
        githubSteps.openRepository("allure-framework/allure-java");
        githubSteps.clickOnIssueTab();
        githubSteps.isIssueWithIdVisible(issueId);
    }
}

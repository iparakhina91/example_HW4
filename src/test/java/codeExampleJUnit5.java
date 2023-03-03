package src.test.java;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class codeExampleJUnit5 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldFindExampleJUnit5() {

        // Откройте страницу Selenide в Github
    open("https://github.com/");
    $("input.header-search-input").setValue("Selenide").pressEnter();
    $$("ul.repo-list").first().$("a.v-align-middle").click();
        // Перейдите в раздел Wiki проекта
    $("#wiki-tab").click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
    $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
    $("#repo-content-pjax-container").shouldHave(text("Using JUnit5 extend test class"));
    sleep(10000);
    }
}
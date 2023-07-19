package guru.qa.tests.ui;

import guru.qa.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("EphimSh")
@Feature("Поиск фильма")
@Tags({@Tag("search"), @Tag("web")})
public class SearchTest extends TestBase {


    @Test
    @Story("Поиск фильма")
    @DisplayName("Поиск фильма Хоббит: Нежданное путешествие")
    void subscribeInfoCheck(){
        step("Перейти на главную страницу okko.tv", ()->{
            open("");
        });
        step("Нажать на кнопку поиск", ()->{
            $("[test-id=nav_search]").hover().click();
        });
        step("Ввести в строку поиска Хоббит", ()->{
            $("input[type=search]").setValue("Хоббит").pressEnter();
        });
        step("В результатах поиска нажать на карточку Хоббит: Нежданное путешествие", ()->{
            $$("section div a").filter(visible)
                    .find(innerText("Хоббит: Нежданное путешествие"))
                    .click();
        });

        step("Название выбранного фильма - Хоббит: Нежданное путешествие", ()->{
            sleep(3000);
            $(withText("Хоббит: Нежданное путешествие")).should(exist);
        });
    }
}

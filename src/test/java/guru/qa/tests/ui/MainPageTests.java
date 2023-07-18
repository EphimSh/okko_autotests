package guru.qa.tests.ui;


import com.github.javafaker.Faker;
import guru.qa.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



@Feature("Элементы главной страницы")
@Owner("EphimSh")
public class MainPageTests extends TestBase {

    static Faker faker = new Faker();
    @Tag("web")
    @Test
    @Story("Авторизация через Сбер ID")
    @DisplayName("После нажатия кнопки 'Войти' появляется страница авторизации")
    void signButtonCheck() {
        step("Перейти на главную страницу okko.tv", () -> {
            open("");
        });
        step("Нажать на кнопку 'Войти'", () -> {
            $("[test-id=nav_sign]").hover().click();
        });
        step("Окно для авторизации по сбер ID видно", () -> {
            $(withText("Вход с помощью Сбер ID"))
                    .should(visible);
        });
        step("Вход можно выполнить только с помощью номера телеофна или email", () -> {
            $("input[name=phone]")
                    .setValue(faker.random().toString()).submit();
            sleep(1000);
            $("#input-phone-error").shouldBe(visible);
        });

    }

    @Test
    @Story("Авторизация через Сбер ID")
    @DisplayName("Окно с возможностью авторизации через QR-код видно")
    void signUsingQrCodeCheck() {
        step("Перейти на главную страницу okko.tv", () -> {
            open("");
        });
        step("Нажать на кнопку 'Войти'", () -> {
            $("[test-id=nav_sign]").hover().click();
        });
        step("На странице авторизации через sberID нажать на элемент 'по QR-коду'", () -> {
            $(withText("по QR-коду"))
                    .should(visible).click();
        });
        step("Окно для входа по QR-коду отображается", () -> {
            $(withText("Отсканируйте QR-код")).shouldBe(visible);
            $("[class*=LayoutBlock_container] svg").shouldBe(visible);
        });

    }

    @Test
    @Story("Получение информации о вариантах подписки")
    @DisplayName("Нажатие кнопки 'Подбробнее' переводит пользователя на страницу с инфо о вариантах подписки")
    void subscribeInfoCheck() {
        step("Перейти на главную страницу okko.tv", () -> {
            open("");
        });
        step("Перейти к блоку с предложением о подписке и нажать кнопку 'Подробнее'", () -> {
            $$("[test-id=banner_subscription]").find(exist).$("a").hover().click();
        });
        step("Страница с описанием доступных подписок отображается", () -> {
            $(withText("Выберите подписку")).should(exist);
        });
    }

    @Test
    @Story("Выбор категории контента")
    @DisplayName("Кнопка 'Видеокурсы' работает")
    void contentCategoriesCheck() {
        step("Перейти на главную страницу okko.tv", () -> {
            open("");
        });
        step("Выбрать из 'Видеокурсы' из категорий контента", () -> {
            $$("[test-id=rail_tab]").filter(visible).find(exist).$(withText("Видеокурсы")).click();
            $(withText("Видеокурсы")).should(exist);
        });

    }

    @Test
    @Story("Выбор фильма с помощью функции рекомендаций по настроению")
    @DisplayName("Фильм можно найти по подсказке")
    void moodRecommendationCheck() {
        step("Перейти на главную страницу okko.tv", () -> {
            open("");
        });
        step("выбрать настроение: ужаснуться", () -> {
            $$("[test-id=mood_rekko] button")
                    .filter(visible)
                    .find(exist)
                    .$(withText("посмеяться")).hover().click();
            sleep(1000);
            $$("[id=okko-popup] div")
                    .filter(visible)
                    .find(exist).hover().scrollTo()
                    .$(withText("ужаснуться")).click();
        });
        sleep(1000);
        step("Постер предлагаемого фильма виден", () -> {
            $$("[test-id=mood_rekko] #video-player")
                    .filter(exist)
                    .find(visible).shouldBe(visible);
        });

    }

}

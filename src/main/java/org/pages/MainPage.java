package org.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Класс главной страницы.
 */
public class MainPage {

    /**
     * Кнопка обратной связи.
     */
    @FindBy(xpath = "//a[@data-gclick='showModalFeedback']")//позволяет реализовать отложенную инициализацию
    private SelenideElement feedbackButton;

    @FindBy(xpath = "//*[contains(@class,'gh-nav-item--about')]")
    private SelenideElement navItemAbout;

    /**
     * Проверяет, что кнопка Написать нам присутствует и кликабельна.
     * @return текущйи экземпляр класса
     */
    @Step("Проверить, что кнопка Написать нам присутствует и кликабельна")
    public FeedbackModal showFeedbackModal() {
        feedbackButton
                .should(exist)
                .shouldBe(visible)//видима
                .shouldHave(text("Написать нам"))
                .click();
        return page(FeedbackModal.class);
    }

    @Step("Проверить, что при наведении на элемент меню О нас появляется ссылка Контакты")
    public ContactsPage goToContacts() {
        navItemAbout
                .shouldHave(text("О нас"))
                .hover();
        $(By.linkText("Контакты"))
                .shouldHave(text("Контакты"))
                .click();
        return page(ContactsPage.class);
    }
    /**
     * Проверить наличие кнопки обратной связи.
     * @return текущий экземпляр класса.
     */
    @Step("Проверить наличие кнопки обратной связи")
    public MainPage checkFeedbackButtonVisibility() {
        feedbackButton.shouldBe(visible);
        return this;
    }

}

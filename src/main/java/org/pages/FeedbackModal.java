package org.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class FeedbackModal {

    final String FEEDBACK_MODAL = "//*[@class='fmo-parent']//*[@class='fb-modal-default']";

    @FindBy(xpath = FEEDBACK_MODAL)
    private SelenideElement feedbackModalWindow;

    @FindBy(xpath = FEEDBACK_MODAL + "//input[@data-clear='text']/../..")
    private SelenideElement textInput;

    @Step("Проверить, что модальное окно Обратной связи отобразилось на странице")
    public FeedbackModal checkModalWindowVisible() {
        feedbackModalWindow.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что текстовое поле присутствует")
    public FeedbackModal checkTextInput() {
        textInput.shouldHave(text("Имя или организация"));
        return this;
    }

    /**
     * Заполнить текстовое поле в модальном окне обратной связи.
     * @param nameOrOrganization строка с именем или организацией.
     * @return текущий экземпляр класса.
     */
    @Step("Заполнить текстовое поле именем или организацией: {0}")
    public FeedbackModal fillTextInput(String nameOrOrganization) {
        textInput.shouldBe(visible).setValue(nameOrOrganization);
        return this;
    }
}

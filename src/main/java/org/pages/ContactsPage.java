package org.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {

    @Step("Проверить, что страница контакты открылась")
    public ContactsPage contactsPageIsOpen() {
        $(By.xpath("//h1"))
                .shouldHave(text("Контакты"))
                .shouldBe(visible);
        return this;
    }

    /**
     * Проверить наличие контактной информации на странице.
     * @return текущий экземпляр класса.
     */
    @Step("Проверить наличие контактной информации")
    public ContactsPage checkContactInfo() {
        $(By.xpath("//div[@class='bc-lead-contacts']"))
                .shouldBe(visible)
                .shouldHave(text("@"));
        return this;
    }
}

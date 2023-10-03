package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    SelenideElement fullName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submit = $("button#submit"),

//    Проверки

            outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public TextBoxPage setFullName(String value) {
        fullName.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public void submit() {
        submit.click();
    }

//    Проверки

    public TextBoxPage checkName(String value) {
        outputName.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkEmail(String value) {
        outputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));
        return this;
    }
}

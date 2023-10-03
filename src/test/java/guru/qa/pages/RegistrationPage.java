package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            subject = $("#subjectsInput"),
            hobbie = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            currentAddress = $("#currentAddress-wrapper").$("#currentAddress"),
            state = $("#stateCity-wrapper").$("#state"),
            city = $("#stateCity-wrapper").$("#city"),
            submit = $("#submit"),

    // Форма с таблицей

            resultForm = $(".modal-dialog"),
            formHeader = $(".modal-header"),

            studentName = $(".table-responsive").$(byText("Student Name")).parent(),
            studentEmail = $(".table-responsive").$(byText("Student Email")).parent(),
            studentGender = $(".table-responsive").$(byText("Gender")).parent(),
            studentMobile = $(".table-responsive").$(byText("Mobile")).parent(),
            studentBirthday = $(".table-responsive").$(byText("Date of Birth")).parent(),
            studentSubjects = $(".table-responsive").$(byText("Subjects")).parent(),
            studentHobbies = $(".table-responsive").$(byText("Hobbies")).parent(),
            studentPicture = $(".table-responsive").$(byText("Picture")).parent(),
            studentAddress = $(".table-responsive").$(byText("Address")).parent(),
            studentStateCity = $(".table-responsive").$(byText("State and City")).parent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();
        return this;
    }

    CalendarComponent calendar = new CalendarComponent();

    public RegistrationPage setBirthDate(String day, String month, String year) {
        userNumber.pressTab();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbie.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        picture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }

    public void submit() {
        submit.click();
    }

    //Проверки

    public RegistrationPage checkForm() {
        resultForm.should(appear);
        return this;
    }

    public RegistrationPage checkFormHeader(String value) {
        formHeader.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkName(String value) {
        studentName.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkEmail(String value) {
        studentEmail.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkGender(String value) {
        studentGender.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkMobile(String value) {
        studentMobile.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkBirthday(String value) {
        studentBirthday.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkSubjects(String value) {
        studentSubjects.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkHobbies(String value) {
        studentHobbies.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkPicture(String value) {
        studentPicture.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkAddress(String value) {
        studentAddress.shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkStateCity(String value) {
        studentStateCity.shouldHave(text(value));
        return this;
    }
}

package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm extends TestBase{

    @Test
    void fillingForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Jack");
        $("#lastName").setValue("The Sparrow");
        $("#userEmail").setValue("jack_the_sparrow@gmail.com");

//        $("#genterWrapper").$(byText("Male")).click();
        $("#gender-radio-1").parent().click(); // вариант наставника
//        $("label[for=gender-radio-1]").click(); // вариант наставника


        $("#userNumber").setValue("9876543210");
        $("#userNumber").pressTab();

//       Дата рождения
        $(".react-datepicker__year-select").selectOption("1997");
//        $(".react-datepicker__year-select").selectOptionByValue("6");
        $(".react-datepicker__month-select").selectOption("March");
//        $(".react-datepicker__day--002:nth-child(1)").click();
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();

//        Предметы
        $("#subjectsInput").setValue("Computer").pressEnter();
        $("#subjectsInput").setValue("Hin").pressEnter();
        $("#subjectsInput").setValue("Ph").pressEnter();


//        Хобби
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

//        Выбор картинки
        $("#uploadPicture").uploadFromClasspath("catinabox-150x150.jpg");

//        Адрес
        $("#currentAddress-wrapper").$("#currentAddress").setValue("Russian Federation, Moscow");
        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

//        Проверки

        $(".modal-dialog").should(appear);

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Jack The Sparrow"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("jack_the_sparrow@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9876543210"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("28 March,1997"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science, Hindi, Physics"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("catinabox-150x150.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Russian Federation, Moscow"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
    }
}

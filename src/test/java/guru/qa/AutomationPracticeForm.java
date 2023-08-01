package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
static void config(){
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillingForm() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Jack");
        $("#lastName").setValue("The Sparrow");
        $("#userEmail").setValue("jack_the_sparrow@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9876543210");
        $("#userNumber").pressTab();

//       Дата рождения
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--002:nth-child(1)").click();

//        Предметы
        $("#subjectsInput").setValue("Computer");
        $(byText("Computer Science")).click();
        $("#subjectsInput").setValue("Hin");
        $(byText("Hindi")).click();
        $("#subjectsInput").setValue("Ph");
        $(byText("Physics")).click();

//        Хобби
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

//        Выбор картинки
        $("#uploadPicture").uploadFile(new File("D:\\catinabox-150x150.jpg"));

//        Адрес
        $("#currentAddress-wrapper").$("#currentAddress").setValue("Russian Federation, Moscow");
        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

//        Проверки
        $(".table-responsive").$(byText("Jack The Sparrow")).shouldHave(text("Jack The Sparrow"));
        $(".table-responsive").$(byText("jack_the_sparrow@gmail.com")).shouldHave(text("jack_the_sparrow@gmail.com"));
        $(".table-responsive").$(byText("Male")).shouldHave(text("Male"));
        $(".table-responsive").$(byText("9876543210")).shouldHave(text("9876543210"));
        $(".table-responsive").$(byText("02 March,1997")).shouldHave(text("02 March,1997"));
        $(".table-responsive").$(byText("Computer Science, Hindi, Physics")).shouldHave(text("Computer Science, Hindi, Physics"));
        $(".table-responsive").$(byText("Sports, Music")).shouldHave(text("Sports, Music"));
        $(".table-responsive").$(byText("catinabox-150x150.jpg")).shouldHave(text("catinabox-150x150.jpg"));
        $(".table-responsive").$(byText("Russian Federation, Moscow")).shouldHave(text("Russian Federation, Moscow"));
        $(".table-responsive").$(byText("Haryana Karnal")).shouldHave(text("Haryana Karnal"));
    }
}

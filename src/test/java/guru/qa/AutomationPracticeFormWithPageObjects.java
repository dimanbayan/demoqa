package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjects extends TestBase{

    @Test
    void fillingForm() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage()
                .setFirstName("Jack")
                .setLastName("The Sparrow")
                .setEmail("jack_the_sparrow@gmail.com")
                .setGender("Male")
                .setBirthDate("28", "March", "1997")
                .setPhoneNumber("9876543210")
                .setSubject("Computer")
                .setSubject("Hin")
                .setSubject("Ph")
                .setHobbie("Sports")
                .setHobbie("Music")
                .setPicture("catinabox-150x150.jpg")
                .setCurrentAddress("Russian Federation, Moscow")
                .setState("Haryana")
                .setCity("Karnal")
                .submit();


//        Проверки

        registrationPage.checkForm()
                .checkFormHeader("Thanks for submitting the form")
                .checkName("Jack The Sparrow")
                .checkEmail("jack_the_sparrow@gmail.com")
                .checkGender("Male")
                .checkMobile("9876543210")
                .checkBirthday("28 March,1997")
                .checkSubjects("Computer Science, Hindi, Physics")
                .checkHobbies("Sports, Music")
                .checkPicture("catinabox-150x150.jpg")
                .checkAddress("Russian Federation, Moscow")
                .checkStateCity("Haryana Karnal");
    }
}

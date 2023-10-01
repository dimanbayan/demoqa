package guru.qa;

import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase{

    @Test
    public void fillingForm(){
        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.openPage()
                .setFullName("Новиков Алексей Владимирович")
                .setEmail("novikov@mail.ru")
                .setCurrentAddress("г.Москва, ул. Сходненская, д. 5")
                .setPermanentAddress("г.Москва, ул. Профсоюзная, д. 27")
                .submit();

textBoxPage.checkName("Новиков Алексей Владимирович")
        .checkEmail("novikov@mail.ru")
        .checkCurrentAddress("г.Москва, ул. Сходненская, д. 5")
        .checkPermanentAddress("г.Москва, ул. Профсоюзная, д. 27");
    }
}

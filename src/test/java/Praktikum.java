import com.codeborne.selenide.ElementsCollection;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Praktikum {

    @Before
    public void setUp() {
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("govnec@gmail.com");
        $(byId("password")).setValue("d36rk");
        $(byClassName("auth-form__button")).click();
    }

    @Test
    public void loadProfileImageTest() {

        // кликни по изображению профиля
        $(byCssSelector(".profile__image")).click();
        // в поле ссылки на изображение введи ссылку
        $(byId("owner-avatar")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png");
        // сохрани новое изображение
        $(byXpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }

    @Test
    public void loadImageTest() {

        // кликни по кнопке добавления нового контента
        $(byClassName("profile__add-button")).click();
        // в поле названия введи «Москва»
        $(byName("name")).setValue("Москва");
        // в поле ссылки на изображение введи ссылку
        $(byName("link")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
        // сохрани контент
        $(byXpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        // удали добавленную карточку, кликнув по кнопке удаления
        $(byXpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
    }

    @Test
    public void EditProfileTest(){
        // кликни по кнопке редактирования профиля
        $(byClassName("profile__edit-button")).click();
        // введи «Аристарх Сократович» в поле «Имя»
        $(byId("owner-name")).setValue("Аристарх Сократович");
        // введи «Автор автотестов» в поле «Занятие»
        $(byId("owner-description")).setValue("Автор автотестов");
        // сохрани изменения
        $(byXpath(".//form[@name='edit']/button[text()='Сохранить']")).click();
    }
    @Test
    public void getTextCardTest(){
        // получи текст второй карточки и сохрани его в переменную cardText
        String cardText = $$(byClassName("card")).get(1).find(byClassName("card__title")).getText();
        System.out.println(cardText);
    }
}

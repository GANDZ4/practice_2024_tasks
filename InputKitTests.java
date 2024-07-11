package com.example.uitests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.ExtendWith;
import com.codeborne.selenide.junit5.TextReportExtension;
import static java.time.Duration.ofSeconds;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@ExtendWith({TextReportExtension.class})
public class InputKitTests {
    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1280x720"; // Устанавливаем размер окна браузера
        Configuration.baseUrl = "https://buefy.org/documentation";
    }

    @Test
    public void testInputField() {
        open("/field"); // Открыть необходимый раздел

        // Переключение отображения
        $$("label.b-radio.radio").get(1).click();

        // Очистка поля Name и ввод значения
        $$("input.input").get(4).shouldBe(visible, ofSeconds(10)).clear();
        $$("input.input").get(4).shouldBe(visible, ofSeconds(10)).setValue("John Silver");
        $$("input.input").get(4).shouldHave(value("John Silver"));

        // Ввод значения в Email
        $$("input.input").get(5).shouldBe(visible, ofSeconds(10)).setValue("gmail.com");
        $$("input.input").get(5).shouldHave(value("john@gmail.com"));

        // Ввод значения в Username
        $$("input.input").get(6).shouldBe(visible, ofSeconds(10)).setValue("123");
        $$("input.input").get(6).shouldHave(value("johnsilver123"));

        // Ввод значения в Password
        $$("input.input").get(7).shouldBe(visible, ofSeconds(10)).setValue("P4$$w0rd!");
        $$("input.input").get(7).shouldHave(value("123P4$$w0rd!"));

        // Выбор из выпадающего меню Subject
        $(By.xpath("/html/body/div[1]/main/section/div[2]/div/div/div[1]/section[2]/div[2]/div[2]/section/div[6]/div/span/select")).shouldBe(visible, ofSeconds(10)).click();
        $(By.xpath("/html/body/div[1]/main/section/div[2]/div/div/div[1]/section[2]/div[2]/div[2]/section/div[6]/div/span/select/option[3]")).shouldBe(visible, ofSeconds(10)).click();

        // Ввод текста в Message
        $(".textarea").shouldBe(visible, ofSeconds(10)).setValue("Something");
        $(".textarea").shouldHave(value("Something"));

        // Выбор фреймворка по подсказке
        $$("input.input.is-rounded").get(0).shouldBe(visible, ofSeconds(10)).click();
        $$("input.input.is-rounded").get(0).shouldBe(visible, ofSeconds(10)).setValue("V");
        $$("a.dropdown-item").get(1).shouldBe(visible, ofSeconds(10)).click();

        // Выбор даты в календаре
        $$("input.input").get(9).shouldBe(visible, ofSeconds(10)).click();
        $$("a.datepicker-cell.is-selectable").get(1).shouldBe(visible, ofSeconds(10)).click();

        // Расширенный выбор в календаре
        $$("input.input.is-rounded").get(1).shouldBe(visible, ofSeconds(10)).click();
        // Выбор даты
        $$("select").get(5).shouldBe(visible, ofSeconds(10)).selectOptionByValue("2019"); // установить год 2019
        $$("select").get(4).shouldBe(visible, ofSeconds(10)).selectOptionByValue("0"); // установить месяц январь
        $$("a.datepicker-cell.is-selectable").get(44).shouldBe(visible, ofSeconds(10)).click(); // установить число 14

        // Выбор времени
        $$("select").get(6).shouldBe(visible, ofSeconds(10)).selectOptionByValue("11"); // установить 11 часов
        $$("select").get(7).shouldBe(visible, ofSeconds(10)).selectOptionByValue("5"); // установить 5 минут
        actions().sendKeys(Keys.ESCAPE).perform();

        // Выбор числа
        $$("button.is-primary").get(1).shouldBe(visible, ofSeconds(10)).click();
        $$("button.is-primary").get(1).shouldBe(visible, ofSeconds(10)).click();
        $$("button.is-primary").get(1).shouldBe(visible, ofSeconds(10)).click();
        $$("button.is-primary").get(1).shouldBe(visible, ofSeconds(10)).click();
        $$("button.is-primary").get(0).shouldBe(visible, ofSeconds(10)).click();
        $$("button.is-primary").get(0).shouldBe(visible, ofSeconds(10)).click();

        // Добавление тега
        $$("input.input").get(12).shouldBe(visible, ofSeconds(10)).clear();
        $$("input.input").get(12).shouldBe(visible, ofSeconds(10)).setValue("Some Tag");
        $$("input.input").get(12).shouldHave(value("Some Tag"));
        actions().sendKeys(Keys.ENTER).perform();
        $$("a.delete.is-small").get(0).shouldBe(visible, ofSeconds(10)).click();

        // Ввод значения в поиск и удаление с помощью соответствующей кнопки на сайте
        $$("input.input").get(14).shouldBe(visible, ofSeconds(10)).clear();
        $$("input.input").get(14).shouldBe(visible, ofSeconds(10)).setValue("Something");
        $$("input.input").get(14).shouldHave(value("Something"));
        actions().sendKeys(Keys.ESCAPE).perform();
    }


}





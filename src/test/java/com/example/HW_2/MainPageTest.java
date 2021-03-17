package com.example.HW_2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    private final MainPage mainPage = new MainPage();

//    @BeforeAll
//    public static void setUpAllure() {
//        SelenideLogger.addListener("allure", new AllureSelenide());
//    }

    @BeforeEach
    public void setUp() {

        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }
    @Test
    public void form() {
        Faker faker = new Faker();
        String f_name = faker.name().firstName();
        String f_lastname = faker.name().lastName();
        String sex = "Male";
        String f_useremail = faker.internet().emailAddress();
        String f_phoneNumber = faker.phoneNumber().subscriberNumber(10);
        String f_dateofbirthinput = "19 June,1970";
        String f_subjects = "arts";
        String up_file = "panda.jpeg";
        String address = faker.address().fullAddress();

        String state = "NCR";
        String city = "Delhi";

        mainPage.firstname.sendKeys(f_name);
        mainPage.lastname.sendKeys(f_lastname);
        mainPage.useremail.sendKeys(f_useremail);
        mainPage.gender.click();
        mainPage.usernumber.sendKeys(f_phoneNumber);

        mainPage.dateofbirthinput.click();
        mainPage.month_select.selectOption("June");
        mainPage.year_select.selectOption("1970");
        mainPage.other_select.click();

        mainPage.subjects_con.click();
        mainPage.subjects_on_p.sendKeys(f_subjects);
        mainPage.subjects_on_p.sendKeys(Keys.TAB);
        mainPage.hobbies.click();
        mainPage.uploadpicture.uploadFromClasspath(up_file);

        mainPage.adress.setValue(address);

        mainPage.select_state.sendKeys("N");
        mainPage.select_state_sel.click();

        mainPage.select_city.sendKeys("D");
        mainPage.select_city_sel.click();

        mainPage.submit_button.click();

        mainPage.modal_content.shouldHave(Condition.text(f_dateofbirthinput),
                Condition.text(f_name),
                Condition.text(f_lastname),
                Condition.text(f_useremail),
                Condition.text(sex),
                Condition.text(f_phoneNumber),
                Condition.text(f_dateofbirthinput),
                Condition.text(f_subjects),
                Condition.text(address),
                Condition.text(state),
                Condition.text(city),
                Condition.text(up_file)
        );

    }

}

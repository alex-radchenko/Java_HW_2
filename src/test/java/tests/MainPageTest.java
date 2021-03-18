package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import pages.InputFields;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    InputFields steps = new InputFields();

    @Test
    void form() {
        Faker faker = new Faker();
        String fakeFirstName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String gender = "Male";
        String fakeUserEmail = faker.internet().emailAddress();
        String fakePhoneNumber = faker.phoneNumber().subscriberNumber(10);
        String fakeDateOfBirthInput = "19 June,1970";
        String fakeSubjects = "arts";
        String pathUploadFile = "panda.jpeg";
        String address = faker.address().fullAddress();

        String state = "NCR";
        String city = "Delhi";

        steps.openForm()
                .fillFirstName(fakeFirstName)
                .fillLastName(fakeLastName)
                .fillEmail(fakeUserEmail)
                .clickRadioButtonGender(gender)
                .fillPhoneNumber(fakePhoneNumber);

        Selenide.sleep(3000);
    }
}
//        mainPage.userNumber.val(fakePhoneNumber);
//
//        mainPage.dateOfBirthInput.click();
//        mainPage.monthSelect.selectOption("June");
//        mainPage.yearSelect.selectOption("1970");
//        mainPage.dayOfBirth.click();
//
//        mainPage.subjects.click();
//        mainPage.subjectSelect.val(fakeSubjects).pressEnter();;
//        mainPage.hobbies.click();
//        mainPage.uploadPicture.uploadFromClasspath(pathUploadFile);
//
//        mainPage.address.setValue(address);
//
//        mainPage.selectState.val("N").pressEnter();
//
//        mainPage.selectCity.val("D").pressEnter();
//
//        mainPage.submitButton.click();
//
//        mainPage.modalContent.shouldHave(Condition.text(fakeDateOfBirthInput),
//                Condition.text(fakeName),
//                Condition.text(fakelastName),
//                Condition.text(fakeUserEmail),
//                Condition.text(sex),
//                Condition.text(fakePhoneNumber),
//                Condition.text(fakeDateOfBirthInput),
//                Condition.text(fakeSubjects),
//                Condition.text(address),
//                Condition.text(state),
//                Condition.text(city),
//                Condition.text(pathUploadFile)
//        );

package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    private final MainPage mainPage = new MainPage();

    @BeforeEach
    public void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";

        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }
    @Test
    public void form() {
        Faker faker = new Faker();
        String fakeName = faker.name().firstName();
        String fakelastName = faker.name().lastName();
        String sex = "Male";
        String fakeUserEmail = faker.internet().emailAddress();
        String fakePhoneNumber = faker.phoneNumber().subscriberNumber(10);
        String fakeDateOfBirthInput = "19 June,1970";
        String fakeSubjects = "arts";
        String pathUploadFile = "panda.jpeg";
        String address = faker.address().fullAddress();

        String state = "NCR";
        String city = "Delhi";

        mainPage.firstNname.val(fakeName);
        mainPage.lastName.val(fakelastName);
        mainPage.usereMail.val(fakeUserEmail);
        mainPage.gender.click();
        mainPage.userNumber.val(fakePhoneNumber);

        mainPage.dateOfBirthInput.click();
        mainPage.monthSelect.selectOption("June");
        mainPage.yearSelect.selectOption("1970");
        mainPage.dayOfBirth.click();

        mainPage.subjects_con.click();
        mainPage.subjects_on_p.val(fakeSubjects);
        mainPage.subjects_on_p.pressEnter();
        mainPage.hobbies.click();
        mainPage.uploadPicture.uploadFromClasspath(pathUploadFile);

        mainPage.address.setValue(address);

        mainPage.selectState.val("N").pressEnter();

        mainPage.selectCity.val("D").pressEnter();

        mainPage.submitButton.click();

        mainPage.modalContent.shouldHave(Condition.text(fakeDateOfBirthInput),
                Condition.text(fakeName),
                Condition.text(fakelastName),
                Condition.text(fakeUserEmail),
                Condition.text(sex),
                Condition.text(fakePhoneNumber),
                Condition.text(fakeDateOfBirthInput),
                Condition.text(fakeSubjects),
                Condition.text(address),
                Condition.text(state),
                Condition.text(city),
                Condition.text(pathUploadFile)
        );

    }

}

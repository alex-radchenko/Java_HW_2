package tests;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import pages.RegistationFormPage;

public class RegistationFormTests {
    RegistationFormPage steps = new RegistationFormPage();

    @Test
    void registationFormTest() {
        Faker faker = new Faker();
        String fakeFirstName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String gender = "Male";
        String fakeUserEmail = faker.internet().emailAddress();
        String fakePhoneNumber = faker.phoneNumber().subscriberNumber(10);
        String fakeDateOfBirthInput = "19 June,1970";
        String fakeSubjects = "arts";
        String pathUploadFile = "panda.jpeg";
        String fakeAddress = faker.address().fullAddress();

        String state = "NCR";
        String city = "Delhi";

        steps.openForm()
                .fillFirstName(fakeFirstName)
                .fillLastName(fakeLastName)
                .fillEmail(fakeUserEmail)
                .clickRadioButtonGender(gender)
                .fillPhoneNumber(fakePhoneNumber)
                .fillDateOfBirthInput()
                .fillSubjects(fakeSubjects)
                .fillHobbies()
                .uploadPicture(pathUploadFile)
                .fillAddress(fakeAddress)
                .selectState()
                .selectCity()
                .submitButton();

        steps.checkInModalContent(fakeDateOfBirthInput)
                .checkInModalContent(fakeFirstName)
                .checkInModalContent(fakeLastName)
                .checkInModalContent(fakeUserEmail)
                .checkInModalContent(gender)
                .checkInModalContent(fakePhoneNumber)
                .checkInModalContent(fakeDateOfBirthInput)
                .checkInModalContent(fakeSubjects)
                .checkInModalContent(fakeAddress)
                .checkInModalContent(state)
                .checkInModalContent(city)
                .checkInModalContent(pathUploadFile);
    }
}
package pages;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import io.qameta.allure.Step;

public class RegistationFormPage {
    SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select"),
            dayOfBirth = $(".react-datepicker__day--019"),
            subjects = $("#subjectsContainer"),
            subjectSelect = $("#subjectsInput"),
            hobbies = $x("//label[@for='hobbies-checkbox-1']"),
            uploadPicture = $("#uploadPicture"),
            address = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            submitButton = $("#submit"),
            modalContent = $(".modal-content");

    private SelenideElement getElementByText(String text) {
        return $(byText(text));
    }


    @Step("Open form")
    public RegistationFormPage openForm() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    @Step("Fill first name")
    public RegistationFormPage fillFirstName(String firstNameValue) {
        firstName.val(firstNameValue);
        return this;
    }

    @Step("Fill last name")
    public RegistationFormPage fillLastName(String LastNameValue) {
        lastName.val(LastNameValue);
        return this;
    }

    @Step("Fill email")
    public RegistationFormPage fillEmail(String EmailValue) {
        userEmail.val(EmailValue);
        return this;
    }

    @Step("Select '{gender}' gender")
    public RegistationFormPage clickRadioButtonGender(String gender) {
        getElementByText(gender).click();
        return this;
    }

    @Step("Fill phone number")
    public RegistationFormPage fillPhoneNumber(String PhoneNumberValue) {
        userNumber.val(PhoneNumberValue);
        return this;
    }

    @Step("Fill date of birthInput ")
    public RegistationFormPage fillDateOfBirthInput() {
        dateOfBirthInput.click();
        monthSelect.selectOption("June");
        yearSelect.selectOption("1970");
        dayOfBirth.click();
        return this;
    }

    @Step("Fill subjects ")
    public RegistationFormPage fillSubjects(String fakeSubjects) {
        subjects.click();
        subjectSelect.val(fakeSubjects).pressEnter();
        return this;
    }
    
    @Step("Fill hobbies")
    public RegistationFormPage fillHobbies() {
        hobbies.click();
        return this;
    }

    @Step("Upload picture")
    public RegistationFormPage uploadPicture(String pathToFile) {
        uploadPicture.uploadFromClasspath(pathToFile);
        return this;
    }

    @Step("Fill address")
    public RegistationFormPage fillAddress(String add_address) {
        address.setValue(add_address);
        return this;
    }

    @Step("Select state")
    public RegistationFormPage selectState() {
        selectState.val("N").pressEnter();
        return this;
    }

    @Step("Select city")
    public RegistationFormPage selectCity() {
        selectCity.val("D").pressEnter();
        return this;
    }

    @Step("Press submit button")
    public void submitButton() {
        submitButton.click();
    }

    @Step("Check test")
    public RegistationFormPage checkInModalContent(String textForCheck) {
        modalContent.shouldHave(text(textForCheck));
        return this;
    }

}
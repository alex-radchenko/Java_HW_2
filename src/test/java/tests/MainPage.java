package tests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement firstNname = $("#firstName");
    public SelenideElement lastName = $("#lastName");
    public SelenideElement usereMail = $("#userEmail");

    public SelenideElement gender = $(byText("Male"));
    public SelenideElement userNumber = $("#userNumber");


    public SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    public SelenideElement monthSelect = $(".react-datepicker__month-select");
    public SelenideElement yearSelect = $(".react-datepicker__year-select");
    public SelenideElement dayOfBirth = $(".react-datepicker__day--019");


    public SelenideElement subjects_con = $("#subjectsContainer");
    public SelenideElement subjects_on_p = $("#subjectsInput");

    public SelenideElement hobbies = $x("//label[@for='hobbies-checkbox-1']");

    public SelenideElement uploadPicture = $("#uploadPicture");

    public SelenideElement address = $("#currentAddress");
    public SelenideElement selectState = $("#react-select-3-input");

    public SelenideElement selectCity = $("#react-select-4-input");

    public SelenideElement submitButton = $("#submit");

    public SelenideElement modalContent = $(".modal-content");

}

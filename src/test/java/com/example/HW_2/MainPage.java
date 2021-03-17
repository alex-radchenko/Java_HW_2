package com.example.HW_2;

import com.codeborne.selenide.SelenideElement;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement firstname = $("#firstName");
    public SelenideElement lastname = $("#lastName");
    public SelenideElement useremail = $("#userEmail");
    public SelenideElement gender = $x("//*[contains(text(),'Male')]");
    public SelenideElement usernumber = $("#userNumber");


    public SelenideElement dateofbirthinput = $("#dateOfBirthInput");
    public SelenideElement month_select = $(".react-datepicker__month-select");
    public SelenideElement year_select = $(".react-datepicker__year-select");
    public SelenideElement other_select = $("[aria-label='Choose Friday, June 19th, 1970']");


    public SelenideElement subjects_con = $("#subjectsContainer");
    public SelenideElement subjects_on_p = $("#subjectsInput");

    public SelenideElement hobbies = $x("//label[@for='hobbies-checkbox-1']");

    public SelenideElement uploadpicture = $("#uploadPicture");

    public SelenideElement adress = $("#currentAddress");
    public SelenideElement select_state = $("#react-select-3-input");
    public SelenideElement select_state_sel = $x("//*[contains(text(),'NCR')]");


    public SelenideElement select_city = $("#react-select-4-input");
    public SelenideElement select_city_sel = $x("//*[contains(text(),'Delhi')]");

    public SelenideElement submit_button = $("#submit");

    public SelenideElement modal_content = $(".modal-content");






//    subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3

}

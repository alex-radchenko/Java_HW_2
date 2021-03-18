package tests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class HW3 {
    @BeforeEach
    public void setUp() {
//        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";

        Configuration.headless = false;
    }
    @Test
    void Github() {
        open("https://github.com/");
        $("input[placeholder='Search GitHub']").val("Selenide").pressEnter();
        $x("//a[@href='/selenide/selenide']").click();
        $x("//span[@data-content='Wiki']").click();
        $x("//a[text()='SoftAssertions']").shouldHave(Condition.text("SoftAssertions"));
        $x("//a[text()='SoftAssertions']").click();
        $("#wiki-body").shouldHave(Condition.text("JUnit5"), Condition.text("@ExtendWith({SoftAssertsExtension.class})"));
    }

    @Test
    void dragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}
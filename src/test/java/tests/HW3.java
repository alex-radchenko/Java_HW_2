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
    //don't work on mac
    @Test
    void DragDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }

    //don't work on mac
    @Test
    void DragDropAction(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        Selenide.actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }

    @Test
    void dragAndDropTestJS() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        executeJavaScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", $("#column-a"), $("#column-b"));

        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        Selenide.sleep(3333);
    }


}

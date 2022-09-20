package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.baseUrl = "https://demoqa.com";
    }

    String firstName = "Kseniia";
    String lastName = "Kireeva";
    String email = "250670ov@mail.ru";
    String gender = "Female";
    String mobileNumber = "9658726672";
    String subject1 = "Maths";
    String subject2 = "English";
    String hobbies = "Sports";
    String picture = "cat.jpeg";
    String address = "Russia";
    String state = "NCR";
    String city = "Delhi";

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        zoom(0.8);

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--009").click();

        $("#subjectsInput").setValue(subject2).pressEnter();
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();

        $("#uploadPicture").uploadFromClasspath(picture);

        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent()
                .shouldHave(Condition.text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent()
                .shouldHave(Condition.text(email));
        $(".table-responsive").$(byText("Gender")).parent()
                .shouldHave(Condition.text(gender));
        $(".table-responsive").$(byText("Mobile")).parent()
                .shouldHave(Condition.text(mobileNumber));
        $(".table-responsive").$(byText("Subjects")).parent()
                .shouldHave(Condition.text(subject2 + ", " + subject1));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(Condition.text(hobbies));
        $(".table-responsive").$(byText("Picture")).parent()
                .shouldHave(Condition.text(picture));
        $(".table-responsive").$(byText("Address")).parent()
                .shouldHave(Condition.text(address));
        $(".table-responsive").$(byText("State and City")).parent()
                .shouldHave(Condition.text(state + " " + city));
    }

}

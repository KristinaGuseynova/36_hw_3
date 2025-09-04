package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableResults;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput =  $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            userAddress = $("#currentAddress"),
            stateModal = $("#react-select-3-input"),
            cityModal = $("#react-select-4-input"),
            pressSubmit = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResults tableResults = new TableResults();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        userAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateModal.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityModal.setValue(value).pressEnter();
        return this;
    }

    public void pressSubmit() {
        pressSubmit.click();
    }

    public RegistrationPage checkResult(String key, String value){
        tableResults.checkTableResults(key, value);
        return this;
    }
}

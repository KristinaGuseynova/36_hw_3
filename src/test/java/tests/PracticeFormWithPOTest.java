package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormWithPOTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();



    @Test
    void fillFormTest() {
        registrationPage.openPage()
                        .setFirstName("John")
                        .setLastName("Wick")
                        .setEmail("MrJohn@Wick.com")
                        .setGender("Male")
                        .setUserNumber("1234567891")
                        .setDateOfBirth("02", "September", "1964")
                        .setSubject("phy") .setHobbies("Sports")
                        .setPicture("image.png")
                        .setAddress("Hotel Continental")
                        .setState("Haryana")
                        .setCity("Panipat")
                        .pressSubmit();


        registrationPage.checkResult("Student Name", "John Wick")
                        .checkResult("Student Email", "MrJohn@Wick.com")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "1234567891")
                        .checkResult("Date of Birth", "2 September,1964")
                        .checkResult("Subjects", "Physics")
                        .checkResult("Hobbies", "Sports")
                        .checkResult("Picture", "image.png")
                        .checkResult("Address", "Hotel Continental")
                        .checkResult("State and City", "Haryana Panipat");

    }

    @Test
    void minimumDataTest() {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Wick")
                .setGender("Male")
                .setUserNumber("1234567891")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "John Wick")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567891");
    }

    @Test
    void NoOneAnswerTest() {
        registrationPage.openPage()
                .pressSubmit();

        registrationPage.checkNoResult();
    }


}


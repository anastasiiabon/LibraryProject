package com.cyberteckschool.library2.pages;
import com.cyberteckschool.library2.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Scanner;

public class LoginPage extends BasePage {

    //To not use web elements directly in step definition classes
    //helps to prevent code duplication and keep step definitions clean
    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return warningMessage.getText().trim();
    }

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);

    }

    public void login() {
        String usernameValue = ConfigurationReader.getProperty("librarian.username");
        String passwordValue = ConfigurationReader.getProperty("librarian.password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login2() {
        String usernameValue = ConfigurationReader.getProperty("student.username");
        String passwordValue = ConfigurationReader.getProperty("student.password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }


}

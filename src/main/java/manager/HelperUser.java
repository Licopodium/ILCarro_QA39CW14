package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public interface HelperUser extends HelperBase {

    default void openLoginForm() {
        click(By.xpath("//*[.=' Log in ']"));
    }

    default void openRegistrationForm() {
        click(By.xpath("//*[.=' Sign up ']"));
    }


    default void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    default void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    default void fillRegistrationForm(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        clickCheckbox();
    }

    default void fillRegistrationForm1(User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }


    default void clickCheckbox() {
        // variant 1
//     click(By.cssSelector("label[for='terms-of-use']"));
        // variant 2
      //  JavascriptExecutor js = (JavascriptExecutor) wd;
     //   js.executeScript("document.querySelector('#terms-of-use').click();");
        // variant 3
        Rectangle rect = wd.findElement(By.xpath("(//label[contains(text(),'I agree to the')])[1]")).getRect();
        int x = rect.getX() + rect.getWidth() * 1 / 13;
        int y = rect.getY() + rect.getHeight() / 2;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x, y).click().perform();
    }


    default void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    default void submitRegistration() {
        click(By.xpath("//button[@type='submit']"));
    }

    default boolean isLoggedSuccess() {
        return isElementPresent(
                By.xpath("//h2[contains(text(),'success')]"));
    }

    default boolean isLogged() {
        return isElementPresent(
                By.xpath("//*[.=' Logout ']"));
    }

    default void logout() {
        click(By.xpath("//*[.=' Logout ']"));
    }

    default void clickOkButton() {
        click(By.xpath("//button[@type='button']"));
    }

    default void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        clickOkButton();
    }

    default boolean isErrorMessageDisplayed() {
        return isElementPresent(By.xpath("//div[contains(text(), 'Wrong email format')]"));
    }
    default boolean isErrorMessageDisplayed2() {
        return isElementPresent(By.xpath("//div[contains(text(), ' Name is required ')]"));

    }
    default boolean isErrorMessageDisplayed3() {
        return isElementPresent(By.xpath("//div[contains(text(), 'Last name is required')]"));

    }

    default boolean isErrorMessageDisplayed4() {
        return isElementPresent(By.xpath("//div[contains(text(), 'Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]')]"));

    }

}

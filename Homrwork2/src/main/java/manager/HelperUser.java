package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("a[ng-reflect-router-link='login']"));
    }


    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[@id='email']"), email);

        type(By.xpath("//input[@id='password']"), password);
    }

    public void submitLogin() {
        click(By.xpath("//button[contains(text(),'Y’alla!')]"));
    }


    public String getMessage() {
//        WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = element.getText();
//        return text;
//        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h1")).getText();

    }

    public String getMessage2(){
        return wd.findElement(By.cssSelector(".input-container")).getText();
    }


    public void acceptLogin() {
        click(By.xpath("//button[normalize-space()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[text()=' Logout ']"));
    }
}
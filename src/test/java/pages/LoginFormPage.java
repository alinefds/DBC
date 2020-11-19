package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {
    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    public LoginFormPage digitarLogin(String login) {
        driver.findElement(By.id("loginform")).findElement(By.id("j_username")).sendKeys(login);

        return this;
    }
    public LoginFormPage digitarSenha(String senha) {
        driver.findElement(By.id("loginform")).findElement(By.id("j_password")).sendKeys(senha);

        return this;
    }
    public HomePage clicarEfetuarLogin() {
        driver.findElement(By.id("loginbutton")).click();

        return new HomePage(driver);
    }

    public HomePage fazerLogin(String login, String senha) {
        digitarLogin(login);
        digitarSenha(senha);
        clicarEfetuarLogin();

        return new HomePage(driver);
    }

}

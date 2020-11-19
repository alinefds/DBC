package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginFormPage AcessarSite() {
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        return new LoginFormPage(driver);
    }
}

//estrutura defult de uma page do pageobject
//um atributo do tipo WebDriver e um construtor que recebe um instancia do
// WebDriver e atribiu a propridade interna

//import org.openqa.selenium.WebDriver;

//public class LoginPage {
//private WebDriver driver;

//construtor
//jogar a instancia driver dentro do atributo driver que ja tem na class
//public LoginPage(WebDriver driver) {
//this. driver = driver;

// em todas as paginas do page objects ter um atributo privado que é o WebDriver
// e tbm um construtor que esta aguardando que esta aguardando um WebDriver

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ItensDeOsSgz extends BasePage {

    public ItensDeOsSgz(WebDriver driver) {
        super(driver);
    }

    public ItensDeOsSgz cliclarBotaoWF() {
        driver.findElement(By.cssSelector("a#ROUTEWF__-tbb_anchor.on")).click();

        return this;
    }

    public ItensDeOsSgz irParaDialogoAcaoExecutada() {
        driver.findElement(By.id("inputwf-dialog_inner"));

        return this;
    }

    public ItensDeOsSgz cliclarNaAcaoOSEmAndamento() {
        driver.findElement(By.cssSelector("#mb64e0e96-rb")).click();

        return this;
    }

    public ItensDeOsSgz ClickBotaoOK() {
        driver.findElement(By.id("m37917b04-pb")).click();

        return this;

    }

    public ItensDeOsSgz irDialogoConfirmarAcao() {
        driver.findElement(By.cssSelector("#ms_wowf03-dialog_holder"));

        return this;
    }

}


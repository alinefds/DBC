package pages;

import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocalizarItensdeOS extends BasePage {

    public LocalizarItensdeOS(WebDriver driver) {
        super(driver);
    }

    public LocalizarItensdeOS clicarNoCampoStatus () {
        driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb")).click();

        return this;
    }

    public LocalizarItensdeOS digitarStatus (String status) {
        driver.findElement(By.cssSelector("#m6a7dfd2f_tfrow_\\[C\\:5\\]_txt-tb")).sendKeys(status);

        return this;

    }

    public LocalizarItensdeOS clicarNoCampoSubPrefeitura () {
        driver.findElement(By.cssSelector("#m6a7dfd2f_tfrow_\\[C\\:10\\]_txt-tb")).click();

        return this;
    }

    public LocalizarItensdeOS limparCampoSubPrefeitura () {
        driver.findElement(By.cssSelector("#m6a7dfd2f_tfrow_\\[C\\:10\\]_txt-tb")).clear();

        return this;
    }

    public LocalizarItensdeOS clicarCampoServiço () {
        driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb")).click();

        return this;
    }

    public LocalizarItensdeOS digitarServiço (String serviço ) {
        driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb")).sendKeys(serviço);

        return this;
    }

    public LocalizarItensdeOS ciclarBotaoPesquisar () {
        driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']")).click();

        return this;
    }

    public ItensDeOsSgz clicarNoItemdeOS () {
        driver.findElement(By.cssSelector("#m6a7dfd2f_tdrow_\\[C\\:1\\]_ttxt-lb\\[R\\:0\\]")).click();

        return new ItensDeOsSgz(driver);
    }

    public ItensDeOsSgz fazerPesquisa (String status, String serviço) {
        clicarNoCampoStatus ();
        digitarStatus(status);
        clicarNoCampoSubPrefeitura();
        limparCampoSubPrefeitura();
        clicarCampoServiço();
        digitarServiço(serviço);
        ciclarBotaoPesquisar();
        clicarNoItemdeOS();

        return new ItensDeOsSgz(driver);
    }


}


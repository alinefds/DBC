package pages;

import net.sf.jasperreports.components.charts.ChartSettingsXmlFactory;
import org.junit.Assert;
import org.kohsuke.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.Agro.AcessarItensDeOsSgzAgro;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage menuOrdensdeServiço () {
        driver.findElement(By.linkText("Ordens de Serviço")).click();

        return this;

    }

    public LocalizarItensdeOS aplicacaoItensdeOsSgz () {
        driver.findElement(By.linkText("Itens de OS SGZ")).click();

        return new LocalizarItensdeOS (driver);

    }

    public LocalizarItensdeOS acessarPesquisa () {
        menuOrdensdeServiço();
        aplicacaoItensdeOsSgz();

        return new LocalizarItensdeOS (driver);
    }
}

package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.After.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Beta;
import org.openqa.selenium.WebDriver;
import pages.LocalizarItensdeOS;
import pages.LoginPage;
import suporte.AcessarMaximo;

public class AcessarItensDeOsSgzADMINTest {
    private WebDriver driver;

    //Rodar tudo antes da execução do teste
    @Before
    public void setUp() {
        driver = AcessarMaximo.createChrome();

    }

    @Test
    public void testStatusAprovadoItemDeOsEmAndamentoAdmin() {
        new LoginPage(driver)
                .AcessarSite()
                .fazerLogin("maxadmin" , "Password01")
                .acessarPesquisa()
                .fazerPesquisa("=APROVADO", "HIDRO")
                .criterioDeAceitação();
    }

    //Fechar Tela
    @After
    public void tearDown() {
        driver.quit();

    }
}

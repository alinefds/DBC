package tests.Admin;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import suporte.AcessarMaximo;
import suporte.Generator;
import suporte.Screenshot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
@SuppressWarnings("unused")


public class testStatusAprovadoItemDeOsEmAndamentoAdmin {
    //expor a propriedade driver para todos os metodos da classe
    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before

    public void setUP() {
        driver = AcessarMaximo.createChrome();

        driver.findElement(By.id("details-button")).click();

        driver.findElement(By.id("proceed-link")).click();

        WebElement formularioLoginForm = driver.findElement(By.id("loginform"));

        driver.findElement(By.id("j_username")).sendKeys("maxadmin");

        driver.findElement(By.id("j_password")).sendKeys("Password01");

        driver.findElement(By.id("loginbutton")).click();

        WebElement ClickMenuOs = driver.findElement(By.linkText("Ordens de Serviço"));
        ClickMenuOs.click();

        WebElement ClickItensdeOsSgz = driver.findElement(By.linkText("Itens de OS SGZ"));
        ClickItensdeOsSgz.click();

    }

    @Test
    public void testStatusAprovadoItemDeOsEmAndamentoAdmin() {

        //Filtrar o
        WebElement CampoStatus = driver.findElement(By.cssSelector("#m6a7dfd2f_tfrow_\\[C\\:5\\]_txt-tb"));
        CampoStatus.click();
        CampoStatus.sendKeys("=APROVADO");

        WebElement CampoSubprefeitura = driver.findElement(By.cssSelector("#m6a7dfd2f_tfrow_\\[C\\:10\\]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        //WebElement CampoClassificacaoDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacaoDeServico.click();
        //CampoClassificacaoDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.cssSelector("#m6a7dfd2f_tdrow_\\[C\\:1\\]_ttxt-lb\\[R\\:0\\]"));
        String ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Administrador do Sistema\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);
        ClickOs.click();

        //Clicar no Botão Rotear FLuxo
        WebElement BotaoWF = driver.findElement(By.cssSelector("a#ROUTEWF__-tbb_anchor.on"));
        BotaoWF.click();
        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Administrador do Sistema\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);


        WebElement DialogoAcaoExecutada = driver.findElement(By.id("inputwf-dialog_inner"));
        WebElement OsEmAndamento = driver.findElement(By.cssSelector("#mb64e0e96-rb"));
        assertTrue(OsEmAndamento.isSelected());
        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Administrador do Sistema\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        WebElement ClickBotaoOK = driver.findElement(By.id("m37917b04-pb"));
        ClickBotaoOK.click();

        WebElement DialogoConfirmarAcao = driver.findElement(By.cssSelector("#ms_wowf03-dialog_holder"));
        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Administrador do Sistema\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @After
    public void tearDown() {
        // Fechar o navegador"
        driver.quit();

    }
}

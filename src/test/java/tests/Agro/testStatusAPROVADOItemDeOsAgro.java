package tests.Agro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

@SuppressWarnings("unused")

public class testStatusAPROVADOItemDeOsAgro {

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

        driver.findElement(By.id("j_username")).sendKeys("D782898");

        driver.findElement(By.id("j_password")).sendKeys("123456");

        driver.findElement(By.id("loginbutton")).click();

        WebElement mensagemHome = driver.findElement(By.id("titlebar-tb_username"));
        String mensagem = mensagemHome.getText();
        assertEquals("Audrey Castelo Branco", mensagem);

        WebElement ClickMenuOs = driver.findElement(By.linkText("Ordens de Serviço"));
        ClickMenuOs.click();

        WebElement ClickItensdeOsSgz = driver.findElement(By.linkText("Itens de OS SGZ"));
        ClickItensdeOsSgz.click();

    }

    @Test
    public void testStatusAprovadoItemDeOsEmAndamento() {

        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.click();
        CampoStatus.sendKeys("=APROVADO");


        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");

        WebElement CampoSubPrefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]-c"));
        CampoSubPrefeitura.click();
        CampoSubPrefeitura.clear();

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.id("m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]"));
        String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Administrador do Sistema\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServiço = driver.findElement(By.xpath("//*[@id=\"m397b0593_tabbody_table\"]"));




    }

    @After
    public void tearDown() {
        // Fechar o navegador"
        driver.quit();

    }
}




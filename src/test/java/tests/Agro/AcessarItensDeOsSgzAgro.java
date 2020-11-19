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

public class AcessarItensDeOsSgzAgro {
    //expor a propriedade driver para todos os metodos da classe
    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Before

    public void setUP() {
        driver = AcessarMaximo.createChrome();

        // clicar no botão com o id "details-button"
        driver.findElement(By.id("details-button")).click();

        // clicar no botão com o id "proceed-link"
        driver.findElement(By.id("proceed-link")).click();

        // Identifcando o formulário de Login
        WebElement formularioLoginForm = driver.findElement(By.id("loginform"));

        // Digitar no campo com o nome "Nome do Usuário:" que está dentro do formulário
        // de id "loginform" o texto "maxadmin"
        driver.findElement(By.id("j_username")).sendKeys("D782898");

        //// Digitar no campo com o nome "Senha:" que está dentro do formulário de id
        //// "loginform" o texto "Password01"
        driver.findElement(By.id("j_password")).sendKeys("123456");

        String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Agrônomo\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        // Clicar no botão que possui o id "loginbutton"
        driver.findElement(By.id("loginbutton")).click();

        // Validar que a mensagem apresentada foi "Bem-vindo, Administrador do Maximo"
        WebElement mensagemHome = driver.findElement(By.id("titlebar-tb_username"));
        String mensagem = mensagemHome.getText();
        assertEquals("Audrey Castelo Branco", mensagem);

        ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Agrônomo\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);


        //Acessar o menu Principal "Ordens de Serviço"
        WebElement ClickMenuOs = driver.findElement(By.linkText("Ordens de Serviço"));
        ClickMenuOs.click();

        //Acessar o aplicativo "Itens de OS SGZ"
        WebElement ClickItensdeOsSgz = driver.findElement(By.linkText("Itens de OS SGZ"));
        ClickItensdeOsSgz.click();

    }

    @Test
    public void testStatusAprovadoItemDeOsEmAndamento() {

        //Filtrar o
        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=APROVADO");
        assertEquals("=APROVADO", CampoStatus.getAttribute("value"));


        WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");
        assertEquals("HIDROJATO (MICRODRENAGEM MECANIZADA)" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubPrefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]-c"));
        CampoSubPrefeitura.clear();

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.id("m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]"));
        ClickOs.click();

        String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Administrador do Sistema\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);


    }

   @Test
    public void testStatusAprovadoItemDeOsNaoRealizado() {

        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=APROVADO");
        assertEquals("=APROVADO", CampoStatus.getAttribute("value"));


        WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");
        assertEquals("HIDROJATO (MICRODRENAGEM MECANIZADA)" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ClickOs.click();

        String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Administrador do Sistema" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @After
    public void tearDown() {
        // Fechar o navegador"
        driver.quit();

    }

}

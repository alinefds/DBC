// NÃO HA MASSAS PARA OS STATUS CANCEL, FECHAR, PRECANC
package tests.SubPrefeito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.AcessarMaximo;
import suporte.Generator;
import suporte.Screenshot;

@SuppressWarnings("unused")

public class AcessarItensDeOsSgzSubprefeito {
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

        driver.findElement(By.id("j_username")).sendKeys("D838430");

        driver.findElement(By.id("j_password")).sendKeys("123456");

        driver.findElement(By.id("loginbutton")).click();

        WebElement mensagemHome = driver.findElement(By.id("titlebar-tb_username"));
        String mensagem = mensagemHome.getText();
        assertEquals("Francisco Roberto Arantes Filho", mensagem);

        WebElement ClickMenuOs = driver.findElement(By.linkText("Ordens de Serviço"));
        assertEquals("Ordens de Serviço" , ClickMenuOs.getText());
        ClickMenuOs.click();

        //Acessar o aplicativo "Itens de OS SGZ"
        WebElement ClickItensdeOsSgz = driver.findElement(By.linkText("Itens de OS SGZ"));
        assertEquals("Itens de OS SGZ" , ClickItensdeOsSgz.getText());
        ClickItensdeOsSgz.click();

    }

    @Test
    public void testStatusAprovadoSubprefeito() {


        WebElement CampoStatus = driver.findElement(By.cssSelector("#m6a7dfd2f_tfrow_\\[C\\:5\\]_txt-tb"));
        CampoStatus.sendKeys("=APROVADO");

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.cssSelector("#m90fb1fe9-co1_0"));
        ClickOs.click();
        WebDriverWait aguardar = new WebDriverWait(driver,10);

        WebElement DetalhesdaOrdemdeServiço = driver.findElement(By.xpath("//*[@id=\"m90fb1fe9-lb\"]"));
        String ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @Test
    public void testStatusEMANDSubprefeito() {


        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=EMAND");
        assertEquals("=EMAND", CampoStatus.getAttribute("value"));

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");
        //assertEquals("HIDROJATO (MICRODRENAGEM MECANIZADA)" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServico = driver.findElement(By.id("m128f01d0-co_0"));
        assertEquals("Item de OS:" , DetalhesdaOrdemdeServico.getText());

        String ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @Test
    public void testStatusCONCSubprefeito() {


        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=CONC");
        assertEquals("=CONC", CampoStatus.getAttribute("value"));

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");
        //assertEquals("HIDROJATO (MICRODRENAGEM MECANIZADA)" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServico = driver.findElement(By.id("m128f01d0-co_0"));
        assertEquals("Item de OS:" , DetalhesdaOrdemdeServico.getText());

        String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @Test
    public void testStatusNAOREALIZADASubprefeito() {


        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=NAOREALIZADA");
        assertEquals("=NAOREALIZADA", CampoStatus.getAttribute("value"));

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");
        //assertEquals("HIDROJATO (MICRODRENAGEM MECANIZADA)" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServico = driver.findElement(By.id("m128f01d0-co_0"));
        assertEquals("Item de OS:" , DetalhesdaOrdemdeServico.getText());

        ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }
    @Test
    public void testStatusNOVOSubprefeito() {


        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=NOVO");
        assertEquals("=NOVO", CampoStatus.getAttribute("value"));

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");
        //assertEquals("HIDROJATO (MICRODRENAGEM MECANIZADA)" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServico = driver.findElement(By.id("m128f01d0-co_0"));
        assertEquals("Item de OS:" , DetalhesdaOrdemdeServico.getText());

        ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @Test
    public void testStatusPLANEJARSubprefeito() {


        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=PLANEJAR");
        assertEquals("=PLANEJAR", CampoStatus.getAttribute("value"));

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("HIDROJATO (MICRODRENAGEM MECANIZADA)");
        //assertEquals("HIDROJATO (MICRODRENAGEM MECANIZADA)" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        String ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServico = driver.findElement(By.id("m128f01d0-co_0"));
        assertEquals("Item de OS:" , DetalhesdaOrdemdeServico.getText());

        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @Test
    public void testStatusREJEITADOSubprefeito() {


        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=REJEITADO");
        assertEquals("=REJEITADO", CampoStatus.getAttribute("value"));

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("TAPA BURACO CONSERVACAO PAVIMENTO");
        //assertEquals("TAPA BURACO CONSERVACAO PAVIMENTO" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        String ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServico = driver.findElement(By.id("m128f01d0-co_0"));
        assertEquals("Item de OS:" , DetalhesdaOrdemdeServico.getText());

        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @Test
    public void testStatusREPLANEJARSubprefeito() {


        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=REPLANEJAR");
        assertEquals("=REPLANEJAR", CampoStatus.getAttribute("value"));

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("TAPA BURACO CONSERVACAO PAVIMENTO");
        //assertEquals("TAPA BURACO CONSERVACAO PAVIMENTO" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoStatus.click();
        CampoSubprefeitura.clear();

        String ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServico = driver.findElement(By.id("m128f01d0-co_0"));
        assertEquals("Item de OS:" , DetalhesdaOrdemdeServico.getText());

        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }


    @Test
    @Ignore
    public void testStatusAGINSPSubprefeito() {


        WebElement CampoStatus = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:5]_txt-tb"));
        CampoStatus.sendKeys("=AGINSP");
        assertEquals("=AGINSP", CampoStatus.getAttribute("value"));

        //WebElement CampoClassificacooDeServico = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:2]_txt-tb"));
        //CampoClassificacooDeServico.sendKeys("MANUTENCAO CONSERVACAO GALERIAS");
        //assertEquals("MANUTENCAO CONSERVACAO GALERIAS" , CampoClassificacooDeServico.getAttribute("value"));

        WebElement CampoSubprefeitura = driver.findElement(By.id("m6a7dfd2f_tfrow_[C:10]_txt-tb"));
        CampoSubprefeitura.click();
        CampoSubprefeitura.clear();

        String ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        WebElement BotaoFiltrarTabela = driver.findElement(By.xpath("//*[@id='m6a7dfd2f-ti2']"));
        BotaoFiltrarTabela.click();

        WebElement ClickOs = driver.findElement(By.xpath("//*[@id='m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]']"));
        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);
        ClickOs.click();

        WebElement DetalhesdaOrdemdeServico = driver.findElement(By.id("m128f01d0-co_0"));
        assertEquals("Item de OS:" , DetalhesdaOrdemdeServico.getText());

        ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Subprefeito\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @After
    public void tearDown() {
        // Fechar o navegador"
        driver.quit();

    }



}

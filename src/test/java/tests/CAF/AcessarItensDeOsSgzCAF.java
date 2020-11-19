package tests.CAF;

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

public class AcessarItensDeOsSgzCAF {
    //expor a propriedade driver para todos os metodos da classe
    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Test

    public void testCAFNaoTemAcessoOrdensDeServiço() {
        driver = AcessarMaximo.createChrome();

        // clicar no botão com o id "details-button"
        driver.findElement(By.id("details-button")).click();

        // clicar no botão com o id "proceed-link"
        driver.findElement(By.id("proceed-link")).click();

        // Identifcando o formulário de Login
        WebElement formularioLoginForm = driver.findElement(By.id("loginform"));

        // Digitar no campo com o nome "Nome do Usuário:" que está dentro do formulário
        // de id "loginform" o texto "maxadmin"
        driver.findElement(By.id("j_username")).sendKeys("X343163");

        //// Digitar no campo com o nome "Senha:" que está dentro do formulário de id
        //// "loginform" o texto "Password01"
        driver.findElement(By.id("j_password")).sendKeys("123456");

        String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\CAF\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

        // Clicar no botão que possui o id "loginbutton"
        driver.findElement(By.id("loginbutton")).click();

        // Validar que a mensagem apresentada foi "Bem-vindo, Administrador do Maximo"
        WebElement mensagemHome = driver.findElement(By.id("titlebar-tb_username"));
        String mensagem = mensagemHome.getText();
        assertEquals("Janaína Lopes Souza Vieira", mensagem);

        //Acessar o menu Principal "Ordens de Serviço"
        WebElement ClickMenuOs = driver.findElement(By.id("titlebar-tb_gotoButton"));
        ClickMenuOs.click();

        ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\CAF\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @After
    public void tearDown() {
        // Fechar o navegador"
        driver.quit();

    }
}

package tests.SupervisordeInspecao;

import org.junit.After;
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

public class AcessarItensDeOsSgzSupervisordeInspecao {

    //expor a propriedade driver para todos os metodos da classe
    private WebDriver driver;

    @Rule
    public TestName test = new TestName();

    @Test

    public void testAutorizadorPlanoAnualNaoTemAcessoItensDeOsSGZ() {
        driver = AcessarMaximo.createChrome();

        driver.findElement(By.id("details-button")).click();

        driver.findElement(By.id("proceed-link")).click();

        WebElement formularioLoginForm = driver.findElement(By.id("loginform"));

        driver.findElement(By.id("j_username")).sendKeys("MIPI01");

        driver.findElement(By.id("j_password")).sendKeys("123456");

        driver.findElement(By.id("loginbutton")).click();

        WebElement mensagemHome = driver.findElement(By.id("titlebar-tb_username"));
        String mensagem = mensagemHome.getText();
        assertEquals("Bruno Alves Sousa", mensagem);

        WebElement ClickMenuOs = driver.findElement(By.linkText("Ordens de Serviço"));
        ClickMenuOs.click();
        String ScreenshotArquivo = "C:\\Users\\Cecília\\Documents\\ITENS DE OS\\Supervisor de Inspeção\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
        Screenshot.tirar(driver, ScreenshotArquivo);

    }

    @After
    public void tearDown() {
        // Fechar o navegador"
        driver.quit();

    }

}


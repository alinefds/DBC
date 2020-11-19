package tests.EXECUTOR;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import suporte.AcessarMaximo;
import suporte.Generator;
import suporte.Screenshot;

@SuppressWarnings("unused")

public class AcessarItensDeOsSgzExecutor {
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
            driver.findElement(By.id("j_username")).sendKeys("X525612");

            //// Digitar no campo com o nome "Senha:" que está dentro do formulário de id
            //// "loginform" o texto "Password01"
            driver.findElement(By.id("j_password")).sendKeys("123456");

            String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Executor\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
            Screenshot.tirar(driver, ScreenshotArquivo);


            // Clicar no botão que possui o id "loginbutton"
            driver.findElement(By.id("loginbutton")).click();

            // Validar que a mensagem apresentada foi "Bem-vindo, Administrador do Maximo"
            WebElement mensagemHome = driver.findElement(By.id("titlebar-tb_username"));
            String mensagem = mensagemHome.getText();
            assertEquals("Francisco Das Chagas Oliveira Passos", mensagem);



        }

        @Test
        public void testNaoTemPermissaoOrdensDeServico() {

            //Acessar o menu Principal
            WebElement MenuPrincipal = driver.findElement(By.id("titlebar-tb_gotoButton"));
            MenuPrincipal.click();
            String ScreenshotArquivo = "C:\\MAGNA\\PROJETOS\\Sprint#9\\Reestruturação Grupos de Segurança\\ITENS DE OS\\Executor\\" + Generator.dataHoraParaArquivo() + test.getMethodName() + ".png";
            Screenshot.tirar(driver, ScreenshotArquivo);

            WebElement Mensagem = driver.findElement(By.xpath("//*[@id='ma50ce46e-hg']/tbody/tr/td[2]"));
            assertEquals("Você não possui nenhum Centro de Início configurado. Entre em contato com o administrador do sistema.", Mensagem.getText());

        }


        @After
        public void tearDown() {
            // Fechar o navegador"
            driver.quit();

        }

    }

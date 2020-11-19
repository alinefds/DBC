package suporte;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings("unused")

public class AcessarMaximo {

    public static final String USERNAME = "alineferreira1";
    public static final String AUTOMATE_KEY = "ohNLrizpxt6ywyrsCHpG";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static WebDriver driver;

    public static WebDriver createChrome() {
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cecília\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navegando para a página do SGZ!
        driver.get("https://hsmgimax.prefeitura.sp.gov.br/maximo/");

        return driver;

    }
}

package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    // Başka sınıflardan obje oluşturulmasını engellemek için private constructor
    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            // configuration.properties dosyasındaki browser değerini alıyoruz
            String browser = ConfigReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito"); // Gizli sekmede açar
                    // İstersen testlerin daha stabil çalışması için şu ayarları da ekleyebilirsin:
                    chromeOptions.addArguments("--disable-popup-blocking"); // Pop-up'ları engeller
                    chromeOptions.addArguments("--start-maximized"); // Ekranı tam ekran başlatır (driver.manage().window().maximize() yerine kullanılabilir)

                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
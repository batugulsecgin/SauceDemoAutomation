package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", // Konsola okunaklı loglar basar
                "html:target/default-cucumber-reports.html", // Standart Cucumber HTML raporu
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // ExtentReports entegrasyonu
        },
        features = "src/test/resources/features", // Feature dosyalarının dizin yolu
        glue = "stepdefinitions", // Java kodlarının (step defs) dizin yolu

        tags = "@e2e", // Sadece bu tag'e sahip senaryoları çalıştırır
                       // Kullanılabilir tag'ler; @smoke , @e2e , @cart , @negative .

        dryRun = false // Eksik adım olup olmadığını kontrol etmek için true, testi gerçekten koşmak için false olmalıdır
)
public class Runner {
    // Bu sınıfın içi boş kalmalıdır. Çalıştırma işlemini sınıfın üzerindeki notasyonlar yapar.
}
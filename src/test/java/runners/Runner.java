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

        // Calistirilacak tag(ler). Tum testleri kosmak icin tag'i tamamen kaldirabilirsiniz.
        // Kullanilabilir tag'ler:
        //   @smoke   - Login basarili senaryosu
        //   @negative- Negatif login senaryolari
        //   @cart    - Sepet yonetimi
        //   @e2e     - Uctan uca satin alma
        //   @edge    - Edge case senaryolar
        //   @sorting - Urun siralama testleri (YENI)
        //   @detail  - Urun detay sayfasi testleri (YENI)
        //   @bulk    - Toplu sepet islemleri (YENI)
        //   @coupon  - Kupon/indirim alani dogrulama testleri (YENI)
        tags = "@coupon",

        dryRun = false // Eksik adım olup olmadığını kontrol etmek için true, testi gerçekten koşmak için false olmalıdır
)
public class Runner {
    // Bu sınıfın içi boş kalmalıdır. Çalıştırma işlemini sınıfın üzerindeki notasyonlar yapar.
}
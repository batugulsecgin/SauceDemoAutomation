package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginStepDefs {

    // LoginPage sınıfından bir obje oluşturuyoruz ki içindeki elementlere ulaşabilelim
    LoginPage loginPage = new LoginPage();

    @Given("kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String urlKey) {
        // ConfigReader kullanarak properties dosyasından URL'i dinamik olarak alıyoruz
        Driver.getDriver().get(ConfigReader.getProperty(urlKey));
    }

    @When("kullanici gecerli kullanici adi ve sifresini girer")
    public void kullanici_gecerli_kullanici_adi_ve_sifresini_girer() {
        // POM mimarisine uygun olarak page class'ındaki web elementlerine veri gönderiyoruz
        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("username"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
    }

    @When("login butonuna tiklar")
    public void login_butonuna_tiklar() {
        loginPage.loginButton.click();
    }

    @Then("basarili sekilde giris yaptigini dogrular")
    public void basarili_sekilde_giris_yaptigini_dogrular() {
        // JUnit Assert kullanarak beklenen durum ile gerçekleşen durumu doğruluyoruz
        Assert.assertTrue("Başarılı giriş doğrulanamadı!", loginPage.productsTitle.isDisplayed());

        // Test bitiminde istersek tarayıcıyı kapatabiliriz.
        Driver.closeDriver();
    }
    @When("kullanici kullanici adi alanina {string} yazar")
    public void kullanici_kullanici_adi_alanina_yazar(String username) {
        // Parametre boş gönderilmişse sendKeys metodu hata vermesin diye kontrol ediyoruz
        if (!username.isEmpty()) {
            loginPage.usernameBox.sendKeys(username);
        }
    }

    @When("sifre alanina {string} yazar")
    public void sifre_alanina_yazar(String password) {
        if (!password.isEmpty()) {
            loginPage.passwordBox.sendKeys(password);
        }
    }

    @Then("sistemin {string} seklinde hata verdigini dogrular")
    public void sistemin_seklinde_hata_verdigini_dogrular(String beklenenHataMesaji) {
        Assert.assertTrue("Hata mesajı elementi ekranda görünmüyor!", loginPage.errorMessage.isDisplayed());

        String aktuelHataMesaji = loginPage.errorMessage.getText();
        Assert.assertEquals("Beklenen hata mesajı ile ekrandaki eşleşmiyor!", beklenenHataMesaji, aktuelHataMesaji);

        Driver.closeDriver();
    }
}
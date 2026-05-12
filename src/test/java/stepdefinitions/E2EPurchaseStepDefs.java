package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import utilities.Driver;

public class E2EPurchaseStepDefs {

    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @When("{string} urununu sepete ekler")
    public void urununu_sepete_ekler(String urunAdi) {
        if (urunAdi.contains("Backpack")) {
            inventoryPage.backpackAddButton.click();
        } else if (urunAdi.contains("Bike Light")) {
            inventoryPage.bikeLightAddButton.click();
        }
    }

    @And("sepet ikonuna tiklar")
    public void sepet_ikonuna_tiklar() {
        inventoryPage.cartLink.click();
    }

    @And("{string} butonuna tiklar")
    public void butonuna_tiklar(String buttonText) {
        if (buttonText.equals("Checkout")) {
            cartPage.checkoutButton.click();
        } else if (buttonText.equals("Finish")) {
            checkoutPage.finishButton.click();
        } else if (buttonText.equals("Continue Shopping")) {
            cartPage.continueShoppingButton.click(); // Yeni eklediğimiz koşul
        } else {
            // QA Best Practice: Eğer tanımlanmayan bir buton gelirse testin sessizce geçmesini engellemek için hata fırlatıyoruz
            throw new RuntimeException("Tanımsız buton texti gönderildi: " + buttonText);
        }
    }

    @And("{string}, {string} ve {string} bilgilerini girerek devam eder")
    public void bilgilerini_girerek_devam_eder(String ad, String soyad, String zip) {
        checkoutPage.firstName.sendKeys(ad);
        checkoutPage.lastName.sendKeys(soyad);
        checkoutPage.zipCode.sendKeys(zip);
        checkoutPage.continueButton.click();
    }

    @Then("{string} mesajini gorerek siparisi dogrular")
    public void mesajini_gorerek_siparisi_dogrular(String expectedMessage) {
        Assert.assertEquals(expectedMessage, checkoutPage.successMessage.getText());
        Driver.closeDriver();
    }
}
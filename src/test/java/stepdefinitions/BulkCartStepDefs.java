package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CartPage;
import pages.InventoryPage;

public class BulkCartStepDefs {

    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();

    @When("kullanici listedeki tum urunleri sepete ekler")
    public void kullanici_listedeki_tum_urunleri_sepete_ekler() {
        // PageFactory'nin tembel liste değerlendirmesi nedeniyle her döngüde
        // güncel liste alınır. Buton tıklandığında "Add to cart" → "Remove" olarak
        // değişeceği için her seferinde listenin ilk elemanını alıyoruz.
        int safety = 0;
        while (!inventoryPage.allAddToCartButtons.isEmpty() && safety < 20) {
            inventoryPage.allAddToCartButtons.get(0).click();
            safety++;
        }
    }

    @Then("tum {string} butonlarinin {string} olarak degistigini dogrular")
    public void tum_butonlarinin_olarak_degistigini_dogrular(String eskiButon, String yeniButon) {
        // Hiç "Add to cart" butonu kalmamış olmalı
        Assert.assertTrue("Sayfada hala '" + eskiButon + "' butonu var!",
                inventoryPage.allAddToCartButtons.isEmpty());

        // Tüm butonların "Remove" yazısına döndüğünü kontrol ediyoruz
        for (WebElement removeBtn : inventoryPage.allRemoveButtons) {
            Assert.assertEquals(
                    "Buton metni '" + yeniButon + "' değil!",
                    yeniButon, removeBtn.getText());
        }

        utilities.Driver.closeDriver();
    }

    @And("sepetteki tum urunleri kaldirir")
    public void sepetteki_tum_urunleri_kaldirir() {
        int safety = 0;
        while (!cartPage.allRemoveButtons.isEmpty() && safety < 20) {
            cartPage.allRemoveButtons.get(0).click();
            safety++;
        }
    }

    @Then("sepetin bos oldugunu dogrular")
    public void sepetin_bos_oldugunu_dogrular() {
        Assert.assertTrue("Sepet boş değil, hala ürün satırları var!",
                cartPage.cartItems.isEmpty());

        // Sepet badge'i de görünmemeli
        Assert.assertTrue("Sepet ikonunda hala badge görünüyor!",
                inventoryPage.cartLink.findElements(
                        org.openqa.selenium.By.className("shopping_cart_badge")
                ).isEmpty());

        utilities.Driver.closeDriver();
    }
}


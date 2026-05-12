package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;
import pages.InventoryPage;

public class CartStepDefs {

    CartPage cartPage = new CartPage();
    InventoryPage inventoryPage = new InventoryPage();

    @And("{string} urununu sepetten siler")
    public void urununu_sepetten_siler(String urunAdi) {
        if (urunAdi.contains("Backpack")) {
            cartPage.removeBackpackButton.click();
        }
    }

    @And("sepet ikonundaki urun sayisinin {string} oldugunu dogrular")
    public void sepet_ikonundaki_urun_sayisinin_oldugunu_dogrular(String beklenenSayi) {
        String aktuelSayi = inventoryPage.cartBadge.getText();
        Assert.assertEquals("Sepetteki ürün sayısı hatalı!", beklenenSayi, aktuelSayi);
    }

    @Then("urun listeleme sayfasina geri dondugunu dogrular")
    public void urun_listeleme_sayfasina_geri_dondugunu_dogrular() {
        Assert.assertTrue(inventoryPage.productsTitle.isDisplayed());
        Assert.assertEquals("Products", inventoryPage.productsTitle.getText());
    }
}
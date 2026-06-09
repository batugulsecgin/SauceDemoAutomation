package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.InventoryPage;
import pages.ProductDetailPage;

public class ProductDetailStepDefs {

    InventoryPage inventoryPage = new InventoryPage();
    ProductDetailPage detailPage = new ProductDetailPage();

    @When("kullanici {string} urununun detay sayfasina gider")
    public void kullanici_urununun_detay_sayfasina_gider(String urunAdi) {
        inventoryPage.getProductNameLinkByText(urunAdi).click();
    }

    @Then("detay sayfasinda urun isminin {string} oldugunu dogrular")
    public void detay_sayfasinda_urun_isminin_oldugunu_dogrular(String beklenenAd) {
        Assert.assertEquals(
                "Detay sayfasındaki ürün adı eşleşmiyor!",
                beklenenAd, detailPage.detailProductName.getText());
    }

    @Then("detay sayfasinda urun fiyatinin {string} oldugunu dogrular")
    public void detay_sayfasinda_urun_fiyatinin_oldugunu_dogrular(String beklenenFiyat) {
        Assert.assertEquals(
                "Detay sayfasındaki ürün fiyatı eşleşmiyor!",
                beklenenFiyat, detailPage.detailProductPrice.getText());
    }

    @Then("detay sayfasinda urun aciklamasinin ve gorselinin gosterildigini dogrular")
    public void detay_sayfasinda_urun_aciklamasinin_ve_gorselinin_gosterildigini_dogrular() {
        Assert.assertTrue("Ürün açıklaması görünmüyor!",
                detailPage.detailProductDescription.isDisplayed());
        Assert.assertFalse("Ürün açıklaması boş!",
                detailPage.detailProductDescription.getText().trim().isEmpty());
        Assert.assertTrue("Ürün görseli yüklenmedi!",
                detailPage.detailProductImage.isDisplayed());

        utilities.Driver.closeDriver();
    }

    @And("detay sayfasindaki {string} butonuna tiklar")
    public void detay_sayfasindaki_butonuna_tiklar(String buttonText) {
        if (buttonText.equalsIgnoreCase("Add to cart")) {
            detailPage.detailAddToCartButton.click();
        } else if (buttonText.equalsIgnoreCase("Remove")) {
            detailPage.detailRemoveButton.click();
        } else {
            throw new RuntimeException("Tanımsız detay sayfası butonu: " + buttonText);
        }
    }

    @Then("detay sayfasinda {string} butonunun gorundugunu dogrular")
    public void detay_sayfasinda_butonunun_gorundugunu_dogrular(String buttonText) {
        if (buttonText.equalsIgnoreCase("Remove")) {
            Assert.assertTrue("Remove butonu görünmüyor!",
                    detailPage.detailRemoveButton.isDisplayed());
        } else if (buttonText.equalsIgnoreCase("Add to cart")) {
            Assert.assertTrue("Add to cart butonu görünmüyor!",
                    detailPage.detailAddToCartButton.isDisplayed());
        }
    }

    @And("detay sayfasinda {string} butonuna tiklar")
    public void detay_sayfasinda_butonuna_tiklar(String buttonText) {
        if (buttonText.equalsIgnoreCase("Back to products")) {
            detailPage.backToProductsButton.click();
        } else {
            throw new RuntimeException("Tanımsız detay sayfası butonu: " + buttonText);
        }
    }
}


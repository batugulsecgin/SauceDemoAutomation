package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import utilities.Driver;

public class CouponDiscountStepDefs {

    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Then("sepet sayfasinda kupon kodu girme alani bulunmadigini dogrular")
    public void sepet_sayfasinda_kupon_kodu_girme_alani_bulunmadigini_dogrular() {
        Assert.assertFalse(
                "Sepet sayfasinda beklenmeyen sekilde kupon/indirim alani bulundu!",
                cartPage.isCouponFieldPresent());
        Driver.closeDriver();
    }

    @Then("odeme ozeti sayfasinda kupon kodu girme alani bulunmadigini dogrular")
    public void odeme_ozeti_sayfasinda_kupon_kodu_girme_alani_bulunmadigini_dogrular() {
        Assert.assertFalse(
                "Odeme ozeti sayfasinda beklenmeyen sekilde kupon/indirim alani bulundu!",
                cartPage.isCouponFieldPresent());
        Driver.closeDriver();
    }

    @Then("odeme ozetinde {string} {string} ve {string} tutarlarinin tutarli oldugunu dogrular")
    public void odeme_ozetinde_tutarlarinin_tutarli_oldugunu_dogrular(
            String itemTotalLbl, String taxLbl, String totalLbl) {

        // Etiket metinlerini parse ediyoruz
        // Örn: "Item total: $39.98"   →  39.98
        double itemTotal = parseAmount(checkoutPage.itemTotalLabel.getText());
        double tax = parseAmount(checkoutPage.taxLabel.getText());
        double total = parseAmount(checkoutPage.totalLabel.getText());

        // Bilgi: Etiket isimlerinin de beklendigi gibi oldugunu dogrula
        Assert.assertTrue("'" + itemTotalLbl + "' etiketi gorunmuyor!",
                checkoutPage.itemTotalLabel.getText().toLowerCase().contains(itemTotalLbl.toLowerCase()));
        Assert.assertTrue("'" + taxLbl + "' etiketi gorunmuyor!",
                checkoutPage.taxLabel.getText().toLowerCase().contains(taxLbl.toLowerCase()));
        Assert.assertTrue("'" + totalLbl + "' etiketi gorunmuyor!",
                checkoutPage.totalLabel.getText().toLowerCase().contains(totalLbl.toLowerCase()));

        // SauceDemo'da indirim yok → Total = Item total + Tax olmali
        double expectedTotal = Math.round((itemTotal + tax) * 100.0) / 100.0;
        double actualTotal   = Math.round(total * 100.0) / 100.0;

        Assert.assertEquals(
                "Toplam tutar (Item total + Tax) ile eslesmiyor! Indirim uygulanmamali.",
                expectedTotal, actualTotal, 0.001);

        Driver.closeDriver();
    }

    /**
     * "Item total: $39.98" → 39.98 gibi parse eder.
     */
    private double parseAmount(String text) {
        int dollarIdx = text.indexOf('$');
        String numeric = text.substring(dollarIdx + 1).trim();
        return Double.parseDouble(numeric);
    }
}


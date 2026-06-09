package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.InventoryPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductSortingStepDefs {

    InventoryPage inventoryPage = new InventoryPage();

    @When("kullanici siralama menusunden {string} secenegini secer")
    public void kullanici_siralama_menusunden_secenegini_secer(String secenek) {
        inventoryPage.selectSortOption(secenek);
    }

    @Then("urunlerin isimlerinin {string} sirada listelendigini dogrular")
    public void urunlerin_isimlerinin_sirada_listelendigini_dogrular(String yon) {
        // Ekrandaki gerçek sıra
        List<String> actualOrder = new ArrayList<>();
        for (WebElement nameEl : inventoryPage.productNames) {
            actualOrder.add(nameEl.getText());
        }

        // Beklenen sıralı liste
        List<String> expectedOrder = new ArrayList<>(actualOrder);
        Collections.sort(expectedOrder);
        if (yon.equalsIgnoreCase("azalan")) {
            Collections.reverse(expectedOrder);
        }

        Assert.assertEquals(
                "Ürünler isimlerine göre " + yon + " sırada listelenmedi!",
                expectedOrder, actualOrder);

        Driver.closeDriver();
    }

    @Then("urunlerin fiyatlarinin {string} sirada listelendigini dogrular")
    public void urunlerin_fiyatlarinin_sirada_listelendigini_dogrular(String yon) {
        // Ekrandaki gerçek fiyat sırası
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement priceEl : inventoryPage.productPrices) {
            // "$29.99" → 29.99
            String priceText = priceEl.getText().replace("$", "").trim();
            actualPrices.add(Double.parseDouble(priceText));
        }

        // Beklenen sıralı liste
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);
        if (yon.equalsIgnoreCase("azalan")) {
            Collections.reverse(expectedPrices);
        }

        Assert.assertEquals(
                "Ürünler fiyatlarına göre " + yon + " sırada listelenmedi!",
                expectedPrices, actualPrices);

        Driver.closeDriver();
    }
}


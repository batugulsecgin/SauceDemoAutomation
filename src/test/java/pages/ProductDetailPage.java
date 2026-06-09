package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

/**
 * SauceDemo Ürün Detay (Inventory Item) Sayfası
 * URL formatı: /inventory-item.html?id=<product_id>
 */
public class ProductDetailPage {

    public ProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Detay sayfasındaki ürün ismi
    @FindBy(className = "inventory_details_name")
    public WebElement detailProductName;

    // Detay sayfasındaki açıklama
    @FindBy(className = "inventory_details_desc")
    public WebElement detailProductDescription;

    // Detay sayfasındaki fiyat
    @FindBy(className = "inventory_details_price")
    public WebElement detailProductPrice;

    // Detay sayfasındaki ürün görseli
    @FindBy(className = "inventory_details_img")
    public WebElement detailProductImage;

    // Detay sayfasındaki "Add to cart" butonu (ürün bazında ID değişir, sınıfla yakalıyoruz)
    @FindBy(xpath = "//button[contains(@class,'btn_inventory') and contains(@id,'add-to-cart')]")
    public WebElement detailAddToCartButton;

    // Detay sayfasındaki "Remove" butonu (ürün sepete eklenmişse görünür)
    @FindBy(xpath = "//button[contains(@class,'btn_inventory') and contains(@id,'remove')]")
    public WebElement detailRemoveButton;

    // "Back to products" butonu
    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;
}


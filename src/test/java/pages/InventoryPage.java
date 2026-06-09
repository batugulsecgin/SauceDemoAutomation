package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class InventoryPage {
    public InventoryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpackAddButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLightAddButton;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartLink;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement productsTitle;

    // Yeni eklenen ürün ve silme butonu
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesieAddButton;

    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement removeBikeLightButton;

    // Logout işlemleri için hamburger menü elementleri
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    // ====== YENİ EKLENEN ELEMENTLER ======

    // --- Sıralama (Sort) drop-down'ı ---
    @FindBy(className = "product_sort_container")
    public WebElement sortDropdown;

    // --- Ürün listesindeki tüm ürünlerin isim/fiyat elementleri ---
    @FindBy(className = "inventory_item_name")
    public List<WebElement> productNames;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> productPrices;

    // --- Inventory'deki tüm "Add to cart" ve "Remove" butonları ---
    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    public List<WebElement> allAddToCartButtons;

    @FindBy(xpath = "//button[contains(@id,'remove')]")
    public List<WebElement> allRemoveButtons;

    // --- Tüm ürünlerin "Add" butonları (sepete ekle senaryosu için) ---
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement boltTshirtAddButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement fleeceJacketAddButton;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement redTshirtAddButton;

    // --- Ürün detay sayfasına gitmek için ürün ismi linkleri ---
    // (Örn. "Sauce Labs Backpack" linkine tıklanır)
    public WebElement getProductNameLinkByText(String productName) {
        return Driver.getDriver().findElement(
                By.xpath("//div[@class='inventory_item_name ' and text()='" + productName + "']"));
    }

    // Sıralama yardımcı metodu
    public void selectSortOption(String visibleText) {
        new Select(sortDropdown).selectByVisibleText(visibleText);
    }
}
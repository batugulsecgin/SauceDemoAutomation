package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CartPage {
    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeBackpackButton;

    @FindBy(id = "continue-shopping")
    public WebElement continueShoppingButton;

    // ====== YENİ EKLENEN ELEMENTLER ======

    // Sepetteki ürün satırları (sayım için)
    @FindBy(className = "cart_item")
    public List<WebElement> cartItems;

    // Sepetteki ürün isim ve fiyat elementleri
    @FindBy(className = "inventory_item_name")
    public List<WebElement> cartItemNames;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> cartItemPrices;

    // Sepetteki tüm "Remove" butonları
    @FindBy(xpath = "//button[contains(@id,'remove')]")
    public List<WebElement> allRemoveButtons;

    // SauceDemo'da kupon/indirim alanı bulunmaz - bunu doğrulamak için kullanılacak
    public boolean isCouponFieldPresent() {
        return !Driver.getDriver()
                .findElements(By.xpath(
                        "//*[contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'coupon') " +
                                "or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'coupon') " +
                                "or contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'coupon') " +
                                "or contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'promo') " +
                                "or contains(translate(@name,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'promo') " +
                                "or contains(translate(@placeholder,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'promo') " +
                                "or contains(translate(@id,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'discount')]"))
                .isEmpty();
    }
}
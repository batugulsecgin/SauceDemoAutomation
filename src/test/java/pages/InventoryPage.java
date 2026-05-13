package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
}
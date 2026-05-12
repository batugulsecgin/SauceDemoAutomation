package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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
}
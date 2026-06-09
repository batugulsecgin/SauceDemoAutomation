package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckoutPage {
    public CheckoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement zipCode;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(className = "complete-header")
    public WebElement successMessage;

    // Özet sayfasındaki iptal butonu
    @FindBy(id = "cancel")
    public WebElement cancelButton;

    // ====== YENİ EKLENEN ELEMENTLER ======

    // Checkout Step Two (özet) sayfasındaki fiyat satırları
    @FindBy(className = "summary_subtotal_label")
    public WebElement itemTotalLabel;   // Örn: "Item total: $29.99"

    @FindBy(className = "summary_tax_label")
    public WebElement taxLabel;         // Örn: "Tax: $2.40"

    @FindBy(className = "summary_total_label")
    public WebElement totalLabel;       // Örn: "Total: $32.39"
}
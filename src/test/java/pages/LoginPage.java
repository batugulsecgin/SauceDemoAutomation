package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    // Constructor (Yapıcı Metot): Bu sınıftan bir obje üretildiğinde elementleri başlatır
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Web elementlerini @FindBy notasyonu ile buluyoruz
    @FindBy(id = "user-name")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    // Doğrulama için giriş yapıldıktan sonra çıkan başlık elementi
    @FindBy(xpath = "//span[@class='title']")
    public WebElement productsTitle;

    @FindBy(css = "h3[data-test='error']")
    public WebElement errorMessage;
}
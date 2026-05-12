Feature: SauceDemo Negatif Giris Testleri

  @negative
  Scenario Outline: Kullanici gecersiz bilgilerle giris yapmaya calistiginda uygun hata mesajini gormeli
    Given kullanici "url" sayfasina gider
    When kullanici kullanici adi alanina "<kullanici_adi>" yazar
    And sifre alanina "<sifre>" yazar
    And login butonuna tiklar
    Then sistemin "<hata_mesaji>" seklinde hata verdigini dogrular

    Examples:
      | kullanici_adi   | sifre        | hata_mesaji                                                               |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user   | yanlis_sifre | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
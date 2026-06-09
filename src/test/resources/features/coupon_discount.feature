Feature: SauceDemo İndirim ve Kupon Testleri

  # NOT: SauceDemo (https://www.saucedemo.com) demo bir sitedir ve fiilen
  # bir kupon/indirim kodu mekanizmasi sunmaz. Bu yuzden bu testler;
  #   1) Kupon alaninin bulunmadigini dogrulayan negatif testler
  #   2) Toplam fiyatin (Item total + Tax) dogru hesaplandigini kontrol eden
  #      "indirimsiz" toplam dogrulama testleridir.

  Background:
    Given kullanici "url" sayfasina gider
    When kullanici gecerli kullanici adi ve sifresini girer
    And login butonuna tiklar

  @coupon
  Scenario: Sepet sayfasinda kupon/indirim kodu girme alani bulunmamali
    When "Sauce Labs Backpack" urununu sepete ekler
    And sepet ikonuna tiklar
    Then sepet sayfasinda kupon kodu girme alani bulunmadigini dogrular

  @coupon
  Scenario: Odeme ozeti sayfasinda kupon/indirim kodu alani bulunmamali
    When "Sauce Labs Backpack" urununu sepete ekler
    And sepet ikonuna tiklar
    And "Checkout" butonuna tiklar
    And "Random", "Citizen" ve "11111" bilgilerini girerek devam eder
    Then odeme ozeti sayfasinda kupon kodu girme alani bulunmadigini dogrular

  @coupon
  Scenario: Odeme ozetinde toplam tutar urun fiyati ile vergi toplamina esit olmali (indirim uygulanmaz)
    When "Sauce Labs Backpack" urununu sepete ekler
    And "Sauce Labs Bike Light" urununu sepete ekler
    And sepet ikonuna tiklar
    And "Checkout" butonuna tiklar
    And "Random", "Citizen" ve "11111" bilgilerini girerek devam eder
    Then odeme ozetinde "Item total" "Tax" ve "Total" tutarlarinin tutarli oldugunu dogrular


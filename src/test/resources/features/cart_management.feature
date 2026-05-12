Feature: SauceDemo Sepet Yönetimi

  @cart
  Scenario: Kullanici sepete ekledigi urunu silebilir ve alisverise devam edebilir
    Given kullanici "url" sayfasina gider
    When kullanici gecerli kullanici adi ve sifresini girer
    And login butonuna tiklar
    And "Sauce Labs Backpack" urununu sepete ekler
    And "Sauce Labs Bike Light" urununu sepete ekler
    And sepet ikonuna tiklar
    And "Sauce Labs Backpack" urununu sepetten siler
    And "Continue Shopping" butonuna tiklar
    Then urun listeleme sayfasina geri dondugunu dogrular
    And sepet ikonundaki urun sayisinin "1" oldugunu dogrular
Feature: SauceDemo E2E Satin Alma Testi

  @e2e
  Scenario: Kullanici sectigi urunleri basariyla satin alabilmeli
    Given kullanici "url" sayfasina gider
    When kullanici gecerli kullanici adi ve sifresini girer
    And login butonuna tiklar
    And "Sauce Labs Backpack" urununu sepete ekler
    And "Sauce Labs Bike Light" urununu sepete ekler
    And sepet ikonuna tiklar
    And "Checkout" butonuna tiklar
    And "Random", "Citizen" ve "11111" bilgilerini girerek devam eder
    And "Finish" butonuna tiklar
    Then "Thank you for your order!" mesajini gorerek siparisi dogrular
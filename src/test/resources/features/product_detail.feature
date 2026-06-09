Feature: SauceDemo Ürün Detay Sayfası Testleri

  Background:
    Given kullanici "url" sayfasina gider
    When kullanici gecerli kullanici adi ve sifresini girer
    And login butonuna tiklar

  @detail
  Scenario: Kullanici urun adina tikladiginda detay sayfasindaki bilgileri gormeli
    When kullanici "Sauce Labs Backpack" urununun detay sayfasina gider
    Then detay sayfasinda urun isminin "Sauce Labs Backpack" oldugunu dogrular
    And detay sayfasinda urun fiyatinin "$29.99" oldugunu dogrular
    And detay sayfasinda urun aciklamasinin ve gorselinin gosterildigini dogrular

  @detail
  Scenario: Kullanici urun detay sayfasindan urunu sepete ekleyebilmeli
    When kullanici "Sauce Labs Bike Light" urununun detay sayfasina gider
    And detay sayfasindaki "Add to cart" butonuna tiklar
    Then detay sayfasinda "Remove" butonunun gorundugunu dogrular
    And sepet ikonundaki urun sayisinin "1" oldugunu dogrular

  @detail
  Scenario: Kullanici detay sayfasindan "Back to products" ile listeleme sayfasina donebilmeli
    When kullanici "Sauce Labs Onesie" urununun detay sayfasina gider
    And detay sayfasinda "Back to products" butonuna tiklar
    Then urun listeleme sayfasina geri dondugunu dogrular


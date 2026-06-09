Feature: SauceDemo Toplu Sepet İşlemleri

  Background:
    Given kullanici "url" sayfasina gider
    When kullanici gecerli kullanici adi ve sifresini girer
    And login butonuna tiklar

  @bulk
  Scenario: Kullanici listedeki tum urunleri sepete tek seferde ekleyebilmeli
    When kullanici listedeki tum urunleri sepete ekler
    Then sepet ikonundaki urun sayisinin "6" oldugunu dogrular
    And tum "Add to cart" butonlarinin "Remove" olarak degistigini dogrular

  @bulk
  Scenario: Kullanici tum urunleri sepete ekleyip sonra hepsini cikarabilmeli
    When kullanici listedeki tum urunleri sepete ekler
    And sepet ikonuna tiklar
    And sepetteki tum urunleri kaldirir
    Then sepetin bos oldugunu dogrular

  @bulk
  Scenario: Kullanici tum urunleri sepete ekleyip basariyla satin alabilmeli
    When kullanici listedeki tum urunleri sepete ekler
    And sepet ikonuna tiklar
    And "Checkout" butonuna tiklar
    And "Random", "Citizen" ve "11111" bilgilerini girerek devam eder
    And "Finish" butonuna tiklar
    Then "Thank you for your order!" mesajini gorerek siparisi dogrular


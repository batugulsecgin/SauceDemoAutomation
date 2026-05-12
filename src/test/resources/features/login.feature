Feature: SauceDemo Login Tests

  @smoke
  Scenario: Kullanici gecerli bilgilerle giris yapabilmeli
    Given kullanici "url" sayfasina gider
    When kullanici gecerli kullanici adi ve sifresini girer
    And login butonuna tiklar
    Then basarili sekilde giris yaptigini dogrular
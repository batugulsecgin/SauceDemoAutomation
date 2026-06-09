Feature: SauceDemo Ürün Filtreleme ve Sıralama Testleri

  Background:
    Given kullanici "url" sayfasina gider
    When kullanici gecerli kullanici adi ve sifresini girer
    And login butonuna tiklar

  @sorting
  Scenario: Urunler isimlerine gore A'dan Z'ye siralanabilmeli
    When kullanici siralama menusunden "Name (A to Z)" secenegini secer
    Then urunlerin isimlerinin "artan" sirada listelendigini dogrular

  @sorting
  Scenario: Urunler isimlerine gore Z'den A'ya siralanabilmeli
    When kullanici siralama menusunden "Name (Z to A)" secenegini secer
    Then urunlerin isimlerinin "azalan" sirada listelendigini dogrular

  @sorting
  Scenario: Urunler fiyatlarina gore dusukten yukseye siralanabilmeli
    When kullanici siralama menusunden "Price (low to high)" secenegini secer
    Then urunlerin fiyatlarinin "artan" sirada listelendigini dogrular

  @sorting
  Scenario: Urunler fiyatlarina gore yuksekten dusuge siralanabilmeli
    When kullanici siralama menusunden "Price (high to low)" secenegini secer
    Then urunlerin fiyatlarinin "azalan" sirada listelendigini dogrular


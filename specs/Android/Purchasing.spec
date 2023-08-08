Specification Heading
=====================
Created by testinium on 8.08.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Purchasing below shipping cost
------------------------------
tags:Gratis_Android_KargoIndirimsiz
* Uygulama baslatilir.
* Login sayfasina gecilir.
* Login olunur.
* Ana sayfadan bir urun sepete eklenir.
* Sepet kasa arkasi popup'i varsa kapatilir.
* "priceTwo" li elementli küsüratı bul ve değerini "ilkKüsür" olarak sakla
* "secondPriceTwo" li elementli küsüratı bul ve değerini "ikinciKüsür" olarak sakla
* "priceOne" li elementi bul ve değerini "fiyat1" olarak sakla
* "secondPriceOne" li elementi bul ve değerini "fiyat2" olarak sakla
* "continueBtn"li elementi bulana kadar "2" kere swipe yap ve elementi bul
* Saklanan fiyat değerlerini "ilkKüsür", "ikinciKüsür", "fiyat1", "fiyat2" toplam fiyat "salePriceOne", "salePriceTwo" ile eşit mi kontrol et
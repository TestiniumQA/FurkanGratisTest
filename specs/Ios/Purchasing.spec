Specification Heading
=====================
Created by testinium on 25.08.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

// PURCHASING 1

IOS Scenario Purchasing Above Shipping Cost
-------------------------------------------
tags:Gratis_IOS_KargoIndirimli
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis2 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Elektrikli Ürünler" isimli kategori seçilir
* Alt kategorilerden biri "Küçük Ev Aletleri", "Elektrikli Süpürge" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Adrese Teslim seçeneğine tıklanır ve devam edilir
* Teslimat alanı kontrol edilir
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı fiyat kontrol edilir

IOS Scenario Purchasing Below Shipping Cost
-------------------------------------------
tags:Gratis_IOS_KargoIndirimsiz
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis2 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Makyaj" isimli kategori seçilir
* Alt kategorilerden biri "Göz Makyajı", "Far" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Adrese Teslim seçeneğine tıklanır ve devam edilir
* Teslimat alanı kontrol edilir
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı fiyat kontrol edilir

IOS Scenario Purchasing with Choose Store Popup
-----------------------------------------------
tags:Gratis_IOS_MagazaSecPopup
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis2 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Makyaj" isimli kategori seçilir
* Alt kategorilerden biri "Göz Makyajı", "Far" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Adrese Teslim seçeneğine tıklanır ve devam edilir
* Mağaza Seç popup'ına tıklanır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir
//* Iyzico alanı express ödeme yapılır
//* Siparişin tamamlandığı kontrol edilir

IOS Scenario Purchasing with Editing Address
--------------------------------------------
tags:Gratis_IOS_AdresDuzenleme
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis2 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Makyaj" isimli kategori seçilir
* Alt kategorilerden biri "Yüz Makyajı", "Allık" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Adres düzenleme alanına gidilir
* Teslimat bilgileri alanında guncel adres bilgileri girilir
* Teslimat Adresi kaydet ikonuna tıklanır ve seçildiği kontrol edilir
* Satın alma alanında devam et butonuna tıklanır
* Teslimat alanı kontrol edilir
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı fiyat kontrol edilir

IOS Scenario Purchasing with Deleting and Adding New Address
------------------------------------------------------------
tags:Gratis_IOS_YeniAdresSilipEkleme
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis2 login olunur
* Sepet kontrol edilerek temizlenir
//* Ana sayfa tab'ına tıklanır
//* Ana sayfadan bir urun sepete eklenir
* Kategoriler sayfasina gecilir
* "Makyaj" isimli kategori seçilir
* Alt kategorilerden biri "Tırnak Bakım", "Oje" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Adres silme butonuna tıklanır ve adres silinir
* Teslimat bilgileri alanında yeni adres bilgileri girilir
* Teslimat Adresi devam et ikonuna tıklanır ve seçildiği kontrol edilir
* Teslimat alanı kontrol edilir
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı fiyat kontrol edilir

// PURCHASING 2

IOS Scenario Purchasing with Adding New Address
-----------------------------------------------
tags:Gratis_IOS_YeniAdresEkleme
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis3 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Saç Bakım" isimli kategori seçilir
* Alt kategorilerden biri "Şapmpuanlar", "Erkek Şampuan" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Yeni teslimat adresi alanına gidilir
* Teslimat bilgileri alanında adres bilgileri girilir
* Teslimat Adresi kaydet ikonuna tıklanır ve seçildiği kontrol edilir
* Satın alma alanında devam et butonuna tıklanır
* Teslimat alanı kontrol edilir
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı fiyat kontrol edilir

IOS Scenario Purchasing with Adding New Bill Address
----------------------------------------------------
tags:Gratis_IOS_YeniFaturaAdresiEkleme
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis3 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Saç Bakım" isimli kategori seçilir
* Alt kategorilerden biri "Şapmpuanlar", "Erkek Şampuan" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Yeni fatura adresi alanına gidilir
* Fatura adresi alanında yeni adres eklenir
* Adrese Teslim Fatura Adresi kaydet ikonuna tıklanır ve seçildiği kontrol edilir
* Satın alma alanında devam et butonuna tıklanır
* Teslimat alanı kontrol edilir
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı fiyat kontrol edilir

IOS Scenario Purchasing with Choosing Another Address
-----------------------------------------------------
tags:Gratis_IOS_BaskaAdresSecerekSiparis
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis3 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Saç Bakım" isimli kategori seçilir
* Alt kategorilerden biri "Şapmpuanlar", "Erkek Şampuan" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Başka Adres Seç seçeneğine tıklanır
//* Adrese Teslim seçeneğine tıklanır ve devam edilir
* Satın alma alanında devam et butonuna tıklanır
* Teslimat alanı kontrol edilir
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı fiyat kontrol edilir

IOS Scenario Purchasing with Choosing Another Bill Address
----------------------------------------------------------
tags:Gratis_IOS_BaskaFaturaAdresiSecerekSiparis
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis3 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Makyaj" isimli kategori seçilir
* Alt kategorilerden biri "Göz Makyajı", "Maskara" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Adrese Teslim butonuna tıklanır
* Adrese Teslim teslimat Bilgileri alanı kontrol edilir
* Adrese Teslim Fatura adresi değiştirilir
* Satın alma alanında devam et butonuna tıklanır
* Teslimat alanı kontrol edilir
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı fiyat kontrol edilir

IOS Scenario Purchasing with Store Deliver Changing Bill Address
---------------------------------------------------------------
tags:Gratis_IOS_MagazadanTeslimatFaturaAdresiDegistirme
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis3 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Makyaj" isimli kategori seçilir
* Alt kategorilerden biri "Göz Makyajı", "Maskara" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
* Mağazadan Teslimat Fatura adresi değiştirilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir

// PURCHASING 3

IOS Scenario Purchasing with Store Deliver Myself
-------------------------------------------------
tags:Gratis_IOS_MagazadanKendimTeslimat
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis4 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Makyaj" isimli kategori seçilir
* Alt kategorilerden biri "Dudak Makyajı", "Ruj" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
* Kendim Teslim alacağım seçeneği seçilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir

IOS Scenario Purchasing with Store Deliver Someone
--------------------------------------------------
tags:Gratis_IOS_MagazadanBaskasiTeslimat
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis4 login olunur
* Sepet kontrol edilerek temizlenir
* Kategoriler sayfasina gecilir
* "Makyaj" isimli kategori seçilir
* Alt kategorilerden biri "Dudak Makyajı", "Ruj" seçilir
* Urun detay sayfasına geçilir
* Ürün detay sayfasinda urun sepete eklenir
* Sepete git'e tıklanır
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir guncel ismi secilir
* Mağazadan Teslim Ilce ismi swipe yapmadan secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
//* Mağazadan Teslim ikinci mağazası seçilir
* Başkası teslim alacak seçeneği seçilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir

IOS Scenario Purchasing with Store Deliver Myself and Adding Bill Address
-------------------------------------------------------------------------
tags:Gratis_IOS_MagazadanKendimTeslimatFaturaAdresiEkle
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis4 login olunur
* Sepet kontrol edilerek temizlenir
* Ana sayfa tab'ına tıklanır
* Ana sayfadan bir urun sepete eklenir
//* Sepet kasa arkasi popup'i kapatilir
* Diger'e tiklanir diger sayfasinin acildigi gorulur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Adreslerim'e tiklanir adreslerim sayfasinin acildigi gorulur
* Adres varsa Silme'ye tıklanır, adres silme pop-up'ın açıldığı görülür ve adres silinir
* Ana sayfa tab'ına tıklanır
* Ana sayfa sepet ikonuna tiklanir
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
* Fatura bilgileri alanında yeni adres eklenir
* Kendim Teslim alacağım seçeneği seçilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir

IOS Scenario Purchasing with Store Deliver Someone and Adding Bill Address
--------------------------------------------------------------------------
tags:Gratis_IOS_MagazadanBaskasiTeslimatFaturaAdresiEkle
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis4 login olunur
* Sepet kontrol edilerek temizlenir
* Ana sayfa tab'ına tıklanır
* Ana sayfadan bir urun sepete eklenir
//* Sepet kasa arkasi popup'i kapatilir
* Diger'e tiklanir diger sayfasinin acildigi gorulur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Adreslerim'e tiklanir adreslerim sayfasinin acildigi gorulur
* Adres varsa Silme'ye tıklanır, adres silme pop-up'ın açıldığı görülür ve adres silinir
* Ana sayfa tab'ına tıklanır
* Ana sayfa sepet ikonuna tiklanir
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
* Fatura bilgileri alanında yeni adres eklenir
* Başkası teslim alacak seçeneği seçilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir

// PURCHASING 4

IOS Scenario Purchasing with Deliver Store Edit Billing Address
---------------------------------------------------------------
tags:Gratis_IOS_MagazadanTeslimatFaturaAdresiDuzenle
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis0 login olunur
* Sepet kontrol edilerek temizlenir
* Ana sayfa tab'ına tıklanır
* Ana sayfadan bir urun sepete eklenir
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
* Fatura bilgileri adresi düzenle butonuna tıklanır
* Fatura bilgileri alanında guncel adres bilgileri girilir
* Mağazadan Teslimat Fatura Adresi kaydet ikonuna tıklanır ve seçildiği kontrol edilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir

IOS Scenario Purchasing with Store Deliver Someone and Delete and Adding Bill Address
-------------------------------------------------------------------------------------
tags:Gratis_IOS_MagazadanBaskasiTeslimatFaturaAdresiSilipEkle
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis0 login olunur
* Sepet kontrol edilerek temizlenir
* Ana sayfa tab'ına tıklanır
* Ana sayfadan bir urun sepete eklenir
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Fatura bilgileri adresi sil butonuna tıklanır
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağazadan Teslim mağazası seçilir
* Fatura bilgileri alanında yeni adres eklenir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir

IOS Scenario Purchasing with Store Deliver and Adding Another Bill Address
--------------------------------------------------------------------------
tags:Gratis_IOS_MagazadanTeslimatFaturaAdresiEkle
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis0 login olunur
* Sepet kontrol edilerek temizlenir
* Ana sayfa tab'ına tıklanır
* Ana sayfadan bir urun sepete eklenir
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
* Fatura Bilgileri alanında yeni adres ekle butonuna tıklanır
* Fatura adresi alanında yeni adres eklenir
* Mağazadan Teslimat Fatura Adresi kaydet ikonuna tıklanır ve seçildiği kontrol edilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir

IOS Scenario Purchasing with Store Deliver and Change Delivery Information
--------------------------------------------------------------------------
tags:Gratis_IOS_MagazadanTeslimatTeslimatBilgileriDegistirme
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis0 login olunur
* Sepet kontrol edilerek temizlenir
* Ana sayfa tab'ına tıklanır
* Ana sayfadan bir urun sepete eklenir
//* Sepet kasa arkasi popup'i kapatilir
* Tek ürünün ve toplam fiyatın kontrolü yapılır
* Mağazadan Teslim teslimat Bilgileri alanı kontrol edilir
* Mağazadan Teslim Sehir ismi secilir
* Mağazadan Teslim Ilce ismi secilir
* Mağaza saatleri kontrol edilir
* Mağazadan Teslim mağazası seçilir
* Kendim Teslim alacağım seçeneği seçilir
* Satın alma alanında devam et butonuna tıklanır
* Teslimat Bilgileri değiştirme butonuna tıklanır
* Başkası teslim alacak seçeneği seçilir
* Satın alma alanında devam et butonuna tıklanır
* Sipariş Özeti alanı kontrol edilir
* Iyzico alanı mağazadan teslimat için fiyat kontrol edilir
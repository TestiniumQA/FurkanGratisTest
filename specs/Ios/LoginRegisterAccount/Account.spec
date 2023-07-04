Specification Heading
=====================
Created by testinium on 3.07.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
IOS Scenario Deleting Address and Adding New Address
----------------------------------------------------
tags:Gratis_IOS_YeniAdresEklemeVeSilme
* Uygulama baslatilir
* Login sayfasina gecilir
* Giris yapilir
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Adreslerim'e tiklanir adreslerim sayfasinin acildigi gorulur
* Adres varsa Silme'ye tıklanır, adres silme pop-up'ın açıldığı görülür ve adres silinir
* Yeni Adres Ekle'ye tiklanir adres ekleme sayfasinin acildigi gorulur
* Adres icin Ad, Soyad, Telefon ve Adres Ismi bilgileri girilir
* Adres Ekle Sehir ismi secilir
* Adres Ekle Ilce ismi secilir
* Adres Ekle Mahalle ismi secilir
* Adres Ekleme icin Adres Detay ve Posta Kodu bilgileri girilir
* Kaydet ikonuna tiklanir eklenen adresin adreslerim alanina geldigi gorulur

IOS Scenario Updating Address
-----------------------------
tags:Gratis_IOS_AdresGuncelleme
* Uygulama baslatilir
* Login sayfasina gecilir
* Giris yapilir
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Adreslerim'e tiklanir adreslerim sayfasinin acildigi gorulur
* Adres güncellemeye tıklanır
* Adres icin Ad, Soyad, Telefon ve Adres Ismi bilgilerinin guncelleri girilir
* Adres Ekle Sehir ismi guncelleme icin "2" swipe ile secilir
* Adres Ekle Ilce ismi guncelleme icin "1" swipe ile secilir
* Adres Ekle Mahalle ismi guncelleme icin "1" swipe ile secilir
* Adres Ekleme icin Adres Detay ve Posta Kodu bilgilerinin guncelleri girilir
* Kaydet ikonuna tiklanir eklenen adresin adreslerim alanina geldigi gorulur

IOS Scenario Favorite List Name Update
--------------------------------------
tags:Gratis_IOS_FavoriAdiListeDuzenleme
* Uygulama baslatilir
* Login sayfasina gecilir
* Giris yapilir
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Profil sayfasındaki Favori butonuna tiklanir
* Favori sayfasindaki Liste Adini Duzenle butonuna tiklanir ve yeni isim girilir
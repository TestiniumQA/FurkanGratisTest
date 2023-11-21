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
* Gratis0 ile login olunur
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
* Gratis1 ile login olunur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Adreslerim'e tiklanir adreslerim sayfasinin acildigi gorulur
* Adres güncellemeye tıklanır
* Adres icin Ad, Soyad, Telefon ve Adres Ismi bilgilerinin guncelleri girilir
* Adres Ekle Sehir ismi guncelleme icin "2" swipe ile secilir
* Adres Ekle Ilce ismi guncelleme icin "2" swipe ile secilir
* Adres Ekle Mahalle ismi guncelleme icin "1" swipe ile secilir
* Adres Ekleme icin Adres Detay ve Posta Kodu bilgilerinin guncelleri girilir
* Kaydet ikonuna tiklanir eklenen adresin adreslerim alanina geldigi gorulur

IOS Scenario Address Warning Messages
-------------------------------------
tags:Gratis_IOS_AdresUyariMesajlari
* Uygulama baslatilir
* Login sayfasina gecilir
* Gratis4 ile login olunur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Adreslerim'e tiklanir adreslerim sayfasinin acildigi gorulur
* Adres varsa Silme'ye tıklanır, adres silme pop-up'ın açıldığı görülür ve adres silinir
//* Adres varsa Silme'ye tıklanır, adres silme pop-up'ın açıldığı görülür ve adres silinir
* Yeni Adres Ekle'ye tiklanir adres ekleme sayfasinin acildigi gorulur
* Adres Ad "a", Soyad "b", Telefon "" ve Adres İsmi "c" girilir
* Kaydet ikonuna tiklanir "Türkçe isimler 2 karakterden az olamaz. İsminizi kontrol ediniz." uyarı mesajı görülür
* Yukarı scroll et ve "YeniAd" textini "NewAddressCustomerNameFull" elementine yaz
* Kaydet ikonuna tiklanir "Türkçe isimler 2 karakterden az olamaz. Soyadınızı kontrol ediniz." uyarı mesajı görülür
* Yukarı scroll et ve "YeniSoyad" textini "NewAddressCustomerSurnameFull" elementine yaz
* Kaydet ikonuna tiklanir "Lütfen telefon numarasını eksiksiz giriniz" uyarı mesajı görülür
* Yukarı scroll et ve "5" textini "NewAddressCustomerPhoneFull" elementine yaz
* Kaydet ikonuna tiklanir "Telefon Numarası Geçersiz. Lütfen 10 hane olacak şekilde giriniz." uyarı mesajı görülür
* Yukarı scroll et ve "112223311" textini "NewAddressCustomerPhoneFull" elementine yaz
* Kaydet ikonuna tiklanir "Lütfen adres ismi giriniz." uyarı mesajı görülür
* Yukarı scroll et ve "AdresIsmi" textini "NewAddressCustomerAddressTitleFull" elementine yaz
* Adres Ekle Sehir ismi guncelleme icin "1" swipe ile secilir
* Adres Ekle Ilce ismi guncelleme icin "1" swipe ile secilir
* Adres Ekle Mahalle ismi guncelleme icin "1" swipe ile secilir
* Klavye kapatilir
* Kaydet ikonuna tiklanir "Lütfen adres bilgilerinizi giriniz." uyarı mesajı görülür
* Yukarı scroll et ve "Test ortamı icin adres detay No:1453409" textini "NewAddressCustomerAddressDetailFull" elementine yaz
* Kaydet ikonuna tiklanir "Lütfen posta kodu bilgilerinizi giriniz." uyarı mesajı görülür

IOS Scenario Favorite List Name Update
--------------------------------------
tags:Gratis_IOS_FavoriAdiListeDuzenleme
* Uygulama baslatilir
* Login sayfasina gecilir
* Gratis2 ile login olunur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Profil sayfasındaki Favori butonuna tiklanir
* Favori Liste Adi Duzenle alani kontrol edilir
* Favori sayfasindaki Liste Adini Duzenle butonuna tiklanir ve yeni isim girilir

IOS Scenario Adding A Product To Favorite List
----------------------------------------------
tags:Gratis_IOS_FavorilereUrunEklemeVeCikarma
* Uygulama baslatilir
* Login sayfasina gecilir
* Gratis3 ile login olunur
* En Cok Satanlar alanindan bir urunun favori butonuna tıklanir
* Urun favorilere eklenir
* Ana sayfadaki urun favorilerden cikarilir

IOS Scenario Add Select and Delete Favorite List
------------------------------------------------
tags:Gratis_IOS_ListeOlusturmaSecmeVeSilme
* Uygulama baslatilir
* Login sayfasina gecilir
* Gratis4 ile login olunur
* En Cok Satanlar alanindan bir urunun favori butonuna tıklanir
* Yeni favori listesi olusturulur ve secilen urun favori eklenir
* Diger'e tiklanir diger sayfasinin acildigi gorulur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Profil sayfasındaki Favorilerim ikonuna tiklanir
* Listeden yeni eklenen favori listesi secilir
* Favori listesi silinir

IOS Scenario Adding a Favorite List With the Same Name
------------------------------------------------------
tags:Gratis_IOS_AyniIsimleFavoriListesiOlusturma
* Uygulama baslatilir
* Login sayfasina gecilir
* Gratis3 ile login olunur
* En Cok Satanlar alanindan bir urunun favori butonuna tıklanir
* Yeni favori listesi olusturulur ve secilen urun favori eklenir
* En Cok Satanlar alanindan ikinci urunun favori butonuna tıklanir
* Istek listesi adi benzersiz olmali uyarisi gorulur
* Diger'e tiklanir diger sayfasinin acildigi gorulur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Profil sayfasındaki Favorilerim ikonuna tiklanir
* Listeden yeni eklenen favori listesi secilir
* Favori listesi silinir

IOS Scenario Add To Cart From Favorite List
-------------------------------------------
tags:Gratis_IOS_FavoriListesindenSepeteEkleme
* Uygulama baslatilir
* Login sayfasina gecilir
* Gratis0 ile login olunur
* En Cok Satanlar alanindan bir urunun favori butonuna tıklanir
* Yeni favori listesi olusturulur ve secilen urun favori eklenir
* Diger'e tiklanir diger sayfasinin acildigi gorulur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Profil sayfasındaki Favorilerim ikonuna tiklanir
* Listeden yeni eklenen favori listesi secilir
* Favorilerden urun detay sayfasına gecilir
* Favorilerdeki urun sepete eklenir ve alısverise devam edilir
* Favorilerdeki urun sepete eklenir ve sepete gidilir
* Sepet kasa arkasi popup'i kapatilir
* Urunlerin sepete eklendigi kontrol edilir
* Favori listesi kontrol edilerek temizlenir
* Favori listesi silinir

IOS Scenario From Favorite List to Home Page
--------------------------------------------
tags:Gratis_IOS_FavorilerdenAnasayfayaYonlendirme
* Uygulama baslatilir
* Login sayfasina gecilir
* Gratis1 ile login olunur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Profil sayfasındaki Favorilerim ikonuna tiklanir
* Favori listesinden ana sayfaya yonlendirme yapilir

IOS Scenario Max Add To Cart From Favorite List
-----------------------------------------------
tags:Gratis_IOS_FavorilerdeMaximumSepeteEkleme
* Uygulama baslatilir
* Ana sayfa sepet ikonuna tiklanir
* Sepet ikonu ile Gratis2 login olunur
* Sepet kontrol edilerek temizlenir
* En Cok Satanlar alanindan bir urunun favori butonuna tıklanir
* Urun favorilere eklenir
* Diger'e tiklanir diger sayfasinin acildigi gorulur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Profil sayfasındaki Favorilerim ikonuna tiklanir
* Favorilerdeki urun sepete eklenir ve alısverise devam edilir
* Favorilerdeki urun sepete eklenir ve alısverise devam edilir
* Favorilerdeki urun sepete eklenir ve alısverise devam edilir
* Favorilerdeki urun sepete eklenir ve alısverise devam edilir
* Favorilerdeki ürünün sepete ekleme butonuna tıklanır
* Maksimum ürün ekleme uyarisi kontrol edilir
* Favori listesi kontrol edilerek temizlenir
* Ana sayfa tab'ına tıklanır
* Ana sayfa sepet ikonuna tiklanir
* Sepet kontrol edilerek temizlenir
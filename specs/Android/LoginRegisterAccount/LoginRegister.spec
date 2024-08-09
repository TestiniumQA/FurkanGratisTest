Specification Heading
=====================
Created by testinium on 23.05.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Login
-----
tags:Gratis_Android_Login
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Yeni rastgele login olunur.
* Uygulamadan cikis yapilir.

Register
--------
tags:Gratis_Android_Register
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Yeni Register'a tıklanır.
* Yeni Kullanıcı bilgileri girilir.
* Yeni Kullanıcı şartlarına tıklanır ve üye olunur.
//* Sms uyarısı kontrol edilir.

Register Negative
-----------------
tags:Gratis_Android_Register_Negative
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Yeni Register'a tıklanır.
* Yeni Kayıtlı Mail ile register olunur ve uyarı mesajı gorulur.
* Kayıtlı Telefon ile register olunur ve uyarı mesajı gorulur.
* Şifre hata popup'ı görülür.

Forget Password
---------------
tags:Gratis_Android_SifremiUnuttum
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Sifremi Unuttum ikonuna tiklanir.
* E-posta alanina "javaautomationtest@gmail.com" girilir.
* Sifremi unuttum Gonder butonuna tiklanir.
* Popup Tamam butonuna tiklanir.

Changing Password
---------------
tags:Gratis_Android_SifreDegistirme
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Yeni rastgele login olunur.
* Sifre basarili sekilde degistirilir.

Changing Password Negative
--------------------------
tags:Gratis_Android_SifreDegistirmeNegatif
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Yeni rastgele login olunur.
* Sifre değiştirme alanına gidilir.
* Eski şifre eksik yazılır ve uyarı mesajı görülür.
* Yeni şifre ve tekrarı uyuşmuyor uyarı mesajı görülür.
* Eski şifre hatalı uyarı mesajı görülür.

Negative Login and Forget Password
----------------------------------
tags:Gratis_Android_NegativeLoginAndForgetPassword
* Uygulama baslatilir.
* Login sayfasina gecilir.
* Sifremi Unuttum ikonuna tiklanir.
* Sifremi unuttum Gonder butonuna tiklanir.
* Sifremi unuttum bos mail uyarısı gorulur.
* Uygulama geri butonuna bas.
* Login icin bos mail ve sifre uyarısı gorulur.
* E-posta alanina "yanlış formatta eposta" girilir.
* Sifre alanına "sifre" girilir.
* Yanlıs eposta ve sifre uyarıları gorulur.
* E-posta alanina "kayitliolmayaneposta@gmail.com" girilir.
* Sifre alanına "sifresifre" girilir.
* Kayıtlı olmayan eposta ile login olma uyarısı gorulur.
* E-posta alanina "javaautomationtest@gmail.com" girilir.
* Sifre alanına "sifresifre" girilir.
* Yanlıs sifre veya email/cep telefonu uyarısı gorulur.

Register Warning Messages
-------------------------
tags:Gratis_Android_RegisterUyariMesajlari
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Yeni Register'a tıklanır.
* Üye Ol Ad "a", Soyad "b" ve Eposta İsmi "a@" girilir.
* Üye Ol ikonuna tiklanir "Türkçe isimler 2 karakterden az olamaz. İsminizi kontrol ediniz." uyarı mesajı görülür.
* Yukarı scroll et ve "YeniAd" textini "registerName" elementine yaz.
* Üye Ol ikonuna tiklanir "Türkçe isimler 2 karakterden az olamaz. Soyadınızı kontrol ediniz." uyarı mesajı görülür.
* Yukarı scroll et ve "YeniSoyad" textini "registerSurname" elementine yaz.
* Üye Ol ikonuna tiklanir "Geçersiz giriş. Lütfen bir e-posta adresi girin; örneğin, john@smith.com" uyarı mesajı görülür.
* Yukarı scroll et ve "gratistrtestinium@gmail.com" textini "registerMail" elementine yaz.
* "registerPhone" li elementi bul ve temizle
* Üye Ol ikonuna tiklanir "Telefon Numarası Geçersiz. Lütfen 10 hane olacak şekilde giriniz." uyarı mesajı görülür.
* "registerPhone"li elementi bulana kadar "3" kere yukarı swipe yap ve elementi bul
* Yukarı scroll et ve "5" textini "registerPhone" elementine yaz.
* Üye Ol ikonuna tiklanir "Telefon Numarası Geçersiz. Lütfen 10 hane olacak şekilde giriniz." uyarı mesajı görülür.
* "registerPhone"li elementi bulana kadar "3" kere yukarı swipe yap ve elementi bul
* "registerPhone" li elementi bul ve temizle
* Yukarı scroll et ve "5112223311" textini "registerPhone" elementine yaz.
* Üye Ol ikonuna tiklanir "Doğum Tarihi alanı boş bırakılamaz." uyarı mesajı görülür.

Deleting Account
----------------
tags:Gratis_Android_HesapSilme
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Yeni Gratis5 ile login olunur.
* Profil'e tiklanir profilim sayfasinin acildigi gorulur.
* Hesabı Sil islemi yapilir.

Gratis Card Connect
-------------------
tags:Gratis_Android_GratisCardBagla
* Uygulama baslatilir.
* Yeni login sayfasina gecilir.
* Yeni Gratis5 ile login olunur.
* Diger tabina tiklanir.
* Gratis Kartim sayfasina gecilir.
* Gratis Card baglama islemi yapilir.
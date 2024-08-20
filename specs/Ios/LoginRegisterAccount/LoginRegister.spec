Specification Heading
=====================
Created by testinium on 15.06.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
IOS Scenario Login
------------------
tags:Gratis_IOS_Login
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni rastgele login olunur
* Uygulamadan cikis yapilir

IOS Scenario Register
---------------------
tags:Gratis_IOS_Register
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni Register'a tıklanır
* Kullanıcı bilgileri girilir
* Kullanıcı şartlarına tıklanır ve üye olunur
//* Sms uyarısı kontrol edilir

IOS Scenario Register Negative
------------------------------
tags:Gratis_IOS_Register_Negatif
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni Register'a tıklanır
* 16 yasindan kucuk dogum tarihi secilir ve uyarı mesaji gorulur
* Kayıtlı Mail ile register olunur ve uyarı mesajı gorulur
* Kayıtlı Telefon ile register olunur ve uyarı mesajı gorulur

IOS Scenario Register Warning Messages
--------------------------------------
tags:Gratis_IOS_RegisterUyariMesajlari
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni Register'a tıklanır
* Üye Ol Ad "a", Soyad "b", Telefon "" ve Eposta İsmi "a@" girilir
* Üye Ol ikonuna tiklanir "Türkçe isimler 2 karakterden az olamaz. İsminizi kontrol ediniz." uyarı mesajı görülür
* Yukarı scroll et ve "YeniAd" textini "RegisterNameFull" elementine yaz
* Üye Ol ikonuna tiklanir "Türkçe isimler 2 karakterden az olamaz. Soyadınızı kontrol ediniz." uyarı mesajı görülür
* Yukarı scroll et ve "YeniSoyad" textini "RegisterSurnameFull" elementine yaz
* Üye Ol ikonuna tiklanir "Lütfen e-posta adresi giriniz" uyarı mesajı görülür
* Yukarı scroll et ve "gratistrtestinium@gmail.com" textini "RegisterMailFull" elementine yaz
* "RegisterPhoneFull" li elementi bul ve temizle
* Üye Ol ikonuna tiklanir "Lütfen telefon numarasını eksiksiz giriniz" uyarı mesajı görülür
* Yukarı scroll et ve "5" textini "RegisterPhoneFull" elementine yaz
* Üye Ol ikonuna tiklanir "Telefon Numarası Geçersiz. Lütfen 10 hane olacak şekilde giriniz." uyarı mesajı görülür
* Yukarı scroll et ve "112223311" textini "RegisterPhoneFull" elementine yaz
* Üye Ol ikonuna tiklanir "Doğum Tarihi alanı boş bırakılamaz." uyarı mesajı görülür

IOS Scenario Forget Password
----------------------------
tags:Gratis_IOS_SifremiUnuttum
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Sifremi Unuttum ikonuna tiklanir
* E-posta alanina "javaautomationtest@gmail.com" girilir
* Sifremi unuttum Gonder butonuna tiklanir
* Popup Tamam butonuna tiklanir

IOS Scenario Changing Password
------------------------------
tags:Gratis_IOS_SifreDegistirme
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni rastgele login olunur
* Sifre basarili sekilde degistirilir

IOS Scenario Changing Password Negative
---------------------------------------
tags:Gratis_IOS_SifreDegistirmeNegatif
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni rastgele login olunur
* Sifre değiştirme alanına gidilir
* Eski şifre eksik yazılır ve uyarı mesajı görülür
* Yeni şifre ve tekrarı uyuşmuyor uyarı mesajı görülür
* Eski şifre hatalı uyarı mesajı görülür

IOS Scenario Negative Login and Forget Password
-----------------------------------------------
tags:Gratis_IOS_NegatifLoginVeSifremiUnuttum
* Uygulama baslatilir
* Login sayfasina gecilir
* Sifremi Unuttum ikonuna tiklanir
* Sifremi unuttum Gonder butonuna tiklanir
* Sifremi unuttum bos mail uyarısı gorulur
* Login icin bos mail ve sifre uyarısı gorulur
* E-posta alanina "yanlış formatta eposta" girilir
* Sifre alanına "sifre" girilir
* Yanlıs eposta ve sifre uyarıları gorulur
* E-posta alanina "seyfettinalem@gmail.com" girilir
* Sifre alanına "1A2s3d.." girilir
* Kayıtlı olmayan eposta ile login olma uyarısı gorulur
* E-posta alanina "javaautomationtest@gmail.com" girilir
* Sifre alanına "sifresifre" girilir
* Yanlıs sifre veya email/cep telefonu uyarısı gorulur

IOS Scenario Updating Customer Information
------------------------------------------
tags:Gratis_IOS_UyeBilgileriGuncelleme
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni rastgele login olunur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Uye bilgilerim sayfasina gecilir
* Uye bilgileri basarili sekilde guncellenir

IOS Scenario Deleting Account
-----------------------------
tags:Gratis_IOS_HesapSilme
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni Gratis5 ile login olunur
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Hesabı Sil islemi yapilir

IOS Scenario Gratis Card Connect
--------------------------------
tags:Gratis_IOS_GratisCardBagla
* Uygulama baslatilir
* Yeni login sayfasina gecilir
* Yeni Gratis5 ile login olunur
* Gratis Card baglama islemi yapilir
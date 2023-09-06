Specification Heading
=====================
Created by testinium on 15.06.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
IOS Scenario Login
------------------
tags:Gratis_IOS_Login
* Uygulama baslatilir
* Login sayfasina gecilir
* Giris yapilir
* Uygulamadan cikis yapilir

IOS Scenario Register
---------------------
tags:Gratis_IOS_Register
* Uygulama baslatilir
* Login sayfasina gecilir
* Register'a tıklanır
* Kullanıcı bilgileri girilir
* Kullanıcı şartlarına tıklanır ve üye olunur
* Sms uyarısı kontrol edilir

IOS Scenario Register Negative
------------------------------
tags:Gratis_IOS_Register_Negatif
* Uygulama baslatilir
* Login sayfasina gecilir
* Register'a tıklanır
* 16 yasindan kucuk dogum tarihi secilir ve uyarı mesaji gorulur
* Kayıtlı Mail ile register olunur ve uyarı mesajı gorulur
* Kayıtlı Telefon ile register olunur ve uyarı mesajı gorulur

IOS Scenario Forget Password
----------------------------
tags:Gratis_IOS_SifremiUnuttum
* Uygulama baslatilir
* Login sayfasina gecilir
* Sifremi Unuttum ikonuna tiklanir
* E-posta alanina "javaautomationtest@gmail.com" girilir
* Sifremi unuttum Gonder butonuna tiklanir
* Popup Tamam butonuna tiklanir

IOS Scenario Changing Password
------------------------------
tags:Gratis_IOS_SifreDegistirme
* Uygulama baslatilir
* Login sayfasina gecilir
* Giris yapilir
* Sifre basarili sekilde degistirilir

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
* Login sayfasina gecilir
* Giris yapilir
* Profil'e tiklanir profilim sayfasinin acildigi gorulur
* Uye bilgilerim sayfasina gecilir
* Uye bilgileri basarili sekilde guncellenir
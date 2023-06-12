Specification Heading
=====================
Created by testinium on 23.05.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Login
-----
tags:Gratis_Android_Login
* Uygulama baslatilir.
* Login sayfasina gecilir.
* Login olunur.

Register
--------
tags:Gratis_Android_Register
* Uygulama baslatilir.
* Login sayfasina gecilir.
* Register'a tıklanır.
* Kullanıcı bilgileri girilir.
* Kullanıcı şartlarına tıklanır ve üye olunur.

Register Negative
-----------------
* Uygulama baslatilir.
* Login sayfasina gecilir.
* Register'a tıklanır.
* Kayıtlı Mail ile register olunur ve uyarı mesajı gorulur.


Forget Password
---------------
tags:Gratis_Android_SifremiUnuttum
* Uygulama baslatilir.
* Login sayfasina gecilir.
* Sifremi Unuttum ikonuna tiklanir.
* E-posta alanina "javaautomationtest@gmail.com" girilir.
* Sifremi unuttum Gonder butonuna tiklanir.
* Popup Tamam butonuna tiklanir.

Changing Password
---------------
tags:Gratis_Android_SifreDegistirme
* Uygulama baslatilir.
* Login sayfasina gecilir.
* Login olunur.
* Sifre basarili sekilde degistirilir.

Negative Login and Forget Password
----------------------------------
tags:Gratis_Android_NegativeLoginAndForgetPassword
* Uygulama baslatilir.
* Login sayfasina gecilir.
* Sifremi Unuttum ikonuna tiklanir.
* Sifremi unuttum Gonder butonuna tiklanir.
* Sifremi unuttum bos mail uyarısı gorulur.
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


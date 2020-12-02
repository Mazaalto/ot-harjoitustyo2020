# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattelee kaksiosaista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

studyclock.ui --> studyclock.domain --> (studyclock.dao (dao:ta ei vielä toteutettu))

Pakkauksissa on erikseen määriteltynä käyttöliittymä ja ohjelman toiminnallisuudet ja tietojen tallentaminen. Tällä hetkellä tiedot tallennettaan luokan StudyHistoryn olioihin, myöhemmin tiedostoon.

Studyclock.ui pakkauksessa on toteutettuna yksinkertainen tekstikäyttöliittymä, jonka muutan pian JavaFX-luokkaa toteuttavaksi toteutukseksi. Tekstikäyttöliittymä on toteutettu luokkaan
timerUI.java pakkaukseen studyclock.ui.

Studyclock.domain pitää sisällään ohjelman toiminnallisuuden. Main metodeja on kaksi Java FX testien läpimenemisen varmistamiseksi. Lisäksi paketissa on toiminnallisuudesta huolehtivat Timer-luokka, johon on toteutettu Pomodoro-ajastimen toiminnallisuudet. Viimeisenä on toteutettu oma luokkansa StudyHistory, joka pitää sisällään toiminnallisuudet opiskelun kirjanpitoon. Toteutus toteutetaan myöhemmin tiedostoon. Tällä hetkellä käytetään java-oliota.

# Sovelluslogiikka

(https://github.com/Mazaalto/ot-harjoitustyo2020/blob/4bc4d934bd51828ac1c76eda201d17e96ba7a532/Sovelluslogiikka.jpg)

# Luokkakaavio
(https://github.com/Mazaalto/ot-harjoitustyo2020/blob/4bc4d934bd51828ac1c76eda201d17e96ba7a532/luokkakaavio.jpg)

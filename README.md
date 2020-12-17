# OpiskeluKello

## Yleistä

OpiskeluKello on projektityö Helsingin yliopiston Tietojenkäsittelytieteen kurssin Ohjelmistotekniikan menetelmät-kurssille. Se perustuu opiskelussa erittäin toimivaan Pomodoro-tekniikkaan, jossa voidaan asettaa opiskelulle aika ja tauottaa sitä 25 minuutin paloja, jolloin keskittyminen paranee ja sitä kautta myös tulokset. Lisäksi ohjelmassa voi seurata päivittäin mihin aika opiskelussa menee.

# Dokumentaatio

[Käyttöohje]()

[Vaatimusmäärittely](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti]()

[Työaikakirjanpito](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)

## Releaset

[Julkaistut versiot](https://github.com/Mazaalto/ot-harjoitustyo2020/releases/tag/viikko5)

# Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla:

```
mvn test
```

Testikattavuusraportti luodaan komennolla:

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedoston: _target/site/jacoco/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mazaalto/OtmTodoApp/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston: _OpiskeluKello-1.0-SNAPSHOT.jar_


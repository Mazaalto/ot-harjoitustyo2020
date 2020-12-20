# OpiskeluKello

### Yleistä

OpiskeluKello on projektityö Helsingin yliopiston Tietojenkäsittelytieteen kurssille Ohjelmistotekniikka (5 op). Ohjelmani perustuu opiskelussa erittäin toimivaan Pomodoro-tekniikkaan, jossa voidaan asettaa opiskelulle aika ja tauottaa sitä 25 minuutin paloja, jolloin keskittyminen paranee ja sitä kautta myös tulokset. Lisäksi ohjelmassa voi seurata päivittäin mihin aika opiskelussa menee. Valitsin aiheen, koska jouduin Koronan takia tekemään paljon töitä itseohjautuvasti ja Pomodoro tekniikka oli erittäin isossa asemassa työni jaksottamisessa ja jaksamisessa.

## Vaatimukset laitteistosta

Sovellus on toteutettu käyttämällä JavaFX komponentteja sovelluksessa. Sovelluksen pitäisi toimia riippumatta siitä mikä Javan versio on käytössäsi. Sitä on testattu versiolla 11 (sekä uusimmalla).

## Dokumentaatio

[Käyttöohje](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/maarittelydokumentti.md)

[Arkkitehtuurikuvaus](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/testausdokumentaatio.md)

[Työaikakirjanpito](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)

## Releaset

[loppupalautus](https://github.com/Mazaalto/ot-harjoitustyo2020/releases/tag/1.2)

[Julkaistut versiot](https://github.com/Mazaalto/ot-harjoitustyo2020/releases)

# Komentorivitoiminnot

### Testaus

Testit voidaan suorittaa suoraan komentoriviltä. Jos latasit ohjelman zip-tiedostona se avataan unzip komennolla ennen seuraavia ohjeita. Ohjelman kansion rakenne noudattelee ot-harjoitustyön2020:n rakennetta täällä gitissä. Eli sielä löytyy erikseen kansio harjoitustyö, jonka sisällä on itse ohjelma Opiskelukello. Ohjelmakoodin sisältävässä kansiossa rivikomennolla terminaalissa:

```
mvn test
```

Testikattavuusraportti luodaan komennolla terminaalissa:

```
mvn jacoco:report
```

Kattavuusraportin pääsee näkemään tiedostonkansiosta kansion(target/site/jacoco/index.html_) ja avaamalla sen selaimessa.

### Checkstyle

Projektissa on käytössä Checkstyle, jonka avulla voidaan määrittää ja tarkistaa koodin laatua. Pääset halutessasi näkemään koodin raportin komennolla:

```
 mvn jxr:jxr checkstyle:checkstyle
```
Virheilmoitukset löytyvät vastaavalla tavalla kuin yllä oleva jacocon raportti menemällä tiedoston kansioon (target/site/checkstyle.html_) ja avaamalla selaimessa sen sisältämän checkstyle.html-tiedoston. 

### JavaDoc

Tein ohjelmaa varten javaDoc dokumentaation. Dokumentaatioon pääset komennolla terminaalista
```
 mvn javadoc:javadoc
```
ja kuten jo edellisissä kohdissa, löytyy tieto samasta kansiosta (tiedoston target-kansion, site-kansiosta ja sieltä aidocs kansio) nimellä index.html. Sen voi myös avata selaimeen.

### Valmiin jar-tiedoston luominen

Ohjelmasta saa jar-paketin helposti suorittamalla komennon mvn package. Se luo kuten edellä target kansioon jar-tiedoston.esim.  _OpiskeluKello-1.0-SNAPSHOT.jar_

```
mvn package
```
(Huom! Valmis jar-paketti löytyy myös täältä: [loppupalautus](https://github.com/Mazaalto/ot-harjoitustyo2020/releases/tag/1.2) )

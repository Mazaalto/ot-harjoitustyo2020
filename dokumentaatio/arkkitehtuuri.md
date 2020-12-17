# Arkkitehtuurikuvaus

## Rakenne

Ohjelman Opiskelukello rakenne noudattelee kaksiosaista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

studyclock.ui --> studyclock.domain

Toteutin ohjelman niin että kaikki ohjelmalogiikka löytyy pakkauksesta studyclock.domain ja kaikki käyttöliittymä koodi löytyy kansiosta studyclock.ui.

## Käyttöliittymä 

Toteutin käyttöliittymän kokonaan kansioon studyclock.ui. Korvasin tekstikäyttöliittymän kokonaan JavaFX toteutuksella. Koko käyttöliittymä löytyy luokasta timerUIJavaFX ja esittelen sen pääpiirteittään tässä.

Koska kyseessä on kello-ohjelma, toteutin kellon toiminnallisuudet Timeline ja Label-luokkien avulla. Käytännössä alussa asetetaan Stage oliolle, nimeltä window, päänäkymä, joka on toteutettu BorderPane luokan avulla. Tähän Borderpane olioon nimeltä mainscene on määritelty ohjelman napit (Start, Give up, Adjust the timer, Show studyhistory). Muotoilussa käytin värinä Goldenrodia ja fx- fonttikokoa 2em. Tyylin määrittelyssä on toisteisuutta, mutta en ehtinyt kasata väiren määrittelyä omaan luokkaansa.

### Start the timer nappia painettaessa
Alkaa kello laskemaan oletusajalle aikaa (25 min). Ajan näyttäminen onnistuu kätevän timeline-luokan avulla. Sen setCycleCount-metodilla pystyin määrittämään muutoksia Label olioille, joissa siis oli kuvattuna aika minuutteina ja sekunteina. Koska laskenta tapahtuu studyclock.domain kansiossa niin ajan sieltä saa metodissa this.service.getSeconds(). Ja koska aika täytyy näyttää minuutteina ja sekunteina jaetaan sekunnit 60 ja otetaan siitä jakojäännös. 

### Give up nappia painettaessa
Kellon suoritus keskeytetään asettamalla sovelluslogiikkaan String typen arvoksi "stop". Tällöin ohjelma tietää näyttää oikean hälytyksen Alert luokan avulla. Tällöin Alert oliossa on ohjeet ohjelman loppusuoritukselle. Esimerkiksi uuden timerin saa ajastettua Adjust the timer nappia painamalla.

### Adjust the timer nappia painettaessa
Luodaan uusi HBox olio, johon tallennetaan napit Button luokan avulla sekä ohjetekstit Label luokan avulla. Nappeja painamalla ilmoitetaan sovelluslogiikkaan tarvittavia muutoksia, kuten uuden timerin aika ja tyyppi (Study tai Break) sekä mitä ainetta opiskellaan. Näitä tietoja tarvitaan analytiikkaa varten.

### Show the studyhistory nappia painettaessa
Toteutin analytiikan myös BorderPanen avulla. Alussa luodaan uusi scene olio (Scene scene = new Scene(graphScene); jonka avulla toteutetaan pylväs- ja piirakkadiagrammit. Aluksi Diagrammeissa on määrittämäni demoarvot, eli XYChart series olioon tallennettuna series-luokan getData-metodilla tavoite ja toteutuneet ajat uusina XYChart.data olioina. Jos käyttäjä on opiskellut tai asettaa uuden tavoitteen Set the Goal napilla niin käyttäjä voi päivittää diagnostiikan painamalla nappia graph (jossa lukee update the graphs) piirtyy toteutunut opiskeluaika tunteina vasemmalle goal-graafin viereen sekä piirakkakaavio muuttuu vastaamaan toteutunutta.

# Sovelluslogiikka

(https://github.com/Mazaalto/ot-harjoitustyo2020/blob/4bc4d934bd51828ac1c76eda201d17e96ba7a532/Sovelluslogiikka.jpg)

# Luokkakaavio
(https://github.com/Mazaalto/ot-harjoitustyo2020/blob/4bc4d934bd51828ac1c76eda201d17e96ba7a532/luokkakaavio.jpg)

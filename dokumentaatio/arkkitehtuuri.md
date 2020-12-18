# Arkkitehtuurikuvaus

## Rakenne

Ohjelman Opiskelukello rakenne noudattelee kaksiosaista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

studyclock.ui --> studyclock.domain

Toteutin ohjelman niin että kaikki ohjelmalogiikka löytyy pakkauksesta studyclock.domain ja kaikki käyttöliittymä koodi löytyy kansiosta studyclock.ui. Lisäksi tieto tallentuu ohjelman kansiosta löytyvään memory.txt tiedostoon.

## Käyttöliittymä 

Toteutin käyttöliittymän kokonaan kansioon studyclock.ui. Korvasin tekstikäyttöliittymän kokonaan JavaFX toteutuksella. Koko käyttöliittymä löytyy luokasta timerUIJavaFX ja esittelen sen pääpiirteittään tässä.

Koska kyseessä on ajastin-ohjelma, toteutin kellon toiminnallisuudet Timeline ja Label-luokkien avulla. Käytännössä alussa asetetaan Stage oliolle, nimeltä window, päänäkymä, joka on toteutettu BorderPane luokan avulla. Tähän Borderpane olioon nimeltä mainscene on määritelty ohjelman napit (Start, Give up, Adjust the timer, Show studyhistory). Muotoilussa käytin värinä Goldenrodia ja fx- fonttikokoa 2em. Tyylin määrittelyssä on toisteisuutta, mutta en ehtinyt kasata väiren määrittelyä omaan luokkaansa.

### Start the timer-nappia painettaessa
Alkaa kello laskemaan oletusajalle aikaa (25 min). Ajan näyttäminen onnistuu kätevän timeline-luokan avulla. Sen setCycleCount-metodilla pystyin määrittämään muutoksia Label olioille, joissa siis oli kuvattuna aika minuutteina ja sekunteina. Koska laskenta tapahtuu studyclock.domain kansiossa niin ajan sieltä saa metodissa this.service.getSeconds(). Ja koska aika täytyy näyttää minuutteina ja sekunteina jaetaan sekunnit 60 ja otetaan siitä jakojäännös, jotta minuutit ja sekunnit näyttävät oikeita arvoja. 

### Give up-nappia painettaessa
Kellon suoritus keskeytetään asettamalla sovelluslogiikkaan String typen arvoksi "stop". Tällöin ohjelma tietää näyttää oikean hälytyksen Alert luokan avulla. Tällöin Alert oliossa on ohjeet ohjelman loppusuoritukselle. Esimerkiksi uuden timerin saa ajastettua Adjust the timer nappia painamalla.

### Adjust the timer-nappia painettaessa
Luodaan uusi HBox olio, johon tallennetaan napit Button luokan avulla sekä ohjetekstit Label luokan avulla. Nappeja painamalla ilmoitetaan sovelluslogiikkaan tarvittavia muutoksia, kuten uuden timerin aika ja tyyppi (Study tai Break) sekä mitä ainetta opiskellaan. Näitä tietoja tarvitaan analytiikkaa varten.

### Show the studyhistory-nappia painettaessa
Toteutin analytiikan myös BorderPanen avulla. Alussa luodaan uusi scene olio (Scene scene = new Scene(graphScene); jonka avulla toteutetaan pylväs- ja piirakkadiagrammit. Aluksi Diagrammeissa on määrittämäni demoarvot, eli XYChart series olioon tallennettuna series-luokan getData-metodilla tavoite ja toteutuneet ajat uusina XYChart.data olioina. Jos käyttäjä on opiskellut tai asettaa uuden tavoitteen "Set the Goal"- napilla niin käyttäjä voi päivittää diagnostiikan painamalla nappia graph (jossa lukee update the graphs) piirtyy toteutunut opiskeluaika tunteina vasemmalle goal-graafin viereen sekä piirakkakaavio muuttuu vastaamaan toteutunutta. Käyttäjä voi tallentaa tiedon memory.txt -tiedostoon painamalla nappia "Save the data".

# Sovelluslogiikka
Sovelluksen tieto kulkeutuu sovelluslogiikasta timerUIJavaFX--> StudyClockServiceen ja tieto tallennetaan siitä StudyHistoryyn ja koostuu Timer olioista. Lopuksi käyttäjä voi tallentaa tiedon memory.txt -tiedostoon painamalla nappia "Save the data".

[Sekvenssikaavio](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/Sekvenssikaavio%20kellonka%CC%88ynnistys.jpg)

Kaikki toiminnallisuus, jossa käsitellään tietoa, on toteutettu StudyClockSerciven avulla. Luokassa on kaikille eri tilanteille omat metodinsa. 
Tieto on tallennettu serviisissä seuraavasti:
- Timer oliot, eli toteutuneet opiskeluhetket löytyvät StudyHistory oliosta
- Päivän opintohetket ovat tallennettuna HashMappiin nimeltä today
- int seconds pitää kirjaa kuluvasta ajasta ja int timetosave tallennettavan Timerin ajasta
- String unknownSubj pitää sisällään oletusaiheen timerille
- String type kertoo onko kyseessä study, break vai stop
- goalHours pitää kirjaa käyttäjän opiskelutavoitteesta

Logiikassa on toteutettu edellisten getterien ja settereiden lisäksi
mm. nämä metodit:
- getStringToInt(String fromUI) joka tarkistaa onko kyseessä luku String muodossa ja palauttaa sen jos on
- addTimer()-metodi, joka lisää Studyhistoryyn Timer olion
- addTodaysPieChart(String subj, int minutes)- metodi joka tallentaa aiheella ja ajalla päivän opiskeluhetken Hashmappiin
-  calculatePercentages()-metodi laskee prosenttiosuudet piirakkakaavioon
- getPercentageTrue(String key) antaa prosenttiosuuden jos päivän tiedot sisältää ko. avaimen
- minusSeconds() päivittää ajan kulumista muuttujaan seconds
- getToday() palauttaa kuluvan päivän Date oliosta taulukon avulla
- saveData() joka tallentaa tiedon tekstitiedostoon

//tähän tulee kuva 3 eli luokka/pakkauskaavio

### Tiedostojen pysyväistallennus
Tieto tallentuu, jos käyttäjä niin haluaa. Tämä tapahtuu painamalla  nappia "Save the data". Tieto tallentuu tällöin memory.txt -tiedostoon. 

## Ohjelman päätoiminnallisuudet

Ohjelmassa mitataan aikaa, joten esittelen seuraavaksi miten tämä tapahtuu käytännössä kätevän sekvenssikaavion avulla.

### Kellon käynistäminen oletusarvoilla
[Sekvenssikaavio](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/kuvat/Sekvenssikaavio%20kellonka%CC%88ynnistys.jpg)

Kun käyttäjä klikkaa Start-nappia niin sovellus käynnistyy automaattisesti oletusarvoilla. Käytännössä se tapahtuu kuvan esittämällä tavalla eli käyttäjä näkee vain graafisen ulkoasun ja UI-luokka operoi serviisin kanssa. Serviisissä on toteutettuna StudyHistory-olio, jonka sisältö on tallennettu Timer-olioina. Tämän jälkeen serviisi pitää UI:n ajantasalla ajankulumisesta getSeconds() metodin avulla. Lopuksi kun getSeconds saa arvokseen =>0 niin luodaan uusi TimerOlio, niin että serviisi kutsuu StudyHistorya metodilla addTimer. Tällöin Timer saa konstruktorissaan ajan sekunteina, aiheen String-muuttujana ja päivämäärän String-oliona. Tieto menee serviisiltä UI:lle ja käyttäjä saa Alert ilmoituksen että ajastin on valmis. Lisäksi serviisi lisää metodilla addTodaysPieChart(aihe, aika) tiedon toteutuneesta today hashMappiin. Jos tieto olisi ollut asetettuna käyttäjän toimesta, olisi se laitettu servicen oliomuuttujiksi seconds ja unknownSubj. Muuten timerin lisääminen tapahtuisi samalla tavalla.


### Tietojen asettaminen Timer olioon

Sekvenssikaavioon on merkitty sinisellä arvojen asettaminen. Muuten tilanne vastaa edellä mainittua, mutta nyt aika määritetään UI:ssa käyttäjän syötteestä tekstikenttään. Sitä kautta se päivitetään serviisiin, jossa se korvaa seconds parametrin arvon. Lisäksi myös opiskelun aiheen voi päivittää jos käyttäjä painaa set subject- nappia. Muuten serviisi olettaa että käytetään oletusaihetta. (viimeksi määriteltyä)


### Graafien näyttäminen

Graafien arvot määrätyvät vihreillä piirretyn perusteella. (yllä oleva kuva) Siinä siis graafisille piirakkakaaviolle ja pylväskaaviolle määräytyy oletusarvot ja jos käyttäjä painaa update the graphs-nappia niin silloin graafit muodostuvat uudelleen serviisin lähettämien tietojen perusteella. Tämä tapahtuu metodilla calculatePercentages(). Tämä paloittaa percentages hashmapin, johon on kätevästi serviisissä laskettu prosentit niin että ne löytyvät aiheen nimellä (avaimena hashMapissa). Pylväsdiagrammi päivittyy vastaavasti.



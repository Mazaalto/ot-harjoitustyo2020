# Määrittelydokumentti

## Sovelluksen tarkoitus

Sovelluksen tarkoitus on auttaa opiskelemaan paremmin. Innostuin pomodoro-tekniikasta alunperin ohjelmoinnin peruskurssilla ja sen jälkeen olen ollut uskollinen käyttäjä tekniikalle. Opiskelua voi siis aikatauluttaa jakamalla asiat 25 minuutin pituisiin suorituksiin, suorituksen jälkeen pidetään aina tauko. Tätä toistetaan opiskelijasta riippuen neljä tai enemmän kertoja. Sen jälkeen pidetään pidempi tauko.

Lisäksi halusin omaan opiskeluuni kannustimeksi keinon nähdä miten paljon olen päivän aikana opiskellut ja mitä aineita. Ohjelmassa tämä on toteutettu selkeillä pylväs- ja piirakkadiagrammeilla.

## Käyttäjät
Koska kyseessä on yksinkertainen ajastin, en kokenut tarpeelliseksi rajoittaa käyttöä eri käyttäjätyypeille vaan ajattelin että kellon käytön pitää olla mahdollisimman sujuvaa ja nopeaa. Lisäksi sen käyttäminen on ainakin toistaiseksi äänetöntä (ilmoitukset tulevat ponnahdusikkunoina) joten sovellus sopii myös kirjastoon.

## Käyttöliittymä
Ylhäällä neljä nappia: "Start the timer", "Give up", "Adjust the timer" ja "Show the study History". Niiden alapuolella on isoilla selkeillä numeroilla toteutettu Study Clock ajastin.
Nappien toiminnallisuudet ja käyttöohjeet löytyvät täältä: [käyttöohje](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/kayttoohje.md).



## Jatkokehitysideoita
Haluaisin toteuttaa erilaisia ääniä, mutta tietenkin niin että käyttäjä voisi itse valita mitä ääniä käyttää. Olen aloittanut jo äänten nauhottamisen. Seuraavaan versioon siis.
Visuaalisen ilmeen hiominen. Haluaisin päivittää ohjelmaa vielä hienomman näköiseksi. Nyt valitettavasti muiden kurssien takia en ehtinyt vielä.
Lisäksi nyt ohjelma kattaa hyvin yhden päivän aikana tapahtuvan opiskelun, mutta haluan laajentaa sitä niin että tilastoja saadaan koko vuodelta. Tätä varten tarvitaan teksitiedosto, johon voidaan tallentaa Timerit tiedostoina, ja näin voidaan tarjota laajempia raportteja käyttäjälle.

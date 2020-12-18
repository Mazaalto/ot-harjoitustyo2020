# Testausdokumentaatio
Ohjelmaa on testattu erilaisilla JUnit-testeillä (yksikkö testausta monipuolista) sekä käyttäjätasolla peruskäytössä sekä yrittäen saada ohjelma kaatumaan.

## JUnit-testaus ja testien sisällöstä
Automatisoidut testit on tehty omaan testikansioonsa ja ne kattavat ohjelman sovelluslogiikkaa. Luokat on suunniteltu niin että jokaisen vastuulla olisi selkeästi omat tehtävänsä, esim. serviisissä on kaikki toimintalogiikka. Pääset katsomaan testejä täältä: [testien katseleminen](https://github.com/Mazaalto/ot-harjoitustyo2020/tree/master/harjoitusty%C3%B6/OpiskeluKello/src/test/java)

Omat testit on tehty kaikille luokille, paitsi käyttöliittymälle. Käyttöliittymän toiminta on testattu vain käyttäjätasolla ja suunnittelemalla käyttöliittymä taitojen puitteessa mahdollisen turvalliseksi käyttää.

## Testikattavuudesta
Testikattavuus on korkea. Pääset tarkastelemaan ajamalla jacoco-reportin READ.me-dokumentin kuvaamalla tavalla. Testikattavuus on 85% ja ainoastaan saveFile()-metodi on tarkastamatta.Tämä johtuu siitä että implementoin pysyväistiedon tallentamisen vasta myöhemmin sovellukseen, enkä ehtinyt testata sitä. Tämä tulee korjattavaksi seuraavaan versioon.

## Järjestelmätestauksesta
Sovellus on testattu käyttäjätasolla. Kahden eri käyttäjän toimesta.

## Asennus ja alku konfigurointi
Sovellus on asennettu ja kokeiltu eri koneilla. Toiminta oli selvitettävissä sovelluksesta ja käyttöohjeesta: [käyttöohje sovellukseen](https://github.com/Mazaalto/ot-harjoitustyo2020/blob/master/dokumentaatio/kayttoohje.md)

## Toiminnallisuudet
Määrittelydokumentin mainitsemat toiminnallisuudet on tarkastettu ja lisäksi on yritetty saada ohjelma sekaisin antamalla virheellisiä syötteitä. Tästä seurauksena lisäsin ohjelman viestintää käyttäjälle. Esimerkiksi labelit päivittyvät niin että käyttäjäkin tietää mitä ohjelma milloinkin tekee.

## Sovelluksen laadusta
Tein ohjelman nykyisten taitojeni mukaan, enkä ehtinyt saada siitä palautetta tässä muodossa. Käyttöliittymän testaus ja koodin refraktoroinnissa voi olla parannettavaa. Lisäksi pysyväistallennuksen tallennuksessa oli ongelmia, joista voisin kysyä lisää.

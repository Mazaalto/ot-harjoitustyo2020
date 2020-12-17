# Ohjelma Study Clockin käyttöohje

Lataa tiedosto omalle koneellesi tästä [studyclock.jar](https://github.com/Mazaalto/ot-harjoitustyo2020/releases/tag/1.0)

### Miten käynnistän ohjelman?
Ohjelma käynnistetään yksinkertaisesti komennolla

```
java -jar studyclock.jar 
```

## Painettaessa Start the clock
Koska kyseessä on pomodoro-ajastin, niin kelloon on asetettu valmiiksi pomodoro-aika, eli 25 minuuttia. Voit halutessasi painaa nappia "Start the timer", jolloin kello käynnistyy ja alkaa laskea aikaa alaspäin. Kun Study Clock on valmis tulee selkeä popup ikkuna, joka kertoo onnistuneesta opiskeluhetkestä, lisäksi ohjelma tarjoaa automaattisesti 5 minuutin hengähdystaukoa.

## Painettaessa Give Up
Joskus opiskeleminen voi tuntua raskaalta ja voit joutua lopettamaan opiskeluhetken kesken. Silloin voit painaa nappia "Give up". Tällöin kello lakkaa laskemasta aikaa ja antaa popup tiedotteen käyttäjälle. Kun pystyt jatkamaan opiskelua voit aloittaa sen seuraavaa nappia painamalla "Adjust the timer".

## Painettaessa Adjust the timer
Hyvä opiskelukello ei vain laske aikaa, vaan myös sitä mitä olet tekemässä. Adjust the timer kohdassa voit määrittää itsellesi uuden opiskeluhetken. Jos aiot opiskella valitse se painamalla nappia "Studying", jos aiotkin pitää tauon niin valitse "Break"-nappia painamalla. Ohjelma kertoo kun valinta on onnistunut.
Seuraavaksi määritellään opiskeltavan ajan pituus. Se tapahtuu syöttämällä minuuteissa aika seuraavaan tekstikenttään ja painamalla "Set-time"- nappia. Lopuksi vielä valitaan opiskeltava aika seuraavassa tekstikentässä ja lopuksi tallennetaan se painamalla "Set subject"-nappia. 
Lopuksi voit palata takaisin alkuun painamalla "Go back"- nappia.

## Painettaessa Show the study history
On erittäin mielenkiintoista nähdä, kuinka paljon on tullut luettua yhteensä. Pääset näkemään sen painamalla alkuvalikossa "Show the study history"-nappia. Ruudulle piirtyy oletusnäkymä, jossa on näkyvissä vasemmalla taulukko mikä on tunteina päivän lukutavoite sekä oikealla miten opiskelu on jakautunut eri aineiden välillä.

### Omien tietojen näkeminen
Jos haluat nähdä omat onnistuneet opiskeluaikasi tai haluat määrittää tavoitteen uudelleen, niin kirjoita tunneissa numeroina tekstikenttään montako tuntia haluat opiskella.
Painamalla "Update the graphs"-nappia pääset näkemään omat opiskeluaikasi suhteessa tavoitteeseen tai miten opiskelu jakaantui eri aineiden välillä. Pääset takaisin kellonäkymään painamalla "Go back"-nappia.


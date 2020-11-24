## Rakenne

Ohjelman rakenne noudattelee kolmitasoista kerrosarkkitehtuuria, ja koodin pakkausrakenne on seuraava:

studyclock.ui --> studyclock.domain --> sudyclock.dao (dao:ta ei vielä toteutettu)

Pakkauksissa on erikseen määriteltynä käyttöliittymä, ohjelman toiminnallisuudet sekä tietojen tallentaminen.

Studyclock.ui pakkauksessa on toteutettuna yksinkertainen tekstikäyttöliittymä, jonka muutan seuraavaksi viikoksi Java FX toteutetuksi
käyttöliittymäksi.

Studyclock.domain pitää sisällään ohjelman toiminnallisuuden. studyclock.domain.Timerissa on itse ajastin, main-luokkia on kaksi,
testien toimivuuden takia.

studyclock.dao on vasta toteutus vaiheessa.

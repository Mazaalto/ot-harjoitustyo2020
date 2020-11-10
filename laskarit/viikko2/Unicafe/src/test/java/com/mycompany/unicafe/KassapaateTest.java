/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mazaalto
 */
public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);

    }

    @Test
    public void olemassa() {
        assertTrue(paate != null);
    }

    @Test
    public void rahamaaraAlussaOikea() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void myytyjenLounaidenMaaraOikea() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void myytyjenLounaidenMaaraOikea2() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    //käteisosto toimii sekä edullisten että maukkaiden lounaiden osalta
    @Test
    public void syoEdullisestiToimiiKunMaksuOk() {
        assertEquals(0, paate.syoEdullisesti(240));
    }

    @Test
    public void syoEdullisestiEiToimiKunMaksuEiOk() {
        assertEquals(2, paate.syoEdullisesti(2));
    }

    @Test
    public void syoMaukkaastiToimiiKunMaksuOk() {
        assertEquals(0, paate.syoMaukkaasti(400));
    }

    @Test
    public void syoMaukkaastiEiToimiKunMaksuEiOk() {
        assertEquals(3, paate.syoMaukkaasti(3));

    }

    @Test
    public void syoMaukkaastiKasvattaaEdullistenSyontienMaaraa() {
        paate.syoMaukkaasti(400);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiKasvattaaEdullistenSyontienMaaraa() {
        paate.syoEdullisesti(240);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void josKortillaTarpeeksiVeloitetaansummaJaPalautetaanTrue() {
        assertEquals(true, paate.syoEdullisesti(kortti));

    }

    @Test
    public void josKortillaEiTarpeeksiPalautetaanFalse() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(false, paate.syoEdullisesti(kortti));

    }

    @Test
    public void josKortillaEiTarpeeksiPalautetaanFalseKunSyödäänMaukkaasti() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(false, paate.syoMaukkaasti(kortti));
    }
    @Test
    public void eiVoiLadataNegatiivistaRahaa() {
        paate.lataaRahaaKortille(kortti, -100);
        assertEquals(1000, kortti.saldo());
        
    }
    /*
    @Test
    public void rahaaLadattaessaKassanSaldoMuuttuu() {
        paate.lataaRahaaKortille(kortti, 10);
        assertEquals(100010, paate.kassassaRahaa());

    }
    /*
    @Test
    public void rahaaLadattaessaKortinSaldoMuuttuu() {
        paate.lataaRahaaKortille(kortti, 10);
        assertEquals(990, kortti.saldo());

    }
    

    /*
    rahaaLadattaessaKortinSaldoMuuttuu
    käteisosto toimii sekä edullisten että maukkaiden lounaiden osalta

    jos maksu riittävä: kassassa oleva rahamäärä kasvaa lounaan hinnalla ja vaihtorahan suuruus on oikea
    
    jos maksu on riittävä: myytyjen lounaiden määrä kasvaa
    
    jos maksu ei ole riittävä: kassassa oleva rahamäärä ei muutu, kaikki rahat palautetaan vaihtorahana ja myytyjen lounaiden määrässä ei muutosta

seuraavissa testeissä tarvitaan myös Maksukorttia jonka oletetaan toimivan oikein
korttiosto toimii sekä edullisten että maukkaiden lounaiden osalta

    jos kortilla on tarpeeksi rahaa, veloitetaan summa kortilta ja palautetaan true
    jos kortilla on tarpeeksi rahaa, myytyjen lounaiden määrä kasvaa
    jos kortilla ei ole tarpeeksi rahaa, kortin rahamäärä ei muutu, myytyjen lounaiden määrä muuttumaton ja palautetaan false
    kassassa oleva rahamäärä ei muutu kortilla ostettaessa

kortille rahaa ladattaessa kortin saldo muuttuu ja kassassa oleva rahamäärä kasvaa ladatulla summalla
     */
}

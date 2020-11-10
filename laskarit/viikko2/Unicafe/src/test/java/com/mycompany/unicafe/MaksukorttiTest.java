package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());     
    }
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());     
    }
    @Test
    public void saldoVaheneeOikeinJosRahaaOntarpeeksi() {
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());     
    }
    @Test
    public void saldoEimuutuJosRahaaEiOleTarpeeksi() {
        kortti.otaRahaa(100);
        assertEquals("saldo: 0.10", kortti.toString());     
    }
    @Test
    public void metodiPalauttaaTrueJosOnRahaa() {
        
        assertEquals(true, kortti.otaRahaa(10));     
    }
    @Test
    public void metodiPalauttaaFalseJosEiRahaa() {
        
        assertEquals(false, kortti.otaRahaa(20));     
    }
    @Test
    public void tarkastaSaldo() {
        int saldo = kortti.saldo();
        assertEquals(10, kortti.saldo());     
    }
}

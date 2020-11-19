/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import opiskelukello.opiskelukello.Timer;
import opiskelukello.opiskelukello.timerUI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mazaalto
 */
public class timerUITest {
    
    public timerUITest() {
    }
    @Test
    public void vaarallaKomennollaTuleeOikeaTulos() {
        Scanner testauslukija = new Scanner("9");
        Timer kello = new Timer();
        timerUI ui = new timerUI(testauslukija, kello);
        ui.start();
        //onkohan varmasti oikein?
        assertEquals("virheellinen komento.", ui.toString());
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

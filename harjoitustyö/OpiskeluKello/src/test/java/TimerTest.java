
import org.junit.Test;
import studyclock.domain.Timer;
import static org.junit.Assert.assertEquals;
import org.junit.Before;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author mazaalto
 */
public class TimerTest {

    Timer timer;

    @Before
    public void setUp() {
        timer = new Timer();
    }
    @Test
    public void constructorWorksTimeLeft() {
        assertEquals(0, this.timer.getTimeLeft());
    }
    @Test
    public void constructorWorksDisplayMin() {
        assertEquals(0, this.timer.getDisplayMinutes());
    }
    @Test
    public void constructorWorksIsThereTime() {
        assertEquals(true, this.timer.getIsThereTime());
    }
    
    @Test
    public void setTimeLeftWorks() {
        this.timer.setTimeLeft(1);
        assertEquals(1, this.timer.getTimeLeft());
    }
    //pajassa kysyttävä, miten saan testattua mun timeria? 
    
}

//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }


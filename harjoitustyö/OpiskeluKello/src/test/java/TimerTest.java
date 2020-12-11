
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
        this.timer = new Timer(10, "testing");
    }

    @Test
    public void constructorWorksSubject() {
        assertEquals("testing", this.timer.getSubject());
    }

    @Test
    public void constructorWorksTime() {
        assertEquals(10, this.timer.getSeconds());
    }

    @Test
    public void changingTimeWorks() {
        this.timer.setSeconds(14);
        assertEquals(14, this.timer.getSeconds());
    }
}

//    @AfterEach
//    public void tearDown() {
//    }


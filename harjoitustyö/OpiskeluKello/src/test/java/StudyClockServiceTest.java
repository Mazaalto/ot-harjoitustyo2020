/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import studyclock.domain.StudyClockService;

/**
 *
 * @author mazaalto
 */
public class StudyClockServiceTest {

    StudyClockService service;

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.service = new StudyClockService();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, this.service.getHistory().getListSize());
        assertEquals(1500, this.service.getSeconds());
        assertEquals("not set", this.service.getUnknownSubj());

    }

    @Test
    public void integerCheckerWorks() {
        assertEquals(true, this.service.checkIfInt("1"));
    }

    @Test
    public void integerCheckerWorksWithBig() {
        assertEquals(true, this.service.checkIfInt("5000"));
    }

    @Test
    public void integerCheckerWorksWithReallyBig() {
        assertEquals(true, this.service.checkIfInt("50000"));
    }
    @Test
    public void getStringToIntWorks() {
        assertEquals(1, this.service.getStringToInt("1"));
    }
    @Test
    public void getStringToIntWorksWithBigNumbers() {
        assertEquals(1000, this.service.getStringToInt("1000"));
    }
    @Test
    public void getStringToIntWorksWithNegative() {
        assertEquals(-1, this.service.getStringToInt("-1"));
    }
    @Test
    public void getStringToIntWorksWithNegativeBig() {
        assertEquals(-1, this.service.getStringToInt("-10000"));
    }
    @Test
    public void addingTimerWorks() {
        this.service.addTimer(60, "testing");
        assertEquals(1, this.service.getTimerFromHistory().getMinutes());
        assertEquals("testing", this.service.getTimerFromHistory().getSubject());
    }
    

    @After
    public void tearDown() {
    }

}

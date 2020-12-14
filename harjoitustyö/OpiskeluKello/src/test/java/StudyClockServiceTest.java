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
    public void setTypeWorks() {
        this.service.setType("break");
        assertEquals("break", this.service.getType());
    }

    @Test
    public void minusSecondWorks() {
        this.service.setSeconds(1);
        this.service.minusSeconds();
        assertEquals(0, this.service.getSeconds());
    }

    @Test
    public void setTimeWorks() {
        this.service.setSeconds(60);
        assertEquals(60, this.service.getSeconds());
    }

    @Test
    public void setSubjectWorks() {
        this.service.setSeconds(60);
        this.service.setSubject("abc");
        assertEquals("abc", this.service.getUnknownSubj());
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
    public void getGoalWorks() {
        this.service.setGoal(1);
        assertEquals(1, this.service.getGoal());
    }

    @Test
    public void addingTimerWorks() {
        this.service.setSeconds(60);
        this.service.setSubject("testing");
        this.service.addTimer();
        assertEquals(1, this.service.getTimerFromHistory().getMinutes());
        assertEquals("testing", this.service.getTimerFromHistory().getSubject());
    }

    @After
    public void tearDown() {
    }

}

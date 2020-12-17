/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import studyclock.domain.StudyHistory;
import studyclock.domain.Timer;

/**
 *
 * @author mazaalto
 */
public class StudyHistoryTest {

    private StudyHistory subjectTimestest;

    @Before
    public void setUp() {
        this.subjectTimestest = new StudyHistory();
    }

    // Check that size returns 0 for new StudyHistory Maps
    @Test
    public void testConstructor() {
        assertEquals(0, this.subjectTimestest.getListSize());
    }
    @Test
    public void testGetList() {
        ArrayList<Timer> test = this.subjectTimestest.getList();
        assertEquals(0, test.size());
    }

    @Test
    public void testGetListSizeAfterAdd() {
        this.subjectTimestest.addTimerToList(0, "new", "Tue Dec 15 13:09:18 EET 2020");
        assertEquals(1, this.subjectTimestest.getListSize());
    }
    @Test
    public void testToGetNull() {
        assertEquals(null, this.subjectTimestest.getTimer());
    }
    @Test
    public void testNotNull() {
        this.subjectTimestest.addTimerToList(0, "new", "Tue Dec 15 13:09:18 EET 2020");
        assertEquals("new", this.subjectTimestest.getTimer().getSubject());
        assertEquals(0, this.subjectTimestest.getTimer().getMinutes());
        
    }
    
    

    @AfterClass
    public static void tearDownClass() {
    }

}

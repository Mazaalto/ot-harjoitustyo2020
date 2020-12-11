/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    public void testGetListSizeAfterAdd() {
        Timer timeradd = new Timer(0, "new");
        this.subjectTimestest.addTimerToList(timeradd);
        assertEquals(1, this.subjectTimestest.getListSize());
    }

    @AfterClass
    public static void tearDownClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

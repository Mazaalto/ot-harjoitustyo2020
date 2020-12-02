/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import studyclock.domain.StudyHistory;


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
    public void testSizeForNewStudyHistoryMap() {
        assertEquals(0, this.subjectTimestest.getSubjectTimes().size());
    }
    
    //Check that a new Study History Map returns true for isEmpty
    @Test
    public void constructorWorks(){
       assertTrue(this.subjectTimestest.getSubjectTimes().isEmpty());
        
    }
    //test if adding a subject make isEmpty return "false"
    @Test
    public void testAddSubjectNotEmpty() {
        this.subjectTimestest.addStudyArea("testi", 25);
        assertFalse(this.subjectTimestest.getSubjectTimes().isEmpty());
    }
    // Testing if Map increases as study times are added
    @Test
    public void testSizeGrowsWhenAddingSubjects() {
        this.subjectTimestest.addStudyArea("java", 1);
        assertEquals(1, this.subjectTimestest.getSubjectTimes().size());
        
        this.subjectTimestest.addStudyArea("python", 1);
        assertEquals(2, this.subjectTimestest.getSubjectTimes().size());
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

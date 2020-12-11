/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import studyclock.domain.StudyClockService;
import studyclock.domain.StudyHistory;

/**
 *
 * @author mazaalto
 */
public class StudyClockServiceTest {
    StudyClockService service;
    
    public StudyClockServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.service = new StudyClockService();
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
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

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
    @Test
    public void constructorWorks(){
       // asserThat(map, this.timer.getTimeLeft());
       //tsekkaa onko map olemassa
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import java.util.HashMap;
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

//    @Test
//    public void addWeekWorks() {
//        this.service.addWeek(1, 5);
//        int value = this.service.getWeek().get(1);
//        assertEquals(5, value);
//    }
//
//    @Test
//    public void addWeekWorksAfterWeekDayIsAlready() {
//        this.service.addWeek(1, 5);
//        this.service.addWeek(1, 5);
//        int value = this.service.getWeek().get(1);
//        assertEquals(10, value);
//    }

    @Test
    public void getTodayWorks() {
        Date date = new Date();
        String dateAsString = date.toString();
        String[] split = dateAsString.split(" ");
        //date is the plit[2]
        int day = Integer.valueOf(split[2]);
        assertEquals(day, this.service.getToday());
    }

    @Test
    public void addTodaysPieChartWorks() {
        this.service.addTodaysPieChart("test", 3);
        int time = (int) this.service.getTodaysPieChart().get("test");
        assertEquals(3, time);
    }

    @Test
    public void addTodaysPieChartWorksAfterAdd() {
        this.service.addTodaysPieChart("test", 3);
        this.service.addTodaysPieChart("a", 3);
        int time = (int) this.service.getTodaysPieChart().get("test");
        assertEquals(3, time);
    }

    @Test
    public void addTodaysPieChartWorksMore() {
        this.service.addTodaysPieChart("test", 3);
        this.service.addTodaysPieChart("test", 3);
        assertEquals(6, this.service.getTodaysPieChart().get("test"));
    }

    @Test
    public void getPercentWorks() {
        int value = this.service.getPercentage(1);
        assertEquals(50, value);

    }

    @Test
    public void getPercentTrueWorks() {
        this.service.addTodaysPieChart("test", 1);
        int value = this.service.getPercentageTrue("test");
        assertEquals(100, value);

    }

    @Test
    public void getPercentTrueWorks2() {
        this.service.addTodaysPieChart("test", 1);
        this.service.addTodaysPieChart("abc", 1);
        int value = this.service.getPercentageTrue("test");
        assertEquals(50, value);

    }

    @Test
    public void getPercentTrueWorks3() {
        this.service.addTodaysPieChart("test", 1);
        this.service.addTodaysPieChart("abc", 2);
        int value = this.service.getPercentageTrue("test");
        assertEquals(33, value);

    }

    @Test
    public void percentagesWork() {
        this.service.addTodaysPieChart("test", 3);
        this.service.addTodaysPieChart("abc", 3);
        HashMap<String, Integer> calculatePercentages = this.service.calculatePercentages();
        int percent = calculatePercentages.get("test");
        assertEquals(50, percent);
    }

    @Test
    public void percentagesWork2() {
        this.service.addTodaysPieChart("test", 6);
        this.service.addTodaysPieChart("abc", 3);
        HashMap<String, Integer> calculatePercentages = this.service.calculatePercentages();
        int percent = calculatePercentages.get("test");
        assertEquals(66, percent);
    }

    @After
    public void tearDown() {
    }

}

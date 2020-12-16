/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyclock.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * This class has all the logic that is operated in the UI (timerUIJavaFX)
 *
 * @author mazaalto
 */
public class StudyClockService {

    private StudyHistory history;
    private HashMap today;
    private int seconds;
    private String unknownSubj;
    private String type;
    private int goalHours;
    private HashMap week;

    public StudyClockService() {
        this.history = new StudyHistory();
        this.today = new HashMap<String, Integer>();
        this.unknownSubj = "not set";
        this.seconds = 1500;
        this.type = "study";
        this.goalHours = 4;
        this.week = new HashMap<Integer, Integer>();

    }

    public int getGoal() {
        return goalHours;
    }

    public void setGoal(int goal) {
        this.goalHours = goal;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public StudyHistory getHistory() {
        return this.history;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getUnknownSubj() {
        return unknownSubj;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setSubject(String unknownSubj) {
        this.unknownSubj = unknownSubj;
    }

    //Here we can check if String can be converted to integer
    public boolean checkIfInt(String something) {
        Pattern intPattern = Pattern.compile("\\d+");
        if (something == null) {
            return false;
        }
        return intPattern.matcher(something).matches();

    }

    //gets string as a parameter, return value in int if possible, else -1
    public int getStringToInt(String fromUI) {
        int valueInMinutes = 0;
        if (checkIfInt(fromUI)) {
            valueInMinutes = Integer.parseInt(fromUI);
            return valueInMinutes;
        }
        return -1;
    }

    //seconds are changed to minutes when they are saved to studyhistory, date is stored as a string
    //Tue Dec 15 13:09:18 EET 2020
    public void addTimer() {
        int minutes = this.seconds / 60;
        Date date = new Date();
        String dateAsString = date.toString();
        int day = getToday();
        this.history.addTimerToList(minutes, this.unknownSubj, dateAsString);
//        addWeek(day, minutes);
        addTodaysPieChart(this.unknownSubj, minutes);

    }

    public HashMap getTodaysPieChart() {
        return this.today;
    }

    //Here we add todays HashMap that is the base for the PieChart
    public void addTodaysPieChart(String subj, int minutes) {
        if (!this.today.containsKey(subj)) {
            this.today.put(subj, minutes);

        } else {
            int value = (int) this.today.get(subj);
            value += minutes;
            this.today.put(subj, value);
        }

    }

    //Here we calculate the percentages of the study areas and store it in Map
    public HashMap<String, Integer> calculatePercentages() {
        HashMap<String, Integer> percentages = new HashMap<>();
        for (Object key : this.today.keySet()) {
            int percent;
            percent = getPercentageTrue((String) key);
            percentages.put((String) key, percent);
        }
        return percentages;

    }

    public int getPercentage(int val) {
        double value = 1;
        value /= 2;
        value *= 100;
        return (int) value;
    }

    public int getPercentageTrue(String key) {
        int nominator = (int) this.today.get(key);
        int denominator = this.sumOfHashMap();

        if (nominator != 0 && denominator != 0) {
            double value = nominator;
            value /= denominator;
            value *= 100;
            return (int) value;

        }
        return 100;
    }

    public Integer sumOfHashMap() {
        int sum = 0;
        for (Object value : this.today.values()) {
            sum += (int) value;
        }
        return sum;
    }

//    //Here we add time for the correct week
//    public void addWeek(int day, int time) {
//        if (this.week.containsKey(day)) {
//            int timeTotal = (int) this.week.get(day);
//            timeTotal += time;
//            this.week.put(day, timeTotal);
//        } else {
//            this.week.put(day, time);
//        }
//    }

//    public HashMap<Integer, Integer> getWeek() {
//        return this.week;
//
//    }

    public Timer getTimerFromHistory() {
        return this.history.getTimer();

    }

    public void minusSeconds() {
        this.seconds = this.seconds - 1;
    }

    public int getToday() {
        Date date = new Date();
        String dateAsString = date.toString();
        String[] split = dateAsString.split(" ");
        //date is the plit[2]
        int day = Integer.valueOf(split[2]);
        return day;

    }

}

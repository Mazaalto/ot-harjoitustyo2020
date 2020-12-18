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

    /**
     * This method starts the Study clock and stores all the values needed
     *
     * @author mazaalto
     */
    public StudyClockService() {
        this.history = new StudyHistory();
        this.today = new HashMap<String, Integer>();
        this.unknownSubj = "not set";
        this.seconds = 1500;
        this.type = "study";
        this.goalHours = 4;
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

    /**
     * This method checks if the parameter String is convertable to int
     *
     * @param something is the String we want to convert
     * @return true or false if convertable to int
     * @author mazaalto
     */
    public boolean checkIfInt(String something) {
        Pattern intPattern = Pattern.compile("\\d+");
        return intPattern.matcher(something).matches();
    }

    /**
     * This method gets string as a parameter, return value in integer if
     * possible, else -1
     *
     * @param fromUI is the String we want to convert
     * @return integer value or -1
     * @author mazaalto
     */
    public int getStringToInt(String fromUI) {
        int valueInMinutes = 0;
        if (checkIfInt(fromUI)) {
            valueInMinutes = Integer.parseInt(fromUI);
            return valueInMinutes;
        }
        return -1;
    }

    /**
     * This method stores the current timer and also updates the PieChart
     * seconds are changed to minutes when they are saved to studyhistory, date
     * is stored as a string Tue Dec 15 13:09:18 EET 2020
     *
     * @author mazaalto
     */
    public void addTimer() {
        int minutes = this.seconds / 60;
        Date date = new Date();
        String dateAsString = date.toString();
        int day = getToday();
        this.history.addTimerToList(minutes, this.unknownSubj, dateAsString);
        addTodaysPieChart(this.unknownSubj, minutes);

    }

    public HashMap getTodaysPieChart() {
        return this.today;
    }

    /**
     * This method adds data to todays Piechart (that is stored as Hashmap)
     *
     * @param subj is the studied subject
     * @param minutes is the studied time
     * @author mazaalto
     */
    public void addTodaysPieChart(String subj, int minutes) {
        if (!this.today.containsKey(subj)) {
            this.today.put(subj, minutes);

        } else {
            int value = (int) this.today.get(subj);
            value += minutes;
            this.today.put(subj, value);
        }

    }

    /**
     * This method calculates the percentages from a HashMap to be shown as a
     * Piechart in UI
     *
     *
     * @return HashMap<String, Integer> that has all the todays subjects and
     * their percentages
     * @author mazaalto
     */
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

    /**
     * This method calculates the percentage of a subject today
     *
     * @param key is the subject we want to calculate
     *
     * @return HashMap<String, Integer> that has all the todays subjects and
     * their percentages or 0 if there is not subject
     * @author mazaalto
     */
    public int getPercentageTrue(String key) {
        if (this.today.containsKey(key)) {
            int nominator = (int) this.today.get(key);
            int denominator = this.sumOfHashMap();

            if (nominator != 0 && denominator != 0) {
                double value = nominator;
                value /= denominator;
                value *= 100;
                return (int) value;

            }

        }
        return 0;
    }

    /**
     * This method calculates the sum of todays HashMap to calculate the
     * percentages
     *
     * @return sum that is the sum of all the studied times today
     * @author mazaalto
     */
    public Integer sumOfHashMap() {
        int sum = 0;
        for (Object value : this.today.values()) {
            sum += (int) value;
        }
        return sum;
    }

    public Timer getTimerFromHistory() {
        return this.history.getTimer();

    }

    /**
     * This method updates the seconds
     *
     * @author mazaalto
     */
    public void minusSeconds() {
        this.seconds = this.seconds - 1;
    }

    /**
     * This method returns the day of today (as a number)
     *
     * @return day the integer value of today
     * @author mazaalto
     */
    public int getToday() {
        Date date = new Date();
        String dateAsString = date.toString();
        String[] split = dateAsString.split(" ");
        //date is the plit[2]
        int day = Integer.valueOf(split[2]);
        return day;

    }

}

package studyclock.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
    private String file;

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
        this.file = "memory.txt";
        boolean readingHappened = this.loadFile();

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
        if (something == null) {
            return false;
        }
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
        int nominator = (int) this.today.get(key);
        int denominator = this.sumOfHashMap();

        if (nominator != 0 && denominator != 0) {
            double value = nominator;
            value /= denominator;
            value *= 100;
            return (int) value;

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

    /**
     * This method loads the history data from file
     *
     * @return true if the loading was successful
     * @author mazaalto
     */
    public boolean loadFile() {
        try {
            Scanner reader = new Scanner(new File(file));
            loadOldTimers(reader);
            reader.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * This method loads the timers to StudyHistory
     *
     * @author mazaalto
     */
    //timers are stored as: int minutes;String subject;String date
    private void loadOldTimers(Scanner reader) {
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] partsOfTheLine = line.split(";");
            int minutes = Integer.parseInt(partsOfTheLine[0]);
            this.history.addTimerToList(minutes, partsOfTheLine[1], partsOfTheLine[2]);
        }

    }

    /**
     * This method saves the history data to file
     *
     * @return true if the loading was successful
     * @author mazaalto
     */
    public boolean saveFile() {
        try {
            PrintWriter writer = new PrintWriter(new File(file));
            saveBeforeExit(writer);
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * This method saves the timers to writer
     *
     * @return true if the loading was successful
     * @author mazaalto
     */
    private void saveBeforeExit(PrintWriter writer) throws IOException {
        ArrayList<Timer> timers = this.history.getList();

        for (int i = 0; i < timers.size(); i++) {
            String timerAsString = timers.get(i).timerToString();
            writer.println(timerAsString);
        }

    }

}

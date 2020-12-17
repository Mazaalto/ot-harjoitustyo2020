
import org.junit.Test;
import studyclock.domain.Timer;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 *
 * @author mazaalto
 */
public class TimerTest {

    Timer timer;

    @Before
    public void setUp() {
        this.timer = new Timer(10, "testing", "Tue Dec 15 13:09:18 EET 2020");
    }

    @Test
    public void constructorWorksSubject() {
        assertEquals("testing", this.timer.getSubject());
    }

    @Test
    public void constructorWorksDate() {
        assertEquals("Tue Dec 15 13:09:18 EET 2020", this.timer.getDate());
    }

    @Test
    public void setDateWorks() {
        this.timer.setDate("Tue Dec 16 13:09:18 EET 2020");
        assertEquals("Tue Dec 16 13:09:18 EET 2020", this.timer.getDate());
    }

    @Test
    public void constructorWorksTime() {
        assertEquals(10, this.timer.getMinutes());
    }

    @Test
    public void changingTimeWorks() {
        this.timer.setMinutes(14);
        assertEquals(14, this.timer.getMinutes());
    }

    @Test
    public void changingSubjectWorks() {
        this.timer.setSubject("moretesting");
        assertEquals("moretesting", this.timer.getSubject());

    }

    @Test
    public void timerToStringWorks() {
        String test = this.timer.timerToString();
        assertEquals("10;testing;Tue Dec 15 13:09:18 EET 2020", test);

    }

}

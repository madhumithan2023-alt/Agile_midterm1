import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testNoConflict() {
        App app = new App();

        Meeting m1 = new Meeting("M1",
                LocalDateTime.of(2026, 4, 8, 10, 0),
                LocalDateTime.of(2026, 4, 8, 11, 0));

        Meeting m2 = new Meeting("M2",
                LocalDateTime.of(2026, 4, 8, 11, 0),
                LocalDateTime.of(2026, 4, 8, 12, 0));

        assertTrue(app.scheduleMeeting(m1));
        assertTrue(app.scheduleMeeting(m2));
    }

    @Test
    public void testConflict() {
        App app = new App();

        Meeting m1 = new Meeting("M1",
                LocalDateTime.of(2026, 4, 8, 10, 0),
                LocalDateTime.of(2026, 4, 8, 11, 0));

        Meeting m2 = new Meeting("M2",
                LocalDateTime.of(2026, 4, 8, 10, 30),
                LocalDateTime.of(2026, 4, 8, 11, 30));

        app.scheduleMeeting(m1);
        assertFalse(app.scheduleMeeting(m2));
    }

    @Test
    public void testInvalidTime() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Meeting("Invalid",
                    LocalDateTime.of(2026, 4, 8, 12, 0),
                    LocalDateTime.of(2026, 4, 8, 11, 0));
        });
    }

    @Test
    public void testExactOverlap() {
        App app = new App();

        Meeting m1 = new Meeting("M1",
                LocalDateTime.of(2026, 4, 8, 10, 0),
                LocalDateTime.of(2026, 4, 8, 11, 0));

        Meeting m2 = new Meeting("M2",
                LocalDateTime.of(2026, 4, 8, 10, 0),
                LocalDateTime.of(2026, 4, 8, 11, 0));

        app.scheduleMeeting(m1);
        assertFalse(app.scheduleMeeting(m2));
    }
}
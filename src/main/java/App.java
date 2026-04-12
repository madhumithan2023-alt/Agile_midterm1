import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Meeting {
    String title;
    LocalDateTime start;
    LocalDateTime end;

    public Meeting(String title, LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end) || start.isEqual(end)) {
            throw new IllegalArgumentException("Invalid time range");
        }
        this.title = title;
        this.start = start;
        this.end = end;
    }
}

public class App {

    private List<Meeting> meetings = new ArrayList<>();

    // Schedule meeting
    public boolean scheduleMeeting(Meeting newMeeting) {
        for (Meeting m : meetings) {
            if (isConflict(m, newMeeting)) {
                return false;
            }
        }
        meetings.add(newMeeting);
        return true;
    }

    // Conflict detection
    public boolean isConflict(Meeting m1, Meeting m2) {
        return m1.start.isBefore(m2.end) && m2.start.isBefore(m1.end);
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
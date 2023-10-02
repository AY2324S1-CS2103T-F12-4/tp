package seedu.address.model.meeting;

import java.time.LocalDateTime;
import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

public class MeetingTime {
    public static final String MESSAGE_CONSTRAINTS = "MeetingTimes should be in LocalDateTime and start cannot be after end";
    private final LocalDateTime start;
    private final LocalDateTime end;
    public MeetingTime(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public static boolean isValidMeetingTime(LocalDateTime start, LocalDateTime end) {
        return start.isAfter(end) ? false : true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MeetingTime)) {
            return false;
        }

        MeetingTime otherMeetingTime = (MeetingTime) other;
        return start.equals(otherMeetingTime.start)
                && end.equals(otherMeetingTime.end);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("start", start)
                .add("end", end)
                .toString();
    }
}

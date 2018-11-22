package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Attendees {

    private static final String SPLITTER = ",";
    private List<Attendee> attendees;

    private Attendees(String[] names) {
        attendees = Arrays.asList(names).stream()
                .map(Attendee::create)
                .collect(Collectors.toList());
    }

    public static Attendees create(String names) {
        return new Attendees(names.split(SPLITTER));
    }

    public int size() {
        return attendees.size();
    }

    @Override
    public String toString() {
        return attendees.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}

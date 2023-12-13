package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {

    public static final String NAME_SPLITTER = ",";

    private List<Participant> values = new ArrayList<>();

    public Participants(List<Participant> values) {
        this.values = values;
    }

    public static Participants from(String values) {
        List<Participant> newParticipants = new ArrayList<>();
        String[] splitValues = values.split(NAME_SPLITTER);
        for (String value : splitValues) {
            newParticipants.add(new Participant(value));
        }
        return new Participants(newParticipants);
    }

    public int size() {
        return this.values.size();
    }

    public Participant getParticipant(int index) {
        return values.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        values.stream()
                .forEach(value -> sb.append(value.toString() + " "));
        return sb.toString();
    }
}

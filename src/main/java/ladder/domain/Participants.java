package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {

    private static final String PARTICIPANT_FORMAT = "%-6s";

    private List<Participant> values = new ArrayList<>();

    public Participants(List<Participant> values) {
        this.values = values;
    }

    public static Participants from(String[] names) {
        List<Participant> newParticipants = new ArrayList<>();
        for (String name : names) {
            newParticipants.add(new Participant(name));
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
        for (Participant value : values) {
            sb.append(String.format(PARTICIPANT_FORMAT, value.toString()));
        }
        return sb.toString();
    }
}

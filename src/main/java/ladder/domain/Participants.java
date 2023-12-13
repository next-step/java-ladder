package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {


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
        values.stream()
                .forEach(value -> sb.append(value.toString() + " "));
        return sb.toString();
    }
}

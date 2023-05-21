package ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Participants {
    List<String> Participants = new ArrayList<>();

    public Participants(String[] names) {
        this.Participants = new ArrayList<>(Arrays.asList(names));
    }

    public int count() {
        return this.Participants.size();
    }

    public List<String> getParticipants() {
        return this.Participants;
    }
}

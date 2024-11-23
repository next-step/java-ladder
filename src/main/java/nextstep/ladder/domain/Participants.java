package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Participants {
    private static final String SPLIT_COMMA = ",";
    private final List<Participant> participants = new ArrayList<>();

    public Participants(String names) {
        fromNames(names);
    }

    public Participants(final List<Participant> participants) {
        this.participants.addAll(participants);
    }

    private void fromNames(String names) {
        String[] namesArray = names.split(SPLIT_COMMA);
        Arrays.stream(namesArray).forEach((name) -> {
            participants.add(new Participant(name));
        });
    }

    public int size(){
        return participants.size();
    }

    public List<Participant> getParticipants(){
        return participants;
    }

}

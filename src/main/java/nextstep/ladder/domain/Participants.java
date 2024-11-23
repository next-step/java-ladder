package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Participants {
    private static final String SPLIT_COMMA = ",";
    private final List<Participant> participants;

    public Participants(String names) {
        this(fromNames(names));
    }

    public Participants(List<Participant> participants) {
        this.participants = new ArrayList<>(participants);
    }

    private static List<Participant> fromNames(String names) {
        List<Participant> participants = new ArrayList<>();
        String[] namesArray = names.split(SPLIT_COMMA);
        Arrays.stream(namesArray).forEach((name) -> {
            participants.add(new Participant(name));
        });
        return participants;
    }

    public int size(){
        return participants.size();
    }

    public List<Participant> getParticipants(){
        return participants;
    }

}

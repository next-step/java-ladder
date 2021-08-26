package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private List<Participant> participants;

    private Participants(String... names){
        this.participants = Arrays.stream(names)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public static Participants of(String... names){
        return new Participants(names);
    }

    public int size() {
        return this.participants.size();
    }
}

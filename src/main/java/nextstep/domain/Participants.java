package nextstep.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Participants implements Iterable<Participant>{

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants participate(String[] participants) {
        List<Participant> collect = Arrays.stream(participants)
                .map(Participant::new)
                .collect(Collectors.toList());

        return new Participants(collect);
    }

    @Override
    public Iterator<Participant> iterator() {
        return participants.iterator();
    }
}

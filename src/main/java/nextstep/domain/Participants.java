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

    public static Participants participate(String... participants) {
        List<Participant> collect = Arrays.stream(participants)
                .map(Participant::of)
                .collect(Collectors.toList());

        return new Participants(collect);
    }

    public int count() {
        return this.participants.size();
    }

    @Override
    public Iterator<Participant> iterator() {
        return participants.iterator();
    }

    public Record go(Ladder ladder, String... gameResult) {

        Record record = new Record();

        for (int i = 0; i < participants.size(); i++) {
            int destination = ladder.climb(i);
            record.add(participants.get(i), gameResult[destination]);
        }

        return record;
    }
}

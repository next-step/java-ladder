package nextstep.laddergame.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public record Participants(List<Participant> participantList) {

    public Participants(String participantList) {
        this(Arrays.stream(participantList.split(",")).map(String::trim).toArray(String[]::new));
    }

    public Participants(String... participantList) {
        this(IntStream.range(0, participantList.length).mapToObj(i -> new Participant(participantList[i], i)).toList());
    }

    public Participants(Participant... participantList) {
        this(Arrays.stream(participantList).toList());
    }

    public int size() {
        return participantList().size();
    }

}

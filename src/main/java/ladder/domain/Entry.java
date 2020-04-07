package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Entry {
    private final List<Participant> participants;

    private Entry(List<Participant> participants) {
        if (participants.isEmpty()) {
            throw new IllegalArgumentException("참가자는 1명 이상있어야 한다");
        }
        this.participants = Collections.unmodifiableList(participants);
    }

    public static Entry of(String[] entryNames) {
        List<Participant> participants = Stream.of(entryNames)
                .map(Participant::name)
                .collect(Collectors.toList());
        return new Entry(participants);
    }

    public List<String> getParticipantNames() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public int countOfParticipant() {
        return participants.size();
    }
}

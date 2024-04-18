package ladder.domain;

import java.util.Iterator;
import java.util.List;

public class Participants implements Iterable<Participant> {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public Participant findParticipant(String name) {
        return participants.stream().filter(p -> p.isSameName(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가자가 아닙니다."));
    }

    public boolean isParticipant(String name) {
        return participants.stream().anyMatch(p -> p.isSameName(name));
    }

    @Override
    public Iterator<Participant> iterator() {
        return participants.iterator();
    }
}

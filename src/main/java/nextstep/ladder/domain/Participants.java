package nextstep.ladder.domain;

import java.util.*;

public class Participants {
    private final List<Participant> participants;

    public Participants(String[] participants) {
        this.participants = new ArrayList<>();
        for (String participant : participants) {
            this.participants.add(new Participant(participant));
        }
    }

    public int numberOfParticipants() {
        return this.participants.size();
    }

    public List<Participant> value() {
        return Collections.unmodifiableList(participants);
    }

    public String findByName(String name) {
        Optional<Participant> target = this.participants.stream()
                .filter(participant -> Objects.equals(participant.name(), name))
                .findFirst();

        if (target.isPresent()) {
            return target.get().ladderResult();
        }

        return "NULL";
    }
}

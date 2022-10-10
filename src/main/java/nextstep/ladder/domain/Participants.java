package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Participant getParticipant(int index) {
        return participants.get(index);
    }

    public void match(int indexOfParticipant, LadderResult ladderResult) {
        participants.get(indexOfParticipant).matchResult(ladderResult);
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

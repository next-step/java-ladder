package nextstep.ladder.domain.participant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Stream<Participant> stream() {
        return participants.stream();
    }

    public int size() {
        return participants.size();
    }

    public Participant get(int index) {
        return participants.get(index);
    }

    public Participants findByParticipantName(Name name) {
        String participantName = name.getValue();

        if(participantName.equals("all"))
            return this;

        Participant findByName = participants.stream()
                .filter(participant -> participant.getName().equals(participantName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return new Participants(Arrays.asList(findByName));
    }
}

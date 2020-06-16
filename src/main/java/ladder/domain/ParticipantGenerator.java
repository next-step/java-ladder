package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantGenerator {

    private List<String> participantNames;

    public ParticipantGenerator(List<String> participantNames) {
        this.participantNames = participantNames;
    }

    public List<Participant> getParticipants() {
        return participantNames.stream()
                .map(name -> new Participant(name))
                .collect(Collectors.toList());
    }
}

package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    private List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(List<String> participants) {
        return new Participants(toParticipant(participants));
    }

    private static List<Participant> toParticipant(List<String> participants) {
        return IntStream.range(0, participants.size())
                .mapToObj(i -> Participant.of(Name.of(participants.get(i)), ParticipantPosition.of(i)))
                .collect(Collectors.toList());
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}

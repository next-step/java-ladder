package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    public static final String ALL_PARTICIPANTS = "all";
    public static final String NO_MATCHING_PARTICIPANT = "해당 참가자는 존재하지 않습니다.";

    private List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(List<String> participants) {
        List<Participant> pluralParticipants = IntStream.range(0, participants.size())
                .mapToObj(index -> Participant.of(participants.get(index), index))
                .collect(Collectors.toList());

        return new Participants(pluralParticipants);
    }

    public int getNumberOfParticipants() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public List<Participant> findParticipants(String name) {
        if (name.equals(ALL_PARTICIPANTS)) {
            return participants;
        }

        List<Participant> result = List.of(findParticipant(name));
        return result;
    }

    private Participant findParticipant(String name) {
        return participants.stream()
                .filter(participant -> participant.isEqualParticipant(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_MATCHING_PARTICIPANT));
    }

}

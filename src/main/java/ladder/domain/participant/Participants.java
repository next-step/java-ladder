package ladder.domain.participant;

import ladder.exception.InsufficientParticipantsCountException;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final int MIN_PARTICIPANTS_COUNT = 2;
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        if (participants.size() < MIN_PARTICIPANTS_COUNT) {
            throw new InsufficientParticipantsCountException();
        }
        this.participants = participants;
    }

    public static Participants of(List<String> people) {
        List<Participant> persons = people.stream()
                .map(userName -> new Participant(userName))
                .collect(Collectors.toList());
        return new Participants(persons);
    }

    public int countParticipant() {
        return participants.size();
    }

    public List<String> getParticipantNames() {
        return participants.stream()
                        .map(Participant::getUserName)
                        .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return participants.toString();
    }

}

package ladder.domain.participant;

import ladder.exception.InsufficientParticipantsCountException;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Participant> persons = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            persons.add(new Participant(people.get(i), i));
        }
        return new Participants(persons);
    }

    public int countParticipant() {
        return participants.size();
    }

    public Participant getParticipant(int index){
        return participants.get(index);
    }

    public List<String> getParticipantNames() {
        return participants.stream()
                        .map(Participant::getUserName)
                        .collect(Collectors.toList());
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public String toString() {
        return participants.toString();
    }

}

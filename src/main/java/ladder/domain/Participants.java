package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private final static String DESIRE_ALL = "all";

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public Participants(Participant... participants) {
        this(Arrays.asList(participants));
    }

    public int size(){
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public Participants getDesireParticipants(String desireParticipantName){
        if(desireParticipantName.equals(DESIRE_ALL)) {
            return new Participants(getParticipants());
        }
        List<Participant> result = participants.stream()
                .filter(participant -> participant.isSameName(desireParticipantName))
                .collect(Collectors.toList());
        if(result.isEmpty()) throw new IllegalArgumentException("cannot find a participant with the name " + desireParticipantName);
        return new Participants(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }
}

package ladder;

import java.util.*;
import java.util.stream.Collectors;

public class Participant {

    private final String participant;

    public Participant(String participant) {
        this.participant = participant;
        validForParticipant();
    }

    private void validForParticipant() {
        if (participant.isBlank()) {
            throw new IllegalArgumentException("참가자가 입력되지 않았습니다..");
        }

        if (participant.length() > 5) {
            throw new IllegalArgumentException("참가자 이름은 5자 이하이어야 합니다.");
        }
    }

    public static List<Participant> splitParticipant(String participant) {

        Set<String> uniqueNames = new HashSet<>();

        List<Participant> participants = Arrays.stream(participant.trim().split(","))
                                            .filter(name -> {
                                                if(!uniqueNames.add(name)) {
                                                    throw new IllegalArgumentException("중복된 참가자 이름이 있습니다: " + name);
                                                }
                                                return true;
                                            })
                                            .map(Participant::new)
                                            .collect(Collectors.toList());

        if (participants.isEmpty()) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }

        return participants;
    }

    public String getParticipant() {
        return participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(participant);
    }

    @Override
    public String toString() {
        return participant;
    }
}


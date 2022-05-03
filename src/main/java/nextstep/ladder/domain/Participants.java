package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Participants {

    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants createParticipants(List<String> names) {
        validateDuplicate(names);
        List<Participant> participants = names.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participants);
    }

    private static void validateDuplicate(List<String> names) {
        HashSet<String> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException("participants can't have same names");
        }
    }

    public void swapWithNext(int index) {
        Collections.swap(participants, index, index + 1);
    }

    public int size() {
        return participants.size();
    }

    public Participant get(int index) {
        return participants.get(index);
    }

    public List<Participant> getParticipants() {
        return new ArrayList<>(participants);
    }

}

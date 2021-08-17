package step4.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    private final List<Participant> participants;

    private Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(List<String> names) {
        return new Participants(names.stream()
            .map(Participant::of)
            .collect(Collectors.toList()));
    }

    public List<String> inline() {
        return participants.stream()
            .map(Participant::nameOf)
            .collect(Collectors.toList());
    }

    public int findPositionOf(String name) {
        if (nameIsNotInTheList(name)) {
            throw new RuntimeException("해당 이름이 참가자중에 없습니다.");
        }

        return participants.indexOf(Participant.of(name));
    }

    private boolean nameIsNotInTheList(String name) {
        return participants.stream()
            .noneMatch(participant -> participant.nameOf().equals(name));
    }

    public int size() {
        return participants.size();
    }
}


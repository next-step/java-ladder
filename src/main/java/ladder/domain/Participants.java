package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> names;

    public Participants(List<Participant> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("참여자 이름 목록은 비어 있을 수 없습니다.");
        }
        this.names = List.copyOf(names);
    }

    public static Participants of(String input) {
        List<Participant> participants = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(participants);
    }
}

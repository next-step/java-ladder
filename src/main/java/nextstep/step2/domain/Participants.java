package nextstep.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private static final String NAME_DELIMITER = ",";
    private static final int MINIMUM_USER_COUNT = 0;

    private final List<Participant> participants;

    public Participants(String name) {
        this(Arrays.stream(name.split(NAME_DELIMITER))
                .map(Participant::new)
                .collect(Collectors.toList())
        );
    }

    public Participants(List<Participant> participants) {
        validate(participants.size());

        this.participants = participants;
    }

    private void validate(int count) {
        if (count <= MINIMUM_USER_COUNT) {
            throw new IllegalArgumentException("사다리 게임의 참여자가 존재하지 않습니다.");
        }
    }

    public int count() {
        return participants.size();
    }

    public String toParticipants() {
        return participants.stream()
                .map(Participant::toNameString)
                .collect(Collectors.joining(" "));
    }
}
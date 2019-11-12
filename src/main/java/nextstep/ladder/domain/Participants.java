package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Participants implements ImmutableList<Participant> {

    private static int MIN_COUNT = 2;
    private static final String EMPTY_ERROR_MSG = "사다리 게임은 최소 2명부터 시작할 수 있습니다.";

    private final List<Participant> participants;

    public Participants(List<String> names) {
        assertNames(names);
        this.participants = createParticipants(names);
    }

    private List<Participant> createParticipants(List<String> names) {
        return names
                .stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return participants.size();
    }

    private void assertNames(List<String> names) {
        if (names.size() < MIN_COUNT) {
            throw new IllegalArgumentException(EMPTY_ERROR_MSG);
        }
    }

    @Override
    public List<Participant> get() {
        return Collections.unmodifiableList(participants);
    }
}

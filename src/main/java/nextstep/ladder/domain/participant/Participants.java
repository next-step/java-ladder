package nextstep.ladder.domain.participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {

    private static int MIN_COUNT = 2;
    private static final String ALL_PARTICIPANT = "all";
    private static final List<String> reservedNames = new ArrayList<>(Arrays.asList(ALL_PARTICIPANT));

    private static final String EMPTY_ERROR_MSG = "사다리 게임은 최소 2명부터 시작할 수 있습니다.";
    private static final String INVALID_PARTICIPANT_ERROR_MSG = "일치하는 사용자가 없습니다.";
    private static final String RESERVED_NAME_ERROR_MSG = "%s 는 사용할 수 없는 이름입니다.";

    private final List<Participant> participants;

    public Participants(List<String> names) {
        assertReservedName(names);
        assertNames(names);
        this.participants = createParticipants(names);
    }

    private void assertReservedName(List<String> names) {
        names.stream()
                .filter(targetName -> !reservedNames.contains(targetName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RESERVED_NAME_ERROR_MSG));
    }

    private List<Participant> createParticipants(List<String> names) {
        return IntStream
                .range(0, names.size())
                .mapToObj(order -> new Participant(names.get(order), order))
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

    public List<Participant> getValue() {
        return Collections.unmodifiableList(participants);
    }

    public List<Participant> match(String targetName) {
        if (ALL_PARTICIPANT.equals(targetName)) {
            return Collections.unmodifiableList(participants);
        }

        Participant candidate = participants
                .stream()
                .filter(participant -> participant.getName().equals(targetName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PARTICIPANT_ERROR_MSG));

        return Collections.singletonList(candidate);
    }
}

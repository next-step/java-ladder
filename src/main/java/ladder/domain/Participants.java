package ladder.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {
    private static final int PARTICIPANTS_LIMIT = 2;
    private static final String DELIMITER = ",";

    private final Set<Participant> participants;

    public Participants(Set<Participant> participants) {
        this.participants = participants;
    }

    public static Participants of(String input) {
        if (input == null || input.isEmpty()) {
            throw new NullPointerException("주어진 인풋이 없습니다.");
        }

        String[] names = input.split(DELIMITER);
        Set<Participant> participants = Arrays.stream(names)
                .map(Participant::of)
                .collect(Collectors.toSet());

        validationCheck(participants, names);
        return new Participants(participants);
    }

    private static void validationCheck(Set<Participant> participants, String[] names) {
        if (names.length < PARTICIPANTS_LIMIT) {
            throw new IllegalArgumentException("적어도 2명은 참여해야합니다.");
        }
        if (participants.size() != names.length) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public boolean isBeforeLast(int size) {
        return participants.size() - 1 == size;
    }

    @Override
    public String toString() {
        return participants.stream()
                .map(Participant::toString)
                .collect(Collectors.joining(""));
    }
}

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
        if (names.length < PARTICIPANTS_LIMIT) {
            throw new IllegalArgumentException("적어도 2명은 참여해야합니다.");
        }

        Set<Participant> participants = Arrays.stream(names)
                .map(Participant::of)
                .collect(Collectors.toSet());

        if (participants.size() != names.length) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
        return new Participants(participants);
    }

    public int getSize() {
        return participants.size();
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

package nextstep.step4.engine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    public static final String INVALID_PARTICIPANT_COUNT_MSG = "참가자는 2명 이상이어야 합니다.";
    public static final String NAME_OVER_LENGTH_MSG = "참가자의 이름은 5글자를 초과 할 수 없습니다.";
    private final String[] participants;

    public Participants(String[] participants) {
        sizeCheck(participants.length);

        for (String participant : participants) {
            overFiveLengthCheck(participant);
        }

        this.participants = participants;
    }

    private void overFiveLengthCheck(final String participant) {
        if (isOverFive(participant)) {
            throw new IllegalArgumentException(NAME_OVER_LENGTH_MSG);
        }
    }

    private boolean isOverFive(String name) {
        return name.length() > 5;
    }

    private void sizeCheck(final int participantSize) {
        if (participantSize < 2) {
            throw new IllegalArgumentException(INVALID_PARTICIPANT_COUNT_MSG);
        }
    }

    public String get(final int target) {
        return this.participants[target];
    }

    public int size() {
        return this.participants.length;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Participants that = (Participants) o;
        return Arrays.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(participants);
    }

    @Override
    public String toString() {
        List<String> collect = Arrays.stream(this.participants)
                    .map(p -> String.format("%-6s", p))
                    .collect(Collectors.toList());

        return String.join("", collect);
    }
}

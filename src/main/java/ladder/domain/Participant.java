package ladder.domain;

import ladder.exception.CreatingParticipantFailureException;

import java.util.Objects;
import java.util.Optional;

public final class Participant {

    private static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Participant(final Participant participant) {
        this(participant.name);
    }

    public Participant(final String name) {
        validateOrThrow(name);

        this.name = name;
    }

    private void validateOrThrow(final String name) {
        validateNameOrThrow(name);
    }

    private void validateNameOrThrow(final String name) {
        Optional.ofNullable(name)
                .filter(s -> s.length() >= MINIMUM_NAME_LENGTH)
                .filter(s -> s.length() <= MAXIMUM_NAME_LENGTH)
                .filter(s -> !s.isBlank())
                .orElseThrow(() -> {
                    final String exceptionMessage = String.format("참가자 이름 길이는 최소 %d, 최대 %d 입니다.",
                            MINIMUM_NAME_LENGTH, MAXIMUM_NAME_LENGTH);
                    throw new CreatingParticipantFailureException(exceptionMessage);
                });
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

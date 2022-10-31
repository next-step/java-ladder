package ladder.domain;

import ladder.exception.CreatingParticipantFailureException;

import java.util.Optional;

public final class Participant {

    private final String name;

    public Participant(final String name) {
        validateOrThrow(name);

        this.name = name;
    }

    private void validateOrThrow(final String name) {
        validateNameOrThrow(name);
    }

    private void validateNameOrThrow(final String name) {
        Optional.ofNullable(name)
                .filter(s -> !s.isBlank())
                .filter(s -> s.length() <= 5)
                .orElseThrow(() -> {
                    final String exceptionMessage = "참가자 이름 길이는 최소 1, 최대 5 입니다.";
                    throw new CreatingParticipantFailureException(exceptionMessage);
                });
    }
}

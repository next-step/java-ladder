package nextstep.ladder.domain;

import static nextstep.ladder.domain.Participant.PARTICIPANT_NAME_LENGTH_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParticipantTest {

    @ParameterizedTest
    @DisplayName("이름이 1자 이상 5자 이하가 아니면 예외를 던진다.")
    @ValueSource(strings = {"", " ", "succaa"})
    void create_participant_exception(String given) {
        // when // then
        assertThatThrownBy(() -> new Participant(given))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(PARTICIPANT_NAME_LENGTH_EXCEPTION);
    }
}

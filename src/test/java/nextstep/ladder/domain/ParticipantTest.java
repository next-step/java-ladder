package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {
    @ParameterizedTest
    @ValueSource(strings = {"p1", "test"})
    @DisplayName("정상 적인 이름의 생성 케이스 테스트")
    void name(String input) {
        assertThat(new Participant(input)).isInstanceOf(Participant.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("null, empty 이름의 생성 케이스 테스트 - 예외 발생")
    void null_empty_name(String input) {
        assertThatThrownBy(() -> new Participant(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participant.NULL_OR_EMPTY_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"p123456", "p1234567"})
    @DisplayName("길이가 5자 이상인 이름의 생성 케이스 테스트 - 예외 발생")
    void too_length_name(String input) {
        assertThatThrownBy(() -> new Participant(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participant.TOO_LENGTH_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("위치 정보를 가진 생성 케이스 테스트")
    void create_with_position() {
        assertThat(new Participant("test", 1).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("위치 정보를 업데이트 테스트")
    void move_test() {
        Participant participant = new Participant("test", 1);
        participant.moveTo(2);
        assertThat(participant).isEqualTo(new Participant("test", 2));
    }
}

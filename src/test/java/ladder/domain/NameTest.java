package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {
    @DisplayName("이름이 최대 길이를 초과하는 경우 예외 발생 검증")
    @Test
    void lengthException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participant.from("abcdef"))
                .withMessageContaining("최대")
        ;
    }

    @DisplayName("이름이 null 또는 blank인 경우 예외 발생 검증")
    @Test
    void blankException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participant.from(""))
                .withMessageContaining("존재하지 않습니다.")
        ;
    }
}
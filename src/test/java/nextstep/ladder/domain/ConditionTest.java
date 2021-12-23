package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ConditionTest {

    @Test
    @DisplayName("사다리를 만들 조건을 생성한다")
    void shouldCreate() {
        Condition condition = Condition.of(3, 5);
        assertThat(condition).isEqualTo(Condition.of(3, 5));
    }

    @Test
    @DisplayName("사다리 높이가 1단 미만이면 IllegalArgumentException을 던진다")
    void shouldThrowWhenLadderHeightInvalid() {
        assertThatThrownBy(() -> Condition.of(3, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
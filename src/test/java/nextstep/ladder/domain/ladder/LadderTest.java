package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.strategy.Strategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("높이 값으로 사다리를 생성한다")
    void shouldCreateWithHeight() {
        Ladder ladder = Ladder.from(3, 3, new Strategy.Fake());
        assertThat(ladder).isEqualTo(Ladder.from(3, 3, new Strategy.Fake()));
    }


    @Test
    @DisplayName("사다리 높이가 1단 미만이면 IllegalArgumentException을 던진다")
    void shouldThrowWhenLadderHeightInvalid() {
        assertThatThrownBy(() -> Ladder.from(0, 3, new Strategy.Fake()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
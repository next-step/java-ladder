package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("중복된 다리가 있을 경우 예외를 발생한다.")
    @Test
    void when_hasDuplicateBridge_Expect_throwException() {
        int width = 5;

        BridgeStrategy strategy = () -> true;

        assertThatThrownBy(() -> new Line(width, strategy))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
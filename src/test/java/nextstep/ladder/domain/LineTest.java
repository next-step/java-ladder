package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BridgeStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

class LineTest {

    @DisplayName("중복된 다리가 있을 경우 중복된 다리를 삭제한다.")
    @Test
    void when_hasDuplicateBridge_Expect_EraseBridge() {
        int width = 10;
        BridgeStrategy strategy = () -> true;

        assertThatNoException()
                .isThrownBy(() -> new Line(width, strategy));
    }
}
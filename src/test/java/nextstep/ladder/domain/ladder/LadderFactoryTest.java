package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.line.RandomLineFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderFactoryTest {

    private LadderFactory ladderFactory;

    @BeforeEach
    void setUp() {
        ladderFactory = new LadderFactory(new RandomLineFactory());
    }

    @Test
    @DisplayName("사다리 높이를 1 이상 지정하지 않으면 예외 처리한다.")
    void throwExceptionIfHeightIsInvalid() {
        assertThatThrownBy(() -> ladderFactory.createLadder(0, 2)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("사다리 너비를 2 이상 지정하지 않으면 예외 처리한다.")
    void throwExceptionIfWidthIsInvalid() {
        assertThatThrownBy(() -> ladderFactory.createLadder(1, 1)).isInstanceOf(RuntimeException.class);
    }


}

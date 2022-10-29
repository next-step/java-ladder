package laddergame.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class RandomLadderLineFactoryTest {

    private final LadderLineFactory lineFactory = new RandomLadderLineFactory();

    @DisplayName("포인트의 개수를 전달하면, 예외가 발생하지 않고 사다리 라인이 생성되어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void createLadderLine(int numberOfPoints) {
        assertThatNoException()
                .isThrownBy(() -> lineFactory.createLadderLine(numberOfPoints));
    }

    @DisplayName("포인트의 개수로 0 보다 작은 수를 전달하면, 예외가 발생해야 한다.")
    @Test
    void createLadderLine_givenZero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lineFactory.createLadderLine(0));
    }

}

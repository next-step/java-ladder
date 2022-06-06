package ladder.domain;

import ladder.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineFactoryTest {
    @ParameterizedTest(name = "사다리 높이에 맞게 라인 수 생성하는 테스트{index}")
    @ValueSource(ints = {4, 5, 6})
    void heightException(int heightOfLadder) {
        List<Line> lines = LineFactory.createLines(heightOfLadder, 4, new RandomLineStrategy());
        assertThat(lines).hasSize(heightOfLadder);
    }

    @DisplayName("사다리 높이가 유효하지 않은 경우 예외 발생 테스트")
    @Test
    void heightException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.from(LineFactory.createLines(0, 4, new RandomLineStrategy())))
                .withMessageContaining("사다리 높이")
        ;
    }

    @DisplayName("참가자수가 유효하지 않은 경우 예외 발생 테스트")
    @Test
    void countException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.from(LineFactory.createLines(5, 0, new RandomLineStrategy())))
                .withMessageContaining("참가자")
        ;
    }
}
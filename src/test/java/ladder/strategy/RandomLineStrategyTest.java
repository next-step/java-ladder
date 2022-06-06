package ladder.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineStrategyTest {
    private LineStrategy lineStrategy;

    @BeforeEach
    void setUp() {
        lineStrategy = new RandomLineStrategy();
    }

    @ParameterizedTest(name = "참가자수에 따라 랜덤라인전략을 사용하여 좌표값들 생성하는 테스트")
    @ValueSource(ints = {4, 5, 6})
    void initialPoints(int countOfParticipant) {
        List<Boolean> initialPoints = lineStrategy.initialPoints(countOfParticipant);
        assertThat(initialPoints).hasSize(countOfParticipant);
    }
}
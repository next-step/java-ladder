package ladder.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("고정 사다리 전략 테스트")
class FixedLadderStrategyTest {

    private LadderStrategy ladderStrategy;

    @BeforeEach
    public void setUp() {
        ladderStrategy = new FixedLadderStrategy(true);
    }

    @DisplayName("고정 사다리 전략의 첫번째 라인은 반드시 존재한다")
    @Test
    void firstLineTest() {
        assertThat(ladderStrategy.firstLine()).isTrue();
    }

    @DisplayName("고정 사다리 전략의 다음 라인도 반드시 존재한다")
    @Test
    void nextLineTest() {
        boolean previousLine = ladderStrategy.firstLine();
        boolean currentLine = ladderStrategy.nextLine(previousLine);
        assertThat(currentLine).isTrue();
    }
}

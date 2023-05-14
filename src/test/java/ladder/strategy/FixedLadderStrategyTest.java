package ladder.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("고정 사다리 전략 테스트")
class FixedLadderStrategyTest {

    @DisplayName("수평선을 모두 생성하는 고정 사다리 전략의 첫번째 라인은 반드시 존재한다")
    @Test
    void fixedLadderStrategyWithTrueFirstLineTest() {
        LadderStrategy ladderStrategy = new FixedLadderStrategy(true);
        assertThat(ladderStrategy.firstLine()).isTrue();
    }

    @DisplayName("수평선을 모두 생성하는 고정 사다리 전략의 다음 라인도 반드시 존재한다")
    @Test
    void fixedLadderStrategyWithTrueNextLineTest() {
        LadderStrategy ladderStrategy = new FixedLadderStrategy(true);
        boolean previousLine = ladderStrategy.firstLine();
        boolean currentLine = ladderStrategy.nextLine(previousLine);
        assertThat(currentLine).isTrue();
    }

    @DisplayName("수평선을 모두 생성하지 않는 고정 사다리 전략의 첫번째 라인은 반드시 존재하지 않는다")
    @Test
    void fixedLadderStrategyWithFalseFirstLineTest() {
        LadderStrategy ladderStrategy = new FixedLadderStrategy(false);
        assertThat(ladderStrategy.firstLine()).isFalse();
    }

    @DisplayName("수평선을 모두 생성하지 않는 고정 사다리 전략의 다음 라인도 반드시 존재하지 않는다")
    @Test
    void fixedLadderStrategyWithFalseNextLineTest() {
        LadderStrategy ladderStrategy = new FixedLadderStrategy(false);
        
        boolean previousLine = ladderStrategy.firstLine();
        boolean currentLine = ladderStrategy.nextLine(previousLine);

        assertThat(previousLine).isFalse();
        assertThat(currentLine).isFalse();
    }
}

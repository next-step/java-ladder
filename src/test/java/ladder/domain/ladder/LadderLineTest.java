package ladder.domain.ladder;

import ladder.domain.strategy.FalseLineStrategy;
import ladder.domain.strategy.RandomLineStrategy;
import ladder.domain.strategy.TrueLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @Test
    @DisplayName("LadderLine 생성 테스트")
    public void generateLadderLine() {
        int countOfPerson = 5;
        LadderLine line = LadderLine.of(countOfPerson, new RandomLineStrategy());
    }

    @Test
    @DisplayName("move 테스트")
    public void testMove() {
        LadderLine line = LadderLine.of(5, new FalseLineStrategy());
        assertThat(line.move(0)).isEqualTo(0);
    }
}

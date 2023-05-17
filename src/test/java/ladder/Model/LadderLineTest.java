package ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    MakeLineStrategy makeLineStrategy = new MakeLineStrategyRandom();
    @Test
    @DisplayName("입력된 숫자만큼 horizon list가 만들어져야함.")
    public void ladderLine_horizon_size() {
        int expected = 5;
        LadderLine ladderLine = new LadderLine(expected, makeLineStrategy);
        int actual = ladderLine.horizonLines().size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력된 숫자 + 1만큼 vertical list가 만들어져야함.")
    public void ladderLine_vertical_size() {
        int expected = 6;

        int input = 5;
        LadderLine ladderLine = new LadderLine(input, makeLineStrategy);
        int actual = ladderLine.verticalLines().size();

        assertThat(actual).isEqualTo(expected);
    }
}
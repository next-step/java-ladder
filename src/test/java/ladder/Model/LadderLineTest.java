package ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {

    MakeLineStrategy makeLineStrategy = new MakeLineStrategyRandom();
    @Test
    @DisplayName("입력된 숫자만큼 list가 만들어져야함.")
    public void ladderLine_size() {
        int expected = 5;
        LadderLine ladderLine = new LadderLine(expected, makeLineStrategy);
        int actual = ladderLine.lines().size();

        assertThat(actual).isEqualTo(expected);
    }
}
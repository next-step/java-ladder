package ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MakeLineStrategyTest {
    @Test
    @DisplayName("바로 이전에 line이 만들어져있다면 무조건 만들지 않아야함.")
    public void makeLine_made_before() {
        MakeLineStrategy makeLineStrategy = new MakeLineStrategyRandom();
        Boolean expected = false;

        Boolean input = true;
        Boolean actual = makeLineStrategy.makeLine(input);

        assertThat(actual).isEqualTo(expected);
    }
}
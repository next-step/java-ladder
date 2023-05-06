package ladder.model;

import ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameTest {

    @Test
    public void 참가자_수와_사다리_너비가_같지_않다면_예외가_난다() {
        Names names = Names.of("hello");
        Ladder ladder = Ladder.create(2, 2, new RandomStrategy());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(names, ladder));
    }
}
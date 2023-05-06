package ladder.model;

import ladder.strategy.RandomStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"-1,0", "0,-1"})
    public void 사다리_높이나_너비가_양수가_아니면_예외가_난다(int width, int height) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Ladder.create(width, height, new RandomStrategy())
        );
    }

}
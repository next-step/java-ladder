package ladder.model;

import ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"-1,0", "0,-1"})
    public void 사다리_높이나_너비가_양수가_아니면_예외가_난다(int width, int height) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Ladder.create(width, height, new RandomStrategy())
        );
    }

    @Test
    public void 지정한_높이와_너비로_생성되어야_한다() throws Exception {
        //given
        int width = 5;
        int height = 8;

        Ladder ladder = Ladder.create(width, height, new RandomStrategy());

        //when, then
        assertThat(ladder.width()).isEqualTo(width);
        assertThat(ladder.height()).isEqualTo(height);
        assertThat(ladder.rows()).hasSize(height);
    }

}
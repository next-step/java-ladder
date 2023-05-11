package ladder.model;

import ladder.model.ladder.Ladder;
import ladder.model.ladder.LadderRow;
import ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    @Test
    public void 사다리_이동_후_위치를_제대로_알_수_있다() throws Exception {
        LadderRow row1 = LadderRow.of(false, true, false);    // |   |---|   |
        LadderRow row2 = LadderRow.of(true, false, false);    // |---|   |   |
        Ladder ladder = Ladder.of(row1, row2);

        assertThat(ladder.resultOf(0)).isEqualTo(1);
        assertThat(ladder.resultOf(1)).isEqualTo(2);
        assertThat(ladder.resultOf(2)).isEqualTo(0);
        assertThat(ladder.resultOf(3)).isEqualTo(3);

    }

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
        int stiles = 5;
        int height = 8;

        Ladder ladder = Ladder.create(stiles, height, new RandomStrategy());

        //when, then
        assertThat(ladder.countOfStiles()).isEqualTo(stiles);
        assertThat(ladder.height()).isEqualTo(height);
    }

}
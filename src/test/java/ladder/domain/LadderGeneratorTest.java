package ladder.domain;

import ladder.exception.IllegalLadderParameterException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderGeneratorTest {
    @Test
    void 최대_높이에_음수를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new LadderGenerator().generate(-1, 2))
                .isInstanceOf(IllegalLadderParameterException.class);
    }

    @Test
    void 최대_너비에_1_이하의_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new LadderGenerator().generate(2, 1))
                .isInstanceOf(IllegalLadderParameterException.class);
    }

    @Test
    void 최대_높이와_최대_너비를_지정하면_사다리를_만들_수_있다() {
        int maxHeight = 2;
        int maxWidth = 2;
        LadderGenerator LadderGenerator = new LadderGenerator();
        Ladder ladder = LadderGenerator.generate(maxHeight, maxWidth);

        assertThat(ladder.getHeight()).isEqualTo(maxHeight);
        assertThat(ladder.getWidth()).isEqualTo(maxWidth);
        assertThat(ladder.getVerticalLines().getSize()).isEqualTo(2);
    }

    @Test
    void 사다리_생성_전략에_따라_사다리가_생성된다() {
        LadderGenerator LadderGenerator = new LadderGenerator(() -> false);
        Ladder ladder = LadderGenerator.generate(2, 2);

        assertThat(ladder.getHorizontalLines().getSize()).isEqualTo(0);
    }
}

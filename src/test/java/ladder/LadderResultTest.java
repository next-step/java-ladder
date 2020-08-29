package ladder;

import ladder.domain.LadderData;
import ladder.domain.LadderResult;
import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderResultTest {

    @Test
    public void ladderResultDataTest() {

        int height = 5;
        LadderData ladderData = new LadderData(
                WhenUtils.input("a,b,c,d,e", height), WhenUtils.output());

        List<Line> lines = Stream.generate(() -> new Line(5, () -> true))
                .limit(height)
                .collect(Collectors.toList());

        LadderResult ladderResult = new LadderResult(ladderData, lines);

        int[] data = new int[] { 1, 0, 3, 2, 4 };

        for (int i = 0; i < height; i++) {
            assertEquals(ladderResult.searchRewardIndex(i), data[i]);
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderResult.searchRewardIndex(-1));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderResult.searchRewardIndex(height));
    }
}

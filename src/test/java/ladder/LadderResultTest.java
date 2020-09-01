package ladder;

import org.junit.jupiter.api.Test;

import ladder.domain.LadderResult;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderResultTest {

    @Test
    public void ladderResultDataTest() {

        int[] data = new int[] { 1, 0, 3, 2, 4 };
        LadderResult ladderResult = new LadderResult();

        for (int i = 0; i < data.length; i++) {
            ladderResult.put(i, data[i]);
        }

        for (int i = 0; i < data.length; i++) {
            assertEquals(ladderResult.searchRewardIndex(i), data[i]);
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderResult.searchRewardIndex(-1));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderResult.searchRewardIndex(data.length));
    }
}

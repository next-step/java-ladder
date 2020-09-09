package ladder.domain;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @DisplayName("LadderResult 테스트")
    @Test
    public void ladderResultDataTest() {

        int[] data = new int[] { 1, 0, 3, 2, 4 };
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            map.put(i, data[i]);
        }

        LadderResult ladderResult = new LadderResult(map);

        for (int i = 0; i < data.length; i++) {
            assertThat(ladderResult.get(i)).isBetween(0, data.length - 1);
        }
    }
}

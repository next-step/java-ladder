package domain.ladder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @Test
    public void 입력확인() {
        List<String> result = Arrays.asList("꽝","5000","꽝","3000");
        LadderResult ladderResult = new LadderResult(result);
        assertThat(ladderResult.getResults().get(0)).isEqualTo("꽝");
    }
}

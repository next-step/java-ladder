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
        assertThat(ladderResult.getResults().get(1)).isEqualTo("5000");
        assertThat(ladderResult.getResults().get(2)).isEqualTo("꽝");
        assertThat(ladderResult.getResults().get(3)).isEqualTo("3000");
    }
}

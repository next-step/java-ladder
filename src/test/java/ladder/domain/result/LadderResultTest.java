package ladder.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.result.LadderResult;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void 사다리결과생성_스트링() {
        assertThat(LadderResult.of("5000,꽝,3000")).isEqualTo(LadderResult.of("5000,꽝,3000"));
    }

    @Test
    void 사다리결과생성() {
        assertThat(LadderResult.of(List.of("5000", "꽝", "3000"))).isEqualTo(
            LadderResult.of(List.of("5000", "꽝", "3000")));
    }

}
package ladder.domain.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    void create() {
        LadderResult result = LadderResult.of("pobi", "꽝");
        assertThat(result).isEqualTo(LadderResult.of("pobi", "꽝"));
    }
}
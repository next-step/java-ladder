package ladder.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void put() {
        LadderResult result = new LadderResult();
        result.put(0, 1);
        assertThat(result.findTarget(0)).isEqualTo(1);
    }
}
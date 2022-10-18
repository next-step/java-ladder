package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultTest {

    @Test
    void shouldValidateEachResult() {
        assertThatThrownBy(() -> new LadderResult(Arrays.asList("꽝", "당첨", null), 3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LadderResult(Arrays.asList("꽝", "당첨", ""), 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldValidateSizeOfResult() {
        assertThatThrownBy(() -> new LadderResult(Arrays.asList("꽝", "당첨", "당첨"), 2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldGetGameResult() {
        LadderResult result = new LadderResult(Arrays.asList("제로콜라", "곱창", "떡볶이"), 3);

        assertThat(result.result(new HorizontalPosition(0))).isEqualTo("제로콜라");
        assertThat(result.result(new HorizontalPosition(1))).isEqualTo("곱창");
        assertThat(result.result(new HorizontalPosition(2))).isEqualTo("떡볶이");
    }

}

package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    public void 생성() {
        assertThat(Result.of("꽝")).isEqualTo(Result.of("꽝"));
    }
}
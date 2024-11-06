package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 사용자_결과_조회() {
        Result result = new Result(new Username("TEST"), "꽝");
        assertThat(result.getResultValue()).isEqualTo("꽝");
    }
}

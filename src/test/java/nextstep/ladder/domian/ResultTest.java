package nextstep.ladder.domian;

import nextstep.ladder.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private Result result;

    @DisplayName("결과를 생성한다.")
    @Test
    void 결과를_생성한다() {
        result = new Result("꽝");
        assertThat(result.value()).isEqualTo("꽝");
    }
}

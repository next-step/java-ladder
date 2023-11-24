package nextstep.ladder.domian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

    private Result result;

    @DisplayName("결과를 생성한다.")
    @Test
    void 결과를_생성한다() {
        result = new Result("꽝,5000,꽝,3000");
    }
}

package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    @DisplayName("사다리 게임의 실행 결과 생성")
    void create() {
        assertThat(LadderResult.from(asList("꽝", "5000", "꽝", "3000")))
                .isEqualTo(LadderResult.from(asList("꽝", "5000", "꽝", "3000")));
    }
}
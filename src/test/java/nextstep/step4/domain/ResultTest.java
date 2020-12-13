package nextstep.step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("결과 생성 테스트")
    void createResult() {
        String reward = "1000";
        Result result = Result.of(0, reward);

        Assertions.assertThat(result.toString()).isEqualTo(reward);
    }

}
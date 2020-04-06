package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("result 객체를 생성해보고 같은 객체인지 확인해본다.")
    @Test
    void createResult() {
        Result result = new Result("꽝");
        assertThat(result).isEqualTo(new Result("꽝"));
    }
}

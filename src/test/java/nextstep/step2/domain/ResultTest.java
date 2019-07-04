package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    @DisplayName("Result 생성")
    void create() {
        Result result = new Result(0, "꽝");
        assertThat(result.toString()).isEqualTo("꽝");
    }

    @Test
    @DisplayName("position 이 같은지 확인")
    void equals_position() {
        Result result = new Result(0, "꽝");
        assertThat(result.equalsPosition(0)).isTrue();
    }
}

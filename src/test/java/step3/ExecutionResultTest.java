package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Result;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    @DisplayName("Result 생성 테스트")
    void resultTest() {
        Result result = new Result("꽝");
        assertThat(result).isEqualTo(new Result("꽝"));
    }
}

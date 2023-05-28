package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExecuteResultTest {

    @Test
    void create() {
        ExecuteResult result = new ExecuteResult("꽝");
        assertThat(result.name()).isEqualTo(new ExecuteResult("꽝").name());
    }

    @Test
    void 글자수_5이상시_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ExecuteResult("500000"))
                .withMessageContaining("글자수는 최대 5글자까지 부여할 수 있습니다.");
    }
}

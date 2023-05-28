package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class ExecuteResultsTest {

    @Test
    void 입력된_사람_없을시_예외() {
        assertThatIllegalStateException()
                .isThrownBy(() -> new ExecuteResults(new String[]{}))
                .withMessageContaining("실행 결과가 입력되지 않았습니다.");
    }
}

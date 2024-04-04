package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExecutionResultTest {

    @Test
    @DisplayName("실행결과가 null 또는 ''일 경우에 예외(null => IllegalArgumentException, '' => IllegalArgumentException)")
    void null_or_empty(){
        assertThatThrownBy(() -> {
            new ExecutionResult(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new ExecutionResult("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

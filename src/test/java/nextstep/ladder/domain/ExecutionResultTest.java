package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 12:47
 */
public class ExecutionResultTest {
    @Test
    void 생성() {
        ExecutionResult executionResult = new ExecutionResult(Arrays.asList("꽝", "3000", "5000", "꽝"));
        assertThat(executionResult).isEqualTo(new ExecutionResult(Arrays.asList("꽝", "3000", "5000", "꽝")));
    }

    @Test
    void 참여자_이름이_5글자_보다_큰경우() {
        assertThatThrownBy(() -> {
            ExecutionResult executionResult = new ExecutionResult(Arrays.asList("꽝", "3000", "500055"));
        }).isInstanceOf(InputMismatchException.class);
    }
}

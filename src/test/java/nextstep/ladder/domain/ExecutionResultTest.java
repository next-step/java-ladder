package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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
}

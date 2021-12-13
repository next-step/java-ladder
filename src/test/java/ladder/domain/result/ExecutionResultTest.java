package ladder.domain.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

class ExecutionResultTest {

    @Test
    @DisplayName("ExecutionResults 객체 생성")
    void create() {
        ExecutionResults result = new ExecutionResults(Arrays.asList("꽝", "5000"));
        assertThat(result).isEqualTo(new ExecutionResults(Arrays.asList("꽝", "5000")));
    }

    @ParameterizedTest()
    @ValueSource(ints = {0, 1})
    @DisplayName("index 입력받아 리스트 값 출력")
    void create1(int index) {
        ExecutionResults result = new ExecutionResults(Arrays.asList("꽝", "5000"));
        String results = result.getResults(index);
        assertThat(results).isEqualTo(result.getResults(index));
    }

    @Test
    @DisplayName("ExecutionResults 값이 비어있을 경우 예외 반환 -> IllegalArgumentException")
    void checkSize() {
        assertThatThrownBy(() -> new ExecutionResults(Collections.EMPTY_LIST))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new ExecutionResults(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
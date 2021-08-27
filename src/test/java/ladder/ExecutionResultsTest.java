package ladder;

import ladder.domain.ExecutionResults;
import ladder.exception.NullValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExecutionResultsTest {
    ExecutionResults executionResults;

    @DisplayName("참여할 사람과 실행결과를 인자로 받으면 각각의 데이터를 기반으로 한 리스트를 생성한다.")
    @Test
    void newExecutionResultsTest() {
        List<String> names = Arrays.asList("pobi", "honux", "crong", "jk");
        List<String> results = Arrays.asList("꽝", "5000", "꽝", "3000");
        executionResults = ExecutionResults.of(names, results);

        assertThat(executionResults.toNameStringList()).containsExactly("pobi", "honux", "crong", "jk");
        assertThat(executionResults.toResultStringList()).containsExactly("꽝", "5000", "꽝", "3000");
    }

    @DisplayName("참여할 사람의 인원수와 실행결과의 크기가 다르면 예외를 발생시킨다.")
    @Test
    void notEqualNamesAndResultsTest() {
        List<String> names = Arrays.asList("pobi", "honux");
        List<String> results = Arrays.asList("꽝", "5000", "꽝", "3000");
        assertThatThrownBy(() -> ExecutionResults.of(names, results)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여할 사람과 실행결과가 널이면 예외를 발생시킨다.")
    @Test
    void namesAndResultsIsNullTest() {
        assertThatThrownBy(() -> ExecutionResults.of(Arrays.asList("pobi", "honux"), null)).isInstanceOf(NullValueException.class);
        assertThatThrownBy(() -> ExecutionResults.of(null, Arrays.asList("꽝", "5000"))).isInstanceOf(NullValueException.class);
    }
}

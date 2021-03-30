package ladder.entity.resultCase;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultCaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "d", "e", "f", "g"})
    void canGenerateResultCase(String input) {
        ResultCase resultCase = new ResultCase(input);
        assertThat(resultCase.result()).isEqualTo(input);
    }
}

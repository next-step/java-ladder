package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    @DisplayName("Results 객체 생성")
    void createResults() {
        String input = "a,b,c";
        int inputsNumber = 3;
        InputResult inputResult = InputResult.createInputResult(input, inputsNumber);

        Results results = Results.createResults(inputResult);
        Result result = Result.of("a", 0);

        assertThat(results.getResults().get(0)).isEqualTo(result);
    }

    @Test
    @DisplayName("Result 인덱스 확인")
    void resultMap() {
        String input = "1000,2000,3000";
        int inputsNumber = 3;
        InputResult inputResult = InputResult.createInputResult(input, inputsNumber);

        Results results = Results.createResults(inputResult);

        assertThat(results.confirmResult(0)).isEqualTo(results.getResults().get(0));
    }

}

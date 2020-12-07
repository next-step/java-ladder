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

        assertThat(results.getResults().size()).isEqualTo(3);
    }

}

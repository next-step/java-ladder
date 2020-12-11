package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    @DisplayName("Result 인덱스 맵 생성")
    void resultMap() {
        String input = "1000,2000,3000";
        int inputsNumber = 3;
        InputResult inputResult = InputResult.createInputResult(input, inputsNumber);

        Results results = Results.createResults(inputResult);

        Map<Result, Integer> resultMap = results.mapResultIndex();

        Map<Result, Integer> resultAnswer = new HashMap<>();
        resultAnswer.put(Result.from("1000"), 0);
        resultAnswer.put(Result.from("2000"), 1);
        resultAnswer.put(Result.from("3000"), 2);

        assertThat(resultMap).isEqualTo(resultAnswer);
    }

}

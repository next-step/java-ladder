package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    @DisplayName("객체 생성 테스트")
    void initResultsTest() {
        LadderInputs participants = LadderInputs.from(List.of("a,b".split(",")));
        Results results = Results.init(participants);

        Map<Integer, Result> expected = new HashMap<>();
        expected.put(0, new Result(0));
        expected.put(1, new Result(1));

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("결과 값 업데이트 테스트")
    void updateValueTest() {
        LadderInputs participants = LadderInputs.from(List.of("a,b".split(",")));
        Results results = Results.init(participants);

        assertThat(results.updateValue(0, 1))
                .usingRecursiveComparison()
                .isEqualTo(new Result(1));

        assertThat(results.updateValue(1, -1))
                .usingRecursiveComparison()
                .isEqualTo(new Result(0));
    }

    @Test
    @DisplayName("key 반환 테스트")
    void equalValueKeyTest() {
        Map<Integer, Result> previousResults = new HashMap<>();
        previousResults.put(0, new Result(1));
        previousResults.put(1, new Result(0));

        Results results = new Results(previousResults);

        assertThat(results.equalValueKey(0))
                .usingRecursiveComparison()
                .isEqualTo(1);

        assertThat(results.equalValueKey(1))
                .usingRecursiveComparison()
                .isEqualTo(0);
    }

}
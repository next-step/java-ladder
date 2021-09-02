package ladderrefactoring.domain.datas;

import ladderrefactoring.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {

    @Test
    @DisplayName("Results 생성")
    void create() {
        // given
        People people = new People(Arrays.asList("hwan,kook,hyun,bo".split(",")));

        String resultsName = "3000,lose,2000,lose";
        List<String> resultsList = Arrays.asList(resultsName.split(","));

        // when
        Results results = new Results(resultsList, people);

        // then
        assertThat(results).isEqualTo(new Results(resultsList, people));
    }

    @ParameterizedTest(name = "Results 생성 실패 : 개수 미달 or 초과")
    @ValueSource(strings = {"3000,lose,2000", "3000,lose,2000,lose,5000"})
    void create_fail(String resultsName) {
        // given
        People people = new People(Arrays.asList("a,b,c,d".split(",")));
        List<String> resultsList = Arrays.asList(resultsName.split(","));

        // when, then
        assertThatThrownBy(() -> new Results(resultsList, people))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(Results.TOTAL_RESULTS_EXCEPTION_MESSAGE);
    }
}

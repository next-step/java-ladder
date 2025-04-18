package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class ResultsTest {

    @Test
    @DisplayName("콤마로 구분된 문자열로 Results 생성")
    void createResultsFromString() {
        // given
        String input = "꽝, 5000, 꽝, 3000";

        // when
        Results results = new Results(input);
        List<Result> resultList = results.getResults();

        // then
        assertThat(resultList).hasSize(4);
        assertThat(resultList.get(0).getResult()).isEqualTo("꽝");
        assertThat(resultList.get(1).getResult()).isEqualTo("5000");
        assertThat(resultList.get(3).getResult()).isEqualTo("3000");
    }

    @Test
    @DisplayName("공백 포함 입력도 정상 처리")
    void createResultsWithWhitespace() {
        String input = "  꽝 , 1000 , 2000 ";
        Results results = new Results(input);

        List<String> values = results.getResults().stream()
                .map(Result::getResult)
                .collect(Collectors.toList());

        assertThat(values).containsExactly("꽝", "1000", "2000");
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생")
    void createResultsWithEmptyInput() {
        assertThatThrownBy(() -> new Results(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과가 없습니다");
    }

    @Test
    @DisplayName("null 입력 시 예외 발생")
    void createResultsWithNullInput() {
        assertThatThrownBy(() -> new Results(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과가 없습니다");
    }
}

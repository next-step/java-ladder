package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class ResultsTest {

    @Test
    @DisplayName("플레이어 이름과 결과 문자열로 Results 생성")
    void createResultsFromString() {
        // given
        List<String> playerNames = List.of("pobi", "honux", "crong", "jk");
        String input = "꽝, 5000, 꽝, 3000";

        // when
        Results results = new Results(playerNames, input);
        Map<String, Result> resultMap = results.getResultsByName();

        // then
        assertThat(resultMap).hasSize(4);
        assertThat(resultMap.get("pobi").getResult()).isEqualTo("꽝");
        assertThat(resultMap.get("honux").getResult()).isEqualTo("5000");
        assertThat(resultMap.get("crong").getResult()).isEqualTo("꽝");
        assertThat(resultMap.get("jk").getResult()).isEqualTo("3000");
    }

    @Test
    @DisplayName("공백 포함 입력도 정상 처리")
    void createResultsWithWhitespace() {
        List<String> playerNames = List.of("pobi", "honux", "crong");
        String input = "  꽝 , 1000 , 2000 ";
        Results results = new Results(playerNames, input);

        List<String> values = results.getResults().stream()
                .map(Result::getResult)
                .collect(Collectors.toList());

        assertThat(values).containsExactly("꽝", "1000", "2000");
    }

    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생")
    void createResultsWithEmptyInput() {
        List<String> playerNames = List.of("pobi", "honux");
        assertThatThrownBy(() -> new Results(playerNames, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과가 없습니다");
    }

    @Test
    @DisplayName("null 입력 시 예외 발생")
    void createResultsWithNullInput() {
        List<String> playerNames = List.of("pobi", "honux");
        assertThatThrownBy(() -> new Results(playerNames, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과가 없습니다");
    }

    @Test
    @DisplayName("결과 이름으로 Result 조회")
    void findByNameShouldReturnCorrectResult() {
        List<String> playerNames = List.of("pobi", "honux", "crong");
        String input = "꽝, 1000, 2000";

        Results results = new Results(playerNames, input);

        assertThat(results.findByName("pobi").getResult()).isEqualTo("꽝");
        assertThat(results.findByName("honux").getResult()).isEqualTo("1000");
    }

    @Test
    @DisplayName("존재하지 않는 이름으로 조회 시 예외 발생")
    void findByInvalidName() {
        List<String> playerNames = List.of("pobi", "honux");
        String input = "꽝, 1000";

        Results results = new Results(playerNames, input);

        assertThatThrownBy(() -> results.findByName("crong"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 이름의 결과를 찾을 수 없습니다");
    }

    @Test
    @DisplayName("결과 수와 플레이어 수가 일치하지 않으면 예외 발생")
    void resultSizeMismatch() {
        List<String> playerNames = List.of("pobi", "honux");
        String input = "꽝";

        assertThatThrownBy(() -> new Results(playerNames, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어 수와 결과 수가 일치하지 않습니다.");
    }
}

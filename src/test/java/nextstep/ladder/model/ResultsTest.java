package nextstep.ladder.model;

import nextstep.ladder.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultsTest {

    private static final String DELIMITER = ",";

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"꽝,,꽝,,",})
    @DisplayName("결과값에 빈 값, null, 중간에 빈 값이 들어갔을 경우")
    void validationInputValue(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] splitResults = StringUtils.validationNotNullAndEmpty(input).split(DELIMITER);
            int width = splitResults.length;
            new Results(splitResults, width);
        });
    }

    @Test
    @DisplayName("결과들의 수와 플레이어 수가 일치하지 않을 때")
    void not_equals_results_and_players_size() {
        String inputResults = "꽝,5000,꽝,꽝,꽝,꽝,꽝,꽝,10000"; // size: 9
        String[] splitResults = StringUtils.validationNotNullAndEmpty(inputResults).split(DELIMITER);
        int playerSize = 10;
        assertThatIllegalArgumentException().isThrownBy(() -> new Results(splitResults, playerSize));
    }

    @Test
    @DisplayName("Index로 Result 찾기: 성공")
    void successFindByIndex() {
        String[] splitResults = StringUtils.validationNotNullAndEmpty("꽝,5000,꽝").split(DELIMITER);
        Results results = new Results(splitResults, splitResults.length);

        Result result = results.findResultByIndex(Index.ONE);

        assertThat(result.getName()).isEqualTo("5000");
    }

    @Test
    @DisplayName("Index로 Result 찾기: 실패")
    void failFindByIndex() {
        String[] splitResults = StringUtils.validationNotNullAndEmpty("꽝,5000,꽝").split(DELIMITER);
        Results results = new Results(splitResults, splitResults.length);

        assertThatIllegalArgumentException().isThrownBy(() -> results.findResultByIndex(new Index(3)));
    }
}
package nextstep.ladder.domain;

import nextstep.ladder.domain.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    @DisplayName("입력받은 게임 실행 결과 확인")
    void inputGameResult() {
        String result = "꽝, 5000, 꽝, 3000";
        Results results = new Results(result);
        assertThat(results.getResults()).hasSize(4);
    }

}

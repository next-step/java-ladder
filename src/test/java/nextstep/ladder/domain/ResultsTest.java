package nextstep.ladder.domain;

import nextstep.ladder.domain.result.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {

    @DisplayName("실행결과 생성 테스트 - 플레이어 수와 달라 에러 발생")
    @Test
    void create_results_invalid() {
        int playerCount = 4;
        String[] results = new String[]{"꽝", "5000", "꽝"};

        assertThatThrownBy(() -> new Results(playerCount, results))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

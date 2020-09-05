package nextstep.ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    @DisplayName("입력받은 게임 실행 결과 확인")
    void inputGameResult() {
        String result = "꽝, 5000, 꽝, 3000";
        List<String> gameResult = Results.from(result);
        assertThat(gameResult).hasSize(4);
    }

}

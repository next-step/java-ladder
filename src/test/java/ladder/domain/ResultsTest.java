package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultsTest {

    @Test
    @DisplayName("참가자 수와 동일한 수의 결과를 입력하면 결과는 정상 생성된다.")
    void createResults() {
        int totalGameMebmers = 2;
        Results results = new Results(List.of("꽝", "당첨"), totalGameMebmers);

        assertThat(results).isEqualTo(new Results(List.of("꽝", "당첨"), totalGameMebmers));
    }

    @Test
    @DisplayName("참가자 수 보다 많은 수의 결과를 입력하면 오류가 발생한다.")
    void createResults_더많은_결과() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Results(List.of("꽝", "당첨"), 1))
                .withMessage("게임 참여자 수와 결과의 수는 동일해야 합니다.");
    }
}
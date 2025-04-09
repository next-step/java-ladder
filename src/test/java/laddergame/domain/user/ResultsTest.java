package laddergame.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultsTest {
    @DisplayName("실행 결과의 개수가 참여 인원수와 맞지 않으면 에러 발생")
    @Test
    void no_match_user_number_create_results() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Results("꽝,30000", 4));
    }
}

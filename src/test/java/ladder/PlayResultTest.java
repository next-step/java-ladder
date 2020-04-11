package ladder;

import ladder.domain.PlayResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayResultTest {

    @Test
    @DisplayName("게임결과 생성 실패 테스트")
    void validateTest() {
        assertThatThrownBy(
                () -> PlayResult.of("팔굽혀펴기40회", 1)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

package ladder.domain;

import ladder.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeTest {

    @Test
    @DisplayName("게임결과 생성 실패 테스트")
    void validateTest() {
        assertThatThrownBy(
                () -> Prize.of("팔굽혀펴기40회")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

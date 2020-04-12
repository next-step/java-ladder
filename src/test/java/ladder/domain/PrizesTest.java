package ladder.domain;

import ladder.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizesTest {

    @Test
    @DisplayName("플레이결과들 생성 실패 테스트")
    void validateTest() {
        assertThatThrownBy(
                () -> new Prizes(Arrays.asList("asdf"))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

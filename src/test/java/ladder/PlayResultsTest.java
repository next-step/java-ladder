package ladder;

import ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayResultsTest {

    @Test
    @DisplayName("플레이결과들 생성 실패 테스트")
    void validateTest() {
        assertThatThrownBy(
                () -> new Players(Arrays.asList("asdf"))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}

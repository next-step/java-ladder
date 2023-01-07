package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("높이가 2보다 작을경우 에러 발생")
    void heightMinException() {
        Assertions.assertThatThrownBy(() -> new Height(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 최소값은 2이상이여야 합니다.");
    }
}

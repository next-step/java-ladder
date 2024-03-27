package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("[성공] 높이 5의 사다리를 생성한다.")
    void 사다리_생성() {
        Ladder ladder = Ladder.of(4, 5);
        Assertions.assertThat(ladder.getHeight()).isEqualTo(5);
    }

}

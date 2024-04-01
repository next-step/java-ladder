package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("참가자수(n)에 따라 Point는 (n - 1) * 5 만큼 생긴다")
    @Test
    void initLine() {
        Assertions.assertThat(new Line(3).getPoints().size()).isEqualTo(10);
    }
}

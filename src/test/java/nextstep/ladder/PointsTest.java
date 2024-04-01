package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointsTest {



    @DisplayName("참가자수(n)에 따라 Point는 (n - 1) * 5 개만큼 생긴다")
    @Test
    void size() {
        Assertions.assertThat(new Points(3, true).size()).isEqualTo(10);
    }

}

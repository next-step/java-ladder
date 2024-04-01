package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointsTest {

    @DisplayName("point를 추가할 수 있다")
    @Test
    void add() {
        Points points = new Points(3, true);
        points.add(true);
        assertThat(points.size()).isEqualTo(11);
    }

    @DisplayName("참가자수(n)에 따라 Point는 (n - 1) * 5 개만큼 생긴다")
    @Test
    void size() {
        assertThat(new Points(3, true).size()).isEqualTo(10);
    }

}

package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    private Point point;

    @BeforeEach
    void setUp() {
        point = Point.first(true);
    }

    @DisplayName("{false,true} 상태에서 true 쪽으로 한 칸 이동")
    @Test
    void nextTest() {
        assertThat(point.move()).isEqualTo(1);
    }


}

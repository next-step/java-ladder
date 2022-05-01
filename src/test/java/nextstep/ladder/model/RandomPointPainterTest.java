package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

@DisplayName("랜덤 포인트 생성기")
class RandomPointPainterTest {

    @Test
    @DisplayName("랜덤 객체로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> RandomPointPainter.from(new Random()));
    }

    @Test
    @DisplayName("랜덤 객체는 필수")
    void instance_null_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> RandomPointPainter.from(null));
    }

    @RepeatedTest(10)
    @DisplayName("랜덤 포인터 생성")
    void pointer() {
        assertThat(RandomPointPainter.from(new Random()).point()).isIn(Point.CONNECTED, Point.DISCONNECTED);
    }
}

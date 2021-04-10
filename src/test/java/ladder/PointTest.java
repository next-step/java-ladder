package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @DisplayName("인덱스,위치정보 인자를 받아 인스턴스가 정상적으로 생성된다.")
    @Test
    void create_인덱스위치() {
        Point pointIndex = new Point(1, "FIRST");
        assertThat(pointIndex).isEqualTo(new Point(1, "FIRST"));
    }

    @DisplayName("첫번째 Point 여부를 반환한다.")
    @Test
    void first() {
        Point point = new Point(1, "FIRST");
        assertThat(point.isFirst()).isTrue();
    }

    @DisplayName("마지막 Point 여부를 반환한다.")
    @Test
    void last() {
        Point point = new Point(4, "LAST");
        assertThat(point.isLast()).isTrue();
    }
}

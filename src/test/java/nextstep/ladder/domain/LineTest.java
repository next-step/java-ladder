package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("포인트를 받아 라인을 생성한다")
    @Test
    void create() {
        Line line = new Line.LineBuilder()
                .point(true)
                .build();

        assertThat(line.width()).isEqualTo(2);
    }

    @DisplayName("포인트가 비어있으면 예외가 발생한다")
    @Test
    void emptyPoints() {
        assertThatThrownBy(() -> new Line.LineBuilder().build())
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("인덱스를 받아 포인트를 반환한다")
    @Test
    void getPoint() {
        Line line = new Line.LineBuilder()
                .point(true)
                .build();

        assertThat(line.getPoint(0)).isEqualTo(Point.createLeftmost(true));
    }
}

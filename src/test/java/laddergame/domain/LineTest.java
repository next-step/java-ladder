package laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    public void 가로_라인이_겹칠_수_없음() {
        List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(true);
        points.add(false);
        assertThatThrownBy(() -> {
            new Line(points);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("가로 라인이 겹칠 수 없습니다.");

    }

    @Test
    public void 라인_생성() {
        List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(false);

        Line line = new Line(points);
        assertThat(line.getPoints().size()).isEqualTo(3);
    }
}

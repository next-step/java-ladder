package nextstep.ladder.domian;

import nextstep.ladder.domain.Line;
import nextstep.ladder.exception.LineSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    private Line line;

    void createLine(int width) {
        line = new Line(width, () -> true);
    }

    @DisplayName("사다리 가로칸을 생성한다")
    @Test
    void 가로_칸을_생성한다() {
        List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(true);
        createLine(3);
        assertThat(line.points()).usingRecursiveComparison().isEqualTo(points);
    }

    @DisplayName("사다리는 최소 2개의 가로칸을 가져야 한다")
    @Test
    void 사다리는_최소_2개의_가로칸을_가져야_한다() {
        assertThatThrownBy(() -> createLine(1))
                .isInstanceOf(LineSizeException.class);
    }

    @DisplayName("사다리를 이동한다")
    @Test
    void 사다리를_이동한다() {
        createLine(2);
        assertThat(line.move(0)).isEqualTo(1);
    }
}

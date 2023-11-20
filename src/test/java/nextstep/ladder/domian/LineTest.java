package nextstep.ladder.domian;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    private Line line;

    void createLine(int height) {
        line = new Line(height, () -> true);
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
}

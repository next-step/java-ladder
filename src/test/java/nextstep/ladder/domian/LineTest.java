package nextstep.ladder.domian;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    private Line line;

    void createLine(List<Boolean> points) {
        line = new Line(points);
    }

    @DisplayName("사다리 가로칸을 생성한다")
    @Test
    void 가로_칸을_생성한다() {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        points.add(true);
        points.add(false);
        createLine(points);
        assertThat(line.points()).usingRecursiveComparison().isEqualTo(points);
    }
}

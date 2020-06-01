package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.point.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @DisplayName("라인은 사람수-1개의 포인트를 생성한다.")
    @Test
    void line_create_points() {
        Line line = new Line(LinePoints.of(5, new RandomPointGenerator()));
        assertThat(line.getPoints()).hasSize(4);
    }


}

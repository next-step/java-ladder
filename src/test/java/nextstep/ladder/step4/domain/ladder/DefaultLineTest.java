package nextstep.ladder.step4.domain.ladder;

import static java.lang.Boolean.FALSE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.step4.domain.ladder.engine.Line;
import nextstep.ladder.step4.exception.LineMinimumLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefaultLineTest {

    @Test
    @DisplayName("생성 성공")
    void creat() {
        List<Point> points = new ArrayList<>();
        Direction direction = Direction.first(FALSE);
        points.add(new Point(0, direction));
        direction.last();
        points.add(new Point(1, direction));

        assertThat(new DefaultLine(points)).isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("최소 길이 예외 처리")
    void lineMinimumLengthException() {
        List<Point> points = new ArrayList<>();
        Direction direction = Direction.first(FALSE);
        points.add(new Point(0, direction));

        assertThatExceptionOfType(LineMinimumLengthException.class)
            .isThrownBy(() -> new DefaultLine(points));
    }


}

package ladder;

import ladder.model.Line;
import ladder.model.User;
import ladder.model.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    List<Boolean> points = new ArrayList<>();
    Line line;
    @BeforeEach
    void setting() {
        points.add(true);
        points.add(true);
        points.add(false);
        line = new Line(points);
    }

    @Test
    void 라인_포인트_수() {
        assertThat(line.getPoints().size()).isEqualTo(points.size());
    }

    @Test
    void 라인_포인트대로_잘_세팅() {
        assertThat(Arrays.equals(points.toArray(), line.getPoints().toArray()))
                .isTrue();
    }


}

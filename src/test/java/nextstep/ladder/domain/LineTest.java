package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void create() {
        assertThatCode(() -> Line.from(5)).doesNotThrowAnyException();
    }

    @Test
    void points() {
        List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(true);
        points.add(false);

        assertThat(Line.from(5).points()).isEqualTo(points);
    }
}

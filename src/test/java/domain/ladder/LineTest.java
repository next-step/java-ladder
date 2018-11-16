package domain.ladder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 포인트생성_개수() {
        assertThat(asList(Boolean.FALSE, Boolean.TRUE)).hasSize(2);
    }

    @Test
    public void 이동여부() {
        List<Boolean> points = Arrays.asList(true, false, true);
        Line line = new Line(points);
        assertThat(line.rightMove(3)).isFalse();
        assertThat(line.rightMove(2)).isTrue();
    }
}
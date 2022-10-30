package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    public void Line_랜덤생성() {
        Line line = Line.of(4);
        assertThat(line.getPoints().size()).isEqualTo(4);
    }

    @Test
    public void Line_수동생성_true() {
        Line line = Line.of(4);
        List<Boolean> points = line.getPoints().stream()
                .map(point -> point.isExist())
                .collect(Collectors.toList());
        assertThat(points).containsAll(Arrays.asList(true, true, true, true));
    }

    @Test
    public void Line_수동생성_false() {
        Line line = Line.of(4);
        List<Boolean> points = line.getPoints().stream()
                .map(point -> point.isExist())
                .collect(Collectors.toList());
        assertThat(points).containsAll(Arrays.asList(false, false, false, false));
    }
}
package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 라인 테스트")
public class LineTest {

    @DisplayName("사다리 라인 생성 테스트")
    @Test
    public void createLine() {
        Line line = Line.withPerson(4);

        List<Boolean> points = line.getPoints();

        IntStream.range(0, 4).forEach(i -> {
            if (i == 0 || points.get(i - 1)) {
                assertThat(points.get(i)).isEqualTo(false);
            }
        });
    }
}
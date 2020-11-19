package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 라인 테스트")
public class LadderLineTest {

    @DisplayName("사다리 라인 생성 테스트")
    @Test
    public void createLine() {
        LadderLine ladderLine = LadderLine.ofWidth(4);

        List<Point> points = ladderLine.getPoints();

        IntStream.range(0, 4).forEach(i -> {
            if (i == 0 || points.get(i - 1).hasLeft()) {
                assertThat(points.get(i).hasLeft()).isEqualTo(false);
            }
        });
    }

    @DisplayName("사다리 라인 이동")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "4:4"}, delimiter = ':')
    public void followLine(int startPoint, int expectedEndPoint) {
        LadderLine ladderLine = LadderLine.of(Arrays.asList(false, true, false, true, false));

        int endPoint = ladderLine.followFrom(startPoint);

        assertThat(endPoint).isEqualTo(expectedEndPoint);
    }
}
package rick.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class PointsTest {

    @Test
    @DisplayName("LineCreationStrategy를 통한 연속되는 이동가능한 포인트가 있는 라인 생성")
    void createWithLineCreationStrategy() {
        List<Point> consecutiveMovablePoints = Arrays.asList(
            new Point(false, true), new Point(true, true), new Point(true, false)
        );

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Points(consecutiveMovablePoints));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, empty 문자열")
    void nullAndEmptySource(final List<Point> points) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Points(points));
    }
}

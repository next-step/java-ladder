package rick.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class LineTest {

    @ParameterizedTest
    @DisplayName("LineCreationStrategy를 통한 연속되는 이동가능한 포인트가 있는 라인 생성")
    @CsvSource(value = {"true:true:true", "true:true:false", "false:true:true"}, delimiter = ':')
    void createWithLineCreationStrategy(boolean point1, boolean point2, boolean point3) {
        List<Point> consecutiveMovablePoints = Arrays.asList(
            new Point(point1), new Point(point2), new Point(point3)
        );

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Line(4, (count) -> consecutiveMovablePoints));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, empty 문자열")
    void nullAndEmptySource(final List<Point> points) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Line(points));
    }
}

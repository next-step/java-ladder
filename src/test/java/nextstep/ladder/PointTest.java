package nextstep.ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @ParameterizedTest
    @CsvSource({
            "true, HAS_LINE",
            "false, NO_LINE"
    })
    void testCreation(boolean hasLine, Point point) {
        Point result = Point.of(hasLine);
        assertThat(result).isEqualTo(point);
    }
}

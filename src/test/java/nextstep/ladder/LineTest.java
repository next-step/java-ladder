package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LineTest {

    @Test
    @DisplayName("팩토리 메소드 정상 작동")
    void create() {
        Line line = Line.of(asPointList(true, false, true));
        assertNotNull(line);
    }

    @Test
    @DisplayName("팩토리 메소드 예외 발생")
    void create_validate() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(new ArrayList<>()));
    }

    private static List<Point> asPointList(Boolean... points) {
        return Arrays.stream(points)
                .map(Point::of)
                .collect(Collectors.toList());
    }
}

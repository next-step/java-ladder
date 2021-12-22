package rick.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("true만 반환하는 PointCreationStrategy를 이용한 생성")
    void createWithTrue() {
        Line expected = new Line(Arrays.asList(true, false, true));
        assertThat(new Line(4, () -> true))
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("false만 반환하는 PointCreationStrategy를 이용한 생성")
    void createWithFalse() {
        Line expected = new Line(Arrays.asList(false, false, false));
        assertThat(new Line(4, () -> false))
            .isEqualTo(expected);
    }
}

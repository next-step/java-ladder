package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(booleans = {true, false})
    void 초기값_false(boolean param) {
        Line line = new Line(1, () -> param);
        Line targetLine = new Line(Arrays.asList(false));
        assertThat(line).isEqualTo(targetLine);
    }

    @Test
    void true뒤_false() {
        Line line = new Line(3, () -> true);
        Line targetLine = new Line(Arrays.asList(
                false, true, false
        ));
        assertThat(line).isEqualTo(targetLine);
    }

    @Test
    void 모두_false_확인() {
        Line line = new Line(3, () -> false);
        Line targetLine = new Line(Arrays.asList(
                false, false, false
        ));
        assertThat(line).isEqualTo(targetLine);
    }
}

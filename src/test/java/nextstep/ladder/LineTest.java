package nextstep.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void create() {
        Line line = new Line(4, Arrays.asList(true, true, true));
        assertThat(line.points().size()).isEqualTo(4 - 1);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false", "2:true"}, delimiter = ':')
    void 라인이_겹치지_않는지_확인(int i, boolean point) {
        Line line = new Line(4, Arrays.asList(true, true, true));
        assertThat(line.points().get(i)).isEqualTo(point);
    }
}

package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @ParameterizedTest
    @CsvSource(value = {"false:true:RIGHT", "true:false:LEFT", "false:false:DOWN"}, delimiter = ':')
    void 방향(boolean previous, boolean current, String result) {
        Point point = new Point(previous, current);
        assertThat(point.nextDirection()).isEqualTo(Direction.valueOf(result));
    }

    @Test
    void 허용_불가능_값() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Point(true, true);
                });
    }
}
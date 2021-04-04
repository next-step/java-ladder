package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @ParameterizedTest
    @DisplayName(value = "좌표 방향")
    @CsvSource(value = {"false:true:RIGHT", "true:false:LEFT", "false:false:DOWN"}, delimiter = ':')
    void nextDirection(boolean previous, boolean current, String result) {
        Point point = new Point(previous, current);
        assertThat(point.nextDirection()).isEqualTo(Direction.valueOf(result));
    }

    @Test
    @DisplayName(value = "좌표 생성 인자 유효성 검증")
    void pointArgumentsException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Point(true, true);
                }).withMessageMatching("유효하지 않은 입력값 입니다.");
    }
}
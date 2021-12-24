package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Line line = Line.of(2, () -> true);

        assertThat(line).isNotNull();
    }

    @DisplayName("좌우가 이어진 사다리의 가로 한줄에서의 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:3", "3:2", "5:4", "4:5"}, delimiter = ':')
    void moveLine(int currentPoint, int result) {
        // 사다리 모양
        // |-| |-| |-|
        Line line = Line.of(7, () -> true);

        assertThat(line.move(currentPoint)).isEqualTo(result);
    }

    @DisplayName("이어지지 않은 사다리의 가로 한줄에서의 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5", "6:6"}, delimiter = ':')
    void moveNotLine(int currentPoint, int result) {
        // 사다리 모양
        // | | | | | |
        Line line = Line.of(7, () -> false);

        assertThat(line.move(currentPoint)).isEqualTo(result);
    }
}

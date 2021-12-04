package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("Ladder 생성 테스트")
    void createLadder() {
        List<Point> points = Arrays.asList(Point.from(Boolean.TRUE), Point.from(Boolean.FALSE), Point.from(Boolean.TRUE));
        List<Line> lines = Arrays.asList(Line.from(points), Line.from(points));

        assertThat(Ladder.from(Lines.from(lines))).isInstanceOf(Ladder.class);
    }

    @ParameterizedTest
    @DisplayName("Ladder 생성 예외 테스트")
    @NullSource
    void createExceptionLadder(Lines lines) {
        assertThatThrownBy(() -> Ladder.from(lines)).isInstanceOf(IllegalArgumentException.class);
    }
}
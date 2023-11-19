package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.function.IntFunction;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("width와 사다리 생성 전략을 이용하여 Line 객체를 만들 수 있다.")
    void testLineConstructor() {
        //given
        final int width = 5;
        final IntFunction<Boolean> lineBuilderStrategy = idx -> new Random().nextBoolean();

        //when
        final Line line = new Line(width, lineBuilderStrategy);

        //then
        assertThat(line).isNotNull();
    }

    @Test
    @DisplayName("Line이 생성될 때, 연달아 true가 나오는 경우가 없다.")
    void testLineCreationForNoConsecutiveTrueValues() {
        //given
        final int width = 5;
        final IntFunction<Boolean> lineBuilderStrategy = idx -> true;

        //when
        final Line line = new Line(width, lineBuilderStrategy);
        final List<Boolean> points = line.getPoints();

        //then
        assertThat(points).isNotEmpty();

        for (int i = 1; i < points.size(); i++) {
            assertThat(points.get(i - 1) && points.get(i)).isFalse();
        }
    }
}

package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.IntFunction;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("width와 사다리 생성 전략을 이용하여 Line 객체를 만들 수 있다.")
    void testLadderConstructor() {
        //given
        final int width = 5;
        final IntFunction<Boolean> lineBuilderStrategy = idx -> new Random().nextBoolean();

        //when
        final Line line = new Line(width, lineBuilderStrategy);

        //then
        assertThat(line).isNotNull();
    }
}

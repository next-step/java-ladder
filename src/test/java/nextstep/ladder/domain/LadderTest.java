package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("Ladder 가 잘 생성되는지")
    void Ladder() {
        // given
        final int size = 4;
        final int height = 5;
        final List<Line> lines = IntStream.range(0, height)
                .mapToObj(number -> LineFactory.createLine(size))
                .collect(Collectors.toList());
        // when
        final Ladder actual = Ladder.from(lines);
        // then
        assertThat(actual)
                .isInstanceOf(Ladder.class)
                .hasSize(height);
    }
}
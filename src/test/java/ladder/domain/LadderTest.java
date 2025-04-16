package ladder.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.exception.LadderInvalidException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    @DisplayName("사다리의 라인이 비어있지 않으면 정상적으로 생성된다")
    void getHeight_ReturnsLinesSize() {
        List<Line> lines = List.of(
            new Line(List.of(false, true)),
            new Line(List.of(true, false)),
            new Line(List.of(false, true)));

        Ladder ladder = new Ladder(lines);

        assertThat(ladder.getHeight()).isEqualTo(3);
    }

    @Test
    @DisplayName("사다리의 라인이 비어있으면 예외를 던진다")
    void constructor_WhenLinesIsEmpty_ThrowsException() {
        List<Line> emptyLines = List.of();

        assertThatThrownBy(() -> new Ladder(emptyLines))
            .isInstanceOf(LadderInvalidException.class);
    }
}

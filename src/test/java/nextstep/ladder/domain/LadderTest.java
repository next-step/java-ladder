package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LadderTest {
    @Test
    @DisplayName("라인 크기가 다르면 예외가 발생한다")
    void lineSizeException() {
        Line line1 = new Line();
        Line line2 = new Line();
        line1.add(() -> true);
        line1.add(() -> true);
        line2.add(() -> true);
        assertThatThrownBy(() -> new Ladder(List.of(line1, line2))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인 사이즈가 다른 것이 존재합니다.");
    }

    @Test
    @DisplayName("라인이 비어있으면 예외가 발생한다")
    void lineEmptyException() {
        assertThatThrownBy(() -> new Ladder(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Ladder 객체가 비어있습니다.");
    }
}

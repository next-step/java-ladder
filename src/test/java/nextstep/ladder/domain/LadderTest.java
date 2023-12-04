package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Ladder 는 아무런 라인이 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(List<Line> blankLists) {
        assertThatThrownBy(
                () -> new Ladder(blankLists)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move_success() {
        Brace firstLine_brace1 = new Brace(Point.FALSE, Point.TRUE);
        Brace firstLine_brace2 = new Brace(Point.TRUE, Point.FALSE);
        Brace firstLine_brace3 = new Brace(Point.FALSE, Point.FALSE);
        Brace firstLine_brace4 = new Brace(Point.FALSE, Point.FALSE);
        Line firstLine = new Line(List.of(firstLine_brace1, firstLine_brace2, firstLine_brace3, firstLine_brace4));
        assertThat(firstLine.move(0)).isEqualTo(1);
        assertThat(firstLine.move(1)).isEqualTo(0);
        assertThat(firstLine.move(2)).isEqualTo(2);
        assertThat(firstLine.move(3)).isEqualTo(3);
    }
}

package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @Test
    @DisplayName("사람은 2명 미만일 수 없다")
    public void invalidCountOfPerson() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(1, new RandomAmongAllNonAdjacentCombinationLineStrategy()));
    }

    @Test
    @DisplayName("오른쪽으로 이동한다")
    public void move_right() {
        Line line = new Line(List.of(true, false));
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽으로 이동한다")
    public void move_left() {
        Line line = new Line(List.of(true, false));
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("이동하지 않는다")
    public void move_not() {
        Line line = new Line(List.of(true, false));
        assertThat(line.move(2)).isEqualTo(2);
    }
}
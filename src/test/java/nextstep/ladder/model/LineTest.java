package nextstep.ladder.model;

import nextstep.ladder.exception.LadderLengthException;
import nextstep.ladder.model.ladder.Line;
import nextstep.ladder.model.ladder.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    @DisplayName("사다리 최소 길이 예외 처리")
    void minimum() {
        assertThatThrownBy(() -> Line.init(1)).isExactlyInstanceOf(LadderLengthException.class);
    }

    @Test
    void init() {
        int countOfPerson = 5;
        assertThat(Line.init(countOfPerson).points()).hasSize(countOfPerson);
    }

    @Test
    void move() {
        Point point = Point.first(TRUE);
        assertThat(Line.init(List.of(point, point.last())).move(0)).isEqualTo(1);
    }
}

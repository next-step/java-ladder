package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("최소 지점이 2개 미만일떄 에러를 반환한다.")
    @Test
    void minpointSizeException() {
        List<Direction> directions = List.of(Direction.first(true));

        assertThatThrownBy(() -> {
            new Line(directions);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("마지막 사다리가 오른쪽 연결 값이 있으면 에러를 반환한다.")
    @Test
    void lastIndexLineException() {
        List<Direction> directions = List.of( Direction.first(false), new Direction(false, true) );

        assertThatThrownBy(() -> {
            new Line(directions);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
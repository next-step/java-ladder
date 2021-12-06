package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("방향값 생성")
    void create() {
        Direction direction = new Direction(false, false);
        assertThat(direction).isEqualTo(new Direction(false, false));
    }

    @Test
    @DisplayName("사람 수만큼 Direction 객체 생성 후 리스트 반환")
    void list() {
        List<Direction> directions = Direction.of(4);
        assertThat(directions).size().isEqualTo(4);
    }

}
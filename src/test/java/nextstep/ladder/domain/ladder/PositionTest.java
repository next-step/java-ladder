package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class PositionTest {

    @Test
    @DisplayName("위치 생성 테스트")
    void create() {
        assertThatCode(() -> new Position(Direction.LEFT)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("current 메소드 실행 테스트")
    void current() {
        Position position = new Position(Direction.LEFT);
        assertThat(position.currentDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("next 메소드 실행 테스트")
    void next() {
        Position position = new Position(Direction.RIGHT);
        Position nextPosition = position.next(() -> true);
        assertThat(nextPosition.currentDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("last 메소드 실행 테스트")
    void last() {
        Position position = new Position(Direction.RIGHT);
        assertThat(position.last()).isEqualTo(new Position(Direction.LEFT));
    }
}

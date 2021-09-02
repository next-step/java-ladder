package ladderrefactoring.domain.ladder;

import ladderrefactoring.exception.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    @DisplayName("Direction 생성")
    void create() {
        // when
        Direction direction = new Direction(true, false);

        // then
        assertThat(direction).isEqualTo(new Direction(true, false));
    }

    @Test
    @DisplayName("Direction 생성 실패 : true, true")
    void create_fail() {
        // when, then
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(CustomException.class);
    }
}
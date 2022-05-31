package ladder.domain;

import ladder.exception.NotFoundResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionGroupTest {

    @Test
    void invalidCreate() {
        assertThatThrownBy(() -> new PositionGroup(null, Positions.createResults(new String[]{"1000"})))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PositionGroup(Positions.createPlayers(new String[]{"tom"}), null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PositionGroup(null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Players 중에 Position 이 FIXED 가 아닌 경우가 포함되면 예외를 반환한다.")
    void name() {
        PositionGroup positionGroup = new PositionGroup(Positions.createPlayers(new String[]{"Tim", "Paul"}), Positions.createResults(new String[]{"1000", "꽝"}));

        assertThatThrownBy(() -> positionGroup.result(new Name("Tim")))
                .isInstanceOf(NotFoundResultException.class);
        assertThatThrownBy(() -> positionGroup.resultAll())
                .isInstanceOf(NotFoundResultException.class);
    }
}
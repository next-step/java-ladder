package ladder.domain;

import ladder.exception.NotFoundResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ElementGroupTest {

    @Test
    void invalidCreate() {
        assertThatThrownBy(() -> new ElementGroup(null, Elements.createResults(new String[]{"1000"})))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ElementGroup(Elements.createPlayers(new String[]{"tom"}), null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ElementGroup(null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Players 중에 Position 이 FIXED 가 아닌 경우가 포함되면 예외를 반환한다.")
    void name() {
        ElementGroup elementGroup = new ElementGroup(Elements.createPlayers(new String[]{"Tim", "Paul"}), Elements.createResults(new String[]{"1000", "꽝"}));

        assertThatThrownBy(() -> elementGroup.result(new Name("Tim")))
                .isInstanceOf(NotFoundResultException.class);
        assertThatThrownBy(() -> elementGroup.resultAll())
                .isInstanceOf(NotFoundResultException.class);
    }
}
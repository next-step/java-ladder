package nextstep.ladder.domain.factory;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderFactoryTest {

    private Players players = Players.newInstance(
            Arrays.asList(
                    Player.newInstance("a", 0),
                    Player.newInstance("b", 1))
    );

    @DisplayName("사용자 목록이 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLineIfLessThan2Count() {
        assertThatThrownBy(() -> LadderFactory.create(null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLineIfHeightIsNull() {
        assertThatThrownBy(() -> LadderFactory.create(this.players, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리를 생성할 수 있다.")
    @Test
    void canCreateLine() {
        assertThat(LadderFactory.create(this.players, Height.newInstance(5))).isInstanceOf(Ladder.class);
    }
}

package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 생성, 사다리의 총 길이 및 사용자 수만큼의 Line 확인")
    void ladder() {
        Players players = Players.from("a,b,c");
        Height height = new Height(5);
        MoveStrategy moveStrategy = new DirectionMoveStrategy();

        Ladder ladder = new Ladder(players.size(), height.getHeight(), moveStrategy);

        assertThat(ladder.getLadder().stream().findFirst().get().size()).isEqualTo(players.size());
        assertThat(ladder.getLadder().size()).isEqualTo(height.getHeight());

    }
}
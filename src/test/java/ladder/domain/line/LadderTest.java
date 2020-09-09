package ladder.domain.line;

import ladder.domain.player.Players;
import ladder.domain.point.Position;
import ladder.domain.strategy.PointStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("Ladder 객체 생성 테스트")
    @Test
    void createLadderTest() {
        Players players = Players.ofNames("pobi,honux,crong,jk");
        Height height = Height.of(5);
        PointStrategy pointStrategy = () -> false;

        Ladder ladder = Ladder.of(players.size(), height, pointStrategy);

        assertThat(ladder).isEqualTo(Ladder.of(players.size(), height, pointStrategy));
    }

    @DisplayName("Ladder 이동 테스트")
    @Test
    void moveTest() {
        Players players = Players.ofNames("pobi,honux,crong,jk");
        Height height = Height.of(5);
        PointStrategy pointStrategy = () -> false;

        Ladder ladder = Ladder.of(players.size(), height, pointStrategy);

        assertThat(ladder.move(Position.of(0)).location()).isZero();
    }
}
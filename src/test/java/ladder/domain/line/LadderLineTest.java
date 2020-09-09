package ladder.domain.line;

import ladder.domain.player.Players;
import ladder.domain.strategy.PointStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @DisplayName("LadderLine 객체 생성 테스트")
    @Test
    void createLadderLineTest() {
        Players players = Players.ofNames("pobi,honux,crong,jk");
        PointStrategy pointStrategy = () -> false;

        LadderLine ladderLine = LadderLine.of(players.size(), pointStrategy);

        assertThat(ladderLine).isEqualTo(LadderLine.of(players.size(), pointStrategy));
    }

    @Test
    void move() {
        Players players = Players.ofNames("pobi,honux,crong,jk");
        PointStrategy pointStrategy = () -> false;

        LadderLine ladderLine = LadderLine.of(players.size(), pointStrategy);

        assertThat(ladderLine.move(0)).isZero();
    }
}

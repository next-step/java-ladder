package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @DisplayName("사다리 높이 테스트")
    @Test
    void getLadderHeightSize() {
        assertThat(new Ladder(5, 2).getLineHeight()).isEqualTo(5);
    }

    @DisplayName("사다리 타기 결과 테스트")
    @Test
    void getResultPositionTest() {

        Players players = new Players("iu,iu2,iu3,iu4");
        Ladder ladder = new Ladder(3, players.getPlayerCount());
        ladder.playLadderGame(players);

        String reulstsString = "꽝,꽝,5000원,5000";
        Rewards rewards = new Rewards(reulstsString);

        for(Position p : players.getPlayerResultPosition()) {
            int playerPositionIndex = players.getPlayerByPosition(Position.of(p.getIndex()))
                                        .getPosition()
                                        .getIndex();
            int expectedPositionIndex = rewards.getResultByPositionIndex(p.getIndex())
                                        .getPosition()
                                        .getIndex();
            assertThat(playerPositionIndex).isEqualTo(expectedPositionIndex);
        }
    }
}

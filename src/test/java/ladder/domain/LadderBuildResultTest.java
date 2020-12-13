package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderBuildResultTest {

    private Players players;
    private Ladder ladder;

    @BeforeEach
    public void init(){

        String[] playNames = {"AAA", "BBB", "CCC"};
        players = new Players(playNames);

        ladder = new Ladder(players.getPlayers().size(), 5);
    }

    @DisplayName("Ladder 생성 테스트")
    @Test
    void ladderGameResultCreationTest(){
        // given
        LadderBuildResult line = new LadderBuildResult(ladder, players);
        // then
        assertThat(line.getPlayers()).isEqualTo(players);

        assertThat(line.getLadder()).isEqualTo(ladder);
    }
}

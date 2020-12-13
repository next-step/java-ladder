package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderBuildResultTest {

    private Players players;
    private Ladders ladders;

    @BeforeEach
    public void init(){

        String[] playNames = {"AAA", "BBB", "CCC"};
        players = new Players(playNames);

        List<Ladder> ladderList = new ArrayList<>();
        ladderList.add(new Ladder(1));

        ladders = new Ladders(ladderList);
    }

    @DisplayName("Ladder 생성 테스트")
    @Test
    void ladderGameResultCreationTest(){
        // given
        LadderBuildResult line = new LadderBuildResult(ladders, players);
        // then
        assertThat(line.getPlayers()).isEqualTo(players);

        assertThat(line.getLadders()).isEqualTo(ladders);
    }
}

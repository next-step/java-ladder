package nextstep.ladder.domain;

import static nextstep.ladder.domain.LadderBarStatus.BAR;
import static nextstep.ladder.domain.LadderBarStatus.EMPTY;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.dto.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    class ManualLadderBarStatusDecider implements LadderBarStatusDecider {
        int counter = 0;
        @Override
        public LadderBarStatus decide(LadderBarStatus ladderBarStatus) {
            LadderBarStatus[] ladderBarStatuses = {BAR, EMPTY, BAR, EMPTY, BAR, EMPTY};
            List<LadderBarStatus> ladderBarStatusList = new ArrayList<>(List.of(ladderBarStatuses));

            return ladderBarStatusList.get(counter++);
        }
    }

    @Test
    @DisplayName("play() : PlayerNames와 Reward를 받아 게임 결과를 가진 Winner를 반환한다")
    void play() {
        LadderPoints ladderPoints = LadderPoints.of(2, 4, new ManualLadderBarStatusDecider());
        PlayerNames playerNames = new PlayerNames(new String[]{"pobi", "honux", "crong", "jk"});
        Rewards rewards = new Rewards(new String[]{"꽝", "5000", "쭈", "3000"});
        Ladder ladder = new Ladder(ladderPoints);

        Players players = ladder.play(playerNames, rewards.toMap());

        assertAll(
            () -> assertThat(players.get(0).getPlayerName().getName()).isEqualTo("pobi"),
            () -> assertThat(players.get(0).getResult()).isEqualTo("쭈"),

            () -> assertThat(players.get(1).getPlayerName().getName()).isEqualTo("honux"),
            () -> assertThat(players.get(1).getResult()).isEqualTo("꽝"),

            () -> assertThat(players.get(2).getPlayerName().getName()).isEqualTo("crong"),
            () -> assertThat(players.get(2).getResult()).isEqualTo("3000"),

            () -> assertThat(players.get(3).getPlayerName().getName()).isEqualTo("jk"),
            () -> assertThat(players.get(3).getResult()).isEqualTo("5000")
        );
    }

}
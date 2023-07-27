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

    class ManualLadderBarStatusDecider2 implements LadderBarStatusDecider {
        int counter = 0;
        @Override
        public LadderBarStatus decide(LadderBarStatus ladderBarStatus) {
            LadderBarStatus[] ladderBarStatuses = {EMPTY, EMPTY, EMPTY, BAR, EMPTY, BAR, EMPTY, EMPTY, EMPTY, BAR, EMPTY, BAR, EMPTY, BAR, EMPTY};
            List<LadderBarStatus> ladderBarStatusList = new ArrayList<>(List.of(ladderBarStatuses));

            return ladderBarStatusList.get(counter++);
        }
    }

    @Test
    @DisplayName("play() : PlayerNames와 Reward를 받아 게임 결과를 가진 Winner를 반환한다")
    void play() {
        LadderPoints ladderPoints = LadderPoints.of(2, 4, new ManualLadderBarStatusDecider());
        Ladder ladder = new Ladder(ladderPoints);

        MatchingResult matchingResult = ladder.play();

        assertAll(
            () -> assertThat(matchingResult.getResult(0)).isEqualTo(2),
            () -> assertThat(matchingResult.getResult(1)).isEqualTo(0),
            () -> assertThat(matchingResult.getResult(2)).isEqualTo(3),
            () -> assertThat(matchingResult.getResult(3)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("play2() : PlayerNames와 Reward를 받아 게임 결과를 가진 Winner를 반환한다")
    void play2() {
        LadderPoints ladderPoints = LadderPoints.of(5, 4, new ManualLadderBarStatusDecider2());
        Ladder ladder = new Ladder(ladderPoints);

        MatchingResult matchingResult = ladder.play();

        assertAll(
            () -> assertThat(matchingResult.getResult(0)).isEqualTo(0),
            () -> assertThat(matchingResult.getResult(1)).isEqualTo(2),
            () -> assertThat(matchingResult.getResult(2)).isEqualTo(1),
            () -> assertThat(matchingResult.getResult(3)).isEqualTo(3)
        );
    }
}
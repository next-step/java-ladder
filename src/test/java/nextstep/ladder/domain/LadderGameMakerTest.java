package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.LadderFactory;
import nextstep.ladder.domain.ladder.RandomLineFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameMakerTest {

    @Test
    @DisplayName("참가자 수와 보상의 수가 맞지 않으면 예외 처리한다.")
    void throwExceptionIfSizeNotEqualBetweenPlayersAndRewards() {
        List<String> playerNames = Arrays.asList("crong", "honux", "jk");
        List<String> rewardStrings = Arrays.asList("꽝", "3000", "5000", "꽝");

        LadderGameMaker ladderGameMaker = new LadderGameMaker(new LadderFactory(new RandomLineFactory()));

        assertThatThrownBy(() -> ladderGameMaker.makeRandomLadderGame(playerNames, rewardStrings, 1))
            .isInstanceOf(RuntimeException.class);
    }
    

}

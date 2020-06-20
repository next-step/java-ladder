package ladder.domain.ladder;

import ladder.domain.player.Players;
import ladder.domain.result.LadderResults;
import ladder.domain.result.MatchResult;
import ladder.domain.strategy.RandomLineStrategy;
import ladder.domain.strategy.TrueLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LadderGameTest {

    @ParameterizedTest
    @DisplayName("모든 참가자의 결과 반환 객체 확인")
    @CsvSource(value = {"2:2:a,b:1,2", "3:3:a,b,c:1,2,3", "5:5:a,b,c,d,e:1,2,3,4,5"}, delimiter = ':')
    void findAllResultWithRandomStrategy(int countOfPerson, int ladderHeight, String playersInput, String resultInput) {
        LadderGame ladderGame = new LadderGame(Ladder.of(countOfPerson, ladderHeight, new RandomLineStrategy()));
        Players players = Players.of(playersInput);
        LadderResults ladderResults = LadderResults.of(resultInput, players);

        MatchResult result = ladderGame.findAllPosition(players, ladderResults);

        assertThat(result.size()).isEqualTo(countOfPerson);
    }

    @Test
    @DisplayName("특정 참가자 한명의 결과값")
    void findOneResult() {
        LadderGame ladderGame = new LadderGame(Ladder.of(2,2, new TrueLineStrategy()));
        Players players = Players.of("a,b");

        int result = ladderGame.findResultPosition(0);

        assertThat(result).isEqualTo(0);
    }
}

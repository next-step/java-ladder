package ladder.domain.ladder;

import ladder.domain.player.Players;
import ladder.domain.result.LadderResults;
import ladder.domain.result.MatchResult;
import ladder.domain.strategy.RandomLineStrategy;
import ladder.domain.strategy.TrueLineStrategy;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        int ladderHeight = 5;

        Ladder ladder = Ladder.of(5, ladderHeight, new TrueLineStrategy());

        assertThat(ladder).isInstanceOf(Ladder.class);
    }

    @Test
    @DisplayName("사다리 높이가 음수일 때 예외 발생")
    void throwExceptionWhenNegativeInput() {
        int ladderHeight = -1;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Ladder.of(5, ladderHeight, new TrueLineStrategy());
        }).withMessageMatching("Ladder height must be positive.");
    }

    @ParameterizedTest
    @DisplayName("모든 참가자의 결과 반환 객체 확인")
    @CsvSource(value = {"2:2:a,b:1,2", "3:3:a,b,c:1,2,3", "5:5:a,b,c,d,e:1,2,3,4,5"}, delimiter = ':')
    void findAllResultWithRandomStrategy(int countOfPerson, int ladderHeight, String playersInput, String resultInput) {
        Ladder ladder = Ladder.of(countOfPerson, ladderHeight, new RandomLineStrategy());
        Players players = Players.of(playersInput);
        LadderResults ladderResults = LadderResults.of(resultInput, players);

        MatchResult result = ladder.getGameResult(players, ladderResults);

        AssertionsForClassTypes.assertThat(result.size()).isEqualTo(countOfPerson);
    }
}

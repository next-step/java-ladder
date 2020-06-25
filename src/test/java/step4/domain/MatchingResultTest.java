package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MatchingResultTest {

    @DisplayName("목록에 있는 사람 입력시")
    @Test
    void getMatchedWinningPrizeOrederByPlayerName() {

        String input = "named";
        HashMap<Player, String> test = new HashMap<>();
        test.put(new Player("named"), "1등");
        MatchingResult matchingResult = new MatchingResult(test);
        assertThat(matchingResult.getMatchedWinningPrizeOrederByPlayerName(input)).isEqualTo("1등");

    }

    @DisplayName("목록에 없는 사람 입력시")
    @Test
    void getMatchedWinningPrizeOrederByPlayerNameWithError() {

        assertThatIllegalArgumentException().isThrownBy(() ->
        {
            String input = "failName";
            HashMap<Player, String> test = new HashMap<>();
            test.put(new Player("named"), "1등");
            test.put(new Player("AnyNamed"), "2등");
            MatchingResult matchingResult = new MatchingResult(test);
            matchingResult.getMatchedWinningPrizeOrederByPlayerName(input);
        });

    }

}

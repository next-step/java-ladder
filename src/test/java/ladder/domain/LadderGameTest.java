package ladder.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk pobi:0", "pobi,honux,crong crong:2", "pobi,honux pobi:0"}, delimiter = ':')
    void userLadderClaimTest(String input, String expected) {
        String[] inputs = input.split(" ");
        Users users = Users.of(inputs[0]);
        LadderMap ladderMap = LadderMap.of(users, 4, () -> true);

        LadderGame ladderGame = LadderGame.of(users, ladderMap);
        int result = ladderGame.userClaim(inputs[1]);

        assertThat(result).isEqualTo(Integer.parseInt(expected));
    }
}

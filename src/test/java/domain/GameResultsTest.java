package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {

    @DisplayName("전체 결과를 생성한다.")
    @Test
    void test01() {
        GameResults results = GameResults.createResults(LadderTest.L1, PlayersTest.PS1, RewardsTest.RS1);
        assertThat(results).isNotNull();
    }
}

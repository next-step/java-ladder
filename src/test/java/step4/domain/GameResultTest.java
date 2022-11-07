package step4.domain;

import org.junit.jupiter.api.Test;
import step4.domain.GameResult;
import step4.domain.Ladders;
import step4.domain.Results;
import step4.domain.Users;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void 이름으로_입력했을_때_게임결과_계산() {
        Users users = new Users(List.of("pobi", "jake", "ilil"));
        Results results = new Results(List.of("꽝", "당첨", "꽝"), users.getUserCounts());
        Ladders ladder = new Ladders(3, users.getUserCounts(), index -> {
            if (index % 2 == 0) {
                return true;
            }
            return false;
        });
        String selectedPerson = "pobi";

        assertThat(new GameResult(users, results, ladder).getGameResults().get(selectedPerson)).isEqualTo("당첨");
    }
}

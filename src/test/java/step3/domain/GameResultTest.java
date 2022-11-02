package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    void 이름으로_입력했을_때_게임결과_계산() {
        Users users = new Users(List.of("pobi", "jake", "ilil"));
        Ladder ladder = new Ladder(3, users.getUserCounts(), index -> {
            if (index % 2 == 0) {
                return true;
            }
            return false;
        });
        String selectedPerson = "pobi";

        assertThat(new GameResult(selectedPerson, users, ladder).getResults().get(0)).isEqualTo(1);
    }

    @Test
    void 전체를_입력했을_때_게임결과_계산() {
        Users users = new Users(List.of("pobi", "jake", "ilil"));
        Ladder ladder = new Ladder(3, users.getUserCounts(), index -> {
            if (index % 2 == 0) {
                return true;
            }
            return false;
        });
        String selectedPerson = "all";

        assertThat(new GameResult(selectedPerson, users, ladder).getResults().get(2)).isEqualTo(2);
    }
}
package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    @DisplayName("LadderGame 이 정상적으로 생성된다")
    @Test
    public void createTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        List<LadderResult> ladderResults = LadderResult.of(List.of("꽝","5000","꽝","3000"));
        Ladder ladder = new Ladder(LadderHeight.of(5), users.size());

        LadderGame ladderGame = new LadderGame(users, ladderResults, ladder);

        assertThat(ladderGame).isNotNull();
    }


    @DisplayName("사용자와 사다리 결과의 수가 다를 때 예외를 발생한다.")
    @Test
    public void differentUserCountAndResultCount() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        List<LadderResult> ladderResults = LadderResult.of(List.of("꽝","5000","꽝"));
        Ladder ladder = new Ladder(LadderHeight.of(5), users.size());

        assertThatThrownBy(() -> {
            new LadderGame(users, ladderResults, ladder);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게인을 진행하고 검사결과를 리턴한다.")
    @Test
    public void gameStartTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        List<LadderResult> ladderResults = LadderResult.of(List.of("꽝","5000","꽝","3000"));
        Ladder ladder = new Ladder(LadderHeight.of(3), users.size(), () -> true);
        LadderGame ladderGame = new LadderGame(users, ladderResults, ladder);

        LadderResult result = ladderGame.gameStart(User.of("pobi"));

        assertThat(result).isEqualTo(LadderResult.of("5000"));
    }
}

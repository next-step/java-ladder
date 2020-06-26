package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderPrizesTest {

    @DisplayName("LadderResult 가 정상적으로 생성된다")
    public void createTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(3), 4);

        List<LadderPrize> ladderPrizes = LadderPrize.of(List.of("꽝", "5000", "꽝", "3000"));

        LadderPrizes ladderResult = LadderPrizes.of(ladderPrizes, ladder);

        assertThat(ladderResult).isNotNull();
    }

    @DisplayName("사다리의 StartPosition 개수와 사다리 결과 개수가 다르면 IllegalArgument 예외가 발생한다")
    @Test
    public void validateCountTest() {
        List<LadderPrize> ladderPrizes = LadderPrize.of(List.of("꽝", "5000", "꽝"));
        Ladder ladder = new Ladder(LadderHeight.of(3), 4, () -> true);

        assertThatThrownBy(() -> {
            LadderPrizes.of(ladderPrizes, ladder);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 결과를 LadderPrize List 로 변환한다.")
    @Test
    public void getLadderPrizeTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        List<LadderPrize> ladderPrizes = LadderPrize.of(List.of("꽝", "5000", "꽝", "3000"));
        Ladder ladder = new Ladder(LadderHeight.of(3), 4, () -> true);
        LadderPrizes ladderResult = LadderPrizes.of(ladderPrizes, ladder);

        LadderGame ladderGame = new LadderGame(Participants.of(users, ladder), ladder);
        List<Integer> resultsAfterGame = ladderGame.play("all");

        LadderPrizes ladderPrizesAfterGame = LadderPrizes.convert(resultsAfterGame, ladderResult);

        assertThat(ladderPrizesAfterGame.get(0)).isEqualTo(LadderPrize.of("5000"));
        assertThat(ladderPrizesAfterGame.get(1)).isEqualTo(LadderPrize.of("꽝"));
        assertThat(ladderPrizesAfterGame.get(2)).isEqualTo(LadderPrize.of("3000"));
        assertThat(ladderPrizesAfterGame.get(3)).isEqualTo(LadderPrize.of("꽝"));
    }

}

package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderPrizesTest {

    private final Participants participants = Participants.of(List.of("pobi", "honux", "crong", "jk"));
    private final LadderPrizes ladderPrizes = LadderPrizes.of(participants, List.of("꽝", "5000", "꽝", "3000"));

    @DisplayName("LadderPrizes 가 정상적으로 생성된다")
    @Test
    public void createTest() {
        assertThat(ladderPrizes).isNotNull();
        assertThat(ladderPrizes.size()).isEqualTo(4);
    }

    @DisplayName("게임 결과를 LadderPrize List 로 변환한다.")
    @Test
    public void getLadderPrizeTest() {
        Ladder ladder = new Ladder(LadderHeight.of(3), participants, () -> true);

        LadderGame ladderGame = new LadderGame(participants, ladder);
        List<Integer> resultsAfterGame = ladderGame.play("all");

        LadderPrizes ladderPrizesAfterGame = LadderPrizes.convert(resultsAfterGame, ladderPrizes);

        assertThat(ladderPrizesAfterGame.get(0)).isEqualTo(LadderPrize.of("5000"));
        assertThat(ladderPrizesAfterGame.get(1)).isEqualTo(LadderPrize.of("꽝"));
        assertThat(ladderPrizesAfterGame.get(2)).isEqualTo(LadderPrize.of("3000"));
        assertThat(ladderPrizesAfterGame.get(3)).isEqualTo(LadderPrize.of("꽝"));
    }

    @DisplayName("사용자의 수와 Prizes의 수가 다르면 IllegalArgument 예외가 발생한다.")
    @Test
    public void countSameParticipantsAndPrizesTest() {
        Participants participants = Participants.of(List.of("pobi", "honux", "crong", "jk"));

        assertThatThrownBy(() -> {
            LadderPrizes.of(participants, List.of("꽝"));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

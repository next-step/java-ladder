package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    private Participants defaultParticipants = Participants.of(List.of("pobi", "honux", "crong", "jk"));
    private LadderPrizes defaultLadderPrizes = LadderPrizes.of(List.of("꽝", "5000", "꽝", "3000"));

    @DisplayName("모든 사용자의 실행결과가 리턴된다")
    @Test
    public void playAllTest() {
        Ladder ladder = new Ladder(LadderHeight.of(3), defaultParticipants, defaultLadderPrizes, () -> true);
        LadderGame ladderGame = new LadderGame(defaultParticipants, ladder);

        List<Integer> result = ladderGame.play("all");

        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result).containsSequence(1,0,3,2);
    }

    @DisplayName("입력한 사용자의 실행 결과가 리턴된다.")
    @Test
    public void playOnlyOneTest() {
        Ladder ladder = new Ladder(LadderHeight.of(3), defaultParticipants, defaultLadderPrizes, () -> true);
        LadderGame ladderGame = new LadderGame(defaultParticipants, ladder);

        List<Integer> result = ladderGame.play("pobi");

        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result).containsSequence(1);
    }
}

package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    @DisplayName("모든 사용자의 실행결과가 리턴된다")
    @Test
    public void playAllTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(3), 4, () -> true);
        LadderGame ladderGame = new LadderGame(Participants.of(users, ladder), ladder);

        List<Integer> result = ladderGame.play("all");

        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result).containsSequence(1,0,3,2);
    }

    @DisplayName("입력한 사용자의 실행 결과가 리턴된다.")
    @Test
    public void playOnlyOneTest() {
        List<User> users = User.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(LadderHeight.of(3), 4, () -> true);
        LadderGame ladderGame = new LadderGame(Participants.of(users, ladder), ladder);

        List<Integer> result = ladderGame.play("pobi");

        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result).containsSequence(1);
    }
}

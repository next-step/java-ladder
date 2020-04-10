package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static ladder.domain.type.DirectionType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {
    @Test
    void of() {
        LadderGame ladderGame = LadderGame.of("pobi,honux,crong,jk", "5", "꽝,5000,꽝,3000");

        assertThat(ladderGame.getLadder().getLadderLines()).hasSize(5);

        ladderGame.getLadder()
                .getLadderLines()
                .forEach(line -> assertThat(line.getSize()).isEqualTo(4));
    }

    @Test
    void ladderGame_invalidNameSizeException() {
        assertThatThrownBy(() -> LadderGame.of("pobi,honuxx,crong,jk", "5", "꽝,5000,꽝,3000"))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_NAME_SIZE.getErrorMessage());
    }

    @Test
    void ladderGame_invalidResultSizeException() {
        assertThatThrownBy(() -> LadderGame.of("pobi,honux,crong,jk", "5", "꽝,5000,꽝"))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_RESULT_SIZE.getErrorMessage());
    }

    @Test
    void ladderGame() {
        List<LadderLine> ladderLines = Arrays.asList(
                new LadderLine(Arrays.asList(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, DOWN))),
                new LadderLine(Arrays.asList(new Point(0, DOWN), new Point(1, RIGHT), new Point(2, LEFT))),
                new LadderLine(Arrays.asList(new Point(0, RIGHT), new Point(1, LEFT), new Point(2, DOWN))));
        List<String> userNames = Arrays.asList("seulp", "seul", "pobi");
        List<String> rewards = Arrays.asList("꽝", "100억", "1000억");

        LadderGame game = new LadderGame(ladderLines, userNames, rewards);

        List<User> users = game.getUsers().getUsers();

        assertThat(users.get(0).getReward()).isEqualTo(rewards.get(2));
        assertThat(users.get(1).getReward()).isEqualTo(rewards.get(1));
        assertThat(users.get(2).getReward()).isEqualTo(rewards.get(0));
    }
}

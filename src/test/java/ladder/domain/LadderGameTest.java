package ladder.domain;

import ladder.domain.type.ActionType;
import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {
    @Test
    void of() {
        LadderGame ladderGame = LadderGame.of("pobi,honux,crong,jk", "5", "꽝,5000,꽝,3000");

        assertThat(ladderGame.getLadder().getLines()).hasSize(5);

        ladderGame.getLadder()
                .getLines()
                .forEach(line -> assertThat(line.getActionsSize()).isEqualTo(4));
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
        List<Line> lines = Arrays.asList(new Line(Arrays.asList(ActionType.RIGHT, ActionType.LEFT, ActionType.DOWN)),
                new Line(Arrays.asList(ActionType.DOWN, ActionType.RIGHT, ActionType.LEFT)),
                new Line(Arrays.asList(ActionType.RIGHT, ActionType.LEFT, ActionType.DOWN)));
        List<String> userNames = Arrays.asList("seulp", "seul", "pobi");
        List<String> rewards = Arrays.asList("꽝", "100억", "1000억");

        LadderGame game = new LadderGame(lines, userNames, rewards);

        List<User> users = game.getUsers().getUsers();

        assertThat(users.get(0).getReward()).isEqualTo(rewards.get(2));
        assertThat(users.get(1).getReward()).isEqualTo(rewards.get(1));
        assertThat(users.get(2).getReward()).isEqualTo(rewards.get(0));
    }
}

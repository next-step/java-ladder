package ladder;

import ladder.domain.LadderGame;
import ladder.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void generateLadderWhenCreateLadderGame() {
        List<User> users = Arrays.asList("pobi", "crong", "honux", "jk").stream()
                .map(User::new)
                .collect(toList());
        LadderGame ladderGame = new LadderGame(users, 5);

        assertThat(ladderGame.getLadder()).hasSize(5);
    }
}

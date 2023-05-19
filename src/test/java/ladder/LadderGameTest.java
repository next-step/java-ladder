package ladder;

import ladder.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private Ladder ladder;
    private Users users;
    private Rewards rewards;

    @BeforeEach
    void setUp() {
        Line line1 = new Line(List.of(new Point(0, false, false), new Point(1, false, false)));
        Line line2 = new Line(List.of(new Point(0, false, true), new Point(1, true, false)));

        ladder = new Ladder(List.of(line1, line2));
        users = Users.of(List.of("user1", "user2"));
        rewards = Rewards.of(users.size(), List.of("1000", "2000"));
    }

    @Test
    void playResult() {
        LadderGame ladderGame = new LadderGame(ladder, users, rewards);
        List<GameResult> gameResults = ladderGame.play();

        assertThat(gameResults).containsExactly(new GameResult("user1", "2000"), new GameResult("user2", "1000"));
    }
}

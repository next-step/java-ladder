package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("LadderGame 실행 후 게임결과값 정상인지")
    void ladderGame() {
        Ladder ladder = new Ladder(5, 4, new TrueGenerator());
        List<User> testUsers = List.of(
                new User("a"),
                new User("b"),
                new User("c"),
                new User("d")
        );
        Users users = new Users(testUsers);

        LadderGame ladderGame = new LadderGame(users, ladder);
        GameResults gameResults = ladderGame.gameStart();
        List<GameResult> results = gameResults.getGameResults();
        assertThat(results)
                .contains(
                        new GameResult(testUsers.get(0), 1),
                        new GameResult(testUsers.get(1), 0),
                        new GameResult(testUsers.get(2), 3),
                        new GameResult(testUsers.get(3), 2)
                );
    }
}
package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private Lines lines;
    private Users users;
    private static int countOfUser;

    @BeforeEach
    public void setUp() {
        users = new Users(Arrays.asList(new User(new Name("tom"))
                , new User(new Name("garry"))
                , new User(new Name("soyu"))
                , new User(new Name("jake"))));

        countOfUser = users.count();

        List<Line> lineList = new ArrayList<>();

        for (int i = 0; i < countOfUser; i++) {
            Line line = new Line(countOfUser);
            lineList.add(line);
        }
        lines = new Lines(lineList);
    }


    @Test
    @DisplayName("사다리 게임 한사람 결과 확인")
    public void gameResultTest() {

        LadderGame ladderGame = new LadderGame(users, lines);

        users = ladderGame.start();

        assertThat(users.findByName("tom").gameResult()).isEqualTo("꽝");

    }

    @Test
    @DisplayName("사다리 게임 한사람 결과 확인")
    public void gameAllResultTest() {

        LadderGame ladderGame = new LadderGame(users, lines);

        users = ladderGame.start();

        GameResult gameResult = new GameResult(Arrays.asList("꽝", "100", "200", "300"));
        List<String> results = users.gameResults(gameResult);
        assertThat(results).containsExactly("꽝", "100", "200", "300");

    }

}

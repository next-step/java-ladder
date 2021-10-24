package ladder.domain;

import ladder.engine.LadderResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameResultTest {

    private String[] results;
    private Users users;
    private User tom;
    private User jerry;
    private User white;
    private User jane;

    @BeforeEach
    void setUp() {
        results = new String[]{"꽝", "100", "200", "300"};
        tom = new User("tom", 0);
        jerry = new User("jerry", 2);
        white = new User("white", 4);
        jane = new User("jane", 6);

        List<User> userList = Arrays.asList(tom, jerry, white, jane);
        users = new Users(userList);
    }

    @Test
    @DisplayName("한명의 결과를 확인하는 테스트")
    public void gameResultShowTest() {
        GameResult gameResult = new GameResult(results);
        assertAll(
                () -> assertThat(gameResult.show(tom.position())).isEqualTo("꽝"),
                () -> assertThat(gameResult.show(jerry.position())).isEqualTo("100"),
                () -> assertThat(gameResult.show(white.position())).isEqualTo("200"),
                () -> assertThat(gameResult.show(jane.position())).isEqualTo("300")
        );
    }

    @Test
    @DisplayName("All or all을 입력하였을 때 전체 인원의 결과가 잘 나오는지 확인")
    public void gameResultAllTest() {
        GameResult gameResults = new GameResult(results);
        LadderResult ladderResult = new LadderResult();
        ladderResult.put(0, 0);
        ladderResult.put(2, 2);
        ladderResult.put(4, 4);
        ladderResult.put(6, 6);
        Map<String, String> userResults = gameResults.allResults(users,ladderResult);

        assertAll(
                () -> assertThat(userResults.get("tom")).isEqualTo("꽝"),
                () -> assertThat(userResults.get("jerry")).isEqualTo("100"),
                () -> assertThat(userResults.get("white")).isEqualTo("200"),
                () -> assertThat(userResults.get("jane")).isEqualTo("300")
        );
    }
}

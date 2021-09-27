package ladder.domain;

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

    @BeforeEach
    void setUp() {
        results = new String[]{"꽝", "100", "200", "300"};
        User tom = new User("tom", 0);
        User jerry = new User("jerry", 2);
        User white = new User("white", 4);
        User jane = new User("jane", 6);

        List<User> userList = Arrays.asList(tom, jerry, white, jane);
        users = new Users(userList);
    }

    @Test
    @DisplayName("한명의 결과를 확인하는 테스트")
    public void gameResultShowTest() {
        GameResult gameResult = new GameResult(results);
        assertAll(
                () -> assertThat(gameResult.show(0)).isEqualTo("꽝"),
                () -> assertThat(gameResult.show(1)).isEqualTo("100"),
                () -> assertThat(gameResult.show(2)).isEqualTo("200"),
                () -> assertThat(gameResult.show(3)).isEqualTo("300")
        );
    }

    @Test
    @DisplayName("All or all을 입력하였을 때 전체 인원의 결과가 잘 나오는지 확인")
    public void gameResultAllTest() {
        GameResult gameResults = new GameResult(results);
        Map<String, String> userResults = gameResults.allResults(users);

        assertAll(
                () -> assertThat(userResults.get("tom")).isEqualTo("꽝"),
                () -> assertThat(userResults.get("jerry")).isEqualTo("100"),
                () -> assertThat(userResults.get("white")).isEqualTo("200"),
                () -> assertThat(userResults.get("jane")).isEqualTo("300")
        );
    }
}

package nextstep.ladder;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class GameResultTest {

    private final static int USER_NUMBER = 5;
    List<String> results = IntStream.range(0, USER_NUMBER).boxed().map(String::valueOf).collect(Collectors.toUnmodifiableList());

    Users users = new Users(makeUser());

    @Test
    @DisplayName("사다리 게임 결과 생성")
    void testValidLadder() {
        GameResult gameResult = new GameResult(results, users);

        for (int i = 0; i < results.size(); i++) {
            User user = users.getUsers().get(i);
            assertThat(gameResult.getGameResultByUserName(user.getUserName())).isEqualTo(results.get(i));
        }
    }

    @Test
    @DisplayName("사다리 결과와 유저 수가 다른 경우 에러 발생")
    void testNotMatchSize() {
        List<String> invalidResults = IntStream.range(0, USER_NUMBER - 1).boxed().map(String::valueOf).collect(Collectors.toUnmodifiableList());
        assertThatIllegalArgumentException().isThrownBy(() -> new GameResult(invalidResults, users));
    }

    private static List<User> makeUser() {
        return IntStream.range(0, USER_NUMBER).boxed()
                .map(String::valueOf)
                .map(User::new)
                .collect(Collectors.toUnmodifiableList());
    }

}

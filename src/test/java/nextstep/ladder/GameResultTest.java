package nextstep.ladder;

import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameResultTest {
    List<String> results = IntStream.range(0,5).boxed().map(String::valueOf).collect(Collectors.toUnmodifiableList());
    private Ladder ladder = new Ladder(3,4,count -> List.of(true, false, true, false), results);

    Users users = new Users(makeUser());

    @Test
    @DisplayName("")
    void testGameResult() {
        GameResult gameResult = new GameResult(ladder, users);
        assertThat(gameResult.getGameResultByUserName("0")).isEqualTo("1");
        assertThat(gameResult.getGameResultByUserName("1")).isEqualTo("0");
        assertThat(gameResult.getGameResultByUserName("2")).isEqualTo("3");
        assertThat(gameResult.getGameResultByUserName("3")).isEqualTo("2");
        assertThat(gameResult.getGameResultByUserName("4")).isEqualTo("4");
    }

    private static List<User> makeUser() {
        return IntStream.range(0,5).boxed()
                .map(String::valueOf)
                .map(User::new)
                .collect(Collectors.toUnmodifiableList());
    }
}

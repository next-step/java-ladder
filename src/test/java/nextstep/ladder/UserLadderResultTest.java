package nextstep.ladder;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.UserLadderResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLadderResultTest {

    @ParameterizedTest
    @CsvSource(value = {"boss,1000", "pobi,2000"})
    public void getResultTest(String name, String result) {
        List<User> users = Arrays.asList(new User("boss", 0, 0), new User("pobi", 1, 1));
        List<Result> results = Arrays.asList(new Result("1000"), new Result("2000"));
        UserLadderResult userLadderResult = new UserLadderResult(users, results);

        assertThat(userLadderResult.findUserResult(name)).isEqualTo(new Result(result));
    }
}

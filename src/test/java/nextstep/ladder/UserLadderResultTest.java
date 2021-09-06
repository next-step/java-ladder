package nextstep.ladder;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.UserLadderResult;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UserLadderResultTest {

    @Test
    public void getResultTest() {
        List<User> users = Arrays.asList(new User("boss", 0), new User("pobi", 1));
        List<Result> results = Arrays.asList(new Result("1000"), new Result("2000"));
        UserLadderResult userLadderResult = new UserLadderResult(users, results);
    }
}

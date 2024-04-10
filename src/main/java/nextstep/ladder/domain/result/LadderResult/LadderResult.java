package nextstep.ladder.domain.result.LadderResult;

import java.util.Collection;
import nextstep.ladder.domain.lines.Lines;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;

public interface LadderResult {

    void calculateLadderResult(Users users, Lines lines);

    Result findUserResult(User user);

    Collection<User> users();
}


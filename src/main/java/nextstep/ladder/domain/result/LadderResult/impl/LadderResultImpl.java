package nextstep.ladder.domain.result.LadderResult.impl;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import nextstep.ladder.domain.lines.Lines;
import nextstep.ladder.domain.result.LadderResult.LadderResult;
import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.error.exception.LadderUsersMismatchException;
import nextstep.ladder.error.exception.NotExistUserException;

public class LadderResultImpl implements LadderResult {

    private final Map<User, Result> ladderResult = new HashMap<>();
    private Results results;

    public LadderResultImpl(Results results, Users users) {
        if (results.size() != users.size()) {
            throw new LadderUsersMismatchException(results.size(), users.size());
        }

        this.results = results;
    }

    @Override
    public void calculateLadderResult(Users users, Lines lines) {
        IntStream.range(0, users.size())
            .forEach(userIndex -> ladderResult.put(users.findUser(userIndex),
                results.findResult(lines.findUserResultIndex(userIndex))));
    }

    @Override
    public Result findUserResult(User user) {
        return Optional.ofNullable(ladderResult.get(user))
            .orElseThrow(() -> new NotExistUserException(user.getUserName()));
    }

    @Override
    public Set<User> users() {
        return ladderResult.keySet();
    }
}

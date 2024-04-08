package nextstep.ladder.domain.result;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import nextstep.ladder.domain.lines.Lines;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.error.exception.LadderUsersMismatchException;
import nextstep.ladder.error.exception.NotExistUserException;

public class LadderResult {

    private final Map<User, Result> ladderResult = new HashMap<>();
    private Results results;

    public LadderResult(Results results, Users users) {
        if (results.size() != users.size()) {
            throw new LadderUsersMismatchException(results.size(), users.size());
        }

        this.results = results;
    }

    public void calculateLadderResult(Users users, Lines lines) {
        IntStream.range(0, users.size())
            .forEach(userIndex -> ladderResult.put(users.findUser(userIndex),
                results.findResult(lines.findUserResultIndex(userIndex))));
    }

    public Result findUserDrawResult(User user) throws NotExistUserException {
        return Optional.ofNullable(ladderResult.get(user))
            .orElseThrow(() -> new NotExistUserException(user.getUserName()));
    }

    public Set<User> keySet() {
        return ladderResult.keySet();
    }
}

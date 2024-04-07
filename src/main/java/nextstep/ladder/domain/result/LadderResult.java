package nextstep.ladder.domain.result;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import nextstep.ladder.error.exception.LadderUsersMismatchException;
import nextstep.ladder.error.exception.NotExistUserException;

public class LadderResult {

    private final Map<User, Result> ladderResult = new HashMap<>();
    private List<String> draws;

    public LadderResult(List<String> draws, Users users) {
        if (draws.size() != users.size()) {
            throw new LadderUsersMismatchException(draws.size(), users.size());
        }

        this.draws = draws;
    }

    public void calculateLadderResult(Users users, Lines lines) {
        IntStream.range(0, users.size())
            .forEach(userIndex -> ladderResult.put(users.findUser(userIndex),
                new Result(draws.get(lines.findUserResultIndex(userIndex)))));
    }

    public Result findUserDrawResult(User user) throws NotExistUserException {
        return Optional.ofNullable(ladderResult.get(user))
            .orElseThrow(() -> new NotExistUserException(user.getUserName()));
    }

    public Set<User> keySet() {
        return ladderResult.keySet();
    }
}

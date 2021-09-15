package step4.domain.ladder;

import java.util.Map;
import java.util.Objects;
import step4.domain.user.User;
import step4.exception.ladder.LadderResultUserNotFoundException;

public class LadderResult {

    private final Map<User, String> results;

    private LadderResult(Map<User, String> results) {
        this.results = results;
    }

    public static LadderResult of(Map<User, String> results) {
        return new LadderResult(results);
    }

    public String getResultByUser(User user) {
        checkContainsUser(user);

        return results.get(user);
    }

    private void checkContainsUser(User user) {
        if (!results.containsKey(user)) {
            throw new LadderResultUserNotFoundException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

}

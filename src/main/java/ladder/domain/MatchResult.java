package ladder.domain;

import ladder.exception.NotFoundUserException;
import ladder.exception.NotFoundUserNameException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MatchResult {
    private final Map<User, WinningItem> matchResult;

    public MatchResult(Users users, Ladder ladder, WinningItems winningItems) {
        this.matchResult = match(users, ladder, winningItems);
    }

    private Map<User, WinningItem> match(Users users, Ladder ladder, WinningItems winningItems) {
        Map<User, WinningItem> result = new HashMap<>();
        for (int startPosition = 0; startPosition < users.getUsersCount(); startPosition++) {
            int resultPosition = ladder.getResultPosition(startPosition);

            User user = users.getUserToPosition(startPosition);
            WinningItem item = winningItems.getItemToPosition(resultPosition);

            result.put(user, item);
        }
        return result;
    }

    public Map<User, WinningItem> getMatchResult() {
        return Collections.unmodifiableMap(matchResult);
    }

    public WinningItem getMatchResultToUser(User user) {
        try {
            return matchResult.get(user);
        } catch (NotFoundUserException e) {
            throw new NotFoundUserNameException();
        }
    }
}

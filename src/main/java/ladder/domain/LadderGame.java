package ladder.domain;
import java.util.*;

public class LadderGame {
    private final Users users;
    private final Ladder ladder;
    private final GameResult gameResult;

    public LadderGame(Users users, Ladder ladder, GameResult gameResult) {
        this.users = users;
        this.ladder = ladder;
        this.gameResult = gameResult;
    }

    public GameExecutionResult execute() {
        Map<String, String> userResult = new LinkedHashMap<>();
        for (int i = 0; i < users.size(); i++) {
            int resultPosition = ladder.move(i);
            userResult.put(users.getUserByIndex(i).name(), gameResult.getResultByIndex(resultPosition));
        }

        return GameExecutionResult.create(userResult);
    }

}

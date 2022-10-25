package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;

    public LadderGame(Users users, Ladder ladder) {
        this.ladder = ladder;
        this.users = users;
    }

    public List<GameResult> gameStart() {
        List<GameResult> gameResults = new ArrayList<>();
        List<User> userInfos = users.getUsers();
        for (int position = 0; position < users.getSize(); position++) {
            User user = userInfos.get(position);
            int resultPosition = ladder.executeLaddar(position);
            gameResults.add(new GameResult(user, resultPosition));
        }
        return gameResults;
    }
}

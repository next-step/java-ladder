package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static final String USER_GOALS_COUNTS_SHOULD_SAME = "사용자와 사다리결과 숫자는 같아야합니다.";

    private Users users;
    private LadderGame ladderGame;

    public GameResult(Users users, LadderGame ladderGame) {
        if (users.size() != ladderGame.getLadderGoals().size()) {
            throw new IllegalArgumentException(USER_GOALS_COUNTS_SHOULD_SAME);
        }

        this.users = users;
        this.ladderGame = ladderGame;
    }

    public String findPlayerGoal(String name) {
        User user = users.findUser(name);
        int position = moveResult(user);
        return this.ladderGame.getLadderGoals().getResult(position);
    }

    private int moveResult(User user) {
        int position = user.getPosition();
        for (Line line : this.ladderGame.getLadder().getLines()) {
            position += line.move(position);
        }
        return position;
    }

    public Map<String, String> getAll() {
        Map<String, String> results = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            int result = this.ladderGame.getLadder().move(i);
            results.put(users.getUserName(i), this.ladderGame.getLadderGoals().getResult(result));
        }
        return new HashMap<>(results);
    }

    public Users getUsers() {
        return users;
    }

    public LadderGoals getLadderGoals() {
        return ladderGame.getLadderGoals();
    }

    public Ladder getLadder() {
        return ladderGame.getLadder();
    }
}

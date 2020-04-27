package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static final String USER_GOALS_COUNTS_SHOULD_SAME = "사용자와 사다리결과 숫자는 같아야합니다.";

    private Map<String, String> results;
    private Ladder ladder;
    private Users users;
    private LadderGoals ladderGoals;

    public GameResult(Users users, LadderGame ladderGame) {
        this.results = new HashMap<>();
        this.users = users;
        this.ladder = ladderGame.getLadder();
        this.ladderGoals = ladderGame.getLadderGoals();
        initGame(users, ladderGame);
    }

    public String findPlayerGoal(String name) {
        User user = users.findUser(name);
        int position = moveResult(user);
        return ladderGoals.getResult(position);
    }

    private int moveResult(User user) {
        int position = user.getPosition();
        for (Line line : ladder.getLines()) {
            position += line.move(position);
        }
        return position;
    }

    private void initGame(Users users, LadderGame ladderGame) {
        validateUsersGoal(users, ladderGame.getLadderGoals());
        for (int i = 0; i < users.size(); i++) {
            int result = ladder.move(i);
            results.put(users.getUserName(i), ladderGoals.getResult(result));
        }
    }

    private void validateUsersGoal(Users users, LadderGoals ladderGoals) {
        if (users.size() != ladderGoals.size()) {
            throw new IllegalArgumentException(USER_GOALS_COUNTS_SHOULD_SAME);
        }
    }

    public Map<String, String> getAll() {
        return new HashMap<>(results);
    }

    public Users getUsers() {
        return users;
    }

    public LadderGoals getLadderGoals() {
        return ladderGoals;
    }

    public Ladder getLadder() {
        return ladder;
    }
}

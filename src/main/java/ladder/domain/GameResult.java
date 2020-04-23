package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static final String USER_GOALS_COUNTS_SHOULD_SAME = "사용자와 사다리결과 숫자는 같아야합니다.";
    public static final String NOT_FOUND_USER = "검색 결과가 없습니다.";

    private Map<String, String> results;
    private LadderGenerator ladderGenerator;
    private Ladder ladder;
    private Users users;
    private LadderGoals ladderGoals;

    public GameResult(Users users, LadderGenerator ladderGenerator) {
        this.results = new HashMap<>();
        this.users = users;
        this.ladder = ladderGenerator.getLadder();
        this.ladderGoals = ladderGenerator.getLadderGoals();
        initGame(users, ladderGenerator);
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

    private void initGame(Users users, LadderGenerator ladderGenerator) {
        validateUsersGoal(users, ladderGenerator.getLadderGoals());
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

    public String get(String userName) {
        return results.get(userName);
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

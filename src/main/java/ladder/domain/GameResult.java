package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static final String USER_GOALS_COUNTS_SHOULD_SAME = "사용자와 사다리결과 숫자는 같아야합니다.";
    public static final String NOT_FOUND_USER = "검색 결과가 없습니다.";

    private Users users;
    private LadderGoals ladderGoals;
    private Ladder ladder;
    private Map<String, String> results;

    public GameResult(Users users, Ladder ladder, LadderGoals ladderGoals) {
        this.results = new HashMap<>();
        initGame(users, ladder, ladderGoals);
        this.users = users;
        this.ladder = ladder;
        this.ladderGoals = ladderGoals;
    }

    public String findPlayerGoal(String name) {
        int index = users.index(name);
        if (index == -1) {
            throw new IllegalArgumentException(NOT_FOUND_USER);
        }

        for (Line line : ladder.getLines()) {
            index += line.move(index);
        }
        return ladderGoals.getResult(index);
    }

    private void initGame(Users users, Ladder ladder, LadderGoals ladderGoals) {
        validateUsers(users, ladderGoals);
        for (int i = 0; i < users.size(); i++) {
            int result = ladder.move(i);
            results.put(users.getUserName(i), ladderGoals.getResult(result));
        }
    }

    private void validateUsers(Users users, LadderGoals ladderGoals) {
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

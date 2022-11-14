package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {

    private List<User> users = new ArrayList<>();
    private List<Line> ladder = new ArrayList<>();
    private List<Result> results = new ArrayList<>();

    public LadderResult(Users users, Ladder ladder, Results results) {
        this.users = users.getUsers();
        this.ladder = ladder.getLines();
        this.results = results.getResults();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public List<Result> getResults() {
        return results;
    }
}

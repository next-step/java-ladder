package ladder.domain.ladder;

import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.user.User;
import ladder.domain.user.Users;

import java.util.List;

public class Ladder {
    private final Height height;
    private final Lines lines;
    private final Users users;
    private final Results results;

    public Ladder(Height height, Users users, Results results, Lines lines) {
        this.height = height;
        this.users = users;
        this.results = results;
        this.lines = lines;
    }

    public static Ladder createLadder(int height, Users users, Results results, LinesStrategy lineAddStrategy) {
        Lines lines = Lines.createLines(height, users.getSize(), lineAddStrategy);
        return new Ladder(Height.createHeight(height), users, results, lines);
    }

    public int getHeight() {
        return height.getHeight();
    }

    public List<Line> getLines() {
        return lines.getLines();
    }

    public List<User> getUsers() {
        return users.getUsers();
    }

    public List<Result> getResults() {
        return results.getResults();
    }

    public String getMatchResult(String matchUser) {
        int index = users.findUserIndex(matchUser);
        for (int i = 0; i < lines.getLines().size(); i++) {
            index = lines.getLine(i).move(index);
        }
        return results.getResult(index).getValue();
    }
}

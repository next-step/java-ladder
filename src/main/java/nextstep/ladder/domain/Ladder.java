package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private Users users;
    private Rows rows;
    private LadderResults results;

    public Ladder(Users users, Rows rows, LadderResults results) {
        this.users = users;
        this.rows = rows;
        this.results = results;
    }

    public static Ladder of(List<String> names, int height, PointGenerator generator, LadderResults results) {
        return new Ladder(Users.of(names), Rows.of(names.size(), height, generator), results);
    }

    public void play() {
        for (int i = 0; i < users.getUsers().size(); i++) {
            int x = rows.getResultX(i);
            users.setResult(i, results.getResult(x));
        }
    }

    public Users getUsers() {
        return users;
    }

    public Rows getRows() {
        return rows;
    }

    public LadderResults getResults() {
        return results;
    }
}

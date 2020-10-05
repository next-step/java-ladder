package nextstep.ladder.domain;

import java.util.List;

public class Ladder {
    private final Lines lines;
    private final Users users;
    private final Results results;

    public Ladder(Lines lines, Users users, Results results) {
        this.lines = lines;
        this.users = users;
        this.results = results;
    }

    public static Ladder random(String usersRaw, String resultsRaw, int height) {
        Users users = Users.ofByRaw(usersRaw);
        Lines lines = Lines.random(users.countOfUsers(), height);
        Results result = Results.ofByRaw(resultsRaw);
        return new Ladder(lines, users, result);
    }

    public Users getUsers() {
        return users;
    }

    public Lines getLines() {
        return lines;
    }

    public Results getResults() {
        return results;
    }

    public Results getResultsOfUsers() {
        for (int i = 0; i < users.getUsers().size(); i++) {
            Result result = calculateResultByUserOrder(i);
            String username = users.getUsers().get(i).getName();
            result.setUsername(username);
        }
        return results;
    }

    public int getMaxUserNameLength() {
        return users.getMaxUserNameLength();
    }

    public String getResultByUsername(String username) {
        int orderByUsername = users.getOrderByUsername(username);
        Result result = calculateResultByUserOrder(orderByUsername);
        result.setUsername(username);
        return result.getResultName();
    }

    public Result calculateResultByUserOrder(int orderOfUser) {
        int row = 0;
        int col = orderOfUser;
        while (!lines.isLastRow(row)) {
            col = lines.moveCol(row, col);
            row++;
        }
        return results.getResults().get(col);
    }
}

package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private final int STEP_MIN_NUM = 1;

    private List<User> users;
    private List<Line> ladder;
    private int totalStep;

    public Game(List<String> names, int totalStep) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), i));
        }
        this.users = users;

        if (totalStep < STEP_MIN_NUM) {
            throw new IllegalArgumentException();
        }
        this.totalStep = totalStep;
    }

    public void doGame() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return STEP_MIN_NUM == game.STEP_MIN_NUM &&
                totalStep == game.totalStep &&
                Objects.equals(users, game.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(STEP_MIN_NUM, users, totalStep);
    }
}

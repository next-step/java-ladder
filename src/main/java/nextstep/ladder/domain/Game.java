package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Game {

    private final int STEP_MIN_NUM = 1;
    private final int USER_MIN_NUM = 2;

    private List<User> users;
    private int totalStep;

    public Game(String nameString, int totalStep) {
        if (totalStep < STEP_MIN_NUM) {
            throw new IllegalArgumentException();
        }
        this.totalStep = totalStep;
        this.users = createUsers(nameString);
    }

    private List<User> createUsers(String nameString) {
        List<User> users = new ArrayList<>();
        List<String> names = Arrays.asList(nameString.split(","));
        for (int i = 0; i < names.size(); i++) {
            users.add(new User(names.get(i), i));
        }
        if (users.size() < USER_MIN_NUM) {
            throw new IllegalArgumentException();
        }
        return users;
    }

    public List<Line> doGame() {
        return createLadder(totalStep, users.size());
    }

    private List<Line> createLadder(int totalStep, int totalUser) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < totalStep; i++) {
            ladder.add(new Line(totalUser));
        }
        return ladder;
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

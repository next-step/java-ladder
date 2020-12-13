package ladder.domain;

import java.util.Objects;

public class GameSetup {

    private final int countOfPerson;
    private final int height;

    private GameSetup(int countOfPerson, int height) {
        this.countOfPerson = countOfPerson;
        this.height = height;
    }

    public static GameSetup of(int countOfPerson, int height) {
        return new GameSetup(countOfPerson,height);
    }

    public int getCountOfPerson() {
        return countOfPerson;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameSetup gameSetup = (GameSetup) o;
        return countOfPerson == gameSetup.countOfPerson && height == gameSetup.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfPerson, height);
    }
}

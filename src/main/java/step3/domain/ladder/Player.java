package step3.domain.ladder;

import step3.exceptions.OutOfRangePlayerNameException;

import java.util.Objects;

public class Player {
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final String ERROR_INVALID_NAME_LENGTH = "이름은 5자 이내여야 합니다.";


    private final String name;
    private final Point point;

    public Player(String name, Point point) {
        isNameSizeUnder5(name);
        this.name = name;
        this.point = point;
    }

    public static void isNameSizeUnder5(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new OutOfRangePlayerNameException(ERROR_INVALID_NAME_LENGTH);
        }
    }

    public static Player of(String name, int index) {
        return new Player(name, new Point(index, 0));
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return point.getX();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

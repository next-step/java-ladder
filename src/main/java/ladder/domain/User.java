package ladder.domain;

import java.util.Objects;

public class User {
    private Name name;
    private Position position;

    public User(String name) {
        this.name = new Name(name);
    }

    public User(String name, int index) {
        this(name);
        this.position = new Position(index, 0);
    }

    public boolean right(Line line) {
        if (line.isOverSize(position.getRightPosition())) {
            return false;
        }

        if (line.pointStatus(position.getRightPosition())) {
            this.position.moveRight();
            return true;
        }

        return false;
    }

    public boolean left(Line line) {
        if (line.isLessSize(position.getLeftPosition())) {
            return false;
        }

        if (line.pointStatus(position.getLeftPosition())) {
            this.position.moveLeft();
            return true;
        }

        return false;
    }

    public void move(Line line) {
        if (this.right(line)) {
            return;
        }
        this.left(line);
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}

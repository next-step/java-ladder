package nextstep.ladder.domain;

import java.util.Objects;

public class Player {

    private final Person person;
    private Position position;

    public Player(Person person, Position position) {
        this.person = person;
        this.position = position;
    }

    public static Player of(Person person, Position givenStartPosition) {
        return new Player(person, givenStartPosition);
    }

    public Position position() {
        return position;
    }

    public void move(Position position) {
        this.position = position;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return position == player.position && Objects.equals(person, player.person);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

package ladder.domain;

import ladder.domain.code.Direction;

import java.util.Objects;

public class Player {

    private static final int MIN_NAME_LENGTH = 5;
    private static final int MIN_POSITION = 0;

    private final String name;

    private int position;

    public Player(String name,
                  int position) {
        if (name.length() > MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자 입니다.");
        }
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException("참가자의 위치가 잘못되었습니다.");
        }

        this.name = name;
        this.position = position;
    }

    public String name(){
        return this.name;
    }

    public int position() {
        return this.position;
    }

    public void move(Direction direction) {
        if (direction.equals(Direction.LEFT)) {
            this.position--;
        }
        if (direction.equals(Direction.RIGHT)) {
            this.position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}

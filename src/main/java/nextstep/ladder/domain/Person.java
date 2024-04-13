package nextstep.ladder.domain;

import java.util.Objects;

public class Person {
    private final String name;
    private final Position position;

    private static final int NAME_LENGTH_STANDARD = 5;

    public Person(String name, int position) {
        this(name, new Position(position));
    }

    public Person(String name, Position position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("참가자의 이름은 (%s)와 같이 공백이거나 null일 수 없습니다.", name));
        }
        if (name.length() > NAME_LENGTH_STANDARD) {
            throw new IllegalArgumentException(String.format("참가자(%s)의 이름 글자수는 NAME_LENGTH_STANDARD를 초과할 수 없습니다", name));
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    // Line엔 rungs(사다리 가로선)이 포함되어 있음
    // position이 곧 people의 index
    public void crossLadder(Rungs rungs) {
        // position이 1부터(두번째부터)
        if (!this.position.isFirstPosition()) {
            // Rungs의 position번째가 true일 때
            if (rungs.isExist(this.position.getPosition())) {
                this.position.crossRight();
            }
            // Rungs의 (position - 1)번째가 true일 때
            if (rungs.isExist(this.position.getPosition() - 1)) {
                this.position.crossLeft();
            }
        }
        // position이 0일때
        if (rungs.isExist(this.position.getPosition())) {
            this.position.crossRight();
        }

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Person person = (Person) object;
        return Objects.equals(name, person.name) && Objects.equals(position, person.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}

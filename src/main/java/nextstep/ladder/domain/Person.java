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

    public void crossLadder(Rungs rungs) {
        validateRungs(rungs);
        if (isFirstPosition()) {
            crossLadderFromFirstPosition(rungs);
            return;
        }

        if (isNotFirstPosition()) {
            crossLadderFromNonFirstPosition(rungs);
            return;
        }

        throw new IllegalArgumentException("사다리를 건너는데 문제가 발생했습니다.");
    }

    private static void validateRungs(Rungs rungs) {
        if (rungs == null || rungs.size() == 0) {
            throw new IllegalArgumentException("사다리가 존재하지 않습니다.");
        }
    }

    private void crossLadderFromFirstPosition(Rungs rungs) {
        if (rungs.isExistNextToRight(position)) {
            this.position.crossRight();
        }
    }

    private void crossLadderFromNonFirstPosition(Rungs rungs) {
        if (rungs.isExistNextToLeft(position)) {
            this.position.crossLeft();
        } else if (rungs.isExistNextToRight(position)) {
            this.position.crossRight();
        }
    }

    private boolean isNotFirstPosition() {
        return !isFirstPosition();
    }

    private boolean isFirstPosition() {
        return this.position.isFirstPosition();
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

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isSameName(String personName) {
        return personName.equals(this.name);
    }
}

package nextstep.ladder.domain;

import nextstep.ladder.exception.CanNotMoveException;
import nextstep.ladder.exception.CannotRegisterNameException;

public class Participant {

    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;


    public static Participant nameOf(String name, int position) {
        validateNameLength(name.trim());
        return new Participant(name.trim(), position);
    }

    private Participant(String name, int position) {
        this.name = name;
        this.position = position;
    }

    private static void validateNameLength(String name) {
        if (name.length() < 1) {
            throw new CannotRegisterNameException(String.format("이름은 %d 글자 이상이어야 합니다.", Participant.MIN_NAME_LENGTH));
        }
        if (name.length() > 5) {
            throw new CannotRegisterNameException(String.format("이름은 %d 글자를 초과할 수 없습니다.", Participant.MAX_NAME_LENGTH));
        }
    }

    public void moveFront(int participantCount) {
        canMoveFront(participantCount);
        this.position++;
    }

    private void canMoveFront(int participantCount) {
        if (position == participantCount - 1) {
            throw new CanNotMoveException("제일 오른쪽에 위치해, 더 이상 오른쪽으로 이동할 수 없습니다.");
        }
    }

    public void moveBack() {
        canMoveBack();
        this.position--;
    }

    private void canMoveBack() {
        if (this.position == 0) {
            throw new CanNotMoveException("제일 왼쪽에 위치해, 더 이상 왼쪽으로 이동할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}

package nextstep.ladder.model.value;

import nextstep.ladder.model.Ladder;

import java.util.Objects;

public class Participant {

    private static final String SIZE_ERROR_MSG = "참가자 이름은 5자리를 초과 할 수 없습니다.";
    private static final String FORMAT_ERROR_MSG = "참가자는 1명 이상 입력하여야 합니다.";
    private static final int NAME_MAX_SIZE = 5;

    private final String name;
    private final int position;

    public Participant(String inputName, int position) {

        if(inputName.isEmpty()) {
            throw new NullPointerException(FORMAT_ERROR_MSG);
        }

        if(inputName.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MSG);
        }

        this.name = inputName;
        this.position = position;
    }

    public Participant climb(Ladder ladder) {
        int tempPosition = this.position;

        for (Line line : ladder.getLines()) {
            tempPosition = line.move(tempPosition);
        }

        return new Participant(this.name, tempPosition);
    }

    public boolean isEqualsName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant name1 = (Participant) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

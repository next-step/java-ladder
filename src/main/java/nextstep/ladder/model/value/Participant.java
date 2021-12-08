package nextstep.ladder.model.value;

import java.util.Objects;

public class Participant {

    private static final String SIZE_ERROR_MSG = "참가자 이름은 5자리를 초과 할 수 없습니다.";
    private static final String FORMAT_ERROR_MSG = "참가자는 1명 이상 입력하여야 합니다.";
    private static final int NAME_MAX_SIZE = 5;

    private final String name;

    public Participant(String inputName) {

        if(inputName.isEmpty() || inputName == null) {
            throw new NullPointerException(FORMAT_ERROR_MSG);
        }

        if(inputName.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MSG);
        }

        this.name = inputName;
    }

    public String getName() {
        return name;
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

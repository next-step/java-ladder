package nextstep.ladder.model.value;

import java.util.Objects;

public class Participant {

    private static final String ERROR_MSG = "참가자 이름은 5자리를 초과 할 수 없습니다.";
    private static final int NAME_MAZ_SIZE = 5;

    private final String name;

    public Participant(String inputName) {

        if(inputName.length() > NAME_MAZ_SIZE) {
            throw new IllegalArgumentException(ERROR_MSG);
        }

        this.name = inputName;
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

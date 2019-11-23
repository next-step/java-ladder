package nextstep.ladder.domain.participant;

import java.util.Objects;

public class Participant {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String MAX_NAME_LENGTH_ERROR_MSG = "이름은 5글자를 넘길 수 없습니다. [이름] : %s";

    private final String name;
    private final int order;

    public Participant(String name, int order) {
        assertName(name);
        this.name = name;
        this.order = order;
    }

    private void assertName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(MAX_NAME_LENGTH_ERROR_MSG, name));
        }
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

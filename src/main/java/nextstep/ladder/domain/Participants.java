package nextstep.ladder.domain;

import java.util.*;

public class Participants {
    public static final String TOO_FEW_PARTICIPANTS_MESSAGE = "참여자는 2명 이상이어야 합니다.";
    private final List<Name> values;

    public Participants(List<Name> values) {
        this.valid(values);
        this.values = values;
    }

    private void valid(List<Name> values) {
        if (values == null || values.size() < 2) {
            throw new IllegalArgumentException(TOO_FEW_PARTICIPANTS_MESSAGE);
        }
    }

    public int size() {
        return values.size();
    }

    public Name get(int index) {
        return values.get(index);
    }

    public List<Name> asList() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(values);
    }
}

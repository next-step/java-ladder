package nextstep.ladder.Model;

import java.util.List;
import java.util.Objects;

public class Names {

    private static final String MIN_MEMBER_ERROR = "게임을 하려면 최소 2명이어야 합니다.";
    private static final int STANDARD_GAME = 2;
    List<Name> names;

    public Names(List<Name> names) {
        validate(names);
        this.names = names;
    }

    private void validate(List<Name> names) {
        if (names.size() < STANDARD_GAME) {
            throw new IllegalArgumentException(MIN_MEMBER_ERROR);
        }
    }

    public int size() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Names)) return false;
        Names names1 = (Names) o;
        return Objects.equals(getNames(), names1.getNames());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNames());
    }
}

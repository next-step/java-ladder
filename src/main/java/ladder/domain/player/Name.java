package ladder.domain.player;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + "은 5글자보다 긴 이름입니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

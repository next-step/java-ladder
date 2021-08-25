package ladder.domain.ladder;

import java.util.Objects;

public class Award {

    private final Name name;

    public Award(String name) {
        this.name = new Name(name);
    }

    public String name() {
        return name.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award award = (Award) o;
        return Objects.equals(name, award.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

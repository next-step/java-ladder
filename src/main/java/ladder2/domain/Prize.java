package ladder2.domain;

import java.util.Objects;

public class Prize {

    private final int index;
    private final String name;

    public Prize(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int index() {
        return index;
    }

    public String name() {
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
        Prize prize = (Prize) o;
        return index == prize.index && Objects.equals(name, prize.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, name);
    }

    @Override
    public String toString() {
        return "Prize{" +
            "index=" + index +
            ", name='" + name + '\'' +
            '}';
    }
}

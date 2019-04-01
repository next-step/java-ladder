package domain.prize;

import java.util.Objects;

public class Prize {

    private final String name;

    public Prize(String name) {
        this.name = name;
    }

    public String beautify() {
        return this.name;
    }

    public String beautify(String prefix) {
        return prefix + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return Objects.equals(name, prize.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

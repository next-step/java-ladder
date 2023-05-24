package nextstep.ladder.domain.line;

import java.util.Objects;

public class WinningCategory {

    private static final String PRINT_FORMAT = "%-5s ";
    private final String name;

    public WinningCategory(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningCategory that = (WinningCategory) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format(PRINT_FORMAT, this.name);
    }
}

package nextstep.ladder.domain.line;

import java.util.Objects;

public class WinningCategory {

    private static final String PRINT_FORMAT = "%-5s ";
    private final String name;

    public WinningCategory(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 빈값일 수는 없습니다.");
        }
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

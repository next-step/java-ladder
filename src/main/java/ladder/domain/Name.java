package ladder.domain;

import java.util.Objects;
import java.util.Optional;

/**
 * 이름을 나타내는 클래스입니다.
 * 불변 객체입니다.
 */
public class Name {
    private final String name;

    /**
     * 주어진 이름으로 이름 객체를 생성합니다.
     * @param name 생성할 이름
     */
    public Name(String name) {
        this.name = Optional.ofNullable(name)
                .filter(v -> v.length() > 0)
                .filter(v -> v.length() < 6)
                .orElseThrow(() -> new IllegalArgumentException("주어진 이름 " + name + "은 유효하지 않습니다."));
    }

    public String toPrintableSting() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
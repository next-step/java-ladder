package nextstep.ladder;

import java.util.Objects;

public class Prize {
    private final String name;

    public Prize(String name) {
        validName(name);
        this.name = name;
    }

    private static void validName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("상품 이름은 비어 있을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return Objects.equals(name, prize.name);
    }

}

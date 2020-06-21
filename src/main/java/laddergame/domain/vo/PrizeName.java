package laddergame.domain.vo;

import java.util.Objects;

public class PrizeName {
    private final String name;

    public PrizeName(final String prizeName) {
        validateNullOrEmpty(prizeName);
        this.name = prizeName.trim();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PrizeName)) return false;
        PrizeName prizeName = (PrizeName) o;
        return Objects.equals(getName(), prizeName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public String getName() {
        return name;
    }

    private void validateNullOrEmpty(String prizeName) {
        if (Objects.isNull(prizeName) || prizeName.trim().isEmpty()) {
            throw new IllegalArgumentException("당첨 결과명은 Null 이나 공백일 수 없습니다.");
        }
    }
}

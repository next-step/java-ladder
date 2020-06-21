package laddergame.domain.vo;

import java.util.Objects;

public class PrizeName {
    private final String name;

    public PrizeName(final String prizeName) {
        validateNullOrEmpty(prizeName);
        this.name = prizeName;
    }

    public String getName() {
        return name;
    }

    private void validateNullOrEmpty(String prizeName) {
        if (Objects.isNull(prizeName) || prizeName.isEmpty()) {
            throw new IllegalArgumentException("당첨 결과명은 Null 이나 공백일 수 없습니다.");
        }
    }
}

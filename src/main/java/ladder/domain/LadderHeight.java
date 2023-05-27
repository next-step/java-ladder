package ladder.domain;

import java.util.Objects;

public class LadderHeight {
    private Integer height;

    public LadderHeight(Integer height) {
        validate(height);
        this.height = height;
    }

    private void validate(Integer height) {
        if (height < 0) {
            throw new IllegalArgumentException("사다리 높이는 음수일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}

package ladder.model;

import java.util.Objects;

public class LadderGameReword {

    private final String reword;

    private LadderGameReword(final String reword) {
        validate(reword);
        this.reword = reword;
    }

    public static LadderGameReword create(final String reword) {
        return new LadderGameReword(reword);
    }

    private void validate(final String reword) {
        if (Objects.isNull(reword) || "".equals(reword.trim())) {
            throw new IllegalArgumentException("결과를 입력해주세요.");
        }
    }

    public String getReword() {
        return reword;
    }

    @Override
    public String toString() {
        return reword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderGameReword)) {
            return false;
        }
        LadderGameReword that = (LadderGameReword) o;
        return Objects.equals(getReword(), that.getReword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReword());
    }
}

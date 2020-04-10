package ladder.model;

import java.util.Objects;

public class LadderGameReword {

    private final String reword;

    private LadderGameReword(final String reword) {
        validate(reword);
        this.reword = reword;
    }

    private void validate(final String reword) {
        if (Objects.isNull(reword) || "".equals(reword.trim())) {
            throw new IllegalArgumentException("given reword is null or empty.");
        }
    }

    public static LadderGameReword of(final String reword) {
        return new LadderGameReword(reword);
    }

    public String getReword() {
        return reword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGameReword)) return false;
        LadderGameReword that = (LadderGameReword) o;
        return Objects.equals(getReword(), that.getReword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReword());
    }

    @Override
    public String toString() {
        return reword;
    }
}

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
            throw new IllegalArgumentException("결과를 입력해주세요.");
        }
    }

    public static LadderGameReword of(final String reword) {
        return new LadderGameReword(reword);
    }

    public String getReword() {
        return reword;
    }

    @Override
    public String toString() {
        return reword;
    }
}

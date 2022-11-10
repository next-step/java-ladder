package ladder.domain;

import java.util.Objects;

public class LadderResult {
    private static final int MIN_WORD_LENGTH = 1;
    private static final int MAX_WORD_LENGTH = 5;
    private static final String RESULT_WORD_LENGTH_MESSAGE = "글자수는 " + MIN_WORD_LENGTH + "~" + MAX_WORD_LENGTH + " 사이로 입력해주세요.";

    private int memberIndex;
    private final String result;

    public LadderResult(String result) {
        checkNull(result);
        validateSize(result);
        this.result = result;
    }

    public LadderResult(int memberIndex, String result) {
        this.memberIndex = memberIndex;
        this.result = result;
    }

    private static void validateSize(String result) {
        if (result.length() < MIN_WORD_LENGTH || result.length() > MAX_WORD_LENGTH) {
            throw new IllegalArgumentException(RESULT_WORD_LENGTH_MESSAGE);
        }
    }

    private static void checkNull(String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException(RESULT_WORD_LENGTH_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult result1 = (LadderResult) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "LadderResult{" +
                "memberIndex=" + memberIndex +
                ", result='" + result + '\'' +
                '}';
    }

    public int memberIndex() {
        return memberIndex;
    }

    public String result() {
        return result;
    }
}

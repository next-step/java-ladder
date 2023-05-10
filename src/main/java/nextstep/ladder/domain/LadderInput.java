package nextstep.ladder.domain;

import java.util.Objects;

public class LadderInput {
    private static final int INPUT_MAX_LENGTH = 5;

    private final String ladderInput;

    public LadderInput(String ladderInput) {
        checkInputRule(ladderInput);
        this.ladderInput = ladderInput;
    }

    private void checkInputRule(String ladderInput) {
        hasNullOrEmpty(ladderInput);
        overLengthRule(ladderInput);
    }

    private void hasNullOrEmpty(String ladderInput) {
        if (ladderInput == null || ladderInput.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void overLengthRule(String ladderInput) {
        if (ladderInput.length() > INPUT_MAX_LENGTH) {
            throw new IllegalArgumentException("5글자를 초과할 수 없습니다.");
        }
    }

    public String getLadderInput() {
        return ladderInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderInput ladderInput1 = (LadderInput) o;
        return Objects.equals(ladderInput, ladderInput1.ladderInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderInput);
    }
}

package nextstep.ladder.domain;

import java.util.Objects;

public class LadderInput {

    private static final int INPUT_LENGTH = 5;

    private final String ladderInput;

    public LadderInput(String ladderInput) {
        checkInputValidation(ladderInput);
        checkNullOrEmpty(ladderInput);

        this.ladderInput = ladderInput;
    }

    private void checkInputValidation(String ladderInput) {
        checkNullOrEmpty(ladderInput);
        checkInputLength(ladderInput);
    }

    private void checkNullOrEmpty(String ladderInput) {
        if (ladderInput == null || ladderInput.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private void checkInputLength(String ladderInput) {
        if (ladderInput.length() > INPUT_LENGTH) {
            throw new IllegalArgumentException("입력값이 5자를 초과했습니다.");
        }
    }

    public String getLadderInput() {
        return this.ladderInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderInput that = (LadderInput) o;
        return Objects.equals(ladderInput, that.ladderInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderInput);
    }
}

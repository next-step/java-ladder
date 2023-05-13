package nextstep.ladder.domain;

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
}

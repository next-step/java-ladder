package nextstep.step4.domain;

public class LadderHeight {
    private final int height;

    public LadderHeight(final int inputHeight) {
        validateHeight(inputHeight);

        this.height = inputHeight;
    }

    private void validateHeight(final int inputHeight) {
        if (inputHeight <= 0) {
            throw new IllegalArgumentException("최대 사다리 높이는 1보다 커야합니다.");
        }
    }
}

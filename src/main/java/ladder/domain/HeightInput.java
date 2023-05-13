package ladder.domain;

public class HeightInput {

    private final int heightInput;

    public HeightInput(int heightInput) {
        this.heightInput = heightInput;
    }

    public LadderHeight ladderHeightByInput() {
        return new LadderHeight(this.heightInput);
    }
}

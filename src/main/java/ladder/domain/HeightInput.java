package ladder.domain;

public class HeightInput {

    private final int heightInput;

    public HeightInput(int heightInput) {
        this.heightInput = heightInput;
    }

    public LadderHeight ladderHeight() {
        return new LadderHeight(this.heightInput);
    }
}

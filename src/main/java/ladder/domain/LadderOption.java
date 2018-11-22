package ladder.domain;

public class LadderOption {

    private int height;

    private LadderOption(int height) {
        this.height = height;
    }

    public static LadderOption create(int height) {
        if(!isValidHeight(height)) {
            throw new IllegalArgumentException();
        }
        return new LadderOption(height);
    }

    private static boolean isValidHeight(int height) {
        return 0 < height;
    }

    public int height() {
        return this.height;
    }
}

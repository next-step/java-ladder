package ladder.refactoring.domain;

public class Height {
    private final int height;

    public Height(int height) {
        this.height = height;
    }

    public static Height of(String input) {
        int height = Integer.parseInt(input);
        if (height <= 0) {
            throw  new IllegalArgumentException("높이가 잘못되었습니다.");
        }
        return new Height(height);
    }

    public int getValue() {
        return height;
    }
}

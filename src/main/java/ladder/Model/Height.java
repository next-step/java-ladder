package ladder.Model;

public class Height {
    private static final int MIN_HEIGHT = 1;
    public final int height;

    public Height(String input) {
        int number;

        try {
            number = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("높이는 숫자여야 합니다.");
        }

        if (number < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 " + MIN_HEIGHT + " 이상이어야 합니다.");
        }

        height = number;
    }

    public int height() {
        return height;
    }
}

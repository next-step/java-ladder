package ladder.Model;

public class MaxHeight {
    public final int maxHeight;

    public MaxHeight(String input) {
        int number;

        try {
            number = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("최대 높이는 숫자여야 합니다.");
        }

        maxHeight = number;
    }

    public int height() {
        return maxHeight;
    }
}

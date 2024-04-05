package domain;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        validatePositive(x, y);
        this.x = x;
        this.y = y;
    }

    private void validatePositive(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("좌표는 음수일 수 없습니다.");
        }
    }
}

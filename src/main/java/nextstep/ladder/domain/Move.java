package nextstep.ladder.domain;

public class Move {

    private final boolean left;
    private final boolean present;

    private Move(boolean left, boolean present) {
        this.left = left;
        this.present = present;
    }

    public static Move of(boolean left, boolean present) {
        valid(left, present);
        return new Move(left, present);
    }

    public int move() {
        if (left) {
            return -1;
        }

        if (present) {
            return 1;
        }

        return 0;
    }

    private static void valid(boolean left, boolean present) {
        if (left && present) {
            throw new IllegalArgumentException("정상적이지 않는 사다리 입니다.");
        }
    }

}

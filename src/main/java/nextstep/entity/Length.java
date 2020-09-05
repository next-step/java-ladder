package nextstep.entity;

public class Length implements TryCatchable {

    private final int length;

    public Length(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("사다리 높이는 최소 1 단위 까지 부여할 수 있어요.");
        }
        this.length = length;
    }
}

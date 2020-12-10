package ladder.domain;

public class LadderDirection {
    private boolean left;
    private boolean right;

    public LadderDirection(boolean left, boolean right) {
        checkDirection(left, right);

        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    private void checkDirection(boolean left, boolean right) {
        if (left == true && right == true) {
            throw new RuntimeException("방향을 제대로 선택해주세요");
        }
    }

    @Override
    public String toString() {
        return "LadderDirection{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

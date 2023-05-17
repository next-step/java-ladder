package nextstep.ladder.dto;

public class PointDto {
    private boolean left, right;

    public PointDto(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }
}

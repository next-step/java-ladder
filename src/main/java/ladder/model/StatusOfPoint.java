package ladder.model;

import ladder.utils.StatusGenerator;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class StatusOfPoint {

    private final boolean left;
    private final boolean right;

    public StatusOfPoint(boolean left, boolean right) {
        validation(left, right);
        this.left = left;
        this.right = right;
    }

    private void validation(boolean left, boolean right){
        if(left && right){
            throw new IllegalStateException("양 옆의 사다기라 같은 높이에 있을 수 없습니다.");
        }
    }

    private static StatusOfPoint of(boolean left, boolean right){
        return new StatusOfPoint(left, right);
    }

    public static StatusOfPoint first(boolean right){
        return of(FALSE, right);
    }

    public StatusOfPoint next(boolean nextRight){
        return of(this.right, nextRight);
    }

    public StatusOfPoint next(){
        if(right){
            return next(FALSE);
        }
        return next(StatusGenerator.get());
    }

    public StatusOfPoint last(){
        return of(this.right, FALSE);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusOfPoint that = (StatusOfPoint) o;
        return left == that.left &&
                right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}

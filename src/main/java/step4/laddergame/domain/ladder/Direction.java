/*
 * 각 지점의 좌/우 연결정보를 관리하고 다음 점 생성을 담당하는 클래스
 * */
package step4.laddergame.domain.ladder;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {

    private static final String ILLEGAL_DIRECTION = "연결은 좌/우 중에 한쪽만 가능합니다.";

    private final Boolean left;
    private final Boolean right;

    public Direction(Boolean left, Boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public static Direction of(Boolean first, Boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(Boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    public Direction next(Boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next(LadderPointerGenerator generator) {
        if (this.right) {
            return next(FALSE);
        }
        return next(generator.generatePoint());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }


}

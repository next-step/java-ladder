package ladder.model.line;

import ladder.error.IllegalDirectionPositionException;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
  private static final String ILLEGAL_DIRECTION_POSITION_MESSAGE = "방향 양쪽이 모두 가능할 수 없습니다.";

  private final boolean left;
  private final boolean right;

  public Direction(boolean left, boolean right){
    if(left && right){
      throw new IllegalDirectionPositionException(ILLEGAL_DIRECTION_POSITION_MESSAGE);
    }

    this.left = left;
    this.right = right;
  }

  public boolean isLeft(){
    return this.left;
  }

  public boolean isRight(){
    return this.right;
  }

  public Direction next(boolean nextRight){
    return of(this.right, nextRight);
  }

  public Direction next(){
    if(this.right){
      return next(FALSE);
    }
//    return next(generatePoint());
    return new Direction(FALSE, FALSE);
  }

  public static Direction of(boolean first, boolean second){
    return new Direction(first, second);
  }

  public static Direction first(boolean right){
    return of(FALSE, right);
  }

  public Direction last(){
    return of(this.right, FALSE);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Direction direction = (Direction) o;
    return left == direction.left &&
      right == direction.right;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }

  @Override
  public String toString() {
    return "Direction{" +
      "left=" + left +
      ", right=" + right +
      '}';
  }
}

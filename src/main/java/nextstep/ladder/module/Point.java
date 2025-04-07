package nextstep.ladder.module;

public class Point implements Comparable<Point> {
   private final int x;
   private Bridge ladder;

   public Point(int x) {
      this.x = x;
      this.ladder = new Bridge(false);
   }

   public Point(int x, Bridge ladder) {
      validate(x);
      this.x = x;
      this.ladder = ladder;
   }

   public int value() {
      return x;
   }

   public Bridge ladder() {
      return ladder;
   }

   public void createLadder() {
      ladder = new Bridge(true);
   }

   public void destroyLadder() {
      ladder = new Bridge(false);
   }

   private void validate(int x) {
      if (x < 0) {
         throw new IllegalArgumentException("x는 0 이상이어야 합니다.");
      }
   }

   @Override
   public int compareTo(Point other) {
      return Integer.compare(this.x, other.x);
   }

   @Override
   public String toString() {
      return ladder.isBuilt() ? "-----|" : "     |";
   }

}

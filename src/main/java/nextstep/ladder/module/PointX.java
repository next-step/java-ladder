package nextstep.ladder.module;

public class PointX implements Comparable<PointX> {
   private final int x;
   private Ladder ladder;

   public PointX(int x) {
      this.x = x;
      this.ladder = new Ladder(false);
   }

   public PointX(int x, Ladder ladder) {
      validate(x);
      this.x = x;
      this.ladder = ladder;
   }

   public int value() {
      return x;
   }

   public Ladder ladder() {
      return ladder;
   }

   public void createLadder() {
      ladder = new Ladder(true);
   }

   public void destroyLadder() {
      ladder = new Ladder(false);
   }

   private void validate(int x) {
      if (x < 0) {
         throw new IllegalArgumentException("x는 0 이상이어야 합니다.");
      }
   }

   @Override
   public int compareTo(PointX other) {
      return Integer.compare(this.x, other.x);
   }

   @Override
   public String toString() {
      return ladder.isBuilt() ? "-----|" : "     |";
   }

}

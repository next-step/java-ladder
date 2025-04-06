package nextstep.ladder.module;

public class PointX {
   private final int x;
   private Ladder ladder = null;

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

   private void validate(int x) {
      if (x < 0) {
         throw new IllegalArgumentException("x는 0 이상이어야 합니다.");
      }
   }
   
}

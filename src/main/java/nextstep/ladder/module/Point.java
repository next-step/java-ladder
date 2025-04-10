package nextstep.ladder.module;

import java.util.Objects;

public class Point implements Comparable<Point> {
   private final int x;
   private Bridge bridge;

   public Point(int x) {
      this.x = x;
      this.bridge = new Bridge(false);
   }

   public Point(int x, Bridge ladder) {
      validate(x);
      this.x = x;
      this.bridge = ladder;
   }

   public int value() {
      return x;
   }

   public Bridge bridge() {
      return bridge;
   }

   public void createBridge() {
      bridge = new Bridge(true);
   }

   public void destroyBridge() {
      bridge = new Bridge(false);
   }

   private void validate(int x) {
      if (x < 0) {
         throw new IllegalArgumentException("x는 0 이상이어야 합니다.");
      }
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null || getClass() != obj.getClass())
         return false;
      Point point = (Point) obj;
      return x == point.x;
   }

   @Override
   public int hashCode() {
      return Objects.hash(x);
   }

   @Override
   public int compareTo(Point other) {
      return Integer.compare(this.x, other.x);
   }
}

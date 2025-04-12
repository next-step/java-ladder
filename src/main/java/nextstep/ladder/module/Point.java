package nextstep.ladder.module;

import java.util.Objects;

public class Point implements Comparable<Point> {
   private final int x;
   private LeftBridge leftBridge;
   private RightBridge rightBridge;

   public Point(int x) {
      this(x, new LeftBridge(false), new RightBridge(false));
   }

   public Point(int x, LeftBridge leftBridge) {
      this(x, leftBridge, new RightBridge(false));
   }

   public Point(int x, RightBridge rightBridge) {
      this(x, new LeftBridge(false), rightBridge);
   }

   public Point(int x, LeftBridge leftBridge, RightBridge rightBridge) {
      validatePoint(x);
      this.x = x;
      this.leftBridge = leftBridge;
      this.rightBridge = rightBridge;
   }

   public int value() {
      return x;
   }

   public LeftBridge leftBridge() {
      return leftBridge;
   }

   public RightBridge rightBridge() {
      return rightBridge;
   }

   public void createLeftBridge() {
      leftBridge = new LeftBridge(true);
      validatePoint();
   }

   public void createRightBridge() {
      rightBridge = new RightBridge(true);
      validatePoint();
   }

   public void destroyLeftBridge() {
      leftBridge = new LeftBridge(false);
   }

   public void destroyRightBridge() {
      rightBridge = new RightBridge(false);
   }

   private void validatePoint() {
      if (x == 0 && leftBridge.isBuilt()) {
         throw new IllegalArgumentException("Line의 시작은 사다리가 없어야 합니다.");
      }

      if (leftBridge.isBuilt() && rightBridge.isBuilt()) {
         throw new IllegalArgumentException("Point에서 양쪽 사다리가 있으면 안됩니다.");
      }
   }

   private void validatePoint(int x) {
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

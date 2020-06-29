package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class PointDTOTest {

  public static PointDTO point0;
  public static PointDTO point1;
  public static PointDTO point0_1;
  public static PointDTO point1_0;
  public static PointDTO point2;
  public static PointDTO point3;
  public static PointDTO point4;
  public static PointDTO point5;
  public static PointDTO point6;

  static {
    initPointDTOTest();
  }

  @AfterEach
  void tearDown() {
    initPointDTOTest();
  }

  private static void initPointDTOTest() {
    point0 = PointDTO.createBy(new Point(0));
    point1 = PointDTO.createBy(new Point(1));
    point0_1 = PointDTO.createBy((new Point(0, new Point(1))));
    point1_0 = PointDTO.createBy((new Point(1, new Point(0))));
    point2 = PointDTO.createBy(new Point(2));
    point3 = PointDTO.createBy(new Point(3));
    point4 = PointDTO.createBy(new Point(4));
    point5 = PointDTO.createBy(new Point(5));
    point6 = PointDTO.createBy(new Point(6));
  }

  @Test
  void hasLeft() {
    assertThat(point0_1.hasLeft()).isFalse();
    assertThat(point1_0.hasLeft()).isTrue();
  }

  @Test
  void testToString() {
    System.out.println(point0.toString());
    System.out.println(point0_1.toString());
  }
}
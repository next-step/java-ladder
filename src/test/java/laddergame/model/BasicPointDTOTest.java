package laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class BasicPointDTOTest {

  public static LinkablePoint point1;
  public static LinkablePoint point0_1;
  public static LinkablePoint point1_0;
  public static LinkablePoint point2;
  public static LinkablePoint point3;
  public static LinkablePoint point4;
  public static LinkablePoint point5;
  public static LinkablePoint point6;

  static {
    initPointDTOTest();
  }

  @AfterEach
  void tearDown() {
    initPointDTOTest();
  }

  private static void initPointDTOTest() {
    point0_1 = new BasicPoint(0);
    point1 = new BasicPoint(1);
    point1_0 = point0_1.createNextWithLinkedBy(true);
    point2 = new BasicPoint(2);
    point3 = new BasicPoint(3);
    point4 = new BasicPoint(4);
    point5 = new BasicPoint(5);
    point6 = new BasicPoint(6);
  }

  @Test
  void hasLeft() {
    assertThat(PointDTO.createBy(point0_1).hasLeft()).isFalse();
    assertThat(PointDTO.createBy(point1_0).hasLeft()).isTrue();
  }
}
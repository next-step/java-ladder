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
    point0_1 = BasicPoint.create(0);
    point1 = BasicPoint.create(1);
    point1_0 = point0_1.createNextWithLinkedBy(true);
    point2 = BasicPoint.create(2);
    point3 = BasicPoint.create(3);
    point4 = BasicPoint.create(4);
    point5 = BasicPoint.create(5);
    point6 = BasicPoint.create(6);
  }

  @Test
  void hasLeft() {
    assertThat(PointDTO.createBy(point0_1).hasLeft()).isFalse();
    assertThat(PointDTO.createBy(point1_0).hasLeft()).isTrue();
  }
}
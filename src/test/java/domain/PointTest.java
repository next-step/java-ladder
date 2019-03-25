package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class PointTest {

  @Test
  public void test_point_ofTrue() {

    // When
    Point truePoint = Point.of(true);

    // Then
    assertThat(truePoint.is()).isTrue();
  }

  @Test
  public void test_point_ofFalse() {

    // When
    Point truePoint = Point.of(false);

    // Then
    assertThat(truePoint.is()).isFalse();
  }

  @Test
  public void test_generatePoint_first() {

    // Given
    List<Point> points = new ArrayList<>();

    // When
    Point nextPoint = Point.generatePoint(points);

    // Then
    assertThat(nextPoint.is()).isFalse();
  }

  @Test
  public void test_generatePoint_trueAfterIsFalse() {

    // Given
    List<Point> points = new ArrayList<>();
    points.add(Point.of(true));

    // When
    Point nextPoint = Point.generatePoint(points);

    // Then
    assertThat(nextPoint.is()).isFalse();
  }
}
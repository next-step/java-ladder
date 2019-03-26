package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PointsTest {

  @Test(expected = IllegalArgumentException.class)
  public void test_move_illegalPosition() {

    // Given
    Points points = new Points();
    points.add();
    points.add();
    points.add();

    int position = 3;

    // When
    points.move(position);
  }

  @Test
  public void test_move_lastPosition() {

    // Given
    Points points = new Points();
    points.add(Point.of(false));
    points.add(Point.of(true));
    points.add(Point.of(false));

    int position = 2;

    // When
    int resultPosition = points.move(position);

    // Then
    assertThat(resultPosition).isEqualTo(position);
  }

  @Test
  public void test_move_forward() {

    // Given
    Points points = new Points();
    points.add(Point.of(false));
    points.add(Point.of(true));
    points.add(Point.of(false));

    int position = 1;

    // When
    int resultPosition = points.move(position);

    // Then
    assertThat(resultPosition).isEqualTo(position - 1);
  }

  @Test
  public void test_move_backward() {

    // Given
    Points points = new Points();
    points.add(Point.of(false));
    points.add(Point.of(false));
    points.add(Point.of(true));

    int position = 1;

    // When
    int resultPosition = points.move(position);

    // Then
    assertThat(resultPosition).isEqualTo(position + 1);
  }
}